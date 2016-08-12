/**
 * 
 */
package net.xjbean.snake.snake;

import net.xjbean.snake.GameCont;
import net.xjbean.snake.Point;

import org.eclipse.swt.graphics.Color;

/**
 * @author xjBean
 *
 */
public class SnakeNode extends Point {

	public SnakeNode(){
		super();
	}
	
	public SnakeNode(int posX, int posY){
		super(posX, posY);
	}

	@Override
	public Color getBorderColor() {
		return GameCont.COLOR_WHITE;
	}

	@Override
	public Color getColor() {
		return GameCont.COLOR_SNAKE;
	}
}
