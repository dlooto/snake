package net.xjbean.snake.ui;

import org.eclipse.swt.graphics.GC;

/**
 * 画笔类，
 * 通过此类得到GC，进行各种绘制
 */

public class SnakeGC {

	private static GC gc;
	
	public static GC getSnakeGC(){
		return gc;
	}
	
	public static void setSnakeGC(GC newGc){
		gc = newGc;
	}
}
