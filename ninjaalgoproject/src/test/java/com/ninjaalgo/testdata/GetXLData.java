/*Code details:
	#Author: Meenakshi Dated: 6-Nov-2023
*/
package com.ninjaalgo.testdata;

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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.ninjaalgo.driverfactory.DriverFactory;
import com.ninjaalgo.pages.LoginPage;
import com.ninjaalgo.steps.CommonSteps;
import com.ninjaalgo.utils.XLUtility;

public class GetXLData {
		InputStream fi;
		OutputStream fout;
		XSSFRow row;
		XSSFCell cell;
		CellStyle style ;
		DataFormatter formatter;
		XLUtility xlutil;
	    String path = null;
		File dataFile;
        XSSFWorkbook wkb;
		XSSFSheet sh;

	public GetXLData(String path) throws IOException {
			super();
			this.path = path;
			//this.path = System.getProperty("user.dir")+"/src/test/resources/TestData/TestData.xlsx";
		}

	  public String[][] GetPythonData(String sheet) throws Exception{			       
		   	try {
				xlutil = new XLUtility(path,"Child");
				int totalRows = xlutil.GetLastRow(sheet);
				//int totalCells = xlutil.GetLastCell(sheet, 1);	
				
				//String pythonData[][] = new String[totalRows][totalCells] ;
				String pythonData[][] = new String[1][2] ;

				pythonData[0][0] = xlutil.GetCellData(sheet, 1, 0)+"\n";	
					for(int i=2;i<=totalRows;i++)
						pythonData[0][0] = pythonData[0][0] + xlutil.GetCellData(sheet, i, 0)+"\n";		
					
					pythonData[0][1]="564 is Number is Not Found";
			       return pythonData;
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}	  
	  }
	  public Object[][] GetLoginData(String sheet) throws InvalidFormatException {
			try {
				 xlutil = new XLUtility(path,"Child");

				int totalRows = xlutil.GetLastRow(sheet);
				int totalCells = xlutil.GetLastCell(sheet, 1);

				String loginData[][] = new String[totalRows][totalCells];
				for (int i = 0; i < totalRows; i++) {
					for (int j = 0; j < totalCells; j++) {
						loginData[i][j] = xlutil.GetCellData(sheet, i + 1, j);
					}
				}
				return loginData;
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		}
}	  

