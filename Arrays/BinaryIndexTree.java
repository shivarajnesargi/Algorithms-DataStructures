/**
*Author:Shivraj
*Date :Jul 30, 2017
*Time :7:18:31 PM
*Place:Brooklyn,Newyork
*
*/

public class BinaryIndexTree {

	public int[] createTree(int[] ar)
	{
		int[] binaryIndexedTree = new int[ar.length+1];
		for(int i=0;i<ar.length;i++)
		{
			updateBinaryIndexedTree(binaryIndexedTree,ar[i],i);
		}
		return binaryIndexedTree;
	}
	
	public void updateBinaryIndexedTree(int[] binaryIndexedTree,int val,int index)
	{
		index=index+1;
		while(index<binaryIndexedTree.length)
		{
			binaryIndexedTree[index] += val;
			index = getNext(index);
		}
	}
	
	public int getSum(int[] binaryIndexedTree, int index)
	{
		int sum=0;
		index = index+1;
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
	
	public static void main(String[] args)
	{
		BinaryIndexTree bit = new BinaryIndexTree();
		int[] ar = {3,2,-1,6,5,4,-3,3,7,2,3};
		int[] binaryIndexTree=bit.createTree(ar);
		System.out.println(bit.getSum(binaryIndexTree,3));
		bit.updateBinaryIndexedTree(binaryIndexTree,1,3);
		System.out.println(bit.getSum(binaryIndexTree,3));
	}
}
