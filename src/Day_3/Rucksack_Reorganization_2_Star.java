package Day_3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Rucksack_Reorganization_2_Star {

	public static void main(String[] args) throws IOException {

		
		int sum = 0;
		try {
			File inputFile = new File("E:\\Advent_of_Code_2022\\AdventOfCode_Day3_Input.txt");
			
			FileReader reader = new FileReader(inputFile);
			
			BufferedReader bReader = new BufferedReader(reader);
			
			String line1 = bReader.readLine();
			
			String compartment1, compartment2;
			
			char itemtypes[] = {'#','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
									'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
			
			ArrayList<Character> list = new ArrayList<Character>();
			
			for(char value : itemtypes) {
				list.add(value);
			}
			
			Boolean done;
			
		

			while(line1 != null) {
				
				done = false;
				compartment1 = bReader.readLine();
				compartment2 = bReader.readLine();
				
				for(char value1 : line1.toCharArray()) {
					
					if(done) {
						break;
					}
					
					for(char value2 : compartment1.toCharArray()) {
						
						if(done) {
							break;
						}
						
						if(value1 == value2) {
							
							
							
							for(char value3 : compartment2.toCharArray()) {
								if(done){
									break;
								}
								
								if(value1 == value3 && value2 == value3) {
									sum += list.indexOf(value1);
									done = true;
								}
							}
							
						}
					}
				}
				line1 = bReader.readLine();
			}
			
			reader.close();
			bReader.close();
			System.out.print(sum);
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
