package Day_2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Rock_Paper_Scissors {

	public static void main(String[] args) throws IOException {


		try {
			File inputFile = new File("E:\\Advent_of_Code_2022\\AdventOfCode_Day2_Input.txt");
			
			FileReader reader = new FileReader(inputFile);
			
			BufferedReader bReader = new BufferedReader(reader);
			
			int sum = 0;
			
			String line = bReader.readLine();
			
			while(line != null) {
				
				if(line.contains("X")) {
					sum += 0;
					
					if(line.contains("A")) {
						sum += 3;
					}
					if(line.contains("B")) {
						sum += 1;
					}
					if(line.contains("C")) {
						sum += 2;
					}
				}
				
				if(line.contains("Y")) {
					sum += 3;
					
					if(line.contains("A")) {
						sum += 1;
					}
					if(line.contains("B")) {
						sum += 2;
					}
					if(line.contains("C")) {
						sum += 3;
					}
					
				}
				
				if(line.contains("Z")) {
					sum += 6;
					if(line.contains("A")) {
						sum += 2;
					}
					if(line.contains("B")) {
						sum += 3;
					}
					if(line.contains("C")) {
						sum += 1;
					}
				}
				line = bReader.readLine();
			}
			reader.close();
			bReader.close();
			System.out.println(sum);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

}
