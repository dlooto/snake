/**
 * 
 */
package net.xjbean.snake;

import java.util.LinkedList;
import java.util.List;

import net.xjbean.snake.snake.State;

import junit.framework.TestCase;

/**
 * @author xjBean
 *
 */
public class SnakeMoveTest extends BaseSnakeTest {

	public SnakeMoveTest(String arg0) {
		super(arg0);
	}

	public void testKnockWall(){
		Point head = new BlankPoint(GameCont.BOARD_WIDTH - 1, 0);
		snake.setState(new State(head, -1));

		snake.moveWhatEver();		
	}
	
	//无障碍移动
	public void testKnockNull(){
		Point head = new BlankPoint(5,5);
		snake.setState(new State(head,3,3,GameCont.DIREC_RIGHT));//设置右移
		
		//移动前
		int len = snake.getLength();
		assertEquals(new BlankPoint(5,5), snake.getHead());
		assertEquals(new BlankPoint(3,5), snake.getTail());  //蛇身默认长为3
		
		snake.moveWhatEver();
		
		//移动后
		assertEquals(new BlankPoint(6,5), snake.getHead());
		assertEquals(new BlankPoint(4,5), snake.getTail());
		assertEquals(len, snake.getLength());
	}
	
	//头撞蛇身
	public void testKnockSelf(){
		assertTrue(game.isGoing());
		Point head = new BlankPoint(5,5);
		snake.setState(new State(head,4,3,GameCont.DIREC_UP));//设置初始北移
			
		snake.turnRight();	//右转
		snake.moveWhatEver();
		assertTrue(game.isGoing());
		
		snake.turnDown();	//下转
		snake.moveWhatEver();
		assertTrue(game.isGoing());
		
		snake.turnLeft();	//左转
		snake.moveWhatEver();
		assertFalse(game.isGoing());
	}
}
