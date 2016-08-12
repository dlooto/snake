/**
 * 
 */
package net.xjbean.snake;

import net.xjbean.snake.snake.State;
import junit.framework.TestCase;

/**
 * @author xjBean
 *
 */
public class ShiftDirectionTest extends BaseSnakeTest {

	private int x;		//蛇头横坐标
	private int y;	    //蛇头纵坐标
	private int len;    //蛇长
	
	public ShiftDirectionTest(String arg0) {
		super(arg0);
	}

	//测试北转(上)
	public void testTurnUp(){
		Point head = new BlankPoint(10,10);
		snake.setState(new State(head,5,3,GameCont.DIREC_RIGHT));//设置初始右移
		snake.moveWhatEver();
		assertEquals(GameCont.DIREC_RIGHT,snake.getDirection());
		assertEquals(new BlankPoint(11,10), snake.getHead());
		assertEquals(new BlankPoint(7,10), snake.getTail());
		
		snake.turnUp();	//北转
		
		assertEquals(GameCont.DIREC_UP, snake.getDirection());//头转北
		assertEquals(new BlankPoint(11,10), snake.getHead());     //蛇身不移动
		assertEquals(new BlankPoint(7,10), snake.getTail());
		
		snake.moveWhatEver();
		
		assertEquals(GameCont.DIREC_UP, snake.getDirection());
		assertEquals(new BlankPoint(11,9), snake.getHead());		//头向北移一格
		assertEquals(new BlankPoint(8,10), snake.getTail());		//尾右移一格
	}
	
	//测试南转(下)
	public void testTurnDown(){
		Point head = new BlankPoint(10,10);
		snake.setState(new State(head,5,3,GameCont.DIREC_RIGHT));//设置初始右移
		snake.moveWhatEver();
		
		snake.turnDown();	//南转
		
		assertEquals(GameCont.DIREC_DOWN, snake.getDirection());//头转南
		assertEquals(new BlankPoint(11,10), snake.getHead());     	//蛇身不动
		assertEquals(new BlankPoint(7,10), snake.getTail());
		
		snake.moveWhatEver();
		
		assertEquals(GameCont.DIREC_DOWN, snake.getDirection());
		assertEquals(new BlankPoint(11,11), snake.getHead());		//头向南移一格
		assertEquals(new BlankPoint(8,10), snake.getTail());			//尾右移一格
	}
	
	//测试西转(左)
	public void testTurnLeft(){
		x = 10; y = 10; len = 5;
		
		Point head = new BlankPoint(x,y);
		snake.setState(new State(head,len,3,GameCont.DIREC_UP));//设置初始北移
		
		snake.turnLeft();	//西转
		
		assertEquals(GameCont.DIREC_LEFT, snake.getDirection());//头转西
		assertEquals(new BlankPoint(x, y), snake.getHead());     //蛇身不动
		assertEquals(new BlankPoint(x, y + len - 1), snake.getTail());
		
		snake.moveWhatEver();
		
		assertEquals(GameCont.DIREC_LEFT, snake.getDirection());
		assertEquals(new BlankPoint(x - 1, y), snake.getHead());		//头向西移一格
		assertEquals(new BlankPoint(x, y + len - 2), snake.getTail());		//尾北移一格
	}
	
	//测试东转(右)
	public void testTurnRight(){
		x = 5; y = 5; len = 3;
		
		Point head = new BlankPoint(x,y);
		snake.setState(new State(head,len,3,GameCont.DIREC_UP));//设置初始北移
		
		//System.out.println("Before turnRight and move:");
		//printSnakeBody(snake.getBody());
		
		snake.turnRight();	//东转
		
		assertEquals(GameCont.DIREC_RIGHT, snake.getDirection());//头转东
		assertEquals(new BlankPoint(x, y), snake.getHead());     	 //蛇身不动
		assertEquals(new BlankPoint(x, y + len - 1), snake.getTail());
		
		snake.moveWhatEver();
		
		assertEquals(GameCont.DIREC_RIGHT, snake.getDirection());
		assertEquals(new BlankPoint(x + 1, y), snake.getHead());		//头向东移一格
		assertEquals(new BlankPoint(x, y + len - 2), snake.getTail());		//尾北移一格
		
		//System.out.println("After turnRight and move:");
		//printSnakeBody(snake.getBody());
	}
}
