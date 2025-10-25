package com.ninjaalgo.testdata;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.ninjaalgo.utils.ConfigReader;

public class GetJSONData {
    String path = null;

	public GetJSONData() throws IOException {
			super();
			//this.path = path;
			this.path = System.getProperty("user.dir")+"/src/test/resources/TestData/pythonjson.json";
		}
	public String[][] ReadJsonData() throws IOException, ParseException {
			JSONParser jsonParser = new JSONParser();
			FileReader file = new FileReader(path);
			
			Object javaObj = jsonParser.parse(file);
			
			JSONObject pythonCodeObj = (JSONObject) javaObj;
		    JSONArray codeJsonArr  = (JSONArray) pythonCodeObj.get("PythonCode");
		    
		    String[][] codeArr = new String[codeJsonArr.size()][2]; 
		    
		    for(int i=0;i<codeJsonArr.size();i++) {
		    
		    	JSONObject codeObj = (JSONObject) codeJsonArr.get(i);
		    	codeArr[i][0] = (String)codeObj.get("code");
		    	codeArr[i][1]= (String)codeObj.get("result");		    	
		    }
		    return codeArr;
	}

}
