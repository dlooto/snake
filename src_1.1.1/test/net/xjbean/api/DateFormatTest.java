/**
 * 
 */
package net.xjbean.api;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import net.xjbean.util.StringUtils;

import junit.framework.TestCase;

/**
 * @author xjBean
 *
 */
public class DateFormatTest extends TestCase {

	/**
	 * @param arg0
	 */
	public DateFormatTest(String arg0) {
		super(arg0);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testString2Date(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		try {
			
			java.util.Date date = dateFormat.parse("2008-05-12T17:23:49");//"2008-05-12T17:23:49"

			System.out.println("date= "+date.getDate());
		
			System.out.println("date2= " + new java.util.Date());
			
			System.out.println("to format= " + dateFormat.format(new Date()));
			
		} catch (ParseException pe) {
			pe.printStackTrace();
		}
		
	}
	
	public void testFormatDate(){
		println("mat: "+StringUtils.formatDate(new Date(), "yyyy-MM-dd'T'HH:mm:ss"));
	}
	
	public void testDate2String(){
		Date date = new Date();
		println("date.toLocalString= "+date.toLocaleString());
	}
	
	private static void println(Object obj){
		System.out.println(obj);
	}
	
}
