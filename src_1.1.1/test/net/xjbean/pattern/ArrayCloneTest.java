package net.xjbean.pattern;

import net.xjbean.chess.BaseArrayTestCase;
import net.xjbean.prelearn.*;
import net.xjbean.util.ArrayUtils;

public class ArrayCloneTest extends BaseArrayTestCase {

	public ArrayCloneTest(String name){
		super(name);
	}
	
	public void testArrayClone(){
		//测试Template模式
		ArrayHandle arrayHandle = new IntArrayHandle();
		int[] srcArray1 = new int[]{1,2,3,4,5};
		arrayHandle.setArray(srcArray1);
		assertArrayEquals(srcArray1,(int[])arrayHandle.clone());
		
		arrayHandle = new LongArrayHandle();
		long[] srcArray2 = new long[]{1,2,3,4,5};
		arrayHandle.setArray(srcArray2);
		assertArrayEquals(srcArray2,(long[])arrayHandle.clone());
	}
}
