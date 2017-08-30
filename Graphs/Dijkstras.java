package graph;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
*Author:Shivraj
*Date :Jul 15, 2017
*Time :8:35:39 PM
*Place:Brooklyn,Newyork
*
*/

public class Dijkstras {
	
	public Map<Vertex<Integer>,Integer> getShortestPath(Graph<Integer> graph,Vertex<Integer> sourceVertex)
	{
		Map<Vertex<Integer>,Integer> distanceMap = new HashMap<>();
		Map<Vertex<Integer>,Vertex<Integer>> parentMap = new HashMap<>();
		BinaryMinHeap<Vertex<Integer>> minHeap = new BinaryMinHeap<>();
		
		for(Vertex<Integer> vertex: graph.getAllVertices())
		{
			minHeap.add(Integer.MAX_VALUE, vertex);
		}
		
		minHeap.decrease(sourceVertex,0);
		parentMap.put(sourceVertex,null);
		distanceMap.put(sourceVertex, 0);
		
		while(!minHeap.empty())
		{
			BinaryMinHeap<Vertex<Integer>>.Node heapNode = minHeap.extractMinNode();
			Vertex<Integer> current = heapNode.key;
			
			distanceMap.put(current,heapNode.weight);
			
			for(Edge<Integer> edge: current.getEdges())
			{
				Vertex<Integer> adjacent = getVertexFromEdge(current,edge);
				
				if(!minHeap.containsData(adjacent))
				{
					continue;
				}
				
				int newWeight = distanceMap.get(current)+ edge.getWeight();
				
				if(minHeap.getWeight(adjacent)>newWeight)
				{
					minHeap.decrease(adjacent, newWeight);
					parentMap.put(adjacent,current);
				}
			}
		}
		
		return distanceMap;
	}
	
	private Vertex<Integer> getVertexFromEdge(Vertex<Integer> v,Edge<Integer> e)
	{
		return e.getVertex1().equals(v)? e.getVertex2():e.getVertex1();
	}

	public static void main(String[] args)
	{
		Graph<Integer> graph = new Graph<Integer>(false);
		graph.addEdge(1,2,5);
		graph.addEdge(1,5,2);
		graph.addEdge(1,4,9);
		graph.addEdge(2,3,2);
		graph.addEdge(3,4,3);
		graph.addEdge(4,6,2);
		graph.addEdge(5,6,3);
		graph.addEdge(7,8,4);
		graph.addEdge(8,9,3);
		graph.addEdge(9,10,2);
		
		Vertex<Integer> sourceVertex= graph.getVertex(1);
		Dijkstras d = new Dijkstras();
		Map<Vertex<Integer>,Integer> dist=d.getShortestPath(graph,sourceVertex);
	    
		System.out.println(dist);
		System.out.println("This is the value:--->"+Integer.MAX_VALUE);
		 for(int i=1;i<=10;i++)
         {
             if(dist.get(graph.getVertex(i))<0 || dist.get(graph.getVertex(i))>3000000) System.out.print(-1+" ");
             else if(dist.get(graph.getVertex(i))==0) continue;
             else System.out.print (dist.get(graph.getVertex(i)) +" ");
         }
		
	}
}
