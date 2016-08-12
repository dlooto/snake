/**
 * Created on 2008-5-25
 */
package net.xjbean.api;

import junit.framework.TestCase;

/**
 * Used for testing Java API 
 * 
 * @author xjBean
 * 
 */
public class JavaAPITest extends TestCase {

	public JavaAPITest(String arg0) {
		super(arg0);
	}

	//测试幂函数
	public void testPowOfMath(){
		assertEquals(1.0,Math.pow(-1,0));
		assertEquals(-1.0,Math.pow(-1,1));
		assertEquals(1.0,Math.pow(-1,2));
	}
	
}
