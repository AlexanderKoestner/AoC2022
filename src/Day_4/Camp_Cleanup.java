package Day_4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Camp_Cleanup {

	public static void main(String[] args) throws IOException {
	
		try {
			File inputFile = new File("E:\\Advent_of_Code_2022\\AdventOfCode_Day5_Input.txt");
			
			FileReader reader = new FileReader(inputFile);
			
			BufferedReader bReader = new BufferedReader(reader);
			
			String line = bReader.readLine();
			
			String firstRange = null;
			String secondRange = null;
			int startFirstRange;
			int endFirstRange;
			int startSecondRange;
			int endSecondRange;
			int start;
			int end;
			Boolean inside;
			
			
			ArrayList<Integer> listFirstRange = new ArrayList<>();
			ArrayList<Integer> listSecondRange = new ArrayList<>();
			
			int sum = 0;
			
			while(line != null) {
				
				inside = false;
				
				listFirstRange.clear();
				listSecondRange.clear();

				firstRange = line.split(",")[0];
				secondRange = line.split(",")[1];
				
				startFirstRange = Integer.valueOf(firstRange.split("-")[0]);
				endFirstRange = Integer.valueOf(firstRange.split("-")[1]);
				
				startSecondRange = Integer.valueOf(secondRange.split("-")[0]);
				endSecondRange = Integer.valueOf(secondRange.split("-")[1]);
				
				for(int i = 0; i < 100; i++) {
					
					if(i < startFirstRange || i > endFirstRange) {
						listFirstRange.add(0);
					}
					else {
						listFirstRange.add(1);
					}
					
					if(i < startSecondRange || i > endSecondRange) {
						listSecondRange.add(0);
					}
					else {
						listSecondRange.add(1);
					}
				}
				
				if(endFirstRange - startFirstRange > endSecondRange - startSecondRange) {
					start = startFirstRange;
					end = endFirstRange;
				}
				else {
					start = startSecondRange;
					end = endSecondRange;
				}
				
				for(int i = 0; i < 100; i++) {
					
					
						if(i >= start && i <= end) {
							if(listFirstRange.get(i) == listSecondRange.get(i)) {
								inside = true;
								break;
							}
						}
					
				}
				
				if(inside) {
					sum++;
				}
				
				line = bReader.readLine();
			}
			
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
