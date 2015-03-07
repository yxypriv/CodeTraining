package randomization;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordCounting {
	static File inputFile = new File("input.txt");
	
	public static Set<String> initialStopwords() {
		Set<String> stopwordSet = new HashSet<String>();
		String [] stopwords = new String[]{"the","a","to","of","on"};
		for(String sw : stopwords) {
			stopwordSet.add(sw);
		}
		return stopwordSet;
	}
		
	public static void main(String[] args) {
		final Map<String, Integer> wordCountMap = new HashMap<String, Integer>();
		Set<String> stopWords = initialStopwords();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), "utf8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String line = null;
		try {
			while((line = reader.readLine())!=null) {
				String[] split = line.toLowerCase().split("[ ,\\.\"]+");
				for(String str : split) {
					if("".equals(str) || stopWords.contains(str))
						continue;
					if(!wordCountMap.containsKey(str))
						wordCountMap.put(str, 1);
					else
						wordCountMap.put(str, wordCountMap.get(str)+1);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		List<String> wordList = new ArrayList<String>();
		wordList.addAll(wordCountMap.keySet());
		Collections.sort(wordList, Collections.reverseOrder(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return wordCountMap.get(o1).compareTo(wordCountMap.get(o2));
			}
		}));
		
		for(String str : wordList) {
			System.out.println(str + "\t" + wordCountMap.get(str));
		}
	}
	

}
