package net.xjbean.temp;

import net.xjbean.util.StringUtils;
import junit.framework.TestCase;

public class StringUtilsTest extends TestCase {

	public StringUtilsTest(String arg0) {
		super(arg0);
	}

	public void testStringMethod(){
		String str = StringUtils.cutTail("2008-05-12T16:35:14.300");
		
		assertEquals("2008-05-12T16:35:14".length(),str.length());
		assertEquals("2008-05-12T16:35:14",str);
	}
}
