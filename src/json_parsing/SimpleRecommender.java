package json_parsing;
import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class SimpleRecommender {
	
	private static final String filepath = "C:\\Users\\ShrutiN\\Documents\\MS\\BusinessData\\business.json";
	
	static Csv objCsv = new Csv();

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static List<Health> listHealthCategory = new ArrayList();
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static List<Restaurant> listRestaurantCategory = new ArrayList();
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static List<PubsAndBars> listPubsBarsCategory = new ArrayList();
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static List<Shopping> listShoppingCategory = new ArrayList();
	
	public static void main(String[] args) throws IOException, ParseException {
		JSONObject objJson;
		JSONArray categoryList;
		FileReader reader = new FileReader(filepath);
		
		JSONParser objJsonParser = new JSONParser();
		JSONArray objJsonArray = (JSONArray) objJsonParser.parse(reader);
				
		JSONObject objTempJson;
		Health objHealthCategory = new Health();	
		Restaurant objRestaurantCategory = new Restaurant();
		PubsAndBars objPubsAndBarsCategory = new PubsAndBars();
		Shopping objShoppingCategory = new Shopping();
		
		String[] categoryListAttributes;
		String[] elementList;
		
		String category = "";
		
		for(int i = 0; i < objJsonArray.size(); i++) {
			objJson = (JSONObject) objJsonArray.get(i);
			categoryList = (JSONArray) objJson.get("categories");
			category = "";
			for(int j= 0; j < categoryList.size(); j++) {
				category = category + categoryList.get(j).toString() + " ";
			}
			
			if(category.contains("Health")) {
				objHealthCategory = new Health();
				try {
					objHealthCategory.businessId = (String) objJson.get("business_id");
					objHealthCategory.fullAddress = ((String) objJson.get("full_address")).replace("\n", " ").replace(",", "");
					objHealthCategory.stars = (Double) objJson.get("stars");
					objTempJson = (JSONObject)objJson.get("attributes");
					if(objTempJson.containsKey("By Appointment Only")) {
						objHealthCategory.byAppointment = (Boolean) objTempJson.get("By Appointment Only") == false ? 0 : 1;
					} else {
						objHealthCategory.byAppointment = 0;
					}
					objTempJson = (JSONObject)objJson.get("hours");
					objHealthCategory.openOnSaturday = (Boolean) objTempJson.toString().contains("Saturday") == true ?  1 : 0;
					objHealthCategory.name = (String) objJson.get("name");
				}catch(Exception ex) {
					System.out.println(ex);
				}
								
				listHealthCategory.add(objHealthCategory);				
			} 
			
			if(category.contains("Restaurants")) {
				objRestaurantCategory = new Restaurant();
				try {
					objRestaurantCategory.businessId = (String) objJson.get("business_id");
					objRestaurantCategory.name = (String) objJson.get("name");
					objRestaurantCategory.fullAddress = ((String) objJson.get("full_address")).replace("\n", " ").replace(",", "");
					objRestaurantCategory.stars = (Double) objJson.get("stars");
					categoryListAttributes = ((JSONObject)objJson.get("attributes")).toString().split(",");
					for(int k = 0; k < categoryListAttributes.length; k++) {						
						if(categoryListAttributes[k].contains("Take-out\":true")) {
							objRestaurantCategory.takeOut = 1;
							break;
						} else {
							objRestaurantCategory.takeOut = 0;
						}
						if(categoryListAttributes[k].contains("Good for Kids\":true")) {
							objRestaurantCategory.goodForKids = 1;
							break;
						} else {
							objRestaurantCategory.goodForKids = 0;
						}
					}
					objTempJson = (JSONObject)objJson.get("attributes");
					objRestaurantCategory.alcohol = (Boolean) objTempJson.toString().contains("Alcohol") == true ?  1 : 0;
					if(objTempJson.containsKey("Parking")){
						objTempJson = (JSONObject)objTempJson.get("Parking");
						objRestaurantCategory.parking = (Boolean) objTempJson.toString().contains("true") == true ?  1 : 0;
					} else {
						objRestaurantCategory.parking = 0;
					}
					
					objTempJson = (JSONObject)objJson.get("attributes");					
					objRestaurantCategory.goodForDessert = 0;
					objRestaurantCategory.goodForLatenight = 0;
					objRestaurantCategory.goodForLunch = 0;
					objRestaurantCategory.goodForDinner = 0;
					objRestaurantCategory.goodForBreakfast = 0;
					objRestaurantCategory.goodForBrunch = 0;
					if(objTempJson.containsKey("Good For")){
						elementList = ((JSONObject)objTempJson.get("Good For")).toString().split(",");
						for(int k = 0; k < elementList.length; k++) {
							String[] menuList = elementList[k].split(":");
							switch (menuList[0]) {
								case "\"dessert\"":
									objRestaurantCategory.goodForDessert = menuList[1].equals("true") ? 1 : 0;
									break;
								case "\"latenight\"":
									objRestaurantCategory.goodForLatenight = menuList[1].equals("true") ? 1 : 0;
									break;
								case "\"lunch\"":
									objRestaurantCategory.goodForLunch = menuList[1].equals("true") ? 1 : 0;
									break;
								case "\"dinner\"":
									objRestaurantCategory.goodForDinner = menuList[1].equals("true") ? 1 : 0;
									break;
								case "\"breakfast\"":
									objRestaurantCategory.goodForBreakfast = menuList[1].equals("true") ? 1 : 0;
									break;
								case "\"brunch\"":
									objRestaurantCategory.goodForBrunch = menuList[1].equals("true") ? 1 : 0;
									break;						
							}
						} 
					} else {	
						objRestaurantCategory.goodForDessert = 0;
						objRestaurantCategory.goodForLatenight = 0;
						objRestaurantCategory.goodForLunch = 0;
						objRestaurantCategory.goodForDinner = 0;
						objRestaurantCategory.goodForBreakfast = 0;
						objRestaurantCategory.goodForBrunch = 0;
					}	
					
				}catch(Exception ex) {
					System.out.println(ex);
				}
									
				listRestaurantCategory.add(objRestaurantCategory);	
			} 
			if((category.contains("Pubs") && category.contains("Bars"))) {
				objPubsAndBarsCategory = new PubsAndBars();
				try {
					objPubsAndBarsCategory.businessId = (String) objJson.get("business_id");
					objPubsAndBarsCategory.name = (String) objJson.get("name");
					objPubsAndBarsCategory.fullAddress = ((String) objJson.get("full_address")).replace("\n", " ").replace(",", "");
					objPubsAndBarsCategory.stars = (Double) objJson.get("stars");
					objTempJson = (JSONObject)objJson.get("attributes");
					objPubsAndBarsCategory.alcohol = (Boolean) objTempJson.toString().contains("Alcohol") == true ?  1 : 0;
					elementList = ((JSONObject)objJson.get("attributes")).toString().split(",");
					for(int k = 0; k < elementList.length; k++) {
						String[] attributesList = elementList[k].split(":");
						switch (attributesList[0]) {
							case "\"Noise Level\"":
								objPubsAndBarsCategory.noiceLevel = attributesList[1];
								break;
							
							case "\"Good For Dancing\"":
								objPubsAndBarsCategory.allowedDancing = attributesList[1].equals("true") ? 1 : 0;
						}
					}
				}catch(Exception ex) {
					System.out.println(ex);
				}
				
				listPubsBarsCategory.add(objPubsAndBarsCategory);
			} 
			if((category.contains("Shopping ") || category.contains("Clothing") || category.contains("Fashion"))) {
				objShoppingCategory = new Shopping();
				try {
					objShoppingCategory.businessId = (String) objJson.get("business_id");
					objShoppingCategory.name = (String) objJson.get("name");
					objShoppingCategory.fullAddress = ((String) objJson.get("full_address")).replace("\n", " ").replace(",", "");
					objShoppingCategory.stars = (Double) objJson.get("stars");
					objTempJson = (JSONObject)objJson.get("attributes");
					if(objTempJson.containsKey("Parking")){
						objTempJson = (JSONObject)objTempJson.get("Parking");
						objShoppingCategory.parking = (Boolean) objTempJson.toString().contains("true") == true ?  1 : 0;
					} else {
						objShoppingCategory.parking = 0;
					}
					elementList = ((JSONObject)objJson.get("attributes")).toString().split(",");
					for(int k = 0; k < elementList.length; k++) {
						String[] attributesList = elementList[k].split(":");
						if(attributesList[0].contains("Price Range")){
							objShoppingCategory.priceRange = Integer.parseInt(attributesList[1].replace("}", ""));
						}
						if(attributesList[0].contains("Wheelchair Accessible")){
							objShoppingCategory.wheelchairAccessible = attributesList[1].equals("true") ? 1 : 0;
						}
					}
					objTempJson = (JSONObject)objJson.get("attributes");
					if(objTempJson.containsKey("Music")){
						objTempJson = (JSONObject)objTempJson.get("Music");
						objShoppingCategory.music = (Boolean) objTempJson.toString().contains("true") == true ?  1 : 0;
					} else {
						objShoppingCategory.music = 0;
					}					
				}catch(Exception ex) {
					System.out.println(ex);
				}
				
				listShoppingCategory.add(objShoppingCategory);
			}			
		}
		
		objCsv.writeCsvFile(listRestaurantCategory, listHealthCategory, listPubsBarsCategory, listShoppingCategory);
	}
}
