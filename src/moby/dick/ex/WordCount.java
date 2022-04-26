/**
 * 
 */
package moby.dick.ex;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

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
				String[] text2 = text.split(" ");

				HashMap<String, Integer> mobyT = new HashMap<>();
				for (int i = 0; i < text2.length; i++) {
					mobyT.put(text2[i], 1);

				}
				System.out.println(mobyT);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
