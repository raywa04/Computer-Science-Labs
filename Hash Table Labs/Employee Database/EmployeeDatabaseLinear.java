/**
 * Class that implements a closed hash of linear probing
 * @author Rayyan Waris
 *
 */
public class EmployeeDatabaseLinear
{	
	/**
	 * Entry class that initalizes the employee and their ID
	 *
	 */
	class Entry
	{
		private int ID;
		private Employee employee;
		public Entry(int ID, Employee employee)
		{
			this.ID = ID;
			this.employee = employee;
		}
		@Override
		public String toString()
		{
			return "" + ID + "-" + employee.toString();
		}
	}

	private Entry[] hashTable;
	public int getCollide;
	private int size;
	public int numCollide;
	/**
	 * Basic constructor that initalizes hashTable with prime number 13 to avoid problems
	 * and initalizes the other vars
	 */
	public EmployeeDatabaseLinear()
	{
		hashTable = new Entry[13];
		getCollide = 0;
		size = 0;
		numCollide = 0;
	}
	/**
	 * Secondary constructor that sets the hashtable size and initalizes other values
	 * @param size
	 */
	public EmployeeDatabaseLinear(int size)
	{
		hashTable = new Entry[size];
		getCollide = 0;
		this.size = size;
		numCollide = 0;
	}
	/**
	 * Hashcode that I just did randomly 
	 * @param key - the key given to get hashCode
	 * @return the hashcode
	 */
	public int hashCode(int key)
	{
		return  (key * key + key) % hashTable.length;
	}
	/**
	 * puts the actual employee into the linear probing hashtable
	 * @param key - the key
	 * @param value - the val
	 * @return the employee
	 */
	public void put(int key, Employee value)
	{
		int temp = hashCode(key);
		try
		{
		 while (hashTable[temp] != null) 
		 {
	            temp++;
	            numCollide++;
	        }
	        hashTable[temp] = new Entry(key, value);
		}
		catch(Exception e)
		{
			
		}
	}
	/**
	 * gets the actual employee when given the key by checking its hashcode
	 * and trying to retrieve the employee name through its ID
	 * @param key
	 * @return
	 */
	public Employee get(int key)
	{
		int temp = hashCode(key);
		try
		{
		 while (hashTable[temp] == null || hashTable[temp].ID != key)
		 {
			 getCollide++;
			 temp++;
	            if (temp == hashTable.length) 
	            {
	            	return null;
	            }
	        }
	        return hashTable[temp].employee;
		}
		catch(Exception e)
		{
			
		}
		return null;
	}
	/**
	 * Reset num probs collided
	 */
	public void res() 
	{
		getCollide = 0;
	}
	/**
	 * Basic toString that prints out the hashTable
	 */
	@Override 
	public String toString()
	{
		String output = "";
		for(Entry ent: hashTable)
		{
			output += ent + "\n";
		}
		return output;
	}
}