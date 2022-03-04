/**
 * Class that defines the Word object to store into a hashtable
 * @author Rayyan Waris 
 *
 */
public class Word
{
	private String theValue;
	
	//write a constructor
	/**
	 * Constructor that initalizes the word and its value
	 * @param val - string
	 */
	public Word(String val)
	{
		theValue = val;
	}
	
	
	//write the getValue method
	/**
	 * Returns the value of the Word
	 * @return the string
	 */
	public String getValue()
	{
		return theValue;
	}
	
	
	//write the equals method
	/**
	 * Compares the word to the object given
	 * @return true or false
	 */
	public boolean equals(Object obj)
	{
		return theValue.equals(((Word) obj).getValue());
	}
	
	
	//write the hashCode method
	/**
	 * Hashcode method that is defined by checking all the vowels
	 * and multyplying that by the length and modulus that toal
	 * by 10
	 * @return the hashcode of the word
	 */
	public int hashCode()
	{
		int count = 0;
		for(int i = 0; i < theValue.length(); i++)
		{
			if(theValue.toLowerCase().charAt(i) == 'a' || theValue.toLowerCase().charAt(i) == 'e' || theValue.toLowerCase().charAt(i) == 'i' || theValue.toLowerCase().charAt(i) == 'o' || theValue.toLowerCase().charAt(i) == 'u')
			{
				count++;
			}
		}
		return (count * theValue.length()) % 10;
	}
	
	
	//write the toString method
	/**
	 * Returns a string representation of the word
	 * @return string
	 */
	@Override
	public String toString()
	{
		return "" + theValue;
	}
	
}