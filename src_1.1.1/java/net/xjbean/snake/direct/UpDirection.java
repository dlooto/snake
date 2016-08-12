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
public class UpDirection extends Direction {

	public UpDirection(){
		super();
	}

	@Override
	public Point getFrontPoint(Point snakeHead) {
		return new BlankPoint(snakeHead.getPosX(),
				snakeHead.getPosY() - GameCont.SQUARE_SIZE);
	}
}
