package Lab07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class MyWordCount {
	// public static final String fileName = "data/hamlet.txt";
	public static final String fileName = "data/fit.txt";

	private List<String> words = new ArrayList<>();

	public MyWordCount() {
		try {
			this.words.addAll(Utils.loadWords(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public int countWord(String Word) {
		int count = 0;
		for (int i = 0; i < words.size(); i++) {
		}return count;
	}
	
	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt)
	// In this method, we do not consider the order of tokens.
	public List<WordCount> getWordCounts() {
		List<WordCount> res = new ArrayList<WordCount>();
		for (String w : words) {
			WordCount wc = new WordCount(w, countWord(w));
			if (!res.contains(wc)) {
				res.add(wc);
			}
		}
		return res;
	}

	// Returns the words that their appearance are 1, do not consider duplidated
	// words
	public Set<String> getUniqueWords() {
		Set<String> res = new HashSet<String>();
		List<WordCount> list = getWordCounts();
		for (WordCount wc : list) {
			if (wc.getCount() == 1) {
				res.add(wc);
			}
		}

		return res;
	}

	// Returns the words in the text file, duplicated words appear once in the
	// result
	public Set<String> getDistinctWords() {
		return new HashSet<>(words);
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according ascending order of tokens
	// Example: An - 3, Bug - 10, ...
	public Set<WordCount>  exportWordCounts() {
		 Set<WordCount> wordCounts = new TreeSet<>(Comparator.comparing(WordCount::getWord));
	        wordCounts.addAll(getWordCounts());
	        return wordCounts;
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according descending order of occurences
	// Example: Bug - 10, An - 3, Nam - 2.
	public Set<WordCount> exportWordCountsByOccurence() {
		  Set<WordCount> wordCounts = new TreeSet<>(Comparator.comparing(WordCount::getCount).reversed());
	        wordCounts.addAll(getWordCounts());
	        return wordCounts;
	}

	// delete words begining with the given pattern (i.e., delete words begin with
	// 'A' letter
	public Set<String> filterWords(String pattern) {
		 Set<WordCount> wordCounts = new HashSet<>();
	        for (WordCount wc : getWordCounts()) {
	            if (!wc.getWord().startsWith(pattern)) {
	                wordCounts.add(wc);
	            }
	        }
	        return wordCounts;
	}
}
