import java.util.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
public class LinearTester
{
	private static final double FACTOR = .99;
	public static void main(String args[]) throws IOException
	{
		int recordsAdded = 50000;
		int size = (int) (50000 / FACTOR);
		EmployeeDatabaseLinear data = new EmployeeDatabaseLinear(size);
		Scanner scan = new Scanner(new File("Large Data Set.txt"));
		
		long buildTableTimer = System.currentTimeMillis();
		while(scan.hasNext()) 
		{
			int id = scan.nextInt();
			Employee employee = new Employee(scan.nextLine());
			data.put(id, employee);
		}
		long buildTableTimerFin = System.currentTimeMillis();
		
		Scanner scan1 = new Scanner(new File("Successful Search Records.txt"));
		long buildTableTimer1 = System.currentTimeMillis();
		while(scan1.hasNext()) 
		{
			int id = scan1.nextInt();
            scan1.nextLine();
			data.get(id);
		}
		int numProbe = data.getCollide;
		data.res();
		long buildTableTimerFin1 = System.currentTimeMillis();
		Scanner scan2 = new Scanner(new File("Successful Search Records.txt"));
		long buildTableTimer2 = System.currentTimeMillis();
		while(scan2.hasNext()) 
		{
			int id = scan2.nextInt();
			scan2.nextLine();
			data.get(id);
		}
		int numProbe1 = data.getCollide;
		data.res();
		long buildTableTimerFin2 = System.currentTimeMillis();
		PrintWriter output = new PrintWriter(new FileOutputStream("Report.txt"));
		output.println("Type of hashing used: LINEAR PROBING");
		output.println("Hash function used: Multiply the keys together add the key, modulus divide that by the size of the hashMap");
		output.println("Number of records added: 50,000");
		output.println("Table Size: " + size);
		output.println("Load Factor: " + FACTOR);
		output.println("Number of Table Insertion Collisons: " + data.numCollide);
		output.println("Number of collisions vs. number of insertions (expressed as %): " + (((double) data.numCollide / 50000) * 100) + "%");
		output.println("Successful Search Records");
		output.println("Average Search Time: " + ((double) (buildTableTimerFin1 - buildTableTimer1) / 1000) + "ms");
		output.println("Number Of Probes To Find: " + numProbe);
		output.println("Unsuccessful Search Records");
		output.println("Average Search Time: " + ((double) (buildTableTimerFin2 - buildTableTimer2) / 1000) + "ms");
		output.println("Number Of Probes To Find: " + numProbe1);
		output.close();
		
		//TESTING OUTPUT TO CONSOLE
		System.out.println("Type of hashing used: LINEAR PROBING");
		System.out.println("Hash function used: Multiply the keys together add the key, modulus divide that by the size of the hashMap");
		System.out.println("Number of records added: " + recordsAdded);
		System.out.println("Table Size: " + size);
		System.out.println("Load Factor: " + FACTOR);
		System.out.println("Average Insertion Time: " + ((double) (buildTableTimerFin - buildTableTimer) / recordsAdded) + "ms");
		System.out.println("Number of Table Insertion Collisons: " + data.numCollide);
		System.out.println("Number of collisions vs. number of insertions (expressed as %): " + (((double) data.numCollide / 50000) * 100) + "%");
		System.out.println("Successful Search Records");
		System.out.println("Average Search Time: " + ((double) (buildTableTimerFin1 - buildTableTimer1) / 1000) + "ms");
		System.out.println("Number Of Probes To Find: " + numProbe);
		System.out.println("Unsuccessful Search Records");
		System.out.println("Average Search Time: " + ((double) (buildTableTimerFin2 - buildTableTimer2) / 1000) + "ms");
		System.out.println("Number Of Probes To Find: " + numProbe1);
		
		
		
		EmployeeDatabaseLinear test = new EmployeeDatabaseLinear();
		test.put(1234, new Employee("BOB"));
		test.put(1, new Employee("JEFF"));
		test.put(1455, new Employee("GREG"));
		test.put(1766, new Employee("FISCHER"));	
		System.out.println(test.hashCode(1));
		System.out.println(test.hashCode(1756));
		System.out.println(test.hashCode(176));
		System.out.println(test.get(1234));
		System.out.println(test.get(1455));
		System.out.println(test.get(1));
	}
}