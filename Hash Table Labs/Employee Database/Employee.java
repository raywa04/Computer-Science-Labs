/**
 * Basic class that constructs an Employee obj
 * @author Rayyan Waris 
 *
 */
public class Employee
{
	String name;
	/**
	 * Basic constructor that initalizes the employee with a name
	 * @param name
	 */
	public Employee(String name)
	{
		this.name = name;
	}
	@Override
	/**
	 * Returns name of employee
	 */
	public String toString()
	{
		return name;
	}
}