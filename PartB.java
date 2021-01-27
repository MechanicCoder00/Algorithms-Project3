package project3;

public class PartB
{
	static int range = 10000;
	
	public static int[] createarr(int n)
	{
		int randarr[] = new int[n];
		for (int i = 0; i < n; i++)
		{
		    randarr[i] = (int)(Math.random()*range+1);
		    
		    cleanarr(randarr, i);
		   
		}
		return randarr;
	}
	
	public static void cleanarr(int[] arr2, int i)
	{
		for (int j = 0; j < i; j++)
	    {
	    	if(arr2[i] == arr2[j])
		    {
	    		arr2[i] = (int)(Math.random()*range+1);
	    		cleanarr(arr2, i);
		    }
	    }
	}

	public static int[] createarr2(int n)
	{
		int randarr[] = new int[n];
		for (int i = 0; i < n; i++)
		{
		    randarr[i] = (int)(Math.random()*range+1);
		    
		    cleanarr(randarr, i);
		   
		}
		return randarr;
	}
	
	public static void cleanarr2(int[] arr2, int i)
	{
		for (int j = 0; j < i; j++)
	    {
	    	if(arr2[i] == arr2[j])
		    {
	    		arr2[i] = (int)(Math.random()*range+1);
	    		cleanarr(arr2, i);
		    }
	    }
	}
	
	public static void avgarrht(int keys, int trees)
	{
		float sum = 0;
		int ht[] = new int[trees];
		for (int i = 0; i < ht.length; i++)
	    {
			int arr[] = createarr(keys);
			BinaryTree bt = new BinaryTree();
			BinaryTree.createBT2(bt, arr);
			sum += BinaryTree.treeheight(BinaryTree.root);		
			bt.deltree(keys);
	    }
		System.out.println("Avg tree height of " + trees + " trees with " + keys + " keys: " + (sum/trees));
	}
	
	
	
	public static void main(String[] args)
	{
		int arrkeys[] = {100, 500, 1000};
		int arrtrees[] = {5, 10, 15};
		
		for (int i = 0; i < arrkeys.length; i++)
		{
			for (int j = 0; j < arrtrees.length; j++)
			{
				avgarrht(arrkeys[i],arrtrees[j]);
			}
		}
	}
}