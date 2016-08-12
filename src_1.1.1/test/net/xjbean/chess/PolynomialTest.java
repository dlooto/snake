/**
 * Created on 2008-5-23
 */
package net.xjbean.chess;

import net.xjbean.util.PolyUtils;

/**
 * 多项式操作测试用例
 * 
 * @author xjBean
 *
 */
public class PolynomialTest extends BaseArrayTestCase {
	
	public PolynomialTest(String name) {
		super(name);
	}
	
	public static void main(String[] args){
		junit.textui.TestRunner.main(new String[]{"PolynomialTest"});
	}
	
	public void setUp(){	
	}
	
	//测试多项式相乘
	public void testPolyMultiply(){
		int[] rc1 = new int[]{1,1,1};
		int[] rc2 = new int[]{1,1,1};		
		
		int[] r = PolyUtils.polyMultiply(rc1, rc2);  //ArrayUtils.printArrayElements(r);	
		assertArrayEquals(r,new int[]{1,2,3,2,1});
	}
	
	//测试多项式相加
	public void testPolyAdd(){
		int[] r1 = new int[]{1,1,2,3};
		int[] r2 = new int[]{0,1,1};		
		assertArrayEquals(new int[]{1,2,3,3},PolyUtils.polyAdd(r1,r2));
		
		r1 = new int[]{0,1,1};
		r2 = new int[]{0,1};		
		assertArrayEquals(new int[]{0,2,1},PolyUtils.polyAdd(r1,r2));
	}
	
	//测试多项式升幂
	public void testPolyPromote(){
		int[] r = new int[]{1,1};
		assertEquals(3,PolyUtils.polyPromote(r).length);
		
		r = new int[]{1,1,2};
		assertArrayEquals(new int[]{0,1,1,2},PolyUtils.polyPromote(r));
		
		r = new int[]{0,1,1};
		assertArrayEquals(new int[]{0,0,1,1},PolyUtils.polyPromote(r));
	}
	
}
