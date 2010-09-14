package com.agritrace.edairy.desktop.common.persistence.services;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import org.eclipse.riena.core.Log4r;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.osgi.service.log.LogService;

import com.agritrace.edairy.desktop.common.model.base.ImageEntry;
import com.agritrace.edairy.desktop.common.model.base.ModelFactory;
import com.agritrace.edairy.desktop.internal.common.persistence.Activator;
import com.agritrace.edairy.desktop.internal.operations.services.DairyRepository;

public final class ImageDataUtil {
	private ImageDataUtil() { }

	/**
	 * 
	 */
	public static ImageData getImageData(String key) {
		ImageData ret = null;
		if (key != null) {
			try {
				ImageEntry entry = (ImageEntry) PersistenceManager.getDefault()
						.getSession().load("ImageEntry", key);
				final byte[] data = entry.getImageData();
				debug_print(key, data);
				InputStream stream = new ByteArrayInputStream(
						entry.getImageData());
				ret = new ImageData(stream);
			} catch (HibernateException hbe) {
				log(LogService.LOG_WARNING, hbe.getMessage(), hbe);
			}
		}
		return ret;
	}

	/**
	 * 
	 */
	public static void saveImageData(String key, ImageData data) {
		if (key == null) {
			return;
		}
		Session session = PersistenceManager.getDefault().getSession();
		try {
			Transaction tx = session.beginTransaction();
			ImageEntry entry = (ImageEntry) session.get("ImageEntry", key);
			if (entry == null) {
				entry = ModelFactory.eINSTANCE.createImageEntry();
				entry.setImageId(key);
				entry.setMimeType("image/unknown");
				session.save(entry);
			}
			final ByteArrayOutputStream baos = new ByteArrayOutputStream();
			final ImageLoader loader = new ImageLoader();
			loader.data = new ImageData[] { data };
			loader.save(baos, data.type);
			entry.setImageData(baos.toByteArray());
			entry.setMimeType(decodeMimeType(data.type));
			tx.commit();
		} catch (HibernateException hbe) {
			log(LogService.LOG_WARNING, "Error saving ImageEntry: " + key, hbe);
		} finally {
			if (session != null) {
				session.clear();
			}
		}

	}

	private static String decodeMimeType(int type) {
		String mimeType;

		switch (type) {
		case SWT.IMAGE_BMP:
		case SWT.IMAGE_BMP_RLE:
		case SWT.IMAGE_OS2_BMP:
			mimeType = "image/bmp";
			break;

		case SWT.IMAGE_GIF:
			mimeType = "image/gif";
			break;

		case SWT.IMAGE_ICO:
			mimeType = "image/gif";
			break;

		case SWT.IMAGE_JPEG:
			mimeType = "image/jpeg";
			break;

		case SWT.IMAGE_PNG:
			mimeType = "image/png";
			break;

		case SWT.IMAGE_TIFF:
			mimeType = "image/tiff";
			break;

		case SWT.IMAGE_UNDEFINED:
		default:
			mimeType = "application/octet-stream";
		}

		return mimeType;
	}

	private static void debug_print(String tag, byte[] array) {
		int COUNT = 64;
		System.err
				.println(String.format("First %d bytes of %s\n ", COUNT, tag));
		for (int i = 0; i < COUNT; i++) {
			System.err.print(String.format("%02x ", array[i]));
			if ((i + 1) % 32 == 0)
				System.err.print("\n");
		}
	}

	/**
	 * 
	 */
	private static void log(int level, String message, Throwable exception) {
		Log4r.getLogger(Activator.getDefault(), DairyRepository.class).log(level, message,
				exception);
	}
}
