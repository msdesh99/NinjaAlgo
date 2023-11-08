package com.ninjaalgo.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;

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
//https://www.youtube.com/watch?v=1nP9UlwzpgU
//https://www.tabnine.com/code/java/classes/org.apache.poi.ss.usermodel.DataFormatter

public class XLUtility {
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

	public XLUtility(String path) throws IOException {
			super();
			this.path = path;
			//this.path = System.getProperty("user.dir")+"/src/test/resources/TestData/currencyData.xlsx";
			 this.dataFile = new File(path);			
		}

public void WriteIntoFile() throws IOException{
	//inp = getClass().getResourceAsStream("TutorialNinjaData.xls");		
	 wkb = new XSSFWorkbook();
	 sh = wkb.createSheet("sheet1");
	  String[] loginArr = new String[]{"NinjaAlgo"};
	   String[] passwordArr = new String[]{"@Algo123"};
	    String[] statusArr = new String[]{"Valid"};

	/*   String[] loginArr = new String[]{"NinjaAlgo","AlgoNinja","Test","Test123"};
	   String[] passwordArr = new String[]{"@Algo123","Passes","test1234","Failed1"};
	   String[] statusArr = new String[]{"Valid","InValid","InValid","InValid"};
	*/
	    Row r1 = sh.createRow(0);
	 r1.createCell(0).setCellValue("UserName");
	 r1.createCell(1).setCellValue("Password");
	 r1.createCell(2).setCellValue("Status");
	 for(int i=1;i<=1;i++) {
		 Row rw = sh.createRow(i);
		 rw.createCell(0).setCellValue(loginArr[i-1]);
		 rw.createCell(1).setCellValue(passwordArr[i-1]);
		 rw.createCell(2).setCellValue(statusArr[i-1]);
         //rw.createCell(2,CellType.BLANK);
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

	
	//need to override method to write data. in CreateTestData file
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
		fi  = new FileInputStream(this.dataFile);
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
		Iterator<Row> rw1 = sh.rowIterator();
		while(rw1.hasNext()) {
		     Row row1 = rw1.next();
		     Iterator<Cell> cell1 = row1.cellIterator();
		     System.out.println();
		     while(cell1.hasNext()) {
		    	 Cell cell2 = cell1.next();
		    	//System.out.println(cell2);
		    	System.out.printf("%s ",cell2);
		     }
		}
		/*
		Iterator<Row> rw = sh.rowIterator(); 
		while (rw.hasNext()) {
			Row row = rw.next();
			Iterator<Cell> cell = row.cellIterator();	
			while(cell.hasNext()) {
				System.out.printf("%s  \n",cell.next()); // ".getStringCellValue());
			}
		}*/		

	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
    finally {
		wkb.close();
		fi.close();
	}
}	 
    public static void main(String[] args) throws IOException {
		String path = System.getProperty("user.dir")+"/src/test/resources/TestData/loginData.xlsx";

    	XLUtility xlUtility = new XLUtility(path);
    	xlUtility.WriteIntoFile();    	
    	
    /*	xlUtility.CreateNewCell("sheet1", 3, "New");

    	int totalRows =xlUtility.GetLastRow("sheet1");
    	System.out.println("get totalrows: "+totalRows);
    		
    	int totalCells = xlUtility.GetLastCell("sheet1", 1);
    	System.out.println("get totalcell : "+totalCells);
  	
    	xlUtility.UpdateCellData("sheet1", 3, 3, "updated");
		
   
		System.out.println(xlUtility.GetCellData("sheet1", 1, 0));
    	
		xlUtility.FillGreenColor("sheet1", 3, 5);
		xlUtility.ReadFile("sheet1");
*/
    }
    
}
