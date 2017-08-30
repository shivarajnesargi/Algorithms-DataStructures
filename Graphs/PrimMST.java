package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
*Author:Shivraj
*Date :Jul 15, 2017
*Time :4:12:08 PM
*Place:Brooklyn,Newyork
*
*/

public class PrimMST {

	public List<Edge<Integer>> primMST(Graph<Integer> graph)
	{
		BinaryMinHeap<Vertex<Integer>> minHeap = new BinaryMinHeap<>();
		Map<Vertex<Integer>,Edge<Integer>> vertexToEdge = new HashMap<>();
		List<Edge<Integer>> result = new ArrayList<>();
		
		for(Vertex<Integer> vertex:graph.getAllVertices())
		{
			minHeap.add(Integer.MAX_VALUE, vertex);
		}
		
		Vertex<Integer> startVertex = graph.getAllVertices().iterator().next();
		minHeap.decrease(startVertex, 0);
		
		while(!minHeap.empty())
		{
			Vertex<Integer> current = minHeap.extractMin();
			Edge<Integer> spanningEdge = vertexToEdge.get(current);
			if(spanningEdge!=null)
			{
				result.add(spanningEdge);
			}
			
			for(Edge<Integer> edge: current.getEdges())
			{
				Vertex<Integer> adjacent = getVertexFromEdge(current,edge);
				if(minHeap.containsData(adjacent) && minHeap.getWeight(adjacent)>edge.getWeight())
				{
					minHeap.decrease(adjacent,edge.getWeight());
					vertexToEdge.put(adjacent, edge);
				}
			}
		}
		
		return result;	
	}
	
	private Vertex<Integer> getVertexFromEdge(Vertex<Integer> v,Edge<Integer> e)
	{
		return e.getVertex1().equals(v)? e.getVertex2():e.getVertex1();
	}
	
	public static void main(String[] args)
	{
		Graph<Integer> graph = new Graph<Integer>(false);
		graph.addEdge(1, 2, 3);
        graph.addEdge(2, 3, 1);
        graph.addEdge(3, 4, 1);
        graph.addEdge(1, 4, 1);
        graph.addEdge(2, 4, 3);
        graph.addEdge(4, 5, 6);
        graph.addEdge(5, 6, 2);
        graph.addEdge(3, 5, 5);
        graph.addEdge(3, 6, 4);

        PrimMST prims = new PrimMST();
        List<Edge<Integer>> resultEdges = prims.primMST(graph);
        int sum=0;
        for(Edge<Integer> edge:resultEdges)
        {
        	System.out.println(edge.getWeight());
        }
	}
}
