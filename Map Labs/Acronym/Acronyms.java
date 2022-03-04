import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;
import static java.lang.System.*;
/**
 * This class implements multiple methods
 * to have a set of acronyms and it in actual words
 * @author Rayyan Waris
 *
 */
public class Acronyms
{
	private Map<String,String> acronymTable;
	/**
	 * Basic constructor that initializes the map
	 * into a a tree map
	 */
	public Acronyms()
	{
		acronymTable = new TreeMap<String, String>();
	}
	/**
	 * Stores the entries given of the acronyms
	 * @param entry - the entries to store
	 */
	public void putEntry(String entry)
	{
		String[] acros = entry.split(" - ");
		String key = acros[0];
		String value = acros[1];
		acronymTable.put(key, value);
	}
	/**
	 * Converts the acronyms into a word format
	 * @param sent - the word to check for
	 * @return the converted acronyms
	 */
	public String convert(String sent)
	{
		Scanner chop = new Scanner(sent);
		String output ="";
		while(chop.hasNext()) 
		{
			String word = chop.next();
			if(acronymTable.containsKey(word))
			{
				output += acronymTable.get(word) + " ";
			}
			else if(acronymTable.containsKey(word.replace(".","")))
			{
				output += acronymTable.get(word.replace(".","")) + ". ";
			}
			else
			{
				output += word + " ";
			}
		}
		return output;
	}
	/**
	 * Prints out a string representation of the acronyms to word format
	 * with all its glory
	 */
	public String toString()
	{
		return acronymTable.toString().replaceAll(",","\n");
	}
}