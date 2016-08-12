/**
 * 
 */
package net.xjbean.snake.snake;

import java.util.LinkedList;
import java.util.List;

import net.xjbean.snake.Board;
import net.xjbean.snake.Food;
import net.xjbean.snake.GameCont;
import net.xjbean.snake.Point;
import net.xjbean.snake.direct.*;

/**
 * @author xjBean
 *
 */
public class Snake {	
	
	private Board itsBoard;     	//蛇活动面板  
	
	private State state;        	//蛇状态(蛇长,速度,蛇身形态等)
	private Direction direction;	//蛇运动方向
	
	/* 
	 * 为解决"当蛇转向太快时,撞到自身而死"问题.
	 * 含意: 蛇是否刚变过方向(即变过向后尚未移动则为true)
	 */
	private boolean isRecentTurned;
	      
	public Snake(){}
	
	public Snake(Board board){	
		this.itsBoard = board;
		this.direction = GameCont.RIGHT; //设定蛇的初始运动方向为右
		initState();
	}

	public Snake(Board board, State state, Direction direction){
		this.itsBoard = board;
		this.direction = direction;
		initState();
	}
	
	private void  initState(){
		if(direction != GameCont.RIGHT){
			throw new RuntimeException("Initialized direction error." +
					"The initialized direction must be RIGHT .");
					
		}
		
		this.state = new State();
	}
	
	private void eatFood(){
		Food food = itsBoard.getFood();
		Point snakeNode = new SnakeNode(food.getPosX(), food.getPosY());			
		state.addToHead(snakeNode);
		
		food.drawSquare(GameCont.COLOR_SNAKE,  	//原食物点换为蛇身颜色(为显示)
				GameCont.COLOR_SNAKE_BORDER);   
			
		itsBoard.produceFood();
	}

	//蛇顺其移动方向向前移动一格
	private void moveTo(Point frontPoint){
		
		/*
		 * 以后此擦除是否要改进? 完全擦除而又重绘蛇身,会否造成显示延迟,
		 * 造成不良视觉效果? 还是只需擦掉尾,绘制头呢? 需重构之
		 */
		eraseSnakeTail();
		
		Point tail = state.deleteSnakeTail();
		tail.setX_Y(frontPoint.getPosX(), frontPoint.getPosY());
		state.addToHead(tail);
		
		drawSnakeHead();
	}
	
	private void eraseSnakeTail(){
		List<Point> body = getBody();
		body.get(body.size() - 1).eraseSquare();
	}
	
	private void drawSnakeHead(){
		getBody().get(0).drawSquare();
	}
	
	/*
	 * 目的: 判断指定坐标点的障碍类型.
	 */
	private int judgeObstacle(Point point){
		if(isWall(point) || intoSelf(point)){		
			return GameCont.OBSTACLE_BLOCK;
		}
		
		if(isFood(point)){		       
			return GameCont.OBSTACLE_FOOD;
		} 

		return GameCont.OBSTACLE_NULL;
	}
	
	private Point getFrontPoint(){
		return direction.getFrontPoint(getHead());
	}
	
	//坐标点为墙
	private boolean isWall(Point point){
		if((point.getPosX() < 0) || (point.getPosY() < 0) ||   
		   (point.getPosX() >= GameCont.BOARD_WIDTH) || 
		   (point.getPosY() >= GameCont.BOARD_LENGTH)){		
			return true;
		}	
		return false;
	}
	
	//坐标点为食物
	private boolean isFood(Point point){
		if(point.equals(itsBoard.getFood())){		        
			return true;
		} 	
		return false;
	}
	
	//坐标点包含于蛇身
	private boolean intoSelf(Point point){
		if(state.getShape().contains(point)){      
			return true;
		}	
		return false;
	}
	
	private void turn(int wantToTurn){
		/*
		 * 如果之前瞬间没有被转过向(即不允许连续两次在没有移动
		 * 的情况下转向)
		 */
		if(!isRecentTurned){
			this.direction = direction.turn(wantToTurn);
			isRecentTurned = true;
		}
	}
	
	//蛇坚定不移地要向前移动一格
	public void moveWhatEver(){
		final Point frontPoint = getFrontPoint();
		switch(judgeObstacle(frontPoint)){
			case GameCont.OBSTACLE_NULL:			  	 //前方空	
				moveTo(frontPoint);
				break;
			case GameCont.OBSTACLE_FOOD:              	 //前方食物
				eatFood();
				break;
			case GameCont.OBSTACLE_BLOCK:			 	 //前方墙或蛇身
				itsBoard.notifyGameOver();
				break;
		}
		
		isRecentTurned = false; //移动后改变该值
	}
	
	//北转(上)
	public void turnUp(){
		turn(GameCont.DIREC_UP);
	}
	
	//南转(下)
	public void turnDown(){
		turn(GameCont.DIREC_DOWN);
	}
	
	//西转(左)
	public void turnLeft(){
		turn(GameCont.DIREC_LEFT);
	}
	
	//东转(右)
	public void turnRight(){
		turn(GameCont.DIREC_RIGHT);
	}
	
	public Point getTail(){	
		return (Point)((LinkedList)state.getShape()).getLast();
	}
	
	public Point getHead(){
		return (Point)((LinkedList)state.getShape()).getFirst();
	}
	
	public int getLength(){
		return state.getLength();
	}
	
	public int getSpeed(){
		return state.getSpeed();
	}
	
	public Direction getDirection(){
		return direction;
	}
	
	public List<Point> getBody(){
		return state.getShape();
	}
	
	 //绘制整个蛇身(曾使用)
	public synchronized void drawSnake(){
		List<Point> body = getBody();
		for(int i = 0; i < body.size(); i++){
			body.get(i).drawSquare();
		}
	}
	
	//擦除整个蛇身(曾使用)
	public synchronized void eraseSnake(){
		List<Point> body = getBody();
		for(int i = 0; i < body.size(); i++){
			body.get(i).eraseSquare();
		}
	}
}
