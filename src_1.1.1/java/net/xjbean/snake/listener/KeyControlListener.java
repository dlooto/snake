package net.xjbean.snake.listener;

import net.xjbean.snake.GameCont;
import net.xjbean.snake.snake.Snake;
import net.xjbean.snake.ui.Game;
import net.xjbean.snake.ui.Runner;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

/**
 * 键盘控制蛇移动方向
 */
public class KeyControlListener extends KeyAdapter{
	
	private Runner runner;
	private Game game;	
	//private ObservableSource source;//作为被观察源,监视将要发生的转向
	
	public KeyControlListener(){}
	
	public KeyControlListener(Game game, Runner runner){
		this.runner = runner;
		this.game = game;
	}
	
	public void keyPressed(KeyEvent e) {
		if(game.getGameState() == GameCont.GAME_PLAYING){
			switch(e.keyCode){		
				case SWT.ARROW_LEFT:
					getSnake().turnLeft();
					break;
				case SWT.ARROW_RIGHT:	
					getSnake().turnRight();
					break;
				case SWT.ARROW_UP:
					getSnake().turnUp();
					break;
				case SWT.ARROW_DOWN:
					getSnake().turnDown();
					break;
					
				case ' '://暂停游戏
					game.pauseGame();
					runner.setBStartPauseText("Resume");
					break;
			}
		} else if(isResumeGame(e.keyCode)){			
			game.resumeGame();
			runner.setBStartPauseText("Pause");
			
			//是否需要同步方法?会出问题吗?
			//若无此句则用空格键继续游戏后画布上字符"Paused"
			//不会擦除
			runner.getSnakeBoardCanvas().redraw();  
			
		}
	}
	
	/*
	 * 注: 此类中不可以设置一Snake类型的成员变量,那将造成
	 *     监听的并非同一snake对象(尤其当Gameover后又重新开始时)
	 */
	private Snake getSnake(){
		return game.getBoard().getSnake();
	}
	
	private boolean isResumeGame(int keyCode){
		if((game.getGameState() == GameCont.GAME_PAUSED) &&
				(keyCode == ' ')){
			return true;
		}
		
		return false;
	}
}