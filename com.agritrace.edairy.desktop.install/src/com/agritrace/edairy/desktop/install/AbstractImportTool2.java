package com.agritrace.edairy.desktop.install;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.io.IOException;
import java.io.Reader;
import java.util.Date;
import java.util.EventListener;
import java.util.EventObject;

import org.eclipse.core.runtime.ListenerList;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.equinox.log.Logger;
import org.eclipse.jface.util.SafeRunnable;
import org.eclipse.riena.core.Log4r;

import com.agritrace.edairy.desktop.install.AbstractImportTool2.ImportEvent.EventType;
import com.csvreader.CsvReader;

public abstract class AbstractImportTool2 {

	/**
	 * 
	 * @author bjones
	 *
	 */
	public interface ImportEventListener extends EventListener {
		void beginImport(ImportEvent evt);
		void beforeImportRow(ImportEvent evt);
		void importRow(ImportEvent evt);
		void importRowException(ImportEvent evt);
		void importComplete(ImportEvent evt);
		void importFailed(ImportEvent evt);
	}


	/**
	 * 
	 * @author bjones
	 *
	 */
	public static class ImportEvent extends EventObject {
		enum EventType { BEGIN, BEFORE_ROW, ROW, ROW_EXCEPTION, COMPLETE, FAILED };

		/**
		 */
		private static final long serialVersionUID = 1L;
		
		/**
		 */
		protected EventType eventType;
		
		/**
		 * 
		 * @param source
		 */
		public ImportEvent(Object source, EventType type) {
			super(source);
			eventType = type;
		}
	}
	
	/**
	 * 
	 * @author bjones
	 *
	 */
	public static class RowImportEvent extends ImportEvent {
		private static final long serialVersionUID = 1L;
		
		/**
		 * 
		 */
		public String values[];
		
		/**
		 * 
		 * @param source
		 * @param type
		 * @param values
		 */
		RowImportEvent(Object source, EventType type, String[] values) {
			super(source, type);
			this.values = values;
		}
	}
	
	/**
	 * 
	 * @author bjones
	 *
	 */
	public static class RowImportExceptionEvent extends RowImportEvent {
		private static final long serialVersionUID = 1L;
		
		/**
		 * 
		 */
		public Exception exception;
		
		/**
		 * 
		 * @param source
		 * @param type
		 * @param values
		 */
		RowImportExceptionEvent(Object source, EventType type, String[] values, Exception exception) {
			super(source, type, values);
			this.exception = exception;
		}
	}

	public static class ImportFailedEvent extends ImportEvent {
		private static final long serialVersionUID = 1L;
		
		/**
		 * 
		 */
		public Exception exception;
		
		/**
		 * 
		 * @param source
		 */
		ImportFailedEvent(Object source, final Exception e) {
			super(source, EventType.FAILED);
			this.exception = e;
		}		
	}
	
	protected Reader reader;
	private int count, errors;
	private ListenerList listeners;

	public void setReader(Reader reader) {
		this.reader = reader;
	}

	public Reader getReader() {
		return this.reader;
	}
	
	public void processFile() throws IOException {
		CsvReader csvReader = new CsvReader(reader);
		csvReader.readRecord();
		String[] headers = csvReader.getValues();
		try {
			// csvReader.setHeaders(headers);
			fireBegin(headers);
			while (csvReader.readRecord()) {
				String[] values = csvReader.getValues();
				try {
					fireBeforeImportRow(values);
					fireImportRow(values);
					count++;
				} catch (ValidationException e) {
					errors++;
					fireRowException(values, e);
				}
			}
			
			fireImportComplete(count, errors);
		}
		catch(ValidationException e) {
			fireImportFailed(e);
		}
	}


	private void fireBegin(final String[] headers) {
		Object[] array = listeners.getListeners();
		for (int i = 0; i < array.length; i++) {
			final ImportEventListener l = (ImportEventListener) array[i];
			SafeRunnable.run(new SafeRunnable() {
				public void run() {
					l.beginImport(new RowImportEvent(this, EventType.BEGIN, headers));
				}
			});
		}
	}

	private void fireBeforeImportRow(final String[] values) {
		Object[] array = listeners.getListeners();
		for (int i = 0; i < array.length; i++) {
			final ImportEventListener l = (ImportEventListener) array[i];
			SafeRunnable.run(new SafeRunnable() {
				public void run() {
					l.beforeImportRow(new RowImportEvent(this, EventType.BEFORE_ROW, values));
				}
			});
		}
	}

	private void fireImportRow(final String[] values) {
		Object[] array = listeners.getListeners();
		for (int i = 0; i < array.length; i++) {
			final ImportEventListener l = (ImportEventListener) array[i];
			SafeRunnable.run(new SafeRunnable() {
				public void run() {
					l.importRow(new RowImportEvent(this, EventType.BEFORE_ROW, values));
				}
			});
		}
	}

	private void fireRowException(final String[] values, final Exception e) {
		Object[] array = listeners.getListeners();
		for (int i = 0; i < array.length; i++) {
			final ImportEventListener l = (ImportEventListener) array[i];
			SafeRunnable.run(new SafeRunnable() {
				public void run() {
					l.importRowException(new RowImportExceptionEvent(this, EventType.BEFORE_ROW, values, e));
				}
			});
		}
	}

	private void fireImportComplete(int succeeded, int failed) {
		Object[] array = listeners.getListeners();
		for (int i = 0; i < array.length; i++) {
			final ImportEventListener l = (ImportEventListener) array[i];
			SafeRunnable.run(new SafeRunnable() {
				public void run() {
					l.importComplete(new ImportEvent(this, EventType.COMPLETE));
				}
			});
		}

	}
	
	private void fireImportFailed(final Exception e) {
		Object[] array = listeners.getListeners();
		for (int i = 0; i < array.length; i++) {
			final ImportEventListener l = (ImportEventListener) array[i];
			SafeRunnable.run(new SafeRunnable() {
				public void run() {
					l.importFailed(new ImportFailedEvent(this,e));
				}
			});
		}
	}


	public void validateHeaders(String[] expectedHeaders, String[] actualHeaders) {
		String errorMessage = null;
		if (expectedHeaders != null) {
			if (actualHeaders.length != expectedHeaders.length)
				throw new ValidationException("Number of fields does not match - found " + actualHeaders.length
						+ " expected " + expectedHeaders.length);
			for (int i = 0; i < expectedHeaders.length; i++) {
				if (expectedHeaders[i] == null)
					continue;
				String expected = expectedHeaders[i].trim();
				String actual = actualHeaders[i].trim();
				if (!expected.equals(actual)) {
					if (errorMessage == null) {
						errorMessage = "Mismatched headers: \n";
					}
					errorMessage += "    " + i + " - was: '" + actualHeaders[i] + "', expected '" + expectedHeaders[i]
							+ "'\n";
				}
			}
			if (errorMessage != null)
				throw new ValidationException(errorMessage);
		}
	}

	public static Object convert(EStructuralFeature feature, String value) {
		Class<?> instanceClass = feature.getEType().getInstanceClass();
		Object retVal = value;
		if (Date.class.isAssignableFrom(instanceClass)) {
			try {
				retVal = new Date(value);
			} catch (Exception e) {
				retVal = null;
			}
		} else if (Integer.class.isAssignableFrom(instanceClass)) {
			System.err.println(">> Converting from " + value + " (" + instanceClass + ") to Integer");
			try {
				retVal = new Integer(value);
			} catch (Exception e) {
				retVal = null;
			}
		}
		return retVal;
	}

	public void log(int level, String message, Object... args) {
		final Logger logger = Log4r.getLogger(getClass());
		logger.log(level, String.format(message, args));
	}


}