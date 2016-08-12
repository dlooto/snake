package net.xjbean.temp;

import junit.framework.TestCase;

public class IntTest extends TestCase {

	public IntTest(String arg0) {
		super(arg0);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}
	
	//测试整除
	public void testDivideExactly(){
		int len = 400;
		int wid = 555;
		
		assertEquals(40, len/10);
		assertEquals(55, wid/10);
		
	}

}
