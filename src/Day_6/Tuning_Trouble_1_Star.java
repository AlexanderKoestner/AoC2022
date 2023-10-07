package Day_6;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;

public class Tuning_Trouble_1_Star {
	
	static boolean isMarker(String possibleMarker) {
		
		Set<Character> uniqueChars = new HashSet<>();
		
		for(char value : possibleMarker.toCharArray()) {
			uniqueChars.add(value);
		}
		
		return uniqueChars.size() == 4;
    }

	public static void main(String[] args) throws IOException, URISyntaxException {

		String line = Files.readString(Paths.get(new URI("file:/E:/Advent_of_Code_2022/AdventOfCode_Day6_Input.txt")));
		
		AtomicReference<Integer> foundIndex = new AtomicReference<>();
		
		IntStream.range(4, line.length())
		.filter(i -> isMarker(line.substring(i - 4, i)))
		.findFirst()
		.ifPresent(i -> {
			foundIndex.set(i);
			System.out.println("Index: " + (i));
		});
		
		System.out.print(line.substring(foundIndex.get() -4, foundIndex.get()));
	}
}