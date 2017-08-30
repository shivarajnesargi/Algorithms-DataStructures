/**
*Author:Shivraj
*Date :Aug 19, 2017
*Time :8:33:34 PM
*Place:Brooklyn,Newyork
*
*/

public class BubbleSort {

	private static void bubbleSort(int[] ar)
	{
		for(int i=0;i<ar.length;i++)
		{
			for(int j=0;j<ar.length-i-1;j++)
			{
				if(ar[j]>ar[j+1])
				{
					swap(ar,j,j+1);
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
		bubbleSort(ar);
		printArray(ar);
	}
}
