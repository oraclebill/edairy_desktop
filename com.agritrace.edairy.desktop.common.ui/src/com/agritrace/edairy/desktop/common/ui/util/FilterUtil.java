package com.agritrace.edairy.desktop.common.ui.util;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections.Predicate;
import org.eclipse.equinox.log.Logger;
import org.eclipse.riena.core.Log4r;
import org.osgi.service.log.LogService;

import com.agritrace.edairy.desktop.common.ui.activator.Activator;

public class FilterUtil {

	public static abstract class DateComparisonPredicate implements Predicate {
		private final Date comparisonPoint;
		private final String propertyName;

		public DateComparisonPredicate(Date earlyDate) {
			this(earlyDate, null);
		}

		public DateComparisonPredicate(Date earlyDate, String propertyName) {
			this.comparisonPoint = earlyDate;
			this.propertyName = propertyName;
		}

		@Override
		public boolean evaluate(Object obj) {
			Date testDate = null;

			if (obj == null) {
				return true;
			} else if (propertyName != null) {
				obj = resolveProperty(obj);
			}

			if (obj instanceof Date) {
				testDate = (Date) obj;
			} else {
				throw new IllegalArgumentException(String.format(
						"Parameter type '%s' found in property '%s' expecting java.util.Date", obj.getClass(),
						propertyName == null ? "" : propertyName));
			}
			return evaluate(comparisonPoint, testDate);
		}

		private Object resolveProperty(Object obj) {
			Object propVal = null;
			try {
				propVal = PropertyUtils.getNestedProperty(obj, propertyName);
			} catch (IllegalAccessException e) {
				LOGGER.log(LogService.LOG_ERROR, "error getting property: programming error.", e);
			} catch (InvocationTargetException e) {
				LOGGER.log(LogService.LOG_ERROR, "unexpected error getting property", e);
			} catch (NoSuchMethodException e) {
				LOGGER.log(LogService.LOG_ERROR, "error getting property: programming error.", e);
			}
			return propVal;
		}

		protected abstract boolean evaluate(Date earlyDate2, Date testDate);
	}

	public static class DateAfterPredicate extends DateComparisonPredicate {
		public DateAfterPredicate(Date earlyDate) {
			this(earlyDate, null);
		}

		public DateAfterPredicate(Date earlyDate, String propertyName) {
			super(earlyDate, propertyName);
		}

		@Override
		protected boolean evaluate(Date comparisonPoint, Date testDate) {
			return testDate.after(comparisonPoint);
		}
	}

	public static class DateBeforePredicate extends DateComparisonPredicate {
		public DateBeforePredicate(Date earlyDate) {
			this(earlyDate, null);
		}

		public DateBeforePredicate(Date earlyDate, String propertyName) {
			super(earlyDate, propertyName);
		}

		@Override
		protected boolean evaluate(Date comparisonPoint, Date testDate) {
			return testDate.before(comparisonPoint);
		}
	}

	public static class IsSubStringPredicate implements Predicate {

		private final String substring;

		public IsSubStringPredicate(String substring) {
			if (substring == null) {
				substring = "";
			} else {
				substring = substring.trim();
			}

			this.substring = substring;
		}

		@Override
		public boolean evaluate(Object obj) {
			boolean ret = false;
			if (obj instanceof String) {
				final String testString = (String) obj;
				ret = testString.contains(substring);
			}
			return ret;
		}
	}

	private static final Logger LOGGER = Log4r.getLogger(Activator.getDefault(), FilterUtil.class);
	public static final String FILTER_EQUALS = null;
	public static final String FILTER_GREATER_THAN = null;
	public static final String FILTER_LESS_THAN = null;

	public static Predicate createDateAfterPredicate(Date testDate) {
		return new DateAfterPredicate(testDate);
	}

	public static Predicate createDateBeforePredicate(Date testDate) {
		return new DateBeforePredicate(testDate);
	}

	public static Predicate createIsSubStringPredicate(String testString) {
		return new IsSubStringPredicate(testString);
	}

	private FilterUtil() {
		throw new IllegalStateException("This class is only a holder for static methods - do not instantiate.");
	}

}
