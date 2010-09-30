package com.agritrace.edairy.desktop.common.ui.controls.profilephoto;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.UUID;

import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.riena.core.Log4r;
import org.eclipse.riena.core.util.ListenerList;
import org.eclipse.riena.ui.ridgets.AbstractCompositeRidget;
import org.eclipse.riena.ui.ridgets.ILabelRidget;
import org.eclipse.riena.ui.ridgets.ILinkRidget;
import org.eclipse.riena.ui.ridgets.listener.ISelectionListener;
import org.eclipse.riena.ui.ridgets.listener.SelectionEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTException;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.osgi.service.log.LogService;

import com.agritrace.edairy.desktop.common.persistence.services.ImageDataUtil;
import com.agritrace.edairy.desktop.common.ui.activator.Activator;

/**
 * An ImageWidget is a combination of a Label and a Link. The Label is used to
 * display the image while the Link is used to trigger selection of a new image
 * file to display.
 * 
 * @author bjones
 * 
 */
public class ProfilePhotoRidget extends AbstractCompositeRidget implements IProfilePhotoRidget {
	private ListenerList<ISelectionListener> listeners = new ListenerList<ISelectionListener>(ISelectionListener.class);

	private final class LinkSelected implements ISelectionListener {
		@Override
		public void ridgetSelected(SelectionEvent event) {
			File imageFile = getImageFile();
			if (imageFile != null && imageFile.canRead()) {
				imageData = readImageData(imageFile);
				if (imageData != null) {
					updateModel();
					updateDisplay();
					
					for (ISelectionListener listener : listeners.getListeners()) {
						listener.ridgetSelected(event);
					}
				} else {
					log(LogService.LOG_WARNING, "Null returned from readImageData. File not found?");
				}
			}
		}
	}

	public static final long MAX_IMAGE_SIZE = 128 * 1024;
	// private static final ImageData BLANK_IMAGE_DATA = new ImageData(150, 200, 8, new PaletteData(0, -1, 255));

	private String id;
	private ImageData imageData;
	private ILabelRidget profileImageLabel;
	private IObservableValue modelObj;
	private IConverter converter;
	private String currentKey;

	public ProfilePhotoRidget() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 
	 */
	@Override
	public void updateFromModel() {
		if (modelObj == null) {
			imageData = null;
			currentKey = null;
		} else {
			String key = (String) modelObj.getValue();
			if (key == null) {
				imageData = null;
				currentKey = null;
			} else if (!key.equals(currentKey)) {
				currentKey = key;
				imageData = ImageDataUtil.getInstance().getImageData(currentKey);
			}
		}
		updateDisplay();
	}

	/**
	 * 
	 */
	@Override
	public void configureRidgets() {
		profileImageLabel = getRidget(ILabelRidget.class, "profileImageLabel");
		ILinkRidget updateImageLink = getRidget(ILinkRidget.class, "updateImageLink");

		if (updateImageLink != null) {
			updateImageLink.addSelectionListener(new LinkSelected());
		} else {
			System.err.println("> Debug: Error! Null link Ridget.");
		}
	}

	@Override
	public void bindToModel(Object valueHolder, String valuePropertyName) {
		bindToModel(PojoObservables.observeValue(valueHolder, valuePropertyName));
	}

	@Override
	public void bindToModel(IObservableValue obj) {
		modelObj = obj;
		updateFromModel();
		updateDisplay();
		modelObj.addValueChangeListener(new IValueChangeListener() {
			@Override
			public void handleValueChange(ValueChangeEvent event) {
				updateDisplay();
			}
		});
	}

	@Override
	public IConverter getModelToUIControlConverter() {
		return converter;
	}

	@Override
	public void setModelToUIControlConverter(IConverter converter) {
		this.converter = converter;
	}

	/**
	 * 
	 */
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

	/**
	 * 
	 * 
	 * @return
	 */
	private File getImageFile() {
		final Shell shell = PlatformUI.getWorkbench().getDisplay().getActiveShell();
		final int swtOptions = SWT.DIALOG_TRIM | SWT.SHEET;
		final String fName = new FileDialog(shell, swtOptions).open();
		return (fName != null) ? new File(fName) : null;
	}

	/**
	 * 
	 * @param imageFile
	 * @return
	 */
	private ImageData readImageData(File imageFile) {
		log(LogService.LOG_DEBUG, "readImageData: reading file " + imageFile);
		ImageData imageData = null;
		InputStream fStream = null;
		if (imageFile != null) {
			if (!imageFile.canRead() || !imageFile.isFile()) {
				throw new IllegalArgumentException(String.format("Error - file '%s' is not a legal file type.",
						imageFile.getPath()).toString());
			}
		} else {
			throw new IllegalArgumentException("Internal Error - no file.");
		}

		try {
			fStream = new BufferedInputStream(new FileInputStream(imageFile));
			imageData = new ImageData(fStream);
			if (imageFile.length() > MAX_IMAGE_SIZE) {
				double shrinkRatio = (double) MAX_IMAGE_SIZE / (double) imageFile.length();
				imageData = imageData.scaledTo((int) (shrinkRatio * imageData.width),
						(int) (shrinkRatio * imageData.height));
				log(LogService.LOG_INFO, "Scaled original from " + imageFile.length());
			}

		} catch (FileNotFoundException fnfe) {
			MessageDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
					"Error opening file", String.format("Error opening file %s: %s", imageFile, fnfe.getMessage()));
			return null;
		} catch (SWTException se) {
			MessageDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
					"Error opening file", String.format("Error opening file %s: %s", imageFile, se.getMessage()));
			return null;
		} finally {
			try {
				fStream.close();
			} catch (Exception e) {
			}
		}
		return imageData;
	}

	/**
	 * Persist the current image.
	 * 
	 * @param imageData
	 */
	private void updateModel() {
		if (modelObj == null) {
			throw new IllegalStateException("Model should not be null - did you forget to call 'setModel'?");
		}
		// scale the image
		// if (imageData.data.length > MAX_IMAGE_SIZE) {
		// float scale = (float)imageData.data.length / (float)MAX_IMAGE_SIZE;
		// log(LogService.LOG_DEBUG,
		// String.format("Scaling %d image from  %dx%d using scale %f",
		// imageData.data.length, imageData.width, imageData.height, scale));
		// imageData = imageData.scaledTo((int)(imageData.width / scale),
		// (int)(imageData.height / scale));
		// log(LogService.LOG_DEBUG, String.format("Scaled to  %dx%d",
		// imageData.width, imageData.height));
		// if (imageData.data.length > MAX_IMAGE_SIZE) throw new
		// IllegalStateException("internal error: image scale failed - length = "
		// + imageData.data.length);
		// }
		String imageRefKey = (String) modelObj.getValue();
		if (imageRefKey == null) {
			imageRefKey = UUID.randomUUID().toString();
			modelObj.setValue(imageRefKey);
		}
		
		ImageDataUtil.getInstance().saveImageData(imageRefKey, imageData);
	}

	private void updateDisplay() {
		log(LogService.LOG_DEBUG, "updateDisplay: profileImageLabel: " + profileImageLabel);

		if (profileImageLabel == null) {
			return;
		}

		final Object control = profileImageLabel.getUIControl();
		if (control instanceof Label) {
			Label label = (Label) control;
			if (imageData == null) {
				label.setImage(null);
				return;
			}

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

	/**
	 * 
	 */
	private void log(int level, String message) {
		Log4r.getLogger(Activator.getDefault(), getClass()).log(level, message);
	}

	@Override
	public void addLinkSelectionListener(ISelectionListener listener) {
		listeners.add(listener);
	}

	@Override
	public void removeLinkSelectionListener(ISelectionListener listener) {
		listeners.remove(listener);
	}
}