/**
 * 
 */
package net.xjbean.util;

import java.util.Random;

/**
 *  整数工具类
 * 
 * @author xjBean
 */
public class IntUtils {
	
	/**
	 * 产生随机整数,取值在0-scope之间(不包括scope)
	 * @param scope 所要产生的随机整数的取值上界
	 * @return 随机整数
	 */
	public static int getRandom(int scope){
		Random r = new Random();
		return r.nextInt(scope);
	}
	
	/**
	 * 计算阶乘,非递归算法
	 *
	 */
	public static long factorial(int n){
		if((n == 0) || (n == 1)){
			return 1;
		}
		
		long k = 1;
		for(int i = 1; i < n+1; i++){
			k = i * k;
		}
		
		return k;
	}
	
	/**
	 * 计算阶乘，递归算法
	 */
	public static long recursiveFactorial(int n){
		if((n == 0) || (n == 1)){
			return 1;
		}else if(n == 2){
			return 2;
		}
		
		return n * recursiveFactorial(n-1);
	}
	
	/**
	 * 产生阶乘数组。如输入3，将得到数组int[]{0!,1!,2!,3!}
	 */
	public static long[] getFactorialArray(int n){
		long[] facArray = new long[n+1];
		facArray[0] = 1; //表示0的阶乘
		if(n == 0){
			return facArray;
		}

		long k = 1;
		for(int i = 1; i < n+1; i++){
			k = i * k;
			facArray[i] = k;
		}
		
		return facArray;
	}
	
}
