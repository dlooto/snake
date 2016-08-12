/**
 * 
 */
package net.xjbean.snake;

import net.xjbean.util.IntUtils;
import net.xjbean.snake.snake.Snake;
import net.xjbean.snake.ui.Game;

/**
 * 游戏面板
 * 
 * @author xjBean
 *
 */
public class Board {
	
	private Game itsGame;
	
	private int width;		//游戏面板横向宽度
	private int length;    	//游戏面板纵向长度
	
	private Snake snake;  
	private Food food;     	
	
	public Board(){}
	
	public Board(int width, int length){
		this.width = width;
		this.length = length;
		init();
	}
	
	//生成蛇和食物
	private void init(){
		snake = new Snake(this);
		produceFood();
	}
	
	//在随机位置生成食物
	public void produceFood(){
		while(true){
			Food food = getRandomFood();
			if(!intoSnakeBody(food)){//生成的食物不能在蛇身
				this.food = food;
				break;
			} 					
		}
		
		food.drawSquare();
	}
	
	public void notifyGameOver(){
		itsGame.endGame();
	}
	
	//在随机坐标点构造食物
	private Food getRandomFood(){
		int x = IntUtils.getRandom(getDivide(width)) * GameCont.SQUARE_SIZE;
		int y = IntUtils.getRandom(getDivide(length)) * GameCont.SQUARE_SIZE;
		
		return (new Food(x, y));
	}
	
	//返回整除SQUARE_SIZE后的值
	private int getDivide(int size){
		return size / GameCont.SQUARE_SIZE;
	}
	
	//判断坐标点是否位于蛇身
	private boolean intoSnakeBody(Point point){
		return snake.getBody().contains(point);
	}
	
	//定点产生食物    //Used for testing   *********************
	public void newFood(int x, int y){
		this.food = new Food(x, y);
	}
	
	public int getLength() {
		return length;
	}

	public int getWidth() {
		return width;
	}

	public Snake getSnake() {
		return snake;
	}

	public void setSnake(Snake snake) {
		this.snake = snake;
	}

	public Food getFood() {
		return food;
	}
	
	public void setGame(Game game){
		this.itsGame = game;
	}
}
