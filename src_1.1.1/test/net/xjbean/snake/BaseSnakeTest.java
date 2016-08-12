/**
 * 
 */
package net.xjbean.snake;

import java.util.List;

import net.xjbean.snake.Board;
import net.xjbean.snake.snake.Snake;
import net.xjbean.snake.snake.State;
import net.xjbean.snake.ui.Game;

import junit.framework.TestCase;

/**
 * @author xjBean
 *
 */
public class BaseSnakeTest extends TestCase {

	protected Game game;
	protected Board board;
	protected Snake snake;
	protected State initState;
	
	public BaseSnakeTest(String arg0) {
		super(arg0);
	}

	protected void setUp() throws Exception {
		super.setUp();		
		
		//初始化Game
		board = new Board(GameCont.BOARD_WIDTH,GameCont.BOARD_LENGTH);
		snake = new Snake(board);//蛇初始状态为默认值
		board.setSnake(snake);
		
		game = new Game();
		game.setBoard(board);
		board.setGame(game);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		
		snake = null;
		board = null;
		game  = null;
	}
	
	protected void printSnakeBody(List<Point> body){
		for(int i=0; i < body.size(); i++){
			System.out.print(body.get(i));
		}
		
		System.out.println();
	}
	
	protected void assertSnakeBodyEquals(List<Point> expects, List<Point> body){
		assertEquals(expects.size(),body.size());
		for(int i=0; i < body.size(); i++){
			assertEquals(expects.get(i),body.get(i));
		}
	}

}
