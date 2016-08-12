/**
 * 
 */
package net.xjbean.snake.direct;

import net.xjbean.snake.GameCont;
import net.xjbean.snake.Point;

/**
 * 表示蛇运动方向的抽象类
 * 
 * @author xjBean
 *
 */
abstract public class Direction {
	
	protected Direction(){}
	
    //得到移动方向上的前方结点
	abstract public Point getFrontPoint(Point snakeHead);
	
	//子类LeftDirection与RightDirection重写,其他采用该默认实现
	public Direction turn(int wantToTurn){
		if(wantToTurn == GameCont.DIREC_LEFT){
			return GameCont.LEFT;
		} 
		
		if(wantToTurn == GameCont.DIREC_RIGHT){
			return GameCont.RIGHT;
		}
		
		return this;
	}
	
	//Avoid dulplicate code in subclass
	protected Direction turnUpOrDown(int wantToTurn){
		if(wantToTurn == GameCont.DIREC_UP){
			return GameCont.UP;
		}
		
		if(wantToTurn == GameCont.DIREC_DOWN){
			return GameCont.DOWN;
		}
		
		return this;
	}
}
