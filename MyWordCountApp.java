package Lab08;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MyWordCountApp {
	public static final String fileName = "data/fit.txt";
	private Map<String, Integer> map = new HashMap<String, Integer>();

	// Load data from fileName into the above map (containing <word, its
	// occurences>)
	// using the guide given in TestReadFile.java
	public void loadData() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] words = line.split("\\s+");
				for (String word : words) {
					word = word.toLowerCase();
					if (map.containsKey(word)) {
						map.put(word, map.get(word) + 1);
					} else {
						map.put(word, 1);
					}
				}
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Returns the number of distinct tokens in the file data/hamlet.txt or
	// fit.txt
	public int countDistinct() {
		return map.size();
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt)
	// In this method, we do not consider the order of tokens
	public void printWordCounts() throws FileNotFoundException {
		if (map.isEmpty()) {
			loadData();
		}
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}
	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according to ascending order of
	// tokens
	// Example: An - 3, Bug - 10, ...

	public void printWordCountsAlphabet() {
		if (map.isEmpty()) {
			loadData();
		}
		Map<String, Integer> sortedMap = new TreeMap<>(map);
		for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
			System.out.println(entry.getKey() + " - " + entry.getValue());
		}
	}
}
