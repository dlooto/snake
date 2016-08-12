/**
 * 
 */
package net.xjbean.chess;

import junit.framework.TestCase;

import net.xjbean.util.IntUtils;

/**
 * @author xjBean
 * 
 * 算法的不同实现的性能测试用例
 */
public class PerformanceTest extends BaseArrayTestCase {
	
	public PerformanceTest(String arg0) {
		super(arg0);
	}
	
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	public void testGetFactorialArray(){
		long[] facArray = IntUtils.getFactorialArray(0);
		assertArrayEquals(new long[]{1},facArray);
		
		long[] facArray1 = IntUtils.getFactorialArray(1);
		assertArrayEquals(new long[]{1,1},facArray1);
		
		long[] facArray2 = IntUtils.getFactorialArray(5);
		assertArrayEquals(new long[]{1,1,2,6,24,120},facArray2);
	}
	
	 //测试计算阶乘 
	public void testCalFactorial(){
		int nn = 6;
		long value = 720;
		
		assertEquals(1,IntUtils.factorial(1));
		assertEquals(IntUtils.factorial(1),IntUtils.recursiveFactorial(1));
		
		assertEquals(value,IntUtils.factorial(nn));
		assertEquals(IntUtils.factorial(nn),IntUtils.recursiveFactorial(nn));
		
		System.out.println("Factorial value: " + IntUtils.recursiveFactorial(nn));	
	}
	
	public static void main(String[] args){
		junit.textui.TestRunner.main(new String[]{"PerformanceTest"});
	}
}
