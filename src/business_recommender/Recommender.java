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
	public double predicted_rating;
	public double predicted_success_rate;
	public Map<String, List<Double>> op = new HashMap<String, List<Double>>();
	
	public  Map<String, List<Double>> restaurant_recommend(int[] ip, String ip_file, String location) {
		
		prediction = new HashSet<String>();
		
		try {
			
			System.out.println("Input:" + ip);
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
						
						if(ip[i] > 0) {
							if(splitted_ip[i+3].equals("1"))
								cnt++;
						}
						else if(ip[i] == 0 && Double.parseDouble(splitted_ip[14]) > 4)
							prediction.add(restaurant_attributes.get(i+1));
					}
					
					line_graph_map.put(b_id,  Double.parseDouble(splitted_ip[14]));
					b_id++;
					pie_graph.put(Double.parseDouble(splitted_ip[14]), pie_graph.get(Double.parseDouble(splitted_ip[14]))+1);
					
					List<Double> temp_list = new ArrayList<Double>();
					temp_list.add((double)cnt);
					temp_list.add(Double.parseDouble(splitted_ip[14]));
					
					System.out.println("Temp List: " + temp_list);
					op.put(splitted_ip[0].toString(), temp_list);
					System.out.println(op);
				}
			}
			
			Double[] rating = new Double[op.size()];
			int m = 0;
			for(Entry<String, List<Double>> e : op.entrySet()) {
				
				//System.out.println(e.getKey() + ": " + e.getValue()[0] + ", " + e.getValue()[1]);
				if(e.getValue().get(0) > 1) {
					
					rating[m++]  = e.getValue().get(1);
				}
			}
			
			double sum = 0;
			for(int i = 0; i < m; i++) {
				
				sum += rating[i];
			}
			br.close();
			
			predicted_rating = sum/(double)m;
			predicted_success_rate = predicted_rating * 20;
			System.out.println("Predicted Rating : " + predicted_rating + "\nSuccess Rate :" + predicted_success_rate + "%");
			
		}
		catch(FileNotFoundException ex) {
			System.out.println("File did not find!");
		}
		catch(IOException ex) {
			System.out.println("I/O Exception!");
		}
		
		return op;
	}
	
	public  Map<String, List<Double>> health_recommend(int[] ip, String ip_file, String location) {
		
		
		prediction = new HashSet<String>();
		
		try {
			
			System.out.println("Input:" + ip);
			String line = null;
			String[] splitted_ip = new String[6];
			
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
					for(int i = 0; i < 2; i++) {
						
						if(ip[i] > 0) {
							if(splitted_ip[i+3].equals("1"))
								cnt++;
						}
						else if(ip[i] == 0 && Double.parseDouble(splitted_ip[5]) > 4)
							prediction.add(restaurant_attributes.get(i+1));
					}
					
					line_graph_map.put(b_id,  Double.parseDouble(splitted_ip[5]));
					b_id++;
					pie_graph.put(Double.parseDouble(splitted_ip[5]), pie_graph.get(Double.parseDouble(splitted_ip[14]))+1);
					
					List<Double> temp_list = new ArrayList<Double>();
					temp_list.add((double)cnt);
					temp_list.add(Double.parseDouble(splitted_ip[5]));
					
					System.out.println("Temp List: " + temp_list);
					op.put(splitted_ip[0].toString(), temp_list);
					System.out.println(op);
				}
			}
			
			Double[] rating = new Double[op.size()];
			int m = 0;
			for(Entry<String, List<Double>> e : op.entrySet()) {
				
				//System.out.println(e.getKey() + ": " + e.getValue()[0] + ", " + e.getValue()[1]);
				if(e.getValue().get(0) > 1) {
					
					rating[m++]  = e.getValue().get(1);
				}
			}
			
			double sum = 0;
			for(int i = 0; i < m; i++) {
				
				sum += rating[i];
			}
			br.close();
			
			predicted_rating = sum/(double)m;
			predicted_success_rate = predicted_rating * 20;
			System.out.println("Predicted Rating : " + predicted_rating + "\nSuccess Rate :" + predicted_success_rate + "%");
			
		}
		catch(FileNotFoundException ex) {
			System.out.println("File did not find!");
		}
		catch(IOException ex) {
			System.out.println("I/O Exception!");
		}
		
		return op;
	}
	
	public  Map<String, List<Double>> pubsnbars_recommend(int[] ip, String ip_file, String location) {
		
		prediction = new HashSet<String>();
		
		try {
			
			System.out.println("Input:" + ip);
			String line = null;
			String[] splitted_ip = new String[7];
			
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
					for(int i = 0; i < 2; i++) {
						
						if(ip[i] > 0) {
							if(splitted_ip[i+3].equals("1"))
								cnt++;
						}
						else if(ip[i] == 0 && Double.parseDouble(splitted_ip[6]) > 4)
							prediction.add(restaurant_attributes.get(i+1));
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
					
					line_graph_map.put(b_id,  Double.parseDouble(splitted_ip[6]));
					b_id++;
					pie_graph.put(Double.parseDouble(splitted_ip[6]), pie_graph.get(Double.parseDouble(splitted_ip[14]))+1);
					
					List<Double> temp_list = new ArrayList<Double>();
					temp_list.add((double)cnt);
					temp_list.add(Double.parseDouble(splitted_ip[6]));
					
					System.out.println("Temp List: " + temp_list);
					op.put(splitted_ip[0].toString(), temp_list);
					System.out.println(op);
				}
			}
			
			Double[] rating = new Double[op.size()];
			int m = 0;
			for(Entry<String, List<Double>> e : op.entrySet()) {
				
				//System.out.println(e.getKey() + ": " + e.getValue()[0] + ", " + e.getValue()[1]);
				if(e.getValue().get(0) > 1) {
					
					rating[m++]  = e.getValue().get(1);
				}
			}
			
			double sum = 0;
			for(int i = 0; i < m; i++) {
				
				sum += rating[i];
			}
			br.close();
			
			predicted_rating = sum/(double)m;
			predicted_success_rate = predicted_rating * 20;
			System.out.println("Predicted Rating : " + predicted_rating + "\nSuccess Rate :" + predicted_success_rate + "%");
			
		}
		
		catch(FileNotFoundException ex) {
			System.out.println("File did not find!");
		}
		catch(IOException ex) {
			System.out.println("I/O Exception!");
		}
		
		return op;
	}
	
	public  Map<String, List<Double>> shopping_recommend(int[] ip, String ip_file, String location) {
		
prediction = new HashSet<String>();
		
		try {
			
			System.out.println("Input:" + ip);
			String line = null;
			String[] splitted_ip = new String[8];
			
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
					for(int i = 0; i < 4; i++) {
						
						if(ip[i] > 0) {
							if(splitted_ip[i+3].equals("1"))
								cnt++;
						}
						else if(ip[i] == 0 && Double.parseDouble(splitted_ip[7]) > 4)
							prediction.add(restaurant_attributes.get(i+1));
					}
					
					line_graph_map.put(b_id,  Double.parseDouble(splitted_ip[7]));
					b_id++;
					pie_graph.put(Double.parseDouble(splitted_ip[7]), pie_graph.get(Double.parseDouble(splitted_ip[14]))+1);
					
					List<Double> temp_list = new ArrayList<Double>();
					temp_list.add((double)cnt);
					temp_list.add(Double.parseDouble(splitted_ip[7]));
					
					System.out.println("Temp List: " + temp_list);
					op.put(splitted_ip[0].toString(), temp_list);
					System.out.println(op);
				}
			}
			
			Double[] rating = new Double[op.size()];
			int m = 0;
			for(Entry<String, List<Double>> e : op.entrySet()) {
				
				//System.out.println(e.getKey() + ": " + e.getValue()[0] + ", " + e.getValue()[1]);
				if(e.getValue().get(0) > 1) {
					
					rating[m++]  = e.getValue().get(1);
				}
			}
			
			double sum = 0;
			for(int i = 0; i < m; i++) {
				
				sum += rating[i];
			}
			br.close();
			
			predicted_rating = sum/(double)m;
			predicted_success_rate = predicted_rating * 20;
			System.out.println("Predicted Rating : " + predicted_rating + "\nSuccess Rate :" + predicted_success_rate + "%");
			
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
		int cnt = 0;
		List<String> new_prediction = new ArrayList<String>();
		for(String i: prediction) {
			
			System.out.print(i + ", ");
			cnt++;
			if(cnt < 4)
				new_prediction.add(i);
		}
		System.out.println("\n");
		
		data.put("PredictedRating", predicted_rating);
		data.put("PredictedSuccessRate", predicted_success_rate);
		
		data.put("Prediction", new_prediction);
		
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
	
	
	public  JSONObject find_success(String category, List<String> ip, String location) {
		
		Map<String, List<Double>> op;
		
		System.out.println("\nCategory : " + category);
		switch(category) {
		
			case "Restaurant":
				int[] input = new int[10];
				for(Entry e:restaurant_attributes.entrySet()) {
					
					if(ip.contains(e.getValue())) {
						
						input[(int) e.getKey()-1] = 1;
					}
				}
				
				op = restaurant_recommend(input, "F:\\SEM III\\CMPE_239\\Project\\RecommendationSystemYelp\\src\\business_recommender\\restaurant.csv", location);
				predict();
				break;
				
			case "Health":
				input = new int[2];
				for(Entry e:restaurant_attributes.entrySet()) {
					
					if(ip.contains(e.getValue())) {
						
						input[(int) e.getKey()] = 1;
					}
				}
				op = health_recommend(input, "F:\\SEM III\\CMPE_239\\Project\\RecommendationSystemYelp\\src\\business_recommender\\health.csv", location);
				predict();
				break;
				
			case "Pubs and Bars":
				input = new int[3];
				for(Entry e:restaurant_attributes.entrySet()) {
					
					if(ip.contains(e.getValue())) {
						
						input[(int) e.getKey()] = 1;
					}
				}
				op = pubsnbars_recommend(input, "F:\\SEM III\\CMPE_239\\Project\\RecommendationSystemYelp\\src\\business_recommender\\pubsbars.csv", location);
				predict();
				break;
				
			case "Shopping":
				input = new int[4];
				for(Entry e:restaurant_attributes.entrySet()) {
					
					if(ip.contains(e.getValue())) {
						
						input[(int) e.getKey()] = 1;
					}
				}
				op = shopping_recommend(input, "F:\\SEM III\\CMPE_239\\Project\\RecommendationSystemYelp\\src\\business_recommender\\shopping.csv", location);
				predict();
				break;
		}
		
		return data;
	}
}