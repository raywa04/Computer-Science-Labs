/**
 * this program adds, removes, and finds names from the phonebook
 * @author Rayyan Waris
 *
 */
public class PhoneBook implements IMap
{
	class Entry
	{
		Person person;
		PhoneNumber pNumber;
		Entry next;
		public Entry(Person person, PhoneNumber pNumber)
		{
			this.person = person;
			this.pNumber = pNumber;
			this.next = null;
		}
		@Override
		public String toString()
		{
			return "" + person + ": " + pNumber;
		}
	}
	private Entry[] hashTable;
	public int size;
	public PhoneBook()
	{
		size = 0;
		hashTable = new Entry[12];
	}
	
	public PhoneBook(int size)
	{
		this.hashTable = new Entry[size];
		this.size= size;
	}
	
	@Override
	/**
	 * this method adds names and phone numbers
	 * @param person
	 * @param phone
	 */
	public PhoneNumber put(Person person, PhoneNumber phone)
	{
		// TODO Auto-generated method stub
		int temp = person.hashCode();
		Entry ent = new Entry(person, phone);
		Entry temp1 = hashTable[temp];
		if(temp1 != null)
		{
			while(temp1.next != null)
			{
				if(temp1.person.equals(temp1.next.person))
				{
					return temp1.pNumber;
				}
				temp1 = temp1.next;
			}
			temp1.next = ent;
		}
		else
		{
			hashTable[temp] = ent;
		}
		size++;
		return phone;
	}

	@Override
	/**
	 * this method finds names in the array
	 * @param person
	 */
	public PhoneNumber get(Person person)
	{
		// TODO Auto-generated method stub
		int temp = person.hashCode();
		Entry temp1 = hashTable[temp];
		while(temp1 != null)
		{
			if(temp1.person.equals(person))
			{
				return temp1.pNumber;
			}
			temp1 = temp1.next;
		}
		return null;
	}

	@Override
	/**
	 * gets the size of the array
	 */
	public int size()
	{
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	/**
	 * this method removes a person from the array
	 * @param person
	 */
	public PhoneNumber remove(Person person)
	{
		// TODO Auto-generated method stub
		int temp = person.hashCode();
		Entry temp1 = hashTable[temp];
		if(temp1.equals(person))
		{
			PhoneNumber back = temp1.pNumber;
			hashTable[temp] = temp1.next;
			size--;
			return back;
		}

		else
		{
			if(temp1.next.equals(person))
			{
				PhoneNumber back = temp1.pNumber;
				hashTable[temp] = temp1.next;
				size--;
				return back;
			}
		}
		return remove(person);
	}
	@Override 
	public String toString()
	{
		String s = "";
		for(int i = 0;i< hashTable.length; i++)
		{
			s+= "Bucket "+ i + ": ";
			while(hashTable[i]!=null)
			{
				s+= hashTable[i] + ", ";
				hashTable[i] = hashTable[i].next;
			}
			s = s.substring(0,s.length()-2);
			s+="\n";
		}
		return s;
	}
	
	

}