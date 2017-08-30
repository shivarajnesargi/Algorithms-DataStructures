/**
*Author:Shivraj
*Date :Aug 19, 2017
*Time :8:43:33 PM
*Place:Brooklyn,Newyork
*
*/

public class InsertionSort {
	
	private static void insertionSort(int[] ar)
	{
		for(int i=1;i<ar.length;i++)
		{
			int j=i-1;
			int key=ar[i];
			while(j>-1&&ar[j]>key)
			{
				ar[j+1]=ar[j];
				j--;
			}
			ar[j+1]=key;
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
		insertionSort(ar);
		printArray(ar);
	}

}
