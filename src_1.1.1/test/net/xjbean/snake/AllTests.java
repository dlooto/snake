package net.xjbean.snake;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for net.xjbean.snake");
		
		suite.addTestSuite(SnakeMoveTest.class);
		suite.addTestSuite(ShiftDirectionTest.class);
		suite.addTestSuite(EatFoodTest.class);
		
		return suite;
	}

}
