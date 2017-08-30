/**
*Author:Shivraj
*Date :Aug 19, 2017
*Time :9:26:35 PM
*Place:Brooklyn,Newyork
*
*/

public class MergeSort {

	
	private static void merge(int[] ar,int low,int mid,int high)
	{
		int n1 = mid-low+1;
		int n2 = high-mid;
		int L[] = new int[n1];
		int R[] = new int[n2];
		for(int i=0;i<n1;i++)
			L[i]=ar[low+i];
		for(int j=0;j<n2;j++)
			R[j] = ar[mid+1+j];
		int i=0,j=0;
		int k=low;
		while(i<n1&&j<n2)
		{
			if(L[i]<R[j])
			{
				ar[k]=L[i];
				i++;
			}
			else
			{
				ar[k]=R[j];
				j++;
			}		
			k++;
		}
		while(i<n1)
		{
			ar[k++]=L[i++];
		}
		while(j<n2)
		{
			ar[k++]=R[j++];
		}
	}
	
	private static void mergeSort(int[] ar,int low,int high)
	{
		if(low<high)
		{
			int mid = low+(high-low)/2;
			mergeSort(ar,low,mid);
			mergeSort(ar,mid+1,high);
			merge(ar,low,mid,high);
		}
	}
	
	private static void printArray(int[] ar)
	{
		for(int i=0;i<ar.length;i++)
			System.out.print(ar[i]+" ");
	}
	
	public static void main(String[] args)
	{
		int[] ar ={4,2,3,1,0};
		mergeSort(ar,0,ar.length-1);
		printArray(ar);
	}
}
