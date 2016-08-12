/**
 * 
 */
package net.xjbean.snake;

import net.xjbean.snake.direct.*;

import org.eclipse.swt.graphics.Color;

/**
 * 此游戏中用到的相关常量
 * 
 * @author xjBean
 *
 */
public class GameCont {
	
	//被绘制小方块的长宽像素值(默认设定长宽相同)
	public final static int SQUARE_SIZE = 10;  
	
	//游戏状态常量
	public final static int GAME_PLAYING 	= 0;   	//游戏进行中	
	public final static int GAME_PAUSED 	= 1;	//游戏暂停
	public final static int GAME_OVER 		= 2;	//游戏结束
	
	//游戏面板长宽(像素值)
	public final static int BOARD_WIDTH  = 48 * SQUARE_SIZE;    
	public final static int BOARD_LENGTH = 60 * SQUARE_SIZE;	
	
	//蛇运动方向
	public final static int DIREC_LEFT 	= 0;   		
	public final static int DIREC_RIGHT = 1;
	public final static int DIREC_UP 	= 2;
	public final static int DIREC_DOWN 	= 3;
	
	public final static Direction LEFT 	= new LeftDirection();
	public final static Direction RIGHT = new RightDirection();
	public final static Direction UP 	= new UpDirection();
	public final static Direction DOWN 	= new DownDirection();
	
	//蛇初始状态值
	public final static int INIT_POSITION_X = 10 * SQUARE_SIZE;	//初始蛇头横坐标(pix)	
	public final static int INIT_POSITION_Y = 20 * SQUARE_SIZE;	//初始蛇头纵坐标(pix)
	public final static int INIT_LENGTH 	= 5;	     		//初始长度(节点个数) 
	public final static int INIT_SPEED 		= 3;				//初始移动速度(No used)
	public final static int INIT_DIREC 		= DIREC_RIGHT;		//初始移动方向
	
	//移动方向上障碍类型
	public final static int OBSTACLE_NULL 	= 0;          		//无障碍
	public final static int OBSTACLE_FOOD 	= 1;				//食物	
	public final static int OBSTACLE_BLOCK 	= 2;				//墙或蛇身
	
	//蛇移动线程默认睡眠时间(单位ms),此决定了蛇移动速度
	public final static long SLEEP_TIME = 200;
	
	//食物及蛇身结点颜色
	public final static Color COLOR_WHITE = new Color(null, 255, 255, 255);
	public final static Color COLOR_BLACK = new Color(null, 0, 0, 0);
	public final static Color COLOR_FOOD  = new Color(null, 164, 255, 164);  //绿
	public final static Color COLOR_SNAKE = new Color(null, 66, 232, 211);   //青
	
	//组成食物或蛇的小方块的边框颜色
	public final static Color COLOR_FOOD_BORDER  = new Color(null, 0, 155, 0);
	public final static Color COLOR_SNAKE_BORDER = COLOR_WHITE; 
}
