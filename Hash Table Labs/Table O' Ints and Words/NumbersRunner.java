import java.util.LinkedList;
import java.util.Scanner;
import java.io.File;

public class NumbersRunner
{
  public static void main ( String[] args )
  {
		try{
			//make a new table			
			HashTable tab = new HashTable();
			//read from the file	
			String word = "numbers.dat"; //EDIT HERE FOR NUM OR WORD
			Scanner file = new Scanner(new File(word));
			if(word.equals("numbers.dat"))
			{
				//load stuff into the table	
				int num = file.nextInt();
				file.nextLine();
				while(file.hasNext())
				{
					tab.add(new Number(file.nextInt()));
				}
				//print out the table
				System.out.println(tab);
				file.close();
			}
		}
		catch(Exception e)
		{
			System.out.println("Houston, we have a problem!");
		}
  }
}