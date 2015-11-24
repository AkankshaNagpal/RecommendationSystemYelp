package json_parsing;
import java.util.ArrayList;
import java.util.List;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Zip {
	
	private static final String filepath = "C:\\Users\\ShrutiN\\Documents\\MS\\BusinessData\\business.json";
	
	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
		JSONObject objJson;
		JSONArray categoryList;
		FileReader reader = new FileReader(filepath);
		
		JSONParser objJsonParser = new JSONParser();
		JSONArray objJsonArray = (JSONArray) objJsonParser.parse(reader);
		
		String address;
		String[] addressElements;
		String pattern = "\\d{5}";
		List<String>zipCodeList = new ArrayList<>();
		
		Pattern r = Pattern.compile(pattern);
		
		for(int i = 0; i < objJsonArray.size(); i++) {
			objJson = (JSONObject) objJsonArray.get(i);
			address = ((String) objJson.get("full_address")).replace("\n", " ").replace(",", "");
			addressElements = address.split(" ");
			for(int j = 0; j < addressElements.length; j++) {
				Matcher m = r.matcher(addressElements[j]);
				if (m.find( ) && !zipCodeList.contains(addressElements[j])) {
					zipCodeList.add(addressElements[j]);
				}
			}
		}
		
		for(String zipCode : zipCodeList) {
			System.out.println(zipCode);
		}
	}

}
