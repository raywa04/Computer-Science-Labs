import java.util.*;

public class IntegerCalculator {
	private int operand1;
	private int operand2;
	private int result;
	private int select;

	public IntegerCalculator() {
		mainMenu();
	}

	public void mainMenu() {
		int ans = 0;

		do {
			ans = getInfo();

			if (ans == 1)
				add();
			if (ans == 2)
				subtract();
			if (ans == 3)
				multiply();
			if (ans == 4)
				divide();

			System.out.println();
		} while (ans != 5);
	}

	// Postcondition:Retrieves calculator input from the user.
	// Asks the user to select from a menu which operation they wish
	// to perform 1) add 2) subtract 3) multiply 4) divide.
	// It then asks the user to enter in two operands. If either of
	// the two operands are not valid integers it displays an error
	// message and asks the user for the information again.
	// The method returns an integer representing operation selected
	// by the user
	public int getInfo() 
	{
		Scanner key = new Scanner(System.in);

		System.out.print("1)Add 2)Subtract 3)Multiply 4)Divide 5)Quit -->");
		try //will run normally if the value of select is between 1 and 5, and will be passed into mainMenu
		{
			select = key.nextInt();
			if (select == 5) //if selection equals 5 then ends program
				return select;
			if (select < 0 || select > 5) 
			{
				System.out.println("Not a valid number, try again.");
				return select;
			}
			System.out.print("\nOperator 1 -->");
			operand1 = key.nextInt(); //takes in first value 
			System.out.print("Operator 2 -->");
			operand2 = key.nextInt(); //takes in second value 
			
		} 
		catch (Exception e) //if any problem does occur, it will be caught and the code below will run
		{
			System.out.println("\nNot a valid number, try again.\n");
			getInfo();
			return select;
		}

		return select;
	}

	public void add() {
		result = operand1 + operand2;
		System.out.println(operand1 + " + " + operand2 + " = " + result);
	}

	public void subtract() {
		result = operand1 - operand2;
		System.out.println(operand1 + " - " + operand2 + " = " + result);
	}

	public void multiply() {
		result = operand1 * operand2;
		System.out.println(operand1 + " * " + operand2 + " = " + result);

	}

	// Precondition: two valid operands
	// Postcondition: performs the division operation on the two
	// operands and displays the results. If a division by zero
	// error occurs it displays an error message and does not
	// display any results.
	public void divide() 
	{
		try 
		{
			result = operand1 / operand2;
			if (operand2 != 0)//makes sure that the println below runs when value isn't divided by 0
				System.out.println(operand1 + " / " + operand2 + " = " + result);
		} 
		catch (ArithmeticException e) //if divided by zero, the code below runs 
		{
			System.out.println("You cannot divide by zero!");
		}

	}

	public static void main(String[] args) 
	{
		IntegerCalculator app = new IntegerCalculator();
	}
}