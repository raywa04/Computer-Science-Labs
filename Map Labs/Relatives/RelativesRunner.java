import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class RelativesRunner
{
	public static void main( String args[] ) throws IOException
	{
		Scanner file = new Scanner(new File("relatives.dat"));
		Relatives rel = new Relatives();
		int num = file.nextInt();
		file.nextLine();
		for(int i = 0; i < num; i++)
		{
			rel.setPersonRelative(file.nextLine());
		}
		System.out.println(rel);
		String person = file.next();
	}
}