package business_recommender;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Recommender {

	public  Map<Integer, String> restaurant_attributes = new HashMap<Integer, String>(){
		{
			put(1, "Take-out");
			put(2, "Wi-Fi");
			put(3, "Alcohol");
			put(4, "Good-for-kids");
			put(5, "Parking");
			put(6, "Breakfast");
			put(7, "Brunch");
			put(8, "Lunch");
			put(9, "Dinner");
			put(10, "Wheelchair-Access");
			
		}
	};
	
	public  Map<Integer, String> health_attributes = new HashMap<Integer, String>(){
		{
			put(1, "By-appointment-only");
			put(2, "Open-on-weekends");
		}
	};
	
	public  Map<Integer, String> pubsnbars_attributes = new HashMap<Integer, String>(){
		{
			put(1, "Alcohol");
			put(2, "Dance");
			put(3, "Noise-level");
		}
	};
	
	public  Map<Integer, String> shopping_attributes = new HashMap<Integer, String>(){
		{
			put(1, "Parking");
			put(2, "Price-range");
			put(3, "Wheelchair-access");
			put(4, "Music");
		}
	};
	
	public  JSONObject data = new JSONObject();
	public  Map<Double, Integer> pie_graph = new HashMap<Double, Integer>(){{
		put(1.0, 0);
		put(1.5, 0);
		put(2.0, 0);
		put(2.5, 0);
		put(3.0, 0);
		put(3.5, 0);
		put(4.0, 0);
		put(4.5, 0);
		put(5.0, 0);
	}};
	
	public  Map<Integer, Double> line_graph_map = new HashMap<Integer, Double>();
	
	public  Set<String> prediction;
	
	public  Map<String, Double[]> restaurant_recommend(int[] ip, String ip_file, String location) {
		
		Map<String, Double[]> op = new HashMap<String, Double[]>();
		prediction = new HashSet<String>();
		
		try {
			
			String line = null;
			String[] splitted_ip = new String[15];
			
			FileReader fr = new FileReader(ip_file);
			BufferedReader br = new BufferedReader(fr);
			
			if((line = br.readLine()) == null) {
				br.close();
				return null;
			}
			
			JSONObject temp = new JSONObject();	
			Integer b_id = 1;
			
			while((line = br.readLine()) != null) {
				
				splitted_ip = line.split(",");
				
				if(splitted_ip[2].contains(location)) {
				
					int cnt = 0;
					for(int i = 0; i < 10; i++) {
						
						if(ip[i] == 1) {
							if(ip[i] == Integer.parseInt(splitted_ip[i+3]))
								cnt++;
						}
						else if(ip[i] == 0 && Double.parseDouble(splitted_ip[14]) > 3)
							prediction.add(restaurant_attributes.get(i+1));
					}
					//System.out.println("BID : " + b_id);
					/*temp.put("x", new Integer(b_id));
					temp.put("y", new Double(splitted_ip[14]));
					line_graph.add(temp);*/
					
					line_graph_map.put(b_id,  Double.parseDouble(splitted_ip[14]));
					b_id++;
					pie_graph.put(Double.parseDouble(splitted_ip[14]), pie_graph.get(Double.parseDouble(splitted_ip[14]))+1);
					Double[] temp_arr = {(double) cnt, Double.parseDouble(splitted_ip[14])};
					op.put(splitted_ip[0], temp_arr);
				
				}
			}
			
			Double[] rating = new Double[op.size()];
			int m = 0;
			for(Entry<String, Double[]> e : op.entrySet()) {
				
				//System.out.println(e.getKey() + ": " + e.getValue()[0] + ", " + e.getValue()[1]);
				if(e.getValue()[0] > 1) {
					
					rating[m++]  = e.getValue()[1];
				}
			}
			
			double sum = 0;
			for(int i = 0; i < m; i++) {
				
				sum += rating[i];
			}
			br.close();
			System.out.println("Predicted Rating : " + (sum/m) + "\nSuccess Rate :" + ((sum/m)*20) + "%");
			
		}
		catch(FileNotFoundException ex) {
			System.out.println("File did not find!");
		}
		catch(IOException ex) {
			System.out.println("I/O Exception!");
		}
		
		return op;
	}
	
	public  Map<String, Double[]> health_recommend(int[] ip, String ip_file, String location) {
		
		Map<String, Double[]> op = new HashMap<String, Double[]>();
		prediction = new HashSet<String>();
		
		try {
			
			String line = null;
			String[] splitted_ip = new String[6];
			
			FileReader fr = new FileReader(ip_file);
			BufferedReader br = new BufferedReader(fr);
			
			if((line = br.readLine()) == null) {
				br.close();
				return null;
			}
			
			while((line = br.readLine()) != null) {
				
				splitted_ip = line.split(",");
				
				if(splitted_ip[2].contains(location)) {
				
					int cnt = 0;
					for(int i = 0; i < 2; i++) {
						
						if(ip[i] == 1) {
							if(ip[i] == Integer.parseInt(splitted_ip[i+3]))
								cnt++;
						}
						else if(ip[i] == 0 && Double.parseDouble(splitted_ip[5]) > 3)
							prediction.add(health_attributes.get(i+1));
					}
					
					Double[] temp = {(double) cnt, Double.parseDouble(splitted_ip[5])};
					op.put(splitted_ip[0], temp);
				
				}
			}
			
			Double[] rating = new Double[op.size()];
			int m = 0;
			for(Entry<String, Double[]> e : op.entrySet()) {
				
				//System.out.println(e.getKey() + ": " + e.getValue()[0] + ", " + e.getValue()[1]);
				if(e.getValue()[0] > 1) {
					
					rating[m++]  = e.getValue()[1];
				}
			}
			
			double sum = 0;
			for(int i = 0; i < m; i++) {
				
				sum += rating[i];
			}
			br.close();
			System.out.println("Sum : " + sum);
			System.out.println("Predicted Rating : " + (sum/m) + "\nSuccess Rate :" + ((sum/m)*20) + "%");
			
		}
		catch(FileNotFoundException ex) {
			System.out.println("File did not find!");
		}
		catch(IOException ex) {
			System.out.println("I/O Exception!");
		}
		
		return op;
	}
	
	public  Map<String, Double[]> pubsnbars_recommend(int[] ip, String ip_file, String location) {
		
		Map<String, Double[]> op = new HashMap<String, Double[]>();
		prediction = new HashSet<String>();
		
		try {
			
			String line = null;
			String[] splitted_ip = new String[7];
			
			FileReader fr = new FileReader(ip_file);
			BufferedReader br = new BufferedReader(fr);
			
			if((line = br.readLine()) == null) {
				br.close();
				return null;
			}
			
			while((line = br.readLine()) != null) {
				
				splitted_ip = line.split(",");
				
				if(splitted_ip[2].contains(location)) {
				
					int cnt = 0;
					for(int i = 0; i < 2; i++) {
						
						if(ip[i] >= 1) {
							if(ip[i] == Integer.parseInt(splitted_ip[i+3]))
								cnt++;
						}
						else if(ip[i] == 0 && Double.parseDouble(splitted_ip[6]) > 3)
							prediction.add(pubsnbars_attributes.get(i+1));
					}
					
					switch(splitted_ip[5]) {
						
						case "null": if(ip[2] == 0)
							cnt++;
							break;
							
						case "quiet": if(ip[2] == 1)
							cnt++;
							break;
							
						case "average": if(ip[2] == 0)
							cnt++;
							break;
							
						case "loud": if(ip[2] == 0)
							cnt++;
							break;
							
						case "vey_loud": if(ip[2] == 0)
							cnt++;
							break;
					}
					
					Double[] temp = {(double) cnt, Double.parseDouble(splitted_ip[6])};
					op.put(splitted_ip[0], temp);
				
				}
			}
			
			Double[] rating = new Double[op.size()];
			int m = 0;
			for(Entry<String, Double[]> e : op.entrySet()) {
				
				//System.out.println(e.getKey() + ": " + e.getValue()[0] + ", " + e.getValue()[1]);
				if(e.getValue()[0] > 0) {
					
					rating[m++]  = e.getValue()[1];
				}
			}
			
			double sum = 0;
			for(int i = 0; i < m; i++) {
				
				sum += rating[i];
			}
			br.close();
			System.out.println("Sum : " + sum);
			System.out.println("Predicted Rating : " + (sum/m) + "\nSuccess Rate :" + ((sum/m)*20) + "%");
			
		}
		catch(FileNotFoundException ex) {
			System.out.println("File did not find!");
		}
		catch(IOException ex) {
			System.out.println("I/O Exception!");
		}
		
		return op;
	}
	
	public  Map<String, Double[]> shopping_recommend(int[] ip, String ip_file, String location) {
		
		Map<String, Double[]> op = new HashMap<String, Double[]>();
		prediction = new HashSet<String>();
		
		try {
			
			String line = null;
			String[] splitted_ip = new String[8];
			
			FileReader fr = new FileReader(ip_file);
			BufferedReader br = new BufferedReader(fr);
			
			if((line = br.readLine()) == null) {
				br.close();
				return null;
			}
			
			while((line = br.readLine()) != null) {
				
				splitted_ip = line.split(",");
				
				if(splitted_ip[2].contains(location)) {
				
					int cnt = 0;
					for(int i = 0; i < 4; i++) {
						
						if(ip[i] >= 1) {
							if(ip[i] == Integer.parseInt(splitted_ip[i+3]))
								cnt++;
						}
						else if(ip[i] == 0 && Double.parseDouble(splitted_ip[7]) > 3)
							prediction.add(shopping_attributes.get(i+1));
					}
					
					Double[] temp = {(double) cnt, Double.parseDouble(splitted_ip[7])};
					op.put(splitted_ip[0], temp);
				
				}
			}
			
			Double[] rating = new Double[op.size()];
			int m = 0;
			for(Entry<String, Double[]> e : op.entrySet()) {
				
				//System.out.println(e.getKey() + ": " + e.getValue()[0] + ", " + e.getValue()[1]);
				if(e.getValue()[0] > 0) {
					
					rating[m++]  = e.getValue()[1];
				}
			}
			
			double sum = 0;
			for(int i = 0; i < m; i++) {
				
				sum += rating[i];
			}
			br.close();
			System.out.println("Sum : " + sum);
			System.out.println("Predicted Rating : " + (sum/m) + "\nSuccess Rate :" + ((sum/m)*20) + "%");
			
			prediction.add(shopping_attributes.get(4));
		}
		catch(FileNotFoundException ex) {
			System.out.println("File did not find!");
		}
		catch(IOException ex) {
			System.out.println("I/O Exception!");
		}
		
		return op;
	}
	
	public  void predict() {
		
		System.out.print("You should add services like: ");
		for(String i: prediction) {
			
			System.out.print(i + ", ");
		}
		System.out.println("\n");
		
		data.put("Prediction", prediction);
		
		JSONArray pie_chart = new JSONArray();
		String[] colors = {"#90a4ae", "#7986cb", "#9575cd", "#4db6ac", "#64b5f6", "#CC3399", "#990099", "#FF0066", "#FFFF99"};
		int k = 0;
		
		for(Entry e: pie_graph.entrySet()) {
			
			JSONObject temp = new JSONObject();
			temp.put("label", e.getKey());
			temp.put("data", e.getValue());
			temp.put("color", colors[k++]);
			pie_chart.add(temp);
		}
		data.put("PieGraph", pie_chart);
		
		JSONArray line_graph = new JSONArray();
		
		for(Entry e: line_graph_map.entrySet()) {
			
			JSONObject temp2 = new JSONObject();
			temp2.put("x", e.getKey());
			temp2.put("y", e.getValue());
			line_graph.add(temp2);
		}
		data.put("LineGraph", line_graph);
		
		System.out.println(data.toJSONString());
	}
	
	
	public  void find_success(String category, int[] ip, String location) {
		
		Map<String, Double[]> op;
		
		System.out.println("\nCategory : " + category);
		switch(category) {
		
			case "Restaurant":
				op = restaurant_recommend(ip, "F:\\SEM III\\CMPE_239\\Project\\RecommendationSystemYelp\\src\\business_recommender\\restaurant.csv", location);
				predict();
				break;
				
			case "Health":
				op = health_recommend(ip, "F:\\SEM III\\CMPE_239\\Project\\RecommendationSystemYelp\\src\\business_recommender\\health.csv", location);
				predict();
				break;
				
			case "Pubs and Bars":
				op = pubsnbars_recommend(ip, "F:\\SEM III\\CMPE_239\\Project\\RecommendationSystemYelp\\src\\business_recommender\\pubsbars.csv", location);
				predict();
				break;
				
			case "Shopping":
				op = shopping_recommend(ip, "F:\\SEM III\\CMPE_239\\Project\\RecommendationSystemYelp\\src\\business_recommender\\shopping.csv", location);
				predict();
				break;
		}
	}
}