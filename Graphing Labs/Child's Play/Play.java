import java.util.*;
import java.io.*;
/**
 * This class implements a depth search algo to find the number
 * of dominoes that fall over
 * @author Rayyan Waris
 *
 */
public class Play
{
	private static int v; //vertices
	private static ArrayList<Integer> arr[]; //adjacency matrix
	
	public static void main(String args[]) throws IOException
	{
		Scanner scan = new Scanner(new File("play.dat"));
		int num = scan.nextInt();
		while(num-- != 0)
		{
			v = scan.nextInt();
			int e = scan.nextInt();
			arr = new ArrayList[v]; 
			for(int i = 0; i < v; i++)
			{
				arr[i] = new ArrayList<>();
			}
			for(int i = 0; i < e; i++)
			{
				int u = scan.nextInt();
				int v = scan.nextInt();
				arr[u].add(v);
			}
			Stack<Integer> s = new Stack<>();
		    boolean[] visited = new boolean[v];
			System.out.println(search(v, visited, s));
		}
	}
	/**
	 * Search that goes through each domino and checks if they
	 * are fallen when visited while using dfs search to push them
	 * onto the stack
	 * @param v - the domino tiles
	 * @param visited - each visited portion of each domino
	 * @param s - the stack
	 * @return
	 */
	public static int search(int v, boolean[] visited, Stack<Integer> s)
	{
		for(int i = 0; i < v; i++)
		{
			if(!visited[i])
			{
				visited[i] = true;
				dfs(i, visited, s);
			}
		}
		Arrays.fill(visited, false);
		int ans = 0;
		while(!s.isEmpty())
		{
			int u = s.pop();
			if(!visited[u])
			{
				ans++;
				visited[u] = true;
				dfs(u, visited, s);
			}
		}
		return ans-1;
	}
	/**
	 * DFS search that iteravely goes through the dominoes and checks if they are not
	 * visited whilst setting the value to true and pushing them onto the stack.
	 * @param i - the amount
	 * @param visited - dominoes visited val
	 * @param s - the stack
	 */
	public static void dfs(int i, boolean[] visited, Stack<Integer> s)
	{
			for(Integer v: arr[i])
			{
				if(!visited[v])
				{
					visited[v] = true;
					dfs(v, visited, s);
				}
			}
			s.push(i);
	}
}