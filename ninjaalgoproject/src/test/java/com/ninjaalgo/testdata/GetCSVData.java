/*Code details:
	#Author: Meenakshi Dated: 6-Nov-2023
*/
package com.ninjaalgo.testdata;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;


public class GetCSVData {
	    String path = null;

	public GetCSVData() throws IOException {
			super();
			//this.path = path;
			this.path = System.getProperty("user.dir")+"/src/test/resources/TestData/PythonCode.csv";
		}

	  public String[][] ReadCSV() throws Exception {			       
		    String pythonData[][] = new String[1][2] ;
		    String record[]=null;
		       CSVParser csvParser = new CSVParserBuilder().withSeparator('|').build();
		       CSVReader csvReader = new CSVReaderBuilder(new FileReader(path))
		    		   .withCSVParser(csvParser)
		    		   .withSkipLines(1)
		    		   .build(); 
		        while((record = csvReader.readNext())!=null){	           
		        	if(!(pythonData[0][0]==null))
		        		pythonData[0][0]= pythonData[0][0]+"\n"+record[0];
		        	else
		        		pythonData[0][0]= record[0];
	    		    if(!(record[1]==null))
	    		    	pythonData[0][1] = record[1];
	        	}	
	    	return pythonData;	    
	   }
}