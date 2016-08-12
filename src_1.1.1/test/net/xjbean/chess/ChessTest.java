package net.xjbean.chess;

import java.util.List;

import net.xjbean.util.ArrayUtils;
import net.xjbean.chess.BanDigit;
import net.xjbean.chess.Chess;

/**
 * @author xjBean
 *
 */
public class ChessTest extends BaseArrayTestCase {
	private int [][] sparseMatrix;
	
	public ChessTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		int k = 2;
		
		if(k == 1) {//四对夫妇交叉问题
			sparseMatrix = new int[][]{{1,0,0,1},  
					   {1,1,0,0},
					   {0,1,1,0},
					   {0,0,1,1}};
		} else if(k == 2){//四小孩有禁位排列问题
			sparseMatrix = new int[][]{{0,1,0,0},
					   {0,0,1,1},
					   {1,0,0,0},
					   {0,1,1,0}}; 
		} else if(k == 3){//P55习题－教师选课问题
			sparseMatrix = new int[][]{{1,0,0,1},
					   {0,0,1,0},
					   {0,1,1,0},
					   {1,0,0,1}}; 
		} else if(k == 4){//
			sparseMatrix = new int[][]{{1,0,1,0},
					   {1,1,0,0},
					   {0,0,1,0},
					   {1,1,0,0}}; 
		} else if(k == 5){//***************************!!!!!!!!!!!!!!
			sparseMatrix = new int[][]{{0,1,0,0},
					   {0,1,1,0},
					   {0,0,1,1},
					   {0,0,0,1}}; 
		} else if(k == 6){//
			sparseMatrix = new int[][]{{0,0,0,0,0,0},
					   {1,1,1,0,0,0},
					   {1,1,1,0,0,0},
					   {0,0,0,1,1,0},
					   {0,0,0,0,0,0},
					   {0,0,0,0,0,0}}; 
		}				
	}
	
	//测试棋盘多项式
	public void testGetChessPoly(){	
		int[] resultPoly = new int[]{1,6,11,7,1};
		
		List<BanDigit> banArea = ArrayUtils.convertToZippedList(sparseMatrix);
		Chess chess = new Chess(4,4,banArea);
			
		System.out.println("Chess Poly length: " + chess.getChessPoly().length);
		ArrayUtils.printArrayElements(chess.getChessPoly());
		
		assertArrayEquals(resultPoly, chess.getChessPoly());		
	}
	
	//测试计算有禁位的排列数
	public void testGetPermtNumber(){
		List<BanDigit> banArea = ArrayUtils.convertToZippedList(sparseMatrix);
		Chess chess = new Chess(4,4,banArea);
		
		System.out.println("Permutation Number: " + chess.getPermtNumber());
		assertEquals(4,chess.getPermtNumber());
	}
	

}
