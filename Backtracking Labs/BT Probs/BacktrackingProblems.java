import java.util.*;
/**
* This class implements multiple backtracking problems to help improve on the topic.
* @author Rayyan Waris 
*/
public class BacktrackingProblems
{
	/**
	* Method that climbs stairs depending on number of steps taken and finds all combinations.
	* @parm steps - amount of steps to take at the start
	*/
	public static void climbStairs(int steps)
	{
		if(steps == 0)
		{
			System.out.println();
		}
		else
		{
			climbStairsHelper(steps, "", 0);
		}
	}
	/**
	* Climb stairs helper method that recursively adds each steps and make sure that the last comma is not printed.
	*@param steps - steps given
	*@param s - string to append stairs to
	*@param n - keeps track of number of stairs
	*/
	private static void climbStairsHelper(int steps, String s, int n)
	{
		if(n == steps)
		{
			System.out.println(s.substring(0, s.length()-2));
		}
		else if(n > steps)
		{
			return;
		}
		else
		{
			climbStairsHelper(steps, s + 1 + ", ", n + 1);
			climbStairsHelper(steps, s + 2 + ", ", n + 2);
		}
	}
	/**
	* Recursively gets each direction to a campsite with North and East
	* @param x - x coordinate
	* @param y - y coordinate
	*/
	public static void campsite(int x, int y)
	{
		if(x == 0 && y == 0)
		{
			System.out.println();
		}
		else
		{
			campsiteHelper(x, y, "", 0, 0);
		}
	}
        /**
	*Recursive campsite helper method that goes through each coordinate possibility while adding it to the coordinates
	* then checking if they are equal and we can stop
	*@param x x coordinate
	*@param y y coordinate
	*@param s string to append possible directions
	*@param c x val count for E
	*@paeam c1 y val count for N
	*
	*/
	private static void campsiteHelper(int x, int y, String s, int c, int c1)
	{
		//c is the x value count for "E"
		//c1 is the y value count for "N"
		//x E
		//y N
		if(x == c && y == c1)
		{
			   System.out.println(s);
		}
		else if(c > x || c1 > y)
		{
			return;
		}
		{
			campsiteHelper(x, y, s + "E ", c + 1, c1);
			campsiteHelper(x, y, s + "N ", c, c1 + 1);
			campsiteHelper(x, y, s + "NE ", c + 1, c1 + 1);
		}
	}
	/**
	* Gets the max possible combination number in a list given between all the numbers
	* that is less than the limit
	*@param nums list of numbers
	*@param limit the max sum we are allowed to reach
	*@return int the max sum
	*/
	public static int getMax(List<Integer> nums, int limit)
	{
		if(nums.size() == 0 || limit <= 0)
		{
			return 0;
		}
		else
		{
			ArrayList<Integer> numbers = new ArrayList<Integer>(nums);
			int maxArr[] = new int[nums.size()];
			//System.out.println("");
			getMaxHelper(numbers, limit, 0, maxArr);
			return maxArr[0];
		}
	}
	/**
	* Get max helper method  that recursively adds the  nums to the array list and goes through all the combinations 
	* until we are left with the max that is less thanor equal to the limit
	*@param nums the list of numbers
	*@param limit the max sum we can reach
	*@param sum the actual sum we are checking right now
	*@param maxArr the max sum
	*/
	public static void getMaxHelper(ArrayList<Integer> nums, int limit, int sum, int[] maxArr)
	{
		//System.out.println(nums);
		if(sum > maxArr[0] && sum <= limit)
		{
			maxArr[0] = sum;
		}
		if(nums.size() != 0)
		{
			int num = nums.remove(0);
			getMaxHelper(nums, limit, sum + num, maxArr);
			getMaxHelper(nums, limit, sum, maxArr);
			nums.add(num);
		}
	}
	/**
	 * Return the number of different way you can make change
	 * 
	 * @param amount - amount of money to make change for
	 * @return the number of ways we can make change for it
	 */
	public static int makeChange(int amount) 
	{
		int currIndex = 4;
		ArrayList<Integer> coins = new ArrayList<>();
		coins.add(1); coins.add(5); coins.add(10); coins.add(25); 
		return makeChangeHelper(coins, currIndex, amount);
	}
	/**
	* Make change helper method that recursively gets all the possible combinations of the coins by iterating
	* through the list and finding whether the possibility is able
	*@param coins - basic US currency coins to check combinations for
	*@param currIndex the current index of the coins in the list
	*@param currAmount - the current amount of coins we have left
	*@return the number of combinations
	*/
	public static int makeChangeHelper(ArrayList<Integer> coins, int currIndex, int currAmount)
	{
		if(currAmount == 0)
		{
			return 1;
		}
		else if(currIndex <= 0 || currAmount < 0)
		{
			return 0;
		}
		int n1 = makeChangeHelper(coins, currIndex, currAmount - coins.get(currIndex-1));
		n1 += makeChangeHelper(coins, currIndex-1, currAmount);
		return n1;
	}
	/**
	 * Return the number of different way you can make change
	 * 
	 * @param amount - amount of money to make change for
	 * @return the number of ways we can make change for it for each coin
	 */
    public static void makeChangeCoinCount(int amount) 
    {
    	int i = 0;
    	int tot = 0;
    	ArrayList<Integer> coins = new ArrayList<>();
		coins.add(1); coins.add(5); coins.add(10); coins.add(25); 
		ArrayList<Integer> c = new ArrayList<Integer>();
        makeChangeCoinCountHelper(c, coins, amount, tot, i, 0, 0, 0, 0);
    }
	/**
	* Make change helper method that recursively gets all the possible combinations of the coins by getting each amount for the coins
	* through the list and finding whether the possibility is able
	*@param coins - basic US currency coins and each possibility
	*@param tot the current total of the coins in the list
	*@param amount - the current amount of coins we have left
	*@param i iterator value
	* @param p pennies
	*@param n nickels
	*@param d dimes
	*@param q quarters
	*/
    public static void makeChangeCoinCountHelper(ArrayList<Integer> c, ArrayList<Integer> coins, int amount, int tot, int i, int p, int n, int d, int q) {
        if (tot > amount)
        {
        	return;
        }
        if (i >= coins.size()) 
        {
            if (tot == amount)
            {
            	c.add(p); c.add(n); c.add(d); c.add(q);
                System.out.println(c);
                c.clear();
            }
            return;
        }

        makeChangeCoinCountHelper(c, coins, amount, tot, i + 1, p, n, d, q);
        if(coins.get(i) == 1)
        {
        	p++;
        }
        else if(coins.get(i) == 5)
        {
        	n++;
        }
        else if(coins.get(i) == 10)
        {
        	d++;
        }
        else if(coins.get(i) == 25)
        {
        	q++;
        }
        makeChangeCoinCountHelper(c, coins, amount, tot + coins.get(i), i, p, n, d, q);
    }
        
	public static void main(String args[])
	{
		System.out.println("ClimbStairs(4): ");
		climbStairs(4);
		System.out.println();
		System.out.println("Campsite(2,1): ");
		campsite(2, 1);
		System.out.println();
		System.out.println("GetMax(Arrays.asList(30, 2, 8, 22, 6, 4, 20), 19): ");
		System.out.println(getMax(Arrays.asList(30, 2, 8, 22, 6, 4, 20), 19));
		System.out.println();
        System.out.println("MakeChange(25): ");
		System.out.println(makeChange(25));
        System.out.println("MakeChange(100): ");
		System.out.println(makeChange(100));
		System.out.println();
		System.out.println(" P N D Q ");
		System.out.println("---------");
		makeChangeCoinCount(11);
	}
}