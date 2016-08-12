/**
 * Created on 2005-5-23
 */
package net.xjbean.api;

import junit.framework.TestCase;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;

import net.xjbean.util.ArrayUtils;

/**
 * @author xjBean
 *
 */
public class ListTest extends TestCase {
	private List<Integer> lList;
	private List<Integer> lList1;
	
	public static void main(String[] args) {
		junit.textui.TestRunner.main(new String[]{"ListTest"});
	}
	
	public ListTest(String name){
		super(name);
	}
	
	public void setUp(){
		lList = new ArrayList<Integer>();
		lList.add(new Integer(1));
		lList.add(new Integer(2));
		lList.add(new Integer(3));
		
		lList1 = new LinkedList<Integer>();
		lList1.add(new Integer(1));
		lList1.add(new Integer(2));
		lList1.add(new Integer(3));
	}
	
	public void testLinkedList(){
		assertEquals(3,lList1.size());
		assertEquals(new Integer(1),lList1.get(0));
		assertEquals(new Integer(3),lList1.get(2));
		
		Integer ele = lList1.get(1); 
		lList1.remove(ele);
		assertEquals(2,lList1.size());
		assertEquals(new Integer(3),lList1.get(1));
	}
	
	public void testArrayList(){
		lList.add(new Integer(4));
		
		assertEquals(4,lList.size());
		assertEquals(new Integer(1),lList.get(0));
		assertEquals(new Integer(2),lList.get(1));
		assertEquals(new Integer(3),lList.get(2));
		
		Integer ele = lList.get(2);
		lList.remove(ele);
		assertEquals(3,lList.size());
		assertEquals(new Integer(2), lList.get(1));
		assertEquals(new Integer(4), lList.get(2));
	}
	
	public void testListRemove(){
		List<Integer> list1 = lList;
		lList.remove(0);
		assertSame(list1, lList);
		assertEquals(list1.size(), lList.size());
	}
	
	public void testCloneList(){
		//List<Integer> list2 = new ArrayList<Integer>(lList.size());
		List<Integer> list2 = ArrayUtils.cloneList(lList);		
		assertEquals(lList.size(), list2.size());
		
		lList.remove(1);
		assertEquals(2, lList.size());
		assertEquals(3, list2.size());
	}
}
