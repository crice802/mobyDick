/**
 * 
 */
package moby.dick.ex;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author crice
 *
 *
 */

public class WordCount {

	public static void main(String[] args) {
		File moby = new File("/Users/crice/eclipse-workspace/moby-dick/src/moby/dick/ex/Loomings.txt");

		try {
			Scanner reader = new Scanner(moby);
			while (reader.hasNextLine()) {
				String text = reader.nextLine();
//				reader.nextLine();
				String[] text2 = text.toLowerCase().split("\\W+");

				HashMap<String, Integer> mobyT = new HashMap<>();
				for (int i = 0; i < text2.length; i++) {
					if (mobyT.containsKey(text2[i])) {
						mobyT.put(text2[i], mobyT.get(text2[i]) + 1);
					} else {
						mobyT.put(text2[i], 1);
					}

				}

				TreeMap<String, Integer> tm = new TreeMap<String, Integer>();
				tm.putAll(mobyT);
				System.out.println(mobyT);
				System.out.println(tm);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		}

	}

	public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm) {
		// Create a list from elements of HashMap
		List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(hm.entrySet());

		// Sort the list
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});

		// put data from sorted list to hashmap
		HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
		for (Map.Entry<String, Integer> aa : list) {
			temp.put(aa.getKey(), aa.getValue());
		}
		return temp;
	}

}
