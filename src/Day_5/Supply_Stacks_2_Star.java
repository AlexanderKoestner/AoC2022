package Day_5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;



public class Supply_Stacks_2_Star {

	public static void main(String[] args) throws IOException {
	
		try {
			File inputFile = new File("E:\\Advent_of_Code_2022\\AdventOfCode_Day5_Input.txt");
			
			FileReader reader = new FileReader(inputFile);
			
			BufferedReader bReader = new BufferedReader(reader);
			
			String line = bReader.readLine();
			
			ArrayList<ArrayList<Character>> stacks = new ArrayList<>();
			
			ArrayList<Character> load = new ArrayList<>();
			
			
			
			for(int i = 0 ; i < (line.length() + 1)/ 4; i++) {
				
				stacks.add(new ArrayList<Character>());
			}
			
			boolean done = false;
			
			while(line != null) {
				
				if(line.length() > 1) {
					
					if(line.contains("[")) {

						int stack = 0;
						
						for(int i = 1; i < line.length(); i+=4) {
							
							if(i >= line.length()) {
								break;
							}
							if(line.toCharArray()[i] == ' ') {
								stack++;
								continue;
							}
							
							stacks.get(stack++).add(line.toCharArray()[i]);
							
						}
					}
					else if(!done) {
						
						done = true;
						for(ArrayList<Character> list : stacks) {
							Collections.reverse(list);
						}
						
					}
					
				}
				
				if(line.contains("move")) {
					
					int move = Integer.parseInt(line.split("from")[0].replaceAll("[^0-9]", ""));
					int from = Integer.parseInt(line.split("from")[1].substring(0, 2).replaceAll("[^0-9]", "")) - 1;
					int to = Integer.parseInt(line.split("from")[1].substring(3).replaceAll("[^0-9]", "")) - 1;
					
					for(int i = 0; i < move; i++) {
						
						load.add(stacks.get(from).get(stacks.get(from).size() - 1));
						stacks.get(from).remove(stacks.get(from).size() - 1);
					}
					
					Collections.reverse(load);
					
					for(int i = 0; i < load.size(); i++) {
						
						stacks.get(to).add(load.get(i));
					}
					
					load.clear();
					
				}
				
				System.out.println(line);
			
				
				line = bReader.readLine();
			}
			System.out.println();
			
			
			
			for(ArrayList<Character> value : stacks) {
				if(value.size() == 0) {
					continue;
				}
				
				System.out.print(value.get(value.size()-1));
			}
			
			bReader.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
