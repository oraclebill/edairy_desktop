package com.agritrace.edairy.desktop.common.ui.util;

import java.util.Date;

import org.apache.commons.collections.Predicate;

public class FilterUtil {

	public static class DateAfterPredicate implements Predicate {	
		private Date earlyDate;		
		public DateAfterPredicate(Date earlyDate) {
			this.earlyDate = earlyDate;
		}
		@Override
		public boolean evaluate(Object obj) {
			boolean ret = false;
			if (obj instanceof Date) {
				Date testDate = (Date) obj;
				return earlyDate.before(testDate);
			}
			return ret;
		}				
	}
	
	public static class DateBeforePredicate implements Predicate {	
		private Date lateDate;		
		public DateBeforePredicate(Date lateDate) {
			this.lateDate = lateDate;
		}
		@Override
		public boolean evaluate(Object obj) {
			boolean ret = false;
			if (obj instanceof Date) {
				Date testDate = (Date) obj;
				return lateDate.after(testDate);
			}
			return ret;
		}				
	}
	
	public static class IsSubStringPredicate implements Predicate {	
		
		private String substring;
		
		public IsSubStringPredicate(String substring) {			
			if (substring == null) 
				substring = "";
			else 
				substring = substring.trim();
			
			this.substring = substring;
		}
		
		@Override
		public boolean evaluate(Object obj) {
			boolean ret = false;
			if (obj instanceof String) {
				String testString = (String) obj;
				return testString.contains(substring);
			}
			return ret;
		}				
	}
	
	
	public static final String FILTER_GREATER_THAN = null;
	public static final String FILTER_LESS_THAN = null;
	public static final String FILTER_EQUALS = null;
	
	private FilterUtil() {
		throw new IllegalStateException("This class is only a holder for static methods - do not instantiate.");
	}
	
	public static Predicate createDateBeforePredicate(Date testDate) {
		return new DateBeforePredicate(testDate);
	}
	
	public static Predicate createDateAfterPredicate(Date testDate) {
		return new DateAfterPredicate(testDate);
	}
	
	public static Predicate createIsSubStringPredicate(String testString) {
		return new IsSubStringPredicate(testString);
	}
	
}
