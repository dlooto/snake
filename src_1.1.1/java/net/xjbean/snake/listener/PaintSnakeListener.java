package net.xjbean.snake.listener;

import net.xjbean.snake.GameCont;
import net.xjbean.snake.ui.Game;

import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;

/**
 * 定义绘图事件处理类
 */
public class PaintSnakeListener implements PaintListener{
	private Game game;
	
	public PaintSnakeListener(Game game){
		this.game = game;
	}
	
	public void paintControl(PaintEvent e) {		
		switch(game.getGameState()){
			case GameCont.GAME_PLAYING:
				game.getBoard().getFood().drawSquare();
				game.getBoard().getSnake().drawSnake();
				break;
			case GameCont.GAME_PAUSED:
				game.getBoard().getFood().drawSquare();
				game.getBoard().getSnake().drawSnake();
				game.drawMessage("Paused");
				break;
			case GameCont.GAME_OVER:
				game.getBoard().getFood().drawSquare();
				game.getBoard().getSnake().drawSnake();
				game.drawMessage("Game Over");	
				break;	
			default:										//游戏未开始
				game.drawMessage("Press Start");
				break;
		}
	}
}
