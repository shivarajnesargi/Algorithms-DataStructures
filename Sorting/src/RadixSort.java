/**
*Author:Shivraj
*Date :Aug 20, 2017
*Time :2:22:07 PM
*Place:Brooklyn,Newyork
*
*/

public class RadixSort {

	private static int getMax(int[] ar)
	{
		int max=Integer.MIN_VALUE;
		for(int i=0;i<ar.length;i++)
			max=Math.max(max, ar[i]);
		return max;
	}
	
	private static void countSort(int[] ar,int n,int exp)
	{
		int[] output = new int[n];
		int[] count = new int[10];
		for(int i=0;i<n;i++)
		{
			count[(ar[i]/exp)%10]++;
		}
		for(int i=1;i<10;i++)
		{
			count[i]+=count[i-1];
		}
		for(int i=n-1;i>=0;i--)
		{
			output[count[(ar[i]/exp)%10]-1] = ar[i];
			count[(ar[i]/exp)%10]--;
		}
		for(int i=0;i<ar.length;i++)
		{
			ar[i]=output[i];
		}
	}
	
	private static void radixSort(int[] ar)
	{
		int n = ar.length;
		int m = getMax(ar);
		for(int exp=1;m/exp>0;exp*=10)
			countSort(ar,n,exp);
	}
	
	private static void printArray(int[] ar)
	{
		for(int i=0;i<ar.length;i++)
			System.out.print(ar[i]+" ");
	}
	
	public static void main(String[] args)
	{
		int[] ar ={4,2,3,1,0,50,100};
		radixSort(ar);
		printArray(ar);
	}
	
}
