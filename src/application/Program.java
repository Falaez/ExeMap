package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter file full path: ");
		String path = sc.next();

		try (BufferedReader br = new BufferedReader(new FileReader(path))){
			
			Map <String, Integer> map = new HashMap<>();
			int votesSoFar = 0;
			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(",");
				String name = fields[0];
				Integer vote =  Integer.parseInt(fields[1]);
				
				if (map.containsKey(name)) {
					votesSoFar = map.get(name);
					map.put(name, vote + votesSoFar);
				}else {
					map.put(name, vote);
				}
				line = br.readLine();	
			}
				for(String key: map.keySet()) {
					System.out.println(key +" : "+ map.get(key));
				}
				
			
			
		}
		catch (IOException e) {
			System.out.print("Error: "+e.getMessage());
		}
	}

}
