/**
*Author:Shivraj
*Date :Aug 19, 2017
*Time :8:39:08 PM
*Place:Brooklyn,Newyork
*
*/

public class SelectionSort {

	private static void selectionSort(int[] ar)
	{
		for(int i=0;i<ar.length;i++)
		{
			for(int j=i+1;j<ar.length;j++)
			{
				if(ar[i]>ar[j])
				{
					swap(ar,i,j);
				}
			}
		}
	}
	
	private static void swap(int[] ar,int i,int j)
	{
		int temp = ar[i];
		ar[i]=ar[j];
		ar[j] = temp;
	}
	
	private static void printArray(int[] ar)
	{
		for(int i=0;i<ar.length;i++)
			System.out.print(ar[i]+" ");
	}
	
	public static void main(String[] args)
	{
		int[] ar ={4,2,3,1,0};
		selectionSort(ar);
		printArray(ar);
	}
}
