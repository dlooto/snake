/**
 *  
 */
package net.xjbean.chess;

import net.xjbean.api.JavaAPITest;
import net.xjbean.api.ListTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * 
 * @author xjBean
 *
 */
public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for default package");
		
		//$JUnit-BEGIN$
		suite.addTestSuite(ChessTest.class);
		suite.addTestSuite(PolynomialTest.class);
		suite.addTestSuite(PerformanceTest.class);
		//$JUnit-END$
		
		return suite;
	}

}
