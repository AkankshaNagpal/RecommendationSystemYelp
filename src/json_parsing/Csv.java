package json_parsing;
 import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Csv {
	//Delimiter used in CSV file
	private static final String COMMA_DELIMITER = ",";
	private static final String NEW_LINE_SEPARATOR = "\n";
	private static FileWriter fileWriter = null;
	
	public void writeCsvFile(List<Restaurant> listRestaurantCategory, List<Health> listHealthCategory, 
		List<PubsAndBars> listPubsBarsCategory, List<Shopping> listShoppingCategory) {
		writeRestaurantCsvFile(listRestaurantCategory);
		writeHealthCsvFile(listHealthCategory);
		writePubsAndBarsCsvFile(listPubsBarsCategory);
		writeShoppingCsvFile(listShoppingCategory);
	}
	
	public void writeShoppingCsvFile(List<Shopping> listShoppingCategory) {
		fileWriter = null;
		
		try {
			fileWriter = new FileWriter("shopping.csv");
			fileWriter.append("Business Id");
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append("Business Name");
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append("Address");
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append("Parking");
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append("Price Range");
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append("Wheelchair Accessibility");
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append("Music");
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append("Stars");
			fileWriter.append(NEW_LINE_SEPARATOR);
			
			//Write a new student object list to the CSV file
			for (Shopping objShopping : listShoppingCategory) {	
				fileWriter.append(String.valueOf(objShopping.businessId));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(objShopping.name));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(objShopping.fullAddress));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(objShopping.parking));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(objShopping.priceRange));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(objShopping.wheelchairAccessible));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(objShopping.music));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(objShopping.stars));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(NEW_LINE_SEPARATOR);
			}
		} catch(Exception ex) {
			System.out.println("Error in CsvFileWriter !!!");
			ex.printStackTrace(); 
		} finally {
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch(IOException e){
				System.out.println("Error while flushing/closing fileWriter !!!");
				e.printStackTrace();
			}
		}
	}
	
	public void writePubsAndBarsCsvFile(List<PubsAndBars> listPubsBarsCategory) {
		fileWriter = null;
		
		try {
			fileWriter = new FileWriter("pubsbars.csv");
			
			fileWriter.append("Business Id");
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append("Business Name");
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append("Address");
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append("Alcohol");
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append("Dancing");
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append("Noise Level");
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append("Stars");
			fileWriter.append(NEW_LINE_SEPARATOR);
			
			//Write a new student object list to the CSV file
			for (PubsAndBars objPubsAndBars : listPubsBarsCategory) {	
				fileWriter.append(String.valueOf(objPubsAndBars.businessId));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(objPubsAndBars.name));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(objPubsAndBars.fullAddress));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(objPubsAndBars.alcohol));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(objPubsAndBars.allowedDancing));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(objPubsAndBars.noiceLevel));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(objPubsAndBars.stars));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(NEW_LINE_SEPARATOR);
			}
		} catch(Exception ex) {
			System.out.println("Error in CsvFileWriter !!!");
			ex.printStackTrace(); 
		} finally {
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch(IOException e){
				System.out.println("Error while flushing/closing fileWriter !!!");
				e.printStackTrace();
			}
		}
	}

	public void writeHealthCsvFile(List<Health> listHealthCategory) {
		fileWriter = null;
		
		try {
			fileWriter = new FileWriter("health.csv");
			fileWriter.append("Business Id");
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append("Business Name");
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append("Address");
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append("By Appointment Only");
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append("Open On Weekend");
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append("Stars");
			fileWriter.append(NEW_LINE_SEPARATOR);
			
			//Write a new student object list to the CSV file
			for (Health objHealth : listHealthCategory) {	
				fileWriter.append(String.valueOf(objHealth.businessId));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(objHealth.name));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(objHealth.fullAddress));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(objHealth.byAppointment));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(objHealth.openOnSaturday));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(objHealth.stars));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(NEW_LINE_SEPARATOR);
			}
		} catch(Exception ex) {
			System.out.println("Error in CsvFileWriter !!!");
			ex.printStackTrace(); 
		} finally {
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch(IOException e){
				System.out.println("Error while flushing/closing fileWriter !!!");
				e.printStackTrace();
			}
		}
	}
	
	public void writeRestaurantCsvFile(List<Restaurant> listRestaurantCategory) {
		fileWriter = null;
		
		try {
			fileWriter = new FileWriter("restaurant.csv");
			
			fileWriter.append("Business Id");
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append("Business Name");
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append("Address");
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append("Take-out");
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append("Wi-Fi");
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append("Alcohol");
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append("Good for Kids");
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append("Parking");
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append("Good For Lunch");
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append("Good For Dinner");
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append("Good For Dessert");
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append("Good For Latenight");
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append("Good For Brunch");
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append("Good For Breakfast");
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append("Stars");
			fileWriter.append(NEW_LINE_SEPARATOR);
			
			//Write a new student object list to the CSV file
			for (Restaurant objRestaurant : listRestaurantCategory) {	
				fileWriter.append(String.valueOf(objRestaurant.businessId));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(objRestaurant.name));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(objRestaurant.fullAddress));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(objRestaurant.takeOut));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(objRestaurant.wiFi));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(objRestaurant.alcohol));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(objRestaurant.goodForKids));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(objRestaurant.parking));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(objRestaurant.goodForLunch));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(objRestaurant.goodForDinner));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(objRestaurant.goodForDessert));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(objRestaurant.goodForLatenight));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(objRestaurant.goodForBrunch));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(objRestaurant.goodForBreakfast));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(objRestaurant.stars));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(NEW_LINE_SEPARATOR);
			}
		} catch(Exception ex) {
			System.out.println("Error in CsvFileWriter !!!");
			ex.printStackTrace(); 
		} finally {
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch(IOException e){
				System.out.println("Error while flushing/closing fileWriter !!!");
				e.printStackTrace();
			}
		}
	}
}
