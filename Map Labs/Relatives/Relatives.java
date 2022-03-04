import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Scanner;
import static java.lang.System.*;
/**
 * This class implements multiple methods
 * to check if people are related to eachother
 * @author Rayyan Waris
 *
 */
public class Relatives
{
	private Map<String,Set<String>> map;
	/**
	 * Basic constructor that initalizes the map to a treemap
	 */
	public Relatives()
	{
		map = new TreeMap<String, Set<String>>();
	}
	/**
	 * Sets the people that are relative eachother within the 
	 * tree map
	 * @param line - the line to split into the map
	 */
	public void setPersonRelative(String line)
	{
		String[] personRelative = line.split(" ");
		if(map.get(personRelative[0]) == null)
		{
			map.put(personRelative[0], new TreeSet<String>());
		}
		map.get(personRelative[0]).add(personRelative[1]);
	}

	/**
	 * Gets an individual relative
	 * @param person - the person to check
	 * @return the relatives of that person
	 */
	public String getRelatives(String person)
	{
		return "" + map.get(person);
	}

	/**
	 * Prints out a string representation of the people and their
	 * relatives
	 */
	public String toString()
	{
		String output="";
		for(String person : map.keySet())
		{
			output += person + " is related to ";
			for(String s : map.get(person))
			{
				output+=s + ", ";
			}
			output+="\n";
			output = output.replaceAll(", $",  "");
		}
		return output;
	}
}