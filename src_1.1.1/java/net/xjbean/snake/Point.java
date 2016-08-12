/**
 * 
 */
package net.xjbean.snake;

import net.xjbean.snake.ui.SnakeGC;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.widgets.Display;

/**
 * 代表面板中某点坐标
 * 
 * @author xjBean
 *
 */
abstract public class Point {

	protected Display display;

	protected int posX;
	protected int posY;
	
	public Point(){}
	
	public Point(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
	}
	
	abstract public Color getColor();
	abstract public Color getBorderColor();
	
	//画方块
	public void drawSquare(){
		draw(getColor(), getBorderColor(), GameCont.SQUARE_SIZE);
	}
	
	//根据传入颜色可以同时作擦除绘制两用
	public void drawSquare(Color render, Color border){
		draw(render, border, GameCont.SQUARE_SIZE);
	}
	
	//擦除方块
	public void eraseSquare(){
		draw(GameCont.COLOR_BLACK, GameCont.COLOR_BLACK, //填充以黑色
				GameCont.SQUARE_SIZE);
	}
	
	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}
	
	public void setX_Y(int x, int y){
		posX = x;
		posY = y;
	}
	
	public boolean equals(Object obj){
		if (obj == null) { return false;}
		if (this == obj) { return true;}					
		if (!(obj instanceof Point)) { return false;}	
		
		final Point point = (Point) obj;
		if ((point.posX == this.posX) && (point.posY == this.posY)) {
			return true;
		}				
			
		return false;
	}
	
	public String toString(){
		StringBuffer result = new StringBuffer(40);
        result.append("[");
        result.append(this.posX);
        result.append(", ");
        result.append(this.posY);
        result.append("]");
        
        return result.toString();
	}
	
	private void draw(Color render, Color border, int len){
		GC gc = SnakeGC.getSnakeGC();
		gc.setBackground(render);
		gc.setForeground(border);
		
		gc.fillRectangle(posX + 1, posY + 1, len - 1, len - 1);		
		gc.drawLine(posX, posY, posX + len, posY);
		gc.drawLine(posX + len, posY, posX + len, posY + len);
		gc.drawLine(posX + len, posY + len, posX, posY + len);
		gc.drawLine(posX, posY + len, posX, posY);
	}
}
