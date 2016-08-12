/**
 * 
 */
package net.xjbean.api;

import net.xjbean.util.ArrayUtils;
import net.xjbean.util.IntUtils;
import junit.framework.TestCase;

/**
 * @author xjBean
 *
 */
public class RandomTest extends TestCase {

	public RandomTest(String name){
		super(name);
	}
	
	public void testGetRandom(){
		int scope = 101;
		
		for(int i=0; i < 1000; i++){
			int r = IntUtils.getRandom(scope);
			//System.out.print(IntUtils.getRandom(scope) + "  ");
			
			if((i % 20) == 0){
				//System.out.println();
			}
			assertTrue((r >= 0) && (r < scope));
			
		}
	}
	
	//测试随机数分布情况
	public void testRandomDistribute(){
		int scope = 11;
		int[] rate = new int[scope];
		ArrayUtils.clearToZero(rate);//清0
		
		for(int i=0; i < 1000000; i++){
			int r = IntUtils.getRandom(scope);
			rate[r]++;	
		}
		
		for(int i = 0; i < rate.length; i++){
			System.out.print(i + "(" + rate[i] + ")" + "     ");
			
			if((i % 20) == 0){
				System.out.println();
			}
		}
	}
}
