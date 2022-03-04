/**
 * This class implements multiple methods in order to simulate a Binary Search Tree (BST)
 * data structure.
 * @author Rayyan Waris
 *
 */
import java.util.*;
public class MyBST
{
	/**
	 * Basic BSTNode class that initializes the node for the BST.
	 */
	private class BSTNode
	{
	    Integer val;
	    BSTNode left, right;
	    
		public BSTNode(Integer val) 
		{
			this.val = val;
			left = right = null; //initializing left and right sides
		}
		@Override
		public String toString() 
		{ 
			return "" + this.val; 
		}
	}
	 BSTNode root;
	/**
	 * Return the number of elements in the tree
	 * @return # of elements in tree
	 */
	public int size()
	{
           return size(root);
	}
	private int size(BSTNode root)
	{
		if(root == null)
		{
			return 0;
		}
		return 1 + size(root.right) + size(root.left);
	}
	
	/**
	 * Add a node to the the tree with the value n
	 * @param n - the value that is getting added to the tree
	 */
	public void insert(Integer n)
	{
	    if(contains(n)) //if it exists we don't add
	    {
	      return;
	    }
	    else
	    {
	    	if(root == null)
		    {
	            root = new BSTNode(n); //makes a new one of the tree doesn't exist
			    return;
		    }
			insert(n, root);
	    }
       
	}
	private void insert(Integer n, BSTNode root)
	{
		if(n < root.val) // if root is less then the val add to left side
		{
	        if (root.left == null)
		    {
               root.left = new BSTNode(n);
               return;
            }
            	insert(n, root.left);
			}
			else //else add to right side
			{
				if (root.right == null)
				{
                   root.right = new BSTNode(n);
                   return;
                 }
                 insert(n, root.right);
			}
	}
	/**
	 * Find a node with the same value given in the tree
	 * @param n - the value to check for
	 * @return - true or false depending on whether or not it is found
	 */
	public boolean contains(Integer n) 
	{
        return contains(root, n);
    }
    private boolean contains(BSTNode root, Integer n) 
	{
        if (root == null) //if it doesn't exist false
        {
        	return false;
        }
        if (root.val.equals(n)) //if exists true
        {
        	return true;
        }
       	return contains(root.left, n) || contains(root.right, n); //loop through until we find it
    }
	/**
	 * Returns the largest value in the tree,
	 * or null if the tree is empty
	 * @return max
	 */
	public Integer getMax()
	{
		if(root == null)
		{
			return null;
		}
		return getMax(root);
	}
	private Integer getMax(BSTNode root)
	{
		if(root.right == null) //loops right until we stop for the max
		{
			return root.val;
		}
		return getMax(root.right);
	}
	/**
	 * Returns the smallest value in the tree,
	 * or null if the tree is empty
	 * @return min
	 */
	public Integer getMin()
	{
		if(root == null)
		{
			return null;
		}
		return getMin(root);
	}
	public Integer getMin(BSTNode root)
	{
		if(root.left == null) //loops left till we find the min
		{
			return root.val;
		}
		return getMin(root.left);
	}
	/**
	 * Delete a node in the tree with value n. Does nothing if n
	 * doesn't exist in the tree itself.
	 * @param n
	 */
	public void delete(Integer n) 
	{
		this.root = this.delete(this.root, n);
	}
	
	private BSTNode delete(BSTNode root, Integer n) 
	{
		if(root == null) //if root doesnt exist we good
		{
			return root;
		}
		else if(n < root.val) //if root is less than the root val move left
		{
			root.left = delete(root.left, n);
		}
		else if(n > root.val) //else move right
		{
			root.right = delete(root.right, n);
		}
		else //check if the root has child nodes
		{
			if(root.left == null) 
			{
				return root.right;
			}
			else if(root.right == null)
			{
				return root.left;
			}
			else 
			{
				root.val = getNext(root.right); //get successor node to change to
				root.right = delete(root.right, root.val); //delete the right largest value
			} 
		}
		return root;
	}
	/**
	 * Gets the successor root to put in place to shift over
	 * the elements
	 * @param root
	 * @return
	 */
	public Integer getNext(BSTNode root)
	{
		if(root.left == null)
		{
			Integer min = root.val;
			delete(root.val); 
			
			return min; //returns successor node
		}
		return getNext(root.left);
	}
	/**
	 * Prints out the tree in a in a specific format 
	 */
	public void inOrder()
	{
		System.out.print("[");
		inOrder(root);
		System.out.print("]");
	}
	private void inOrder(BSTNode root)
	{
		if(root == null)
		{
			return;
		}
		inOrder(root.left);
		if(root.val < (getMax()))
		{
			System.out.print(root.val + ", ");
		}
		else
		{
			System.out.print(root.val);
		}
		inOrder(root.right);
	}
	/**
	 * Prints out the tree in a tree like way
	 */
	public void print()
	{
		print(root, 0);
	}
	private void print(BSTNode root, int level)
	{
		
		if(root == null)
		{
			return;
		}
		print(root.right, level +1);
		System.out.println(helpIndent(level) + root.val);
		print(root.left, level +1);
	}
	/**
	 * Indents the numbers to create the "tree look"
	 * @param level - the level of the tree
	 * @return the indented spaces
	 */
	public String helpIndent(int level)
	{
		int tab = 4;
		String space = "";
		for(int i = 0; i < level * tab; i++)
		{
			space += " ";
		}
		return space;
	}
}