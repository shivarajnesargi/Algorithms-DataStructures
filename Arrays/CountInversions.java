import java.util.Arrays;
import java.util.HashMap;

/**
*Author:Shivraj
*Date :Jul 31, 2017
*Time :11:53:55 AM
*Place:Brooklyn,Newyork
*
*/

public class CountInversions {
	
	public void updateBinaryIndexedTree(int[] binaryIndexedTree,
			int val,int index)
	{
		while(index<binaryIndexedTree.length)
		{
			binaryIndexedTree[index] += val;
			index = getNext(index);
		}
	}
	
	public int getSum(int[] binaryIndexedTree, int index)
	{
		int sum=0;
		while(index>0)
		{
			sum+= binaryIndexedTree[index];
			index = getParent(index);
		}
		return sum;
	}
	
	public int getNext(int index)
	{
		return index+(index & -index);
	}
	
	public int getParent(int index)
	{
		return index-(index& -index);
	}
	
	public int[] convert(int[] A)
	{
		int[] copyOfA = Arrays.copyOf(A, A.length);
		Arrays.sort(copyOfA);
		for(int i=0;i<A.length;i++)
		{
			A[i] = binarySearch(copyOfA,A[i])+1;
		}
		
		return A;
	}
	
	private int binarySearch(int[] A,int key)
	{
		int indexLow =0;
		int indexHigh = A.length-1;
		while(indexLow<=indexHigh)
		{
			int mid = (indexLow+indexHigh)/2;
			if(A[mid]==key) 
			{
				return mid;
			}
			else if(A[mid]>key)
			{
				indexHigh=mid-1;
			}
			else if(A[mid]<key)
			{
				indexLow=mid+1;
			}
		}
		return -1;
	}
	
	public int countInversions(int[] A)
	{
		convert(A);
		int[] bit = new int[A.length+1];
		for(int i=0;i<=A.length;i++)
		{
			bit[i]=0;
		}
		int invCount=0;
		for(int i=A.length-1;i>=0;i--)
		{
			invCount+=getSum(bit,A[i]-1);
			updateBinaryIndexedTree(bit, 1, A[i]);
		}
		
		return invCount;
	}
	
	public static void main(String[] args)
	{
		CountInversions bit = new CountInversions();
		int[] A = {3,-5,4,1,7};
		int inversions= bit.countInversions(A);
		System.out.println(inversions);
	}
}
