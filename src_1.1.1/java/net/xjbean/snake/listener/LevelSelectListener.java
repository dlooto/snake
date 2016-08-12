/**
 * 
 */
package net.xjbean.snake.listener;

import net.xjbean.snake.ui.Game;
import net.xjbean.snake.ui.Runner;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;

/**
 * 游戏级别选择事件处理(事件为: 选择下拉列表框)
 * 
 * @author xjBean
 *
 */
public class LevelSelectListener extends SelectionAdapter{

	private Game game;
	private Combo cLevel;
	
	public LevelSelectListener(){}
	
	public LevelSelectListener(Game game, Runner runner){
		this.game = game;
		this.cLevel = runner.getCLevel();
	}

	public void widgetSelected(SelectionEvent e) {
        if (cLevel.getSelectionIndex() == 0) {	   //选择游戏级别1
        	game.setGameLevel(1); 
        } else if(cLevel.getSelectionIndex() == 1){//选择游戏级别2
        	game.setGameLevel(2);
        } else if(cLevel.getSelectionIndex() == 2){//选择游戏级别3
        	game.setGameLevel(3);
        }
        
    }

}
