package Lab08;

import java.io.*;
import java.util.*;

public class TextAnalyzer {
	// <word, its positions>
	private Map<String, ArrayList<Integer>> map = new HashMap<>();
	//load words in the text file given by fileName and store them
	//into map by using add method in Task 2.1.
	// Using BufferedReader as in file TextFileUtils.java
	public void load(String fileName) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			String line;
			int position = 0;
			while ((line = reader.readLine()) != null) {
				String[] words = line.split("\\s+");
				for (String word : words) {
					word = word.toLowerCase();
					if (!map.containsKey(word)) {
						map.put(word, new ArrayList<>());
					}
					map.get(word).add(position);
					position++;
				}
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}