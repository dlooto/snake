/**
 * 
 */
package net.xjbean.snake.listener;

import net.xjbean.snake.GameCont;
import net.xjbean.snake.ui.Game;
import net.xjbean.snake.ui.Runner;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

/**
 * 游戏按钮事件处理
 * 
 * @author xjBean
 *
 */
public class StartStopListener extends SelectionAdapter{

	private Game game;
	private Runner runner;    //被监听的按钮
	
	public StartStopListener(){}
	
	public StartStopListener(Game game, Runner runner){
									
		this.game = game;
		this.runner = runner;
	}
	
	public void widgetSelected(SelectionEvent arg0) {						
		switch(game.getGameState()){
			case GameCont.GAME_PLAYING:					//游戏进行中按下Button
				game.pauseGame();
				runner.setBStartPauseText("Resume");				
				break;
			case GameCont.GAME_PAUSED:				    //游戏暂停时按下Button
				game.resumeGame();
				runner.setBStartPauseText("Pause");
				break;
			default:									//游戏尚未开始或Over时按下Button
				game.startGame();
				runner.setBStartPauseText("Pause");
				break;
		}
		
		runner.getSnakeBoardCanvas().forceFocus();//强制将焦点移到boardCanvas
		runner.getSnakeBoardCanvas().redraw();
	}
}
