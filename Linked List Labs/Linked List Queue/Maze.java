
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Maze
{

	public static Square[][] maze;
	private Square start;
	private Square end;
	private int row = 0;
	private int col = 0;
	private int type = 0;
	private String fileName = "";

	/*
	 * loads the maze to Square[][] maze
	 * @param String fileName 
	 * @return true if maze loads
	 * @return false if maze can't load
	 */
	public boolean loadMaze(String fileName)
	{
		try
		{
			Scanner f = new Scanner(new File(fileName));
			this.fileName = fileName; 
			row = Integer.parseInt(f.next());
			col = Integer.parseInt(f.next()); // gets row and column
			maze = new Square[row][col]; // creates array
			while (f.hasNext())
			{
				for (int i = 0; i < row; i++)
				{
					for (int j = 0; j < col; j++)
					{
						String s = f.next();
						type = Integer.parseInt(s); 
						maze[i][j] = new Square(i, j, type); // sets the square
						if (type == 2)
							start = maze[i][j]; // sets start
						if (type == 3)
							end = maze[i][j]; // sets end
					}
				}
			}

			return true;
		} catch (FileNotFoundException e)
		{
			return false;
		}

	}
	/**
	 * Gets the neighbors around the square
	 * @param sq
	 * @return the number of neighbors
	 */
	public ArrayList<Square> getNeighbors(Square sq)
	{
		ArrayList<Square> neighbors = new ArrayList<Square>();
		if (sq.getCol() - 1 >= 0)// checks left neighbors
			if (maze[sq.getRow()][sq.getCol() - 1].getType() == 0 || maze[sq.getRow()][sq.getCol() - 1].getType() == 3)// checks if it's an empty square or the end		
				neighbors.add(maze[sq.getRow()][sq.getCol() - 1]);
		if (sq.getRow() + 1 < row)// checks bottom neighbors
			if (maze[sq.getRow() + 1][sq.getCol()].getType() == 0 || maze[sq.getRow() + 1][sq.getCol()].getType() == 3)// checks if it's an empty square or the end		
				neighbors.add(maze[sq.getRow() + 1][sq.getCol()]);
		if (sq.getCol() + 1 < col)// checks right neighbors
			if (maze[sq.getRow()][sq.getCol() + 1].getType() == 0 || maze[sq.getRow()][sq.getCol() + 1].getType() == 3)// checks if it's an empty square or the end		
				neighbors.add(maze[sq.getRow()][sq.getCol() + 1]);
		if (sq != null && sq.getRow() - 1 >= 0)// checks the top neighbors
			if (maze[sq.getRow() - 1][sq.getCol()].getType() == 0 || maze[sq.getRow() - 1][sq.getCol()].getType() == 3)// checks if it's an empty square or the end																									
				neighbors.add(maze[sq.getRow() - 1][sq.getCol()]);
		
		return neighbors;

	}

	/**
	 * gets start square
	 * @return start
	 */
	public Square getStart()
	{
		return start;
	}
	/**
	 * gets exit square
	 * @return end
	 */
	public Square getExit()
	{
		return end;
	}
	/**
	 * gets number of rows in maze
	 * @return row
	 */
	public int getRow()
	{
		return row;
	}
	/**
	 * gets number of columns in maze
	 * @return col
	 */
	public int getCol()
	{
		return col;
	}
	/**
	 * gets maze
	 * @return maze
	 */
	public Square[][] getMaze()
	{
		return maze;
	}
	/**
	 * resets maze
	 */
	public void reset()
	{
		loadMaze(fileName); 
	}
	/**
	 * Displays the maze
	 * @Override
	 */
	public String toString()
	{
		String myString = "";
		for (int i = 0; i < row; i++)
		{
			for (int j = 0; j < col; j++)
			{
				myString += maze[i][j].toString() + " ";
			}
			myString += "\n"; 
		}
		return myString;
	}

}
