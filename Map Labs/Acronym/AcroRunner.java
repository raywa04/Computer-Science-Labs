import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class AcroRunner
{
	public static void main( String args[] ) throws IOException
	{
		Scanner file = new Scanner(new File("acro.dat"));

		Acronyms acro = new Acronyms();

		int num = file.nextInt();
		file.nextLine();
		for(int i = 0; i < num; i++)
		{
			acro.putEntry(file.nextLine());
		}

		System.out.println("\n====    MAP CONTENTS    ====\n\n");
		System.out.println(acro);
		System.out.println();
		System.out.println();

		System.out.println("\n====    READ LINES    ====\n\n");
		while(file.hasNext())
		{
			String sent = file.nextLine();
			System.out.println(acro.convert(sent));
		}
	}
}