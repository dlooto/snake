/**
 * 
 */
package net.xjbean.snake.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.widgets.Display;

import net.xjbean.snake.snake.Snake;
import net.xjbean.snake.ui.Runner;
import net.xjbean.snake.ui.SnakeGC;
import net.xjbean.snake.Board;
import net.xjbean.snake.GameCont;

/**
 * @author xjBean
 *
 */
public class Game {

	private Display display;int i = 0;
	private Runner runner;
	
	private Board board;
	private SnakeMovable snakeMoveThread;
	
	private int gameState = -1;			  //游戏状态,-1表示尚未开始游戏
	private int gameLevel = 1;			  //默认级别为1(低速)

	
	public Game(){	
		init();
	}
	
	public Game(Runner runner){	
		init();
		this.runner = runner;	
	}
	
	//初始化游戏面板
	private void init(){
		this.board = new Board(GameCont.BOARD_WIDTH, GameCont.BOARD_WIDTH);		
		board.setGame(this);
	}
	
	//开始游戏
	public void startGame(){	
		if(gameState == GameCont.GAME_OVER){//已进行过游戏则重新初始化
			init();
		}
		
		snakeMoveThread = new SnakeMovable(board.getSnake(), gameLevel);
		snakeMoveThread.start();
		
		gameState = GameCont.GAME_PLAYING;	
	}
	
	//暂停游戏
	public void pauseGame(){ 
		snakeMoveThread.setPaused(true);
		drawMessage("Paused");//为用键盘暂停也能显示消息
		gameState = GameCont.GAME_PAUSED;
	}
	
	//继续游戏
	public void resumeGame(){
		snakeMoveThread.setPaused(false);
		drawMessage(" ");
		gameState = GameCont.GAME_PLAYING;
	}
	
	//游戏结束
	public void endGame(){	
		drawMessage("Game Over");//同上
		snakeMoveThread = null;
			
		//以同步线程进行访问button,否则异常
		runner.getDisplay().syncExec(new Runnable(){
			public void run() {
				runner.setBStartPauseText("Replay");
			}
		});
		
		gameState = GameCont.GAME_OVER;	
	}
	
	//在面板中画出指定显示的消息msg  
	public void drawMessage(String msg){	
		GC gc = SnakeGC.getSnakeGC();
		final Font font = new Font(display, "Helvetica", 32, SWT.NORMAL);
		gc.setFont(font);
		gc.setForeground(new Color(display, 255, 225, 225));
		int x = (board.getWidth() - (gc.getFontMetrics().getAverageCharWidth() * msg.length())) / 2 ;
		int y = board.getLength() / 2;
		gc.drawString(msg, x, y, true);
		font.dispose();
	}
	
	//游戏级别影响蛇移动速度
	public void setGameLevel(int level){
		this.gameLevel = level;
	}
	
	public int getGameLevel(){
		return this.gameLevel;
	}
	
	public Board getBoard(){
		return board;
	}
	
	public void setBoard(Board board){
		this.board = board;
	}
	
	public void setRunner(Runner runner){
		this.runner = runner;
	}
	
	public int getGameState() {
		return gameState;
	}

	public void setGameState(int gameState) {
		this.gameState = gameState;
	}
	
	/*
	 * 为了利用成员变量snakeMoveThread,在此定义该私有类
	 * 若以后找到好的方法能把snakeMoveThread作为参数传给
	 * SnakeMovable的构造函数,则应提取出该类定义
	 */
	private class SnakeMovable extends Thread {
		
		private long sleepTime; 				
		private boolean paused = false;	
		private Snake snake;
		
		public SnakeMovable(){}
		
		public SnakeMovable(Snake snake){
			this.snake = snake;
		}
		
		public SnakeMovable(Snake snake, int level){
			this.snake = snake;
			this.sleepTime = GameCont.SLEEP_TIME / level; 
		}
		
		public void run() {			
			//该循环条件为确保被控制的是同一线程
			while(snakeMoveThread == this){
				snake.moveWhatEver();	
				beginSleep(sleepTime);
				
				while(paused){
					beginSleep(100);
				}
			}
		}
		
		//线程睡眠指定的时间(ms)
		private void beginSleep(long sleepTime){
			try{
				Thread.sleep(sleepTime);
			} catch (InterruptedException ine) {
				ine.printStackTrace();
			}
		}	
		
		public void setPaused(boolean paused){
			this.paused = paused;
		}
	}
}
