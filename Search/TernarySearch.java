/**
*Author:Shivraj
*Date :Aug 19, 2017
*Time :8:21:24 PM
*Place:Brooklyn,Newyork
*
*/

public class TernarySearch {

	private static int ternarySearch(int[] ar, int key, int low,int high)
	{
		while(low<high)
		{
			int mid1 = low+(high-low)/3;
			int mid2 = high-(high-low)/3;
			if(ar[mid1]==key) return mid1;
			if(ar[mid2]==key) return mid2;
			if(ar[mid1]>key) high=mid1-1;
			else if(ar[mid2]<key) low = mid2+1;
			else
			{
				low=mid1+1;
				high=mid2-1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args)
	{
		int[] ar ={2,3,5,6,8,9,12,13,14};
		int key =9;
		System.out.println("The number "+key+" found at index "+
		ternarySearch(ar,key,0,ar.length-1));
	}
}
