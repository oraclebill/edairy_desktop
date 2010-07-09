package com.agritrace.edairy.desktop.common.ui.controls;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Formatter;

import org.eclipse.riena.ui.ridgets.AbstractCompositeRidget;
import org.eclipse.riena.ui.ridgets.ILabelRidget;
import org.eclipse.riena.ui.ridgets.ILinkRidget;
import org.eclipse.riena.ui.ridgets.listener.ISelectionListener;
import org.eclipse.riena.ui.ridgets.listener.SelectionEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

/**
 * An ImageWidget is a combination of a Label and a Link. The Label is used
 * to display the image while the Link is used to trigger selection of a new
 * image file to display.
 * 
 * @author bjones
 * 
 */
public class ProfilePhotoRidget extends AbstractCompositeRidget {

	protected static final long MAX_IMAGE_SIZE = 128 * 1024;

	private String id;
	private ImageData imageData;
	private Composite control;
	private ILabelRidget profileImageLabel;

	public ProfilePhotoRidget() {

	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	@Override
	public void configureRidgets() {
		profileImageLabel = getRidget(ILabelRidget.class, "profileImageLabel");

		ILinkRidget updateImageLink = getRidget(ILinkRidget.class, "updateImageLink");
		if (updateImageLink != null) {
			updateImageLink.addSelectionListener(new ISelectionListener() {
				@Override
				public void ridgetSelected(SelectionEvent event) {
					File imageFile = getImageFile();
					if (imageFile != null && imageFile.canRead()) {
						imageData = readImageData(imageFile);
						if (imageData != null) {
							updateModel(imageData);
							updateDisplay(imageData);
						} else {
							throw new IllegalArgumentException("Unable to read file.");
						}
					}
				}
			});
		} else {
			System.err.println("Debug: Error! Null link Ridget.");
		}
	}

	private File getImageFile() {
		final Shell shell = PlatformUI.getWorkbench().getDisplay().getActiveShell();
		final int swtOptions = SWT.DIALOG_TRIM | SWT.SHEET;
		final String fName = new FileDialog(shell, swtOptions).open();
		return (fName != null) ? new File(fName) : null;
	}

	private ImageData readImageData(File imageFile) {
		ImageData imageData = null;
		if (imageFile != null) {
			if (imageFile.canRead() && imageFile.isFile()) {
				if (imageFile.length() > MAX_IMAGE_SIZE) {
					Formatter formatter = new Formatter();
					throw new IllegalArgumentException(formatter.format(
							"Error - file is too large! Maximum size is %,d bytes.", MAX_IMAGE_SIZE).toString());
				}
			} else {
				Formatter formatter = new Formatter();
				throw new IllegalArgumentException(formatter.format("Error - file '%s' is not a legal file type.",
						imageFile.getPath()).toString());
			}
		}
		try {
			InputStream fStream = new BufferedInputStream(new FileInputStream(imageFile));
			imageData = new ImageData(fStream);
		} catch (FileNotFoundException fnfe) {
			// TODO: log
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			// TODO: log
			ioe.printStackTrace();
			// } catch (SWTException se ) {
			// // TODO: log
			// se.printStackTrace();
			// if (se.)
		}

		return imageData;
	}

	private void updateModel(ImageData imageData) {
		// TODO Auto-generated method stub
	}

	private void updateDisplay(ImageData imageData) {

		if (profileImageLabel == null) {
			return;
		}

		final Object control = profileImageLabel.getUIControl();
		if (control instanceof Label) {
			Label label = (Label) control;
			int displayWidth = label.getSize().x, displayHeight = label.getSize().y;

			float imgAspect = (float) imageData.width / (float) imageData.height;
			float displayAspect = (float) displayWidth / (float) displayHeight;
			float scale;
			if (imgAspect > displayAspect) {
				// scale width
				scale = (float) displayWidth / (float) imageData.width;
			} else {
				// scale height
				scale = (float) displayHeight / (float) imageData.height;
			}
			ImageData scaledImage = imageData.scaledTo((int) Math.floor(scale * imageData.width),
					(int) Math.floor(scale * imageData.height));

			final Image photo = new Image(PlatformUI.getWorkbench().getDisplay(), scaledImage);
			label.setText("");
			label.setImage(photo);
			label.redraw();
		}
	}

	@Override
	public void updateFromModel() {
		// TODO
	}

	@Override
	protected void checkUIControl(Object uiControl) {
		if (uiControl instanceof Composite) {
			Composite composite = (Composite) uiControl;
			Control[] children = composite.getChildren();
			if (children.length < 2) {
				throw new RuntimeException();
			}
		}
	}

}