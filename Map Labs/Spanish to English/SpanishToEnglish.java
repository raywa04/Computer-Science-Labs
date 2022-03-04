import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;
import static java.lang.System.*;
/**
 * This class implements multiple methods to use the dat file
 * provided to do a basic translation from spanish to english
 * @author Rayyan Waris
 *
 */
public class SpanishToEnglish
{
	private Map<String,String> pairs;
	/**
	 * Basic constructor that initalizes the map as
	 * a treemap
	 */
	public SpanishToEnglish()
	{
		pairs = new TreeMap<String, String>();
	}
	/**
	 * Puts the entries into the tree map
	 * @param entry - the entry to put in
	 */
	public void putEntry(String entry)
	{
		String[] list = entry.split(" ");
		pairs.put(list[0],  list[1]);
	}
	/**
	 * Translates the sent message into the english
	 * translation of the words
	 * @param sent - the message
	 * @return the translations
	 */
	public String translate(String sent)
	{
		Scanner chop = new Scanner(sent);
		String output ="";
		String[] words = sent.split(" ");
		for (String word : words)
		{
			output += " " + pairs.get(word);
		}
		return output;
	}
	/**
	 * Prints out a toString representation of the spanish to english
	 */
	public String toString()
	{
		return pairs.toString().replaceAll("\\,","\n");
	}
}