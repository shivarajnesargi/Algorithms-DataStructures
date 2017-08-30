/**
*Author:Shivraj
*Date :Aug 20, 2017
*Time :10:40:35 AM
*Place:Brooklyn,Newyork
*
*/

public class QuickSort {

	
	private static void quickSort(int[] ar,int low,int high)
	{
		if(low<high)
		{
			int pivot = partition(ar,low,high);
			quickSort(ar,low,pivot-1);
			quickSort(ar,pivot+1,high);
		}
	}
	
	private static int partition(int[] ar,int low,int high)
	{
		int i=low-1;
		int pivot = ar[high];
		for(int j=low;j<=high-1;j++)
		{
			if(ar[j]<=pivot)
			{
				i++;
				swap(ar,i,j);
			}
		}
		swap(ar,i+1,high);
		return i+1;
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
		int[] ar ={4,2,3,1,0,4};
		quickSort(ar,0,ar.length-1);
		printArray(ar);
	}
}
