/**
 * 
 */
package net.xjbean.temp;

import junit.framework.TestCase;

/**
 * @author xjBean
 *
 */
public class SwitchTest extends TestCase {

	public SwitchTest(String arg0) {
		super(arg0);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testSwitchExpression(){
		int n = 2;
		switch(n){
		case 3:
			System.out.println("is OK !  " + n);
			break;
		case 1:
		case 2:
			System.out.println("is OK ! ");
			break;
		default:
			System.out.println("default ! ");
		}
	}
}
