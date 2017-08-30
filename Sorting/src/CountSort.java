/**
*Author:Shivraj
*Date :Aug 20, 2017
*Time :11:43:13 AM
*Place:Brooklyn,Newyork
*
*/

public class CountSort {

	private static void countSort(int[] ar)
	{
		int k = Integer.MIN_VALUE;
		for(int i=0;i<ar.length;i++)
		{
			k = Math.max(ar[i],k);
		}
		
		int[] count = new int[k+1];
		
		for(int i=0;i<ar.length;i++)
		{
			count[ar[i]]++;
		}
		
		for(int i=1;i<count.length;i++)
		{
			count[i]=count[i-1]+count[i];
		}
		
		int[] res = new int[ar.length];
		
		for(int i=0;i<ar.length;i++)
		{
			res[count[ar[i]]-1]=ar[i];
			count[ar[i]]--;
		}
		printArray(res);
	}
	
	private static void printArray(int[] ar)
	{
		for(int i=0;i<ar.length;i++)
			System.out.print(ar[i]+" ");
	}
	
	
	public static void main(String[] args)
	{
		int[] ar ={4,2,3,1,100,4};
		countSort(ar);
		System.out.println();
		printArray(ar);
	}
}
