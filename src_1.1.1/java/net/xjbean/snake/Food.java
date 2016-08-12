/**
 * 
 */
package net.xjbean.snake;

import org.eclipse.swt.graphics.Color;

/**
 * @author xjBean
 *
 */
public class Food extends Point{
	
	public Food(){
		super();
	}
	
	public Food(int posX, int posY){
		super(posX, posY);
	}

	//食物颜色
	public Color getColor() {
		return GameCont.COLOR_FOOD;
	}
	
	//食物边框颜色
	public Color getBorderColor() {
		return GameCont.COLOR_BLACK;
	}
}
