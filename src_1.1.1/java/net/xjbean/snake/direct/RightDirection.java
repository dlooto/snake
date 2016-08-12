/**
 * 
 */
package net.xjbean.snake.direct;

import net.xjbean.snake.BlankPoint;
import net.xjbean.snake.GameCont;
import net.xjbean.snake.Point;

/**
 * @author xjBean
 *
 */
public class RightDirection extends Direction {
	
	public RightDirection(){
		super();
	}
	
	//转向
	public Direction turn(int wantToTurn){
		return turnUpOrDown(wantToTurn);
	}

	@Override
	public Point getFrontPoint(Point snakeHead) {
		return new BlankPoint(snakeHead.getPosX() + 
				GameCont.SQUARE_SIZE, snakeHead.getPosY());
	}
}
