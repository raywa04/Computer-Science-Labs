import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class HistogramRunner
{
	public static void main( String args[] ) throws IOException
	{
		Scanner file = new Scanner(new File("histogram.dat"));
		Histogram hist = new Histogram();
		while(file.hasNext())
		{
			
			hist = new Histogram(file.nextLine());
			hist.setSentence();
			System.out.print("char");
			System.out.println("\t1---5----10");
			System.out.println(hist);
		}
	}
}