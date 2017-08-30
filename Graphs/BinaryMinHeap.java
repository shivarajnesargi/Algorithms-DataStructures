package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
*Author:Shivraj
*Date :Jul 15, 2017
*Time :11:51:39 AM
*Place:Brooklyn,Newyork
*
*/

public class BinaryMinHeap<T> {
	List<Node> allNodes = new ArrayList<>();
	Map<T,Integer> nodePosition = new HashMap<>();
	
	class Node
	{
		T key;
		int weight;
	}
	
	public boolean containsData(T key)
	{
		return nodePosition.containsKey(key);
	}
	
	public void add(int weight,T key)
	{
		Node node = new Node();
		node.key = key;
		node.weight = weight;
		allNodes.add(node);
		int currentIndex = allNodes.size()-1;
		int parentIndex = (currentIndex-1)/2;
		nodePosition.put(key,currentIndex);
		while(parentIndex>=0)
		{
			Node parent = allNodes.get(parentIndex);
			Node current = allNodes.get(currentIndex);
			if(parent.weight>current.weight)
			{
				swap(parent,current);
				updatePositionMap(parent.key,current.key,parentIndex,currentIndex);
				currentIndex = parentIndex;
				parentIndex = (parentIndex-1)/2;
			}
			else
			{
				break;
			}
		}
	}
	
	public T min()
	{
		return allNodes.get(0).key;
	}
	
	public boolean empty()
	{
		return allNodes.size()==0;
	}
	
	private void swap(Node node1, Node node2)
	{
		int weight=node1.weight;
		T key = node1.key;
		
		node1.key = node2.key;
		node1.weight = node2.weight;
		
		node2.key = key;
		node2.weight = weight;
	}
	
	private void updatePositionMap(T key1,T key2,int index1, int index2)
	{
		nodePosition.remove(key1);
		nodePosition.remove(key2);
		
		nodePosition.put(key1,index1);
		nodePosition.put(key2,index2);
	}
	
	public void decrease(T key,int newWeight)
	{
		Integer position = nodePosition.get(key);
		allNodes.get(position).weight = newWeight;
		int parentIndex = (position-1)/2;
		while(parentIndex>=0)
		{
			if(allNodes.get(parentIndex).weight>allNodes.get(position).weight)
			{
				swap(allNodes.get(position),allNodes.get(parentIndex));
				updatePositionMap(allNodes.get(parentIndex).key,
						allNodes.get(position).key,parentIndex,position);
				position = parentIndex;
				parentIndex = (parentIndex-1)/2;
			}
			else
			{
				break;
			}
		}
	}
	
	public Integer getWeight(T key)
	{
		Integer position = nodePosition.get(key);
		if(position==null)
		{
			return null;
		}
		else
		{
			return allNodes.get(position).weight;
		}
	}
	
	public Node extractMinNode()
	{
		int size = allNodes.size()-1;
		Node minNode = new Node();
		minNode.key = allNodes.get(0).key;
		minNode.weight = allNodes.get(0).weight;
			
		int lastNodeWeight = allNodes.get(size).weight;
		allNodes.get(0).weight = lastNodeWeight;
		allNodes.get(0).key = allNodes.get(size).key;
		nodePosition.remove(minNode.key);
		nodePosition.remove(allNodes.get(size).key);
		nodePosition.put(allNodes.get(0).key,0);
		allNodes.remove(size);
		
		int currentIndex=0;
		size--;
		while(true)
		{
			int left = 2*currentIndex+1;
			int right = 2*currentIndex+2;
			if(left>size)
			{
				break;
			}
			if(right>size)
			{
				right = left;
			}
			
			int smallerIndex = allNodes.get(left).weight<=
					allNodes.get(right).weight?left:right;
			if(allNodes.get(currentIndex).weight>allNodes.get(smallerIndex).weight)
			{
				swap(allNodes.get(currentIndex),allNodes.get(smallerIndex));
				updatePositionMap(allNodes.get(currentIndex).key,
						allNodes.get(smallerIndex).key,currentIndex,smallerIndex);
				currentIndex = smallerIndex;
			}
			else
			{
				break;
			}
		}
		return minNode;
	}
	
	public T extractMin()
	{
		Node node = extractMinNode();
		return node.key;
	}
	
	   public static void main(String args[]){
	        BinaryMinHeap<String> heap = new BinaryMinHeap<String>();
	        heap.add(3, "Tushar");
	        heap.add(4, "Ani");
	        heap.add(8, "Vijay");
	        heap.add(10, "Pramila");
	        heap.add(5, "Roy");
	        heap.add(6, "NTF");
	        heap.add(2,"AFR");
	        heap.decrease("Pramila", 1);
	        //heap.printHeap();
	        //heap.printPositionMap();
	    }

}
