import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class SpanRunner
{
	public static void main( String args[] ) throws IOException
	{
		Scanner file = new Scanner(new File("spantoeng.dat"));
		SpanishToEnglish span = new SpanishToEnglish();
		int num = file.nextInt();
		file.nextLine();
		for(int i = 0; i < num; i++)
		{
			span.putEntry(file.nextLine());
		}
		System.out.println("\n====    MAP CONTENTS    ====\n");
		System.out.println(span + "\n\n");


		while(file.hasNext())
		{
			String sent = file.nextLine();
			System.out.println(span.translate(sent));
		}
	}
}