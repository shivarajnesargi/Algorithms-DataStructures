import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
*Author:Shivraj
*Date :Aug 20, 2017
*Time :4:58:47 PM
*Place:Brooklyn,Newyork
*
*/

public class BucketSort {

	private static final int bucketSize=10;
	public static void bucketSort(int[] ar)
	{
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for(int i=0;i<ar.length;i++)
		{
			max = Math.max(max,ar[i]);
			min = Math.min(min, ar[i]);
		}
		int divider =(int) Math.ceil((max+1)/bucketSize);
		bucketSort(ar,divider);
	}
	
	private static void bucketSort(int[] ar,int divider)
	{
		Map<Integer,ArrayList<Integer>> bucket = new HashMap<>();
			
		for(int i=0;i<ar.length;i++)
		{
			int j = ar[i]/divider;
			if(bucket.containsKey(j))
			{	
				bucket.get(j).add(ar[i]);
			}
			else
			{
				ArrayList<Integer> list = new ArrayList<>();
				list.add(ar[i]);
				bucket.put(j,list);
			}
		}
		
		for(int i=0;i<bucketSize;i++) 
		{
			if(bucket.get(i)!=null)Collections.sort(bucket.get(i));
		}	
		
		int k=0;
		for(int i=0;i<bucketSize;i++)
		{
			if(bucket.get(i)!=null)
			{
				for(int j:bucket.get(i))
					ar[k++]=j;
			}
		}
	}
	
	private static void printArray(int[] ar)
	{
		for(int i=0;i<ar.length;i++)
			System.out.print(ar[i]+" ");
	}
	
	public static void main(String[] args)
	{
		int[] ar ={4,2,3,1,0,50,100};
		bucketSort(ar);
		printArray(ar);
	}
}
