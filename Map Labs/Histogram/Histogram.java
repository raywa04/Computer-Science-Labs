import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;
import static java.lang.System.*;
/**
 * This class implements multiple methods to be able to create 
 * a statistical representation of histogram with a given set of data
 * @author Rayyan Waris
 *
 */
public class Histogram
{
	private Map<String,Integer> histogram;
	private String sent = "";
	/**
	 * Basic constructor that initalizes the sent data
	 */
	public Histogram()
	{
		//call setSentence
		setSentence();
		sent = "";
	}
	/**
	 * SEcondary constructor that sets the sent data to the sentSentence
	 * @param sent - the data
	 */
	public Histogram(String sent)
	{
		//call setSentence
		setSentence();
		this.sent = sent;
	}
	/**
	 * Stores the actual data into a tree map to aid
	 * in visually showing it with *s
	 */
	public void setSentence()
	{
		histogram = new TreeMap<String,Integer>();
		String[] data = sent.split(" ");
		for(int i = 0; i < data.length; i++)
		{
			if(histogram.get(data[i]) == null)
			{
				histogram.put(data[i], 0);
			}
			histogram.put(data[i],histogram.get(data[i]) + 1);
		}
	}
	/**
	 * Returns a string representation of the histogram using
	 * the *s to represent the data
	 * @return a string representation of the histogram
	 */
	public String toString()
	{
		String output="";
		for(String s : histogram.keySet())
		{
			output += s + "    ";
			output += "\t";
			String getStr = "";
			for(int i = 0; i < histogram.get(s); i++)
			{
				getStr = getStr + "*";
			}
			output += getStr + "\n";
		}
		return output+"\n\n";
	}
}