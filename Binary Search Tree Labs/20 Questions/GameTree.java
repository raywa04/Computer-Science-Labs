/**
 * this program makes up all of the logic of the 20Questions lab. It controls adding questions, answers, saving etc., and also creates 
 * the tree like structure when ran.
 * @author Rayyan Waris 
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;
import java.io.PrintWriter;

public class GameTree
{
	/**
	 * Will you need to create an inner class?
	 */
		//TODO?
	private class TreeNode
	{
		String data;
		TreeNode left;
		TreeNode right;
		public TreeNode(String data)
		{
			this(data,null,null);
		}
		public TreeNode(String data, TreeNode left, TreeNode right)
		{
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
	/**
	 * instance variables.
	 */
	private TreeNode tempRoot;
	private TreeNode root;
	private Scanner scan;
	private String treeFile;


	/**
	 * Constructor needed to create the game.
	 *
	 * @param fileName this is the name of the file we need to import the game
	 *                 questions and answers from.
	 */
	public GameTree(String fileName) 
	{
		treeFile = fileName;
		try 
		{
			scan = new Scanner(new File(treeFile));
		} catch (FileNotFoundException e) 
		{
			System.out.println("File does Not Exist Please Try Again: ");
		}
		tempRoot = createTree();
		root = tempRoot;
		scan.close();
	}
	
	/**
	 * creates the tree
	 * @return the tree
	 */
	private TreeNode createTree()
	{
		// There must be at least one more token in the scanner
		String word = scan.nextLine();
		word.trim();
		if (!isQuestion(word))
		{
			return new TreeNode(word);
		}
		else 
		{
			TreeNode left = createTree();
			TreeNode right = createTree();
			return new TreeNode(word, left, right);
		}
	}
	/**
	 * checks if a certain string is a question
	 * @param test
	 * @return true or false depending if the sentence ends with a '?'
	 */
	private boolean isQuestion(String test) 
	{
		if (test.charAt(test.length() - 1) == '?')
		{
			return true;
		}
		return false;
	}

	/*
	 * Add a new question and answer to the currentNode. If the current node has the
	 * answer chicken, theGame.add("Does it swim?", "goose"); should change that
	 * node like this:
	 */
	// -----------Feathers?-----------------Feathers?------
	// -------------/----\------------------/-------\------
	// ------- chicken horse-----Does it swim?-----horse--
	// -----------------------------/------\---------------
	// --------------------------goose--chicken-----------
	/**
	 * @param newQ The question to add where the old answer was.
	 * @param newA The new Yes answer for the new question.
	 */
	public void add(String newQuestion, String newAnswer) 
	{
		String temp = root.data;
		root.data = newQuestion;
		root.left = new TreeNode(newAnswer);
		root.right = new TreeNode(temp);
	}

	/**
	 * True if getCurrent() returns an answer rather than a question.
	 *
	 * @return False if the current node is an internal node rather than an answer
	 *         at a leaf.
	 */
	public boolean foundAnswer() 
	{
		if (isQuestion(getCurrent()))
		{
			return false;
		}
		return true;
	}

	/**
	 * Return the data for the current node, which could be a question or an answer.
	 * Current will change based on the users progress through the game.
	 *
	 * @return The current question or answer.
	 */
	public String getCurrent() 
	{
		return root.data;
	}

	/**
	 * Ask the game to update the current node by going left for Choice.yes or right
	 * for Choice.no Example code: theGame.playerSelected(Choice.Yes);
	 *
	 * @param yesOrNo
	 */
	public void playerSelected(Choice answer) 
	{
		if (answer == Choice.Yes)
		{
			root = root.left;
		}
		else
		{
			root = root.right;
		}
	}

	/**
	 * Begin a game at the root of the tree. getCurrent should return the question
	 * at the root of this GameTree.
	 */
	public void reStart() 
	{
		root = tempRoot;
	}

	/**
	 * Overwrite the old file for this gameTree with the current state that may have
	 * new questions added since the game started.
	 *
	 */
	public void saveGame()
	{
		PrintWriter file = null;
		try 
		{
			file = new PrintWriter(treeFile);
		} catch (IOException io) 
		{
			System.out.println("Could not create file: " + treeFile);
		}
		file.println(printOrder());
		file.close();
	}
	private String printOrder() 
	{
		return printOrder(tempRoot);
	}

	private String printOrder(TreeNode root) 
	{
		if (!isQuestion(root.data))
		{
			return root.data;
		}
		else
		{
			return root.data + '\n' + printOrder(root.left) + '\n' + printOrder(root.right);
		}
	}
	@Override
	public String toString() 
	{
		return toString(tempRoot);
	}

	private String toString(TreeNode root)
	{

		if (!isQuestion(root.data))
		{
			return "- " + root.data;
		}
		else if (root == tempRoot) 
		{
			return "- " + toString(root.right) + '\n' + root.data + '\n' + "- " + toString(root.left);
		} else
		{
			return toString(root.right) + '\n' + "- " + root.data + '\n' + "- " + toString(root.left);
		}

	}
}