/**
 * 
 */
package net.xjbean.snake.ui;

import net.xjbean.snake.listener.KeyControlListener;
import net.xjbean.snake.listener.LevelSelectListener;
import net.xjbean.snake.listener.PaintSnakeListener;
import net.xjbean.snake.listener.StartStopListener;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

/**
 * @author xjBean
 *
 */
public class Runner {

	private Display display;
	private Shell shell;
	
	private Game game;
	private Canvas boardCanvas;
	          
	private Label lLevel;
	private Combo cLevel;
	private Button bStartPause; 
	
	public Runner(){
		init();
	}
	
	public static void main(String[] args) {
		new Runner();
	}
	
	//初始化，画出控制面板界面
	private void init(){
		display = new Display();	
		shell = new Shell(display, SWT.SHELL_TRIM & ~SWT.RESIZE & ~SWT.MAX );
				
		shell.setText("试试你能吃多长？");
		shell.setMinimumSize(600, 600);

		GridLayout gdLayout = new GridLayout(3, true);
		shell.setLayout(gdLayout);
		
		int xCenter = shell.getSize().x / 8;
		int yCenter = shell.getSize().y / 8;
		shell.setLocation(xCenter, yCenter);
		
		//添加画布,添加选择列表框,添加游戏启停按钮
		addCanvas();
		addChooseLevel();
        addStartButton();
        
        //构建游戏,注意此处的构建顺序很重要,需要以上三者添加完以后方能构建Game
        //因Game中要用到画笔及画布
        game = new Game(this);   
        
        //添加事件监听器
		addEventListeners();
		
		//Others
		shell.pack();
		shell.open();
		retainShell();
	}
	
	private void addEventListeners() {
		
		//键盘控制监听
		boardCanvas.addKeyListener(new KeyControlListener(game, this));				  
				     	
		//图形绘制监听		
		boardCanvas.addPaintListener(new PaintSnakeListener(game));				
				  					
		//游戏级别选择监听
		cLevel.addSelectionListener(new LevelSelectListener(game, this));
		
		//游戏启停按钮监听
		bStartPause.addSelectionListener(		
				new StartStopListener(game, this));
	}
	
	//循环显示Shell
	private void retainShell(){
		while(!shell.isDisposed()){
			if(!display.readAndDispatch()){
				display.sleep();
			}
		}
		
		display.dispose();
	}

	//添加游戏画布
	private void addCanvas(){	
		GridData gd = new GridData(GridData.FILL_BOTH);
		gd.verticalSpan = 9;
		gd.horizontalSpan = 2;   //有3列,此强制画布跨越2列
		gd.heightHint = 600;
		gd.widthHint = 300;
		
		boardCanvas = new Canvas(shell, SWT.NONE);
		boardCanvas.setBackground(new Color(display, 0, 0, 0));
		boardCanvas.setLayoutData(gd);
		
		//设置画笔
		SnakeGC.setSnakeGC(new GC(boardCanvas));	
	}
	
	//添加选择游戏级别标签项及下拉列表选择框
	private void addChooseLevel(){
		GridData gd = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
		gd.widthHint = 150;
		gd.horizontalIndent = 60;
		gd.verticalIndent = 20;
		
		//Label
		lLevel = new Label(shell, SWT.NONE);
		lLevel.setText("Choose Level:  ");
		lLevel.setLayoutData(gd);
		
		//Combo
		cLevel = new Combo(shell, SWT.READ_ONLY);
		cLevel.setBounds(200, 100, 50, 65);
	    String items[] = {"Level One", "Level Two", "Level Three"};      
	    cLevel.setItems(items);
	    cLevel.select(0);
	    cLevel.setLayoutData(gd);
	}
	
	
	//添加游戏启停Button
	private void addStartButton(){	       	
		GridData gd = new GridData(GridData.HORIZONTAL_ALIGN_CENTER );
		gd.widthHint = 100;
		gd.horizontalIndent = 50;
		gd.verticalIndent = 20;
		
		bStartPause = new Button(shell, SWT.PUSH);
		bStartPause.setText("Start Game");
		bStartPause.setLayoutData(gd);
	}
	
	
	//设置按钮上的文字
	public void setBStartPauseText(String text){
		bStartPause.setText(text);
	}
	//得到游戏面板的画布
	public Canvas getSnakeBoardCanvas(){
		return boardCanvas;
	}
	
	public Display getDisplay(){
		return display;
	}
	
	public Combo getCLevel(){
		return cLevel;
	}
}
