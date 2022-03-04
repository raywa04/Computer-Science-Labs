import java.util.*;
/**
 * this lab takes in a value which acts as a range from 2-to the value 
 * and prints out only the prime numbers using a queue
 * @author Rayyan Waris 
 */
public class SieveOfEratos
{
	private Queue<Integer> primes;
	private Queue<Integer> que;
	private int num;
/**
 * 
 * @param n the ending value not included in the list of prime values
 * @return a list of prime values that end at the value n not inclusive
 */
	public Queue<Integer> primes(int n)
	{
		primes = new LinkedList<Integer>();
		que = new LinkedList<Integer>();
		num = n;
		
		if (n < 2) 
		{
			throw new IllegalArgumentException("Number too low");
		}

		for (int i = 2; i <= num; i++) 
		{

			que.offer(i);

		}

		int p = que.poll();
		primes.offer(p);
		do {

			int size = que.size();
			for (int j = 0; j < size; j++) 
			{
				int element = que.poll();
				if ((element % p) != 0) 
				{
					que.offer(element);
				}

			}

			p = que.poll();

			primes.offer(p);

		} while (p < Math.sqrt(n));

		while (que.size() != 1) 
		{

			p = que.poll();

			primes.offer(p);

		}
		return primes;

	}

}