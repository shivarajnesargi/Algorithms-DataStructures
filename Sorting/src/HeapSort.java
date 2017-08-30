import java.util.Arrays;

/**
*Author:Shivraj
*Date :Aug 21, 2017
*Time :11:01:19 AM
*Place:Brooklyn,Newyork
*
*/

public class HeapSort {

	private static int size =0;
	private static int capacity =10;
	static int[] items = new int[capacity];
	
	private int getLeftChildIndex(int index) {return 2*index+1;}
	private int getRightChildIndex(int index) {return 2*index+2;}
	private int getParentIndex(int index) {return (index-1)/2;}
	
	private boolean hasLeftChild(int index){
		return getLeftChildIndex(index)<size;
	}
	private boolean hasRightChild(int index){
		return getRightChildIndex(index)<size;
	}
	private boolean hasParent(int index){
		return getParentIndex(index)>=0;
	}
	
	private int leftChild(int index) {return items[getLeftChildIndex(index)];}
	private int rightChild(int index) {return items[getRightChildIndex(index)];}
	private int parent(int index) {return items[getParentIndex(index)];}
	
	private void ensureCapacity()
	{
		if(size==capacity)
		{
			items= Arrays.copyOf(items,capacity*2);
			capacity=capacity*2;
		}
	}
	
	private int peek()
	{
		if(size==0) throw new IllegalStateException();
		return items[0];
	}
	
	private int poll()
	{
		if(size==0) throw new IllegalStateException();
		int item = items[0];
		items[0] = items[size-1];
		size--;
		heapifyDown();
		return item;
	}
	
	private void add(int item)
	{
		ensureCapacity();
		items[size] = item;
		size++;
		heapifyUp();
	}
	
	private void heapifyUp()
	{
		int index = size-1;
		while(hasParent(index))
		{
			int parentIndex = getParentIndex(index);
			if(parent(index)<items[index])
			{
				swap(parentIndex,index);
			}
			else break;
			index = parentIndex;
		}
	}
	
	private void heapifyDown()
	{
		int index=0;
		while(hasLeftChild(index))
		{
			int biggerChildIndex = getLeftChildIndex(index);
			if(hasRightChild(index) && rightChild(index)>leftChild(index))
			{
				biggerChildIndex = getRightChildIndex(index);
			}
			if(items[index]<items[biggerChildIndex])
			{
				swap(index,biggerChildIndex);
			}
			else
			{
				break;
			}
			index = biggerChildIndex;
		}
	}
	
	private void swap(int index1,int index2)
	{
		int temp = items[index1];
		items[index1]=items[index2];
		items[index2] = temp;
	}
	
	private static void printArray(int[] ar)
	{
		for(int i=0;i<ar.length;i++)
			System.out.print(ar[i]+" ");
	}
	
	private void heapSort(int[] ar)
	{
		for(int i=0;i<ar.length;i++)
		{
			add(ar[i]);
		}
		
		for(int i=ar.length-1;i>0;i--)
		{
			swap(i,0);
			size--;
			heapifyDown();
		}
		for(int i=0;i<ar.length;i++)
		{
			ar[i] = items[i];
		}
	}
	
	public static void main(String[] args)
	{
		HeapSort h = new HeapSort();
		int[] ar ={4,2,3,1,0,50,100};
		h.heapSort(ar);	
		printArray(ar);
	}
	
}
