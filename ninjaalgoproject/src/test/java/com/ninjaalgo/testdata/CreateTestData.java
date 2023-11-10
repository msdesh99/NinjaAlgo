/*Code details:
	#Author: Meenakshi Dated: 6-Nov-2023
*/
package com.ninjaalgo.testdata;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ninjaalgo.utils.XLUtility;


public class CreateTestData extends XLUtility{
	/*def search(input_list, num):
		 for x in input_list:
		  if x == num:
			print(str(num) + " is present in array")
		input_list=[12,23,45,56,67]
		num=56
		search(input_list,num) */

	    static String[] loginArr = new String[]{"NinjaAlgo","NinjaAlgo1"};
	    static String[] passwordArr = new String[]{"@Algo123","test1"};
	    static String[] statusArr = new String[]{"Valid","Invalid"};

	InputStream fi;
	OutputStream fout;
	XSSFRow row;
	XSSFCell cell;
	CellStyle style ;
	DataFormatter formatter;

    String path = null;
	File dataFile;
    XSSFWorkbook wkb;
	XSSFSheet sh;

	public CreateTestData(String path) throws IOException {
		super(path);
		this.path = path;
		System.out.println("ctd path: "+path);
		//this.path = System.getProperty("user.dir")+"/src/test/resources/TestData/loginData.xlsx";
		 this.dataFile = new File(path);
	}

	//@Override
	public void WriteIntoFile() throws IOException{
			//inp = getClass().getResourceAsStream("TutorialNinjaData.xls");		
		 wkb = new XSSFWorkbook();
		 sh = wkb.createSheet("sheet1");
		 
		 Row r1 = sh.createRow(0);
		 r1.createCell(0).setCellValue("UserName");
		 r1.createCell(1).setCellValue("Password");
		 r1.createCell(2).setCellValue("Status");
		 for(int i=1;i<=4;i++) {
			 Row rw = sh.createRow(i);
			 rw.createCell(0).setCellValue(loginArr[i-1]);
			 rw.createCell(1).setCellValue(passwordArr[i-1]);
			 rw.createCell(2).setCellValue(statusArr[i-1]);
	         //rw.createCell(2,CellType.BLANK);
			 System.out.println(loginArr[i-1]);
		 }
		try {
			 fout = new FileOutputStream(this.dataFile);
		     wkb.write(fout);	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			wkb.close();
			fout.close();
		} 

	}

	
}
