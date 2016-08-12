/**
 * 
 */
package net.xjbean.snake;

import net.xjbean.snake.snake.State;


/**
 * @author xjBean
 *
 */
public class EatFoodTest extends BaseSnakeTest {

	public EatFoodTest(String arg0) {
		super(arg0);
	}

	//吃食物
	public void testEatFood(){
		//蛇初始位置在[GameCont.INIT_POSITION_X, GameCont.INIT_POSITION_Y]
		//蛇初始向右运动
		board.newFood(GameCont.INIT_POSITION_X + GameCont.SQUARE_SIZE,
				GameCont.INIT_POSITION_Y);
		assertEquals(new BlankPoint(10,10), snake.getHead());
		assertEquals(5, snake.getLength());
		
		snake.moveWhatEver();
		
		assertEquals(6,snake.getLength());
		assertEquals(new BlankPoint(GameCont.INIT_POSITION_X + GameCont.SQUARE_SIZE,
				GameCont.INIT_POSITION_Y), snake.getHead());
	}
	
	//测试随机生产食物 
	public void testProduceFood(){
		//测试生成的食物坐标不位于蛇身
		for(int i=0; i<1000; i++){
			board.produceFood();
			assertFalse(snake.getBody().contains(board.getFood()));
		}
	}
}
