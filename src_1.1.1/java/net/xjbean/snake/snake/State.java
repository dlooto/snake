/**
 * 
 */
package net.xjbean.snake.snake;

import java.util.LinkedList;
import java.util.List;

import net.xjbean.snake.BlankPoint;
import net.xjbean.snake.GameCont;
import net.xjbean.snake.Point;

/**
 * 表示蛇的状态类
 * 
 * @author xjBean
 *
 */
public class State {
    
	//private int length;			     //蛇长
	private int speed;					 //蛇速
	private List<Point> body; 			 //蛇身形态  		
	
	/**
	 * 初始蛇头位置,蛇速均采用默认设定值
	 */
	public State(){
		initFields(null, -1);
	}
	
	/**
	 * Full parameters constructor
	 */
	public State(Point initHead, int speed){
		initFields(initHead, speed);
	}
	
	//删除蛇尾
	public Point deleteSnakeTail(){
		if(body instanceof LinkedList){
			return ((LinkedList<Point>)body).removeLast();
		} else {
			throw new RuntimeException("Delete snake tail Exception !");
		}
	}
	
	//添加到蛇头
	public void addToHead(Point point){
		if(body instanceof LinkedList){
			((LinkedList<Point>)body).addFirst(point);
		} else {
			throw new RuntimeException("Add snake head Exception !");
		}
	}
	
	public int getLength(){
		return body.size();
	}
	
	public int getSpeed() {
		return speed;
	}

	public List<Point> getShape() {
		return body;
	}
	
	//初始化属性值
	private void initFields(Point initHead, int speed){
		if(initHead == null){
			initHead = new BlankPoint(GameCont.INIT_POSITION_X,    //设定默认值
								 	  GameCont.INIT_POSITION_Y);
		} 	
		if(speed == -1){
			this.speed = GameCont.INIT_SPEED;
		} else {
			this.speed = speed;
		}
		
		this.body = initBody(initHead);
	}
	
	//初始蛇向右运动, 需向左构建蛇身
	private List<Point> initBody(Point initHead) {
		LinkedList<Point> snakeBody = new LinkedList<Point>();
		
		for(int i=0; i < GameCont.INIT_LENGTH; i++){
			Point snakeNode = new SnakeNode(initHead.getPosX() - i * GameCont.SQUARE_SIZE,
					initHead.getPosY());
			snakeBody.addLast(snakeNode);
		}
		return snakeBody;
	}
}
