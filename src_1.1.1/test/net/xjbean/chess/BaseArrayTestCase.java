/**
 * 
 */
package net.xjbean.chess;

import junit.framework.TestCase;

/**
 * @author xjBean
 *
 */
public class BaseArrayTestCase extends TestCase {

	public BaseArrayTestCase(String arg0) {
		super(arg0);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/*
	 * 比较int数组相等.需要重构，抽象出公共部分
	 */
	protected static void assertArrayEquals(int[] r1, int[] r2){
		assertEquals(r1.length, r2.length);
		for(int i = 0; i < r1.length; i++){
			assertEquals(r1[i], r2[i]);
		}
	}
	
	/*
	 * 比较long数组相等,与上一方法构成重载。需要重构，同上
	 */
	protected static void assertArrayEquals(long[] r1, long[] r2){
		assertEquals(r1.length, r2.length);
		for(int i = 0; i < r1.length; i++){
			assertEquals(r1[i], r2[i]);
		}
	}
}
