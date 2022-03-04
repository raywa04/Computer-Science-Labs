import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
/**
 * Scooby class that implements all paths in a certain secret passage
 * @author Rayyan Waris 
 *
 */
public class Scooby
{
	static int len;
    static String res = "no";
    static int check;
	static Set<Character> t = new TreeSet<Character>();
    static ArrayList<String> list = new ArrayList<String>();
   
	public static void main(String args[]) throws FileNotFoundException
    {
		Scanner scan = new Scanner(new File("scooby.dat"));
        int num = scan.nextInt();
        scan.nextLine();
        LinkedList<String> paths[];
    	for (int i = 0; i < num; i++)
        {

            String word = scan.nextLine();
            String[] array = word.split(" ");
            String finalDest = scan.nextLine();
            
            paths = new LinkedList[array.length];
            addEdge(array, paths);
            check = 0;
            DFS(paths, finalDest.substring(0, 1), finalDest.substring(1), 0);
            if(check == 0)
            {
                System.out.println(res);
            }
        }
    }
    /**
     * Depth first search method that iteravely goes through each path
     * and checks whether there is a valid edge for the fianl
     * destination
     * @param tPaths - the paths of the secret passage
     * @param r - the room
     * @param f - the destination to look for
     * @param i - the iterator
     */
    public static void DFS(LinkedList<String> tPaths[], String r, String f, int i)
    {
        if (i >= tPaths.length)
        {
            res = "no";
            System.out.println(res);
            check = 1;
            return;
        }
        if (tPaths[i].toString().substring(2, 3).equals(f)||tPaths[i].toString().substring(1, 2).equals(f))
        {
            res = "yes";

            return;
        } else
        {
            for (int k = 0; k < tPaths.length; k++)
            {
                if (tPaths[k].toString().contains(r))
                {
                    DFS(tPaths, tPaths[k].toString().substring(2, 3), f, i+=1);
                }
            }

        }
        return;
    }
    /**
     * Adds each edge to the linked list
     * @param array - the array
     * @param paths - the secret passages
     */
    
	public static void addEdge(String[] array, LinkedList[] paths)
    {
        for (int j = 0; j < array.length; j++)
        {
        	paths[j] = new LinkedList();
        	paths[j].add(array[j]);

        }
    }
}