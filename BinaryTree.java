package project3;

import java.util.Scanner;

public class BinaryTree
{
	static Node root;
	static boolean exit=false;
	static boolean keyPresent=false;
	
	class Node
	{
	    int value;
	    Node left;
	    Node right;

	    Node(int value)
	    {
	        this.value = value;
	        right = null;
	        left = null;
	    }
	}
	
	public static void createBT(BinaryTree bt, int[] data)
	{	
		for(int i=0;i<data.length;i++)
		{
			bt.insert(data[i]);
		}

	    System.out.print("Binary Tree after creation");
	    display(root);
	}
	
	public static void createBT2(BinaryTree bt, int[] data)
	{	
		for(int i=0;i<data.length;i++)
		{
			bt.insert(data[i]);
		}
	}
	
	static int findHeight(Node current)
	{
		if(current == null)
		{
			return 0;
		} else {
			int left = findHeight(current.left);
			int right = findHeight(current.right);
			if(left > right)
			{
				return 1 + left;
			} else {
				return 1 + right;
			}
		} 
	}
	
	static void height(Node current)
	{
		if(root == null)
		{
			System.out.println("No Binary Tree exists");
		} else {
			int height = findHeight(current)-1;
			System.out.println("Height of Binary Tree: " + height);
		}
	}
	
	static int treeheight(Node current)
	{
		
		return findHeight(current)-1;
	}
	
	private Node insertRecursive(Node current, int key)
	{
	    if (current == null)
	    {
	        return new Node(key);
	    }
	    if (key < current.value)
	    {
	        current.left = insertRecursive(current.left, key);
	    } else if (key > current.value) {
	        current.right = insertRecursive(current.right, key);
	    } else {
	        return current;
	    }
	    return current;
	}
	
	public void insert(int key)
	{
	    root = insertRecursive(root, key);
	}
	
	private static boolean containsNodeRecursive(Node current, int key)
	{
	    if (current == null)
	    {
	        return false;
	    } 
	    if (key == current.value)
	    {
	        return true;
	    }
	    if (key < current.value)
	    {
	        return containsNodeRecursive(current.left, key);
	    } else {
	    	return containsNodeRecursive(current.right, key);
	    }
	}
	    
	private static boolean searchRecursive(Node node, int key)
	{
		if (node == null)
		{
			return false;
		} 
		if (key == node.value)
		{
			return true;
		}
		if (key < node.value)
		{
			if(node.left != null)
			{
				System.out.println("Searching for " + key + "(key) in " + node.left.value + "(left)");
			} else {
				System.out.println("Searching for " + key + "(key) in null(left)");
			}
			return searchRecursive(node.left, key);
		} else {
			if(node.right != null)
			{
				System.out.println("Searching for " + key + "(key) in " + node.right.value + "(right)");
			} else {
				System.out.println("Searching for " + key + "(key) in null(right)");
			}
			return searchRecursive(node.right, key);
		}
	}
	
	public boolean search(int key)
	{
		System.out.println("Searching for " + key + "(key) in " + root.value + "(root)");
		keyPresent=searchRecursive(root, key);
		if(keyPresent)
		{
			System.out.println(key + " is present");
		}else {
			System.out.println(key + " is not present");
		}
	    return keyPresent;
	}
	
	private int findMinimum(Node root)
	{
	    return root.left == null ? root.value : findMinimum(root.left);
	}
	
	
	private Node deleteRecursive(Node current, int key)
	{
	    if (current == null)
	    {
	        return null;
	    }
	    if (key == current.value)
	    {
	    	if (current.left == null && current.right == null)
	    	{
	    	    return null;
	    	}
	    	if (current.right == null)
	    	{
	    	    return current.left;
	    	}
	    	if (current.left == null)
	    	{
	    	    return current.right;
	    	}
	    	int minimum = findMinimum(current.right);
            current.value = minimum;
            current.right = deleteRecursive(current.right, minimum);
            return current;
	    } 
	    if (key < current.value)
	    {
	        current.left = deleteRecursive(current.left, key);
	        return current;
	    }
	    current.right = deleteRecursive(current.right, key);
	    return current;
	}
	
	public void delete(int value)
	{
	    root = deleteRecursive(root, value);
	}
	
	public void deltree(int treenodes)
	{
		for (int i = 0; i < treenodes; i++)
	    {
			delete(root.value);
	    }
	}
	
	public static void traverseInOrder(Node node)
	{
	    if (node != null)
	    {
	        traverseInOrder(node.left);
	        System.out.printf("%2d ", node.value);
	        traverseInOrder(node.right);
	    }
	}
	
	public static void traversePreOrder(Node node)
	{
	    if (node != null)
	    {
	        System.out.printf("%2d ", node.value);
	        traversePreOrder(node.left);
	        traversePreOrder(node.right);
	    }
	}
	
	public static void traversePostOrder(Node node)
	{
	    if (node != null)
	    {
	        traversePostOrder(node.left);
	        traversePostOrder(node.right);
	        System.out.printf("%2d ", node.value);
	    }
	}
	
	public static void display(Node node)
	{
		System.out.printf("%-12s", "\nInOrder: ");
		traverseInOrder(root);
		System.out.printf("%-12s", "\nPreOrder: ");
	    traversePreOrder(root);
	    System.out.printf("%-12s", "\nPostOrder: ");
	    traversePostOrder(root);
	    System.out.println("\n");
	}
	
	public static boolean menu(BinaryTree bt, Scanner reader)
	{  
		int n = 0;
		
		while (!(n >= 1 && n <= 5))
		{
			System.out.println("***Binary Tree Menu***");
			System.out.println("1. Insert node");
			System.out.println("2. Delete node");
			System.out.println("3. Search for node");
			System.out.println("4. Height of tree");
			System.out.println("5. Exit");
			System.out.println("\n Please make a selection(1-5)");
			n = reader.nextInt();
		}
		
		switch (n)
		{
			case 1: 
				n=0;
		    	while(!(n >= 1))
				{
					System.out.println("***Binary Tree Menu***");
					System.out.print("\n***Insert***");
					System.out.println("\n Please enter a positive integer to insert into Binary Tree");
					n = reader.nextInt();
				}
		    	keyPresent=containsNodeRecursive(root, n);
				if(!keyPresent)
				{
					bt.insert(n);
				} else {
					System.out.println("That integer already exists");
				}	
		        break;
		    case 2: 
		    	n=0;
		    	while(!(n >= 1))
				{
					System.out.println("***Binary Tree Menu***");
					System.out.print("\n***Delete***");
					
					System.out.println("\n Please enter a positive integer to delete from Binary Tree");
					n = reader.nextInt();
				}
		    	keyPresent=containsNodeRecursive(root, n);
		    	if(keyPresent)
				{
		    		bt.delete(n);
		    		System.out.println(n + " was removed");
				} else {
					System.out.println("That integer does not exist");
				}  	
		        break;
		    case 3: 
		    	n=0;
		    	while(!(n >= 1))
				{
					System.out.println("***Binary Tree Menu***");
					System.out.print("\n***Search***");
					
					System.out.println("\n Please enter a positive integer to search for in Binary Tree");
					n = reader.nextInt();
				}
		    	
		    	bt.search(n);
		        break;
		    case 4: 
		        height(root);
		        break;
		    case 5: 
		        exit = true;
		        System.out.print("\nExiting...");
		        break;
		}
				
			n=0;
			return exit;
	}
	
	public static void main(String[] args)
	{
		BinaryTree bt = new BinaryTree();
		Scanner reader = new Scanner(System.in);
		
		int[] data = {30, 10, 45, 38, 20, 50, 25, 33, 8, 12};
		createBT(bt, data);
		
	    while(exit==false)
	    {    	
	    	exit = menu(bt, reader);
	    	if (!exit)
	    		{
	    			display(root);
	    		}
	    }
	    
	    reader.close();
	}
}
