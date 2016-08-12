/**
 * Created on 2008-5-27
 */
package net.xjbean.xml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import junit.framework.TestCase;

/**
 * 测试对XML文件的相关操作类
 * 
 * @author xjBean
 *
 */
public class XMLHandleTest extends TestCase {

	private String srcFileURL =  "E:\\JavaWork\\TestDIR\\study\\data\\earthquake.kml";         //被处理的文件
	private String createdFileURL = "E:\\JavaWork\\TestDIR\\study\\data\\new\\newKml.kml"; //处理后生成的文件
	
	
	protected void setUp() throws Exception {
		super.setUp();
			
	}
	
	public void testFormatKML(){
		XMLHandler xmlHandler = new XMLHandler();
		Document doc = xmlHandler.parse(srcFileURL);
		
		xmlHandler.write2File(doc, createdFileURL);
	}
	
	/*
	public void testParseXMLDoc(){
		String sheetName = "Sheet1";
		
		ExcelXMLHandler xmlHandler = new ExcelXMLHandler();	
		Document doc = xmlHandler.parse(srcFileURL);
		ExcelSheet excelSheet = xmlHandler.findAndWrapSheet(doc,sheetName);
		Document kmlDoc = xmlHandler.convert2KML(excelSheet);
		xmlHandler.write2File(kmlDoc, createdFileURL);	
	}	*/
	
	public XMLHandleTest(String arg0) {
		super(arg0);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
}
