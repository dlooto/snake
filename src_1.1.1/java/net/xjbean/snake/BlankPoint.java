/**
 * 
 */
package net.xjbean.snake;

import org.eclipse.swt.graphics.Color;

/**
 * 游戏面板上的空白点坐标
 * 
 * @author xjBean
 *
 */
public class BlankPoint extends Point {

	public BlankPoint() {
	}

	public BlankPoint(int posX, int posY) {
		super(posX, posY);
	}

	@Override
	public Color getBorderColor() {
		return GameCont.COLOR_BLACK;
	}

	@Override
	public Color getColor() {
		return GameCont.COLOR_BLACK;
	}

}
