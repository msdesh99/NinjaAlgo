/*Code details:
	#Author: Meenakshi Dated: 6-Nov-2023
*/
package com.ninjaalgo.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtility {
		InputStream fi;
		OutputStream fout;
		XSSFRow row;
		XSSFCell cell;
		CellStyle style ;
		DataFormatter formatter;
        String function="";
	    String path = null;
		File dataFile;
        XSSFWorkbook wkb;
		XSSFSheet sh;
        boolean fileExists;
	public XLUtility(String path, String function) throws IOException, InvalidFormatException {
			super();

			 //this.path = System.getProperty("user.dir")+"/src/test/resources/TestData/TestData.xlsx";
		   if(function.contentEquals("Child")) {
				 this.path = System.getProperty("user.dir")+ path;
				 this.dataFile = new File(this.path);	}
		   else if(function.contentEquals("Super"))
			   this.dataFile = new File(path);	
			 fileExists = this.dataFile.exists()?true:false;
		}

public void CreateTestData(String sheet) throws IOException{
	  sh = GetSheetReady(sheet);
	  if(sh!=null) {
		  GetWorkBookReady(sheet);
	  	  WriteDataIntoFile(dataFile, wkb);
       } 	  
}   
public XSSFSheet GetSheetReady(String sheet) throws IOException {
	  if(fileExists) {
		  fi = new FileInputStream(dataFile);
		  wkb = new XSSFWorkbook(fi);
	  }
	  else wkb = new XSSFWorkbook();
		System.out.println("wkb name: "+wkb.getName(sheet));
		System.out.println("sheet name: "+sheet);

		System.out.println("sheet name: "+wkb.getSheet(sheet));

    if(wkb.getSheet(sheet)== null) {
     sh = wkb.createSheet(sheet);	
     return sh;
    } 
	else {
		System.out.println("Sheet already exists");
		if(fileExists)
			fi.close();
	}
	return null;
}

public void GetWorkBookReady(String dataType) {
	if(sh.getSheetName().contentEquals("LoginCred")) {
				String[] loginArr = new String[] { "NinjaAlgo1", "NinjaAlgo" };
				String[] passwordArr = new String[] { "@Algo3", "@Algo123" };
				String[] statusArr = new String[] { "login", "home" };

				Row r1 = sh.createRow(0);
				r1.createCell(0).setCellValue("UserName");
				r1.createCell(1).setCellValue("Password");
				r1.createCell(2).setCellValue("Status");
				System.out.println("leng: " + loginArr.length);
				
				for (int i = 1; i <= loginArr.length; i++) {
					Row rw = sh.createRow(i);
					rw.createCell(0).setCellValue(loginArr[i - 1]);
					rw.createCell(1).setCellValue(passwordArr[i - 1]);
					rw.createCell(2).setCellValue(statusArr[i - 1]);
					// rw.createCell(2,CellType.BLANK);
				}
	  }
	if(sh.getSheetName().contentEquals("PythonArray")) {
	  String[] inputArr = { "def search(input_list, num):","output = 'Number is Not Found'",
		  		"for x in input_list:","if x == num:","output = 'Number is found'","print(str(num) + ' is '+output)","input_list=[12,23,45,56,67]",
			  	 "num=564", "search(input_list,num)"};
		   //String result="564 is Number is Not Found";

		   Row r1 = sh.createRow(0);
		   Cell cell = r1.createCell(0); 
		   cell.setCellValue("PythonCode for Array in tryedior arrays in python");
		   r1.createCell(1).setCellValue("Expected Output");

		   for(int i=1;i<=inputArr.length;i++) {
			   Row rw = sh.createRow(i);
				 Cell cell1 = rw.createCell(0); 
			     cell1.setCellValue(inputArr[i-1]);
			     if(i==1) rw.createCell(1).setCellValue("564 is Number is Not Found"); 
		 }
	}		   
	
}

public void WriteDataIntoFile(File file, XSSFWorkbook wkb) throws IOException {
	try {
		 fout = new FileOutputStream(this.dataFile);
	     wkb.write(fout);	
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	finally {
		wkb.close();
		fout.close();
		if(fileExists)
		fi.close();
	} 
}

public void CreateNewCell(String sheetName, int rowNumber, String cellValue) throws IOException{
	try {
		fi = new FileInputStream(this.dataFile);
		wkb = new XSSFWorkbook(fi);	
		sh = wkb.getSheet(sheetName);
		
		Row row = sh.getRow(rowNumber);
		int lastCell = row.getLastCellNum();
		Cell cell = row.createCell(lastCell);
		cell.setCellValue(cellValue);    
		
		fout = new FileOutputStream(this.dataFile);
		wkb.write(fout);
		
	} catch (IOException e) {
		e.printStackTrace();
	}
	finally {
		wkb.close();
		fout.close();
		fi.close();
	}

}	
public int GetLastRow(String sheetName) throws IOException {
	int lastRow=0;
    try {
		fi  = new FileInputStream(dataFile);
		wkb = new XSSFWorkbook(fi);
		sh = wkb.getSheet(sheetName);
		lastRow = sh.getLastRowNum();
		
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	finally {
		wkb.close();
		fi.close();
	}
	return lastRow;

}
public int GetLastCell(String sheetName, int row) throws IOException {
	   int lastCell=0;
	   try {
			fi  = new FileInputStream(this.dataFile);
			wkb = new XSSFWorkbook(fi);
			sh = wkb.getSheet(sheetName);
			Row rw = sh.getRow(row);
			lastCell = rw.getLastCellNum();	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			wkb.close();
			fi.close();
		}
		return lastCell;
	
}

public void UpdateCellData(String sheetName, int row, int col, String cellValue) throws IOException{
	try {
		fi = new FileInputStream(this.dataFile);
		wkb = new XSSFWorkbook(fi);
		sh = wkb.getSheet(sheetName);
		Row rw = sh.getRow(row);

		if(rw.getCell(col) != null) {
		Cell cell = rw.getCell(col);  
		cell.setCellValue(cellValue);
		}
		else CreateNewCell(sheetName, row, "Failed-upd-Cre");
		
		fout = new FileOutputStream(this.dataFile); // 2 Variables are needed to close the output and input stream
		wkb.write(fout);
		//wkb.getSheet(sheetName).getRow(Row).getCell(col).setCellValue(cellValue);
		
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	finally {
		wkb.close();
		fout.close();
		fi.close();
	}
}	

public String GetCellData(String sheetName, int row, int col) throws IOException{	   
	//System.out.println("GEtCell: "+wkb.getSheet(sheetName).getRow(row).getCell(col).getStringCellValue());
	    try {
			fi = new FileInputStream(this.dataFile);
			wkb = new XSSFWorkbook(fi);
			sh = wkb.getSheet(sheetName);
		    Row rw = sh.getRow(row);
			formatter = new DataFormatter();
			if(rw.getCell(col) != null) {
				Cell ce = rw.getCell(col);
				return formatter.formatCellValue(ce); 
			}
			else  return null; //CreateCell("sheet1", row,"Failed-upd-Cre");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	    finally {
			wkb.close();
			fi.close();
		}
	}	
public void FillGreenColor(String sheetName, int row, int cell) throws IOException{
		try {
			  fi = new FileInputStream(this.dataFile);
			  wkb = new XSSFWorkbook(fi);
			  sh = wkb.getSheet(sheetName);
			  
			  Row rw = sh.getRow(row);
			  Cell ce = rw.getCell(cell);
			  
			  style = wkb.createCellStyle();
			  style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
			  style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			  
			  ce.setCellStyle(style);
			  fout = new FileOutputStream(this.dataFile);
			  wkb.write(fout);
		} catch (FileNotFoundException e) {
					e.printStackTrace();
		}
		finally {
			fout.close();
			wkb.close();
			fi.close();
		}
	
}
 public void ReadFile(String sheetName) throws IOException {
	try {
            fi  = new FileInputStream(this.dataFile);
			wkb = new XSSFWorkbook(fi);
			sh = wkb.getSheet(sheetName);
			System.out.println("in readFile: "+sh.getSheetName());
			Iterator<Row> rw1 = sh.rowIterator();
		while(rw1.hasNext()) {
		     Row row1 = rw1.next();
		     Iterator<Cell> cell1 = row1.cellIterator();
		     System.out.println();
		     while(cell1.hasNext()) {
		    	 Cell cell2 = cell1.next();
		    	System.out.println(cell2);
		    	//System.out.printf("%s ",cell2);
		     }
		}

	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
    finally {
		wkb.close();
		fi.close();
	}
}	 
    public static void main(String[] args) throws IOException, InvalidFormatException {
		String path = System.getProperty("user.dir")+"/src/test/resources/TestData/TestData.xlsx";
		File newFile = new File(path);	
    
        XLUtility xlUtility = new XLUtility(path,"Super");    
     	xlUtility.CreateTestData("LoginCred");
     	
        xlUtility = new XLUtility(path,"Super");
    	xlUtility.CreateTestData("PythonArray");

    	xlUtility = new XLUtility(path,"Super");
		xlUtility.ReadFile("PythonArray");
		
		int totalRows = xlUtility.GetLastRow("PythonArray");
		int totalCells = xlUtility.GetLastCell("PythonArray", 1);


    /*	xlUtility.CreateNewCell("sheet1", 3, "New");

    	int totalRows =xlUtility.GetLastRow("sheet1");
    	System.out.println("get totalrows: "+totalRows);
    		
    	int totalCells = xlUtility.GetLastCell("sheet1", 1);
    	System.out.println("get totalcell : "+totalCells);
  	
    	xlUtility.UpdateCellData("sheet1", 3, 3, "updated");
		
   
		System.out.println(xlUtility.GetCellData("sheet1", 1, 0));
    	
		xlUtility.FillGreenColor("sheet1", 3, 5);*/

    }
    
}
