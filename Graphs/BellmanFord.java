package graph;

import java.util.HashMap;
import java.util.Map;

/**
*Author:Shivraj
*Date :Aug 22, 2017
*Time :4:32:52 PM
*Place:Brooklyn,Newyork
*
*/

public class BellmanFord {
	
	class NegativeCyleException extends RuntimeException
	{
		
	}
	
	
	private static final int INFINITY = 1000000;
	
	private Map<Vertex<Integer>,Integer> getShortestPath(Graph<Integer> g,Vertex<Integer> sourceVertex)
	{
		Map<Vertex<Integer>,Integer> dist = new HashMap<>();
		Map<Vertex<Integer>,Vertex<Integer>> parent = new HashMap<>();
		for(Vertex<Integer> v:g.getAllVertices())
		{
			dist.put(v,INFINITY);
			parent.put(v,null);
		}
		dist.put(sourceVertex,0);
		int V = g.getAllVertices().size();
		for(int i=0;i<V-1;i++)
		{
			for(Edge<Integer> edge:g.getAllEdges())
			{
				Vertex<Integer> u = edge.getVertex1();
				Vertex<Integer> v = edge.getVertex2();
				if(dist.get(u)+edge.getWeight()<dist.get(v))
				{
					dist.put(v,dist.get(u)+edge.getWeight());
					parent.put(v,u);
				}
			}
		}
		
		for(Edge<Integer> edge:g.getAllEdges())
		{
			Vertex<Integer> u = edge.getVertex1();
			Vertex<Integer> v = edge.getVertex2();
			if(dist.get(u)+edge.getWeight()<dist.get(v))
			{
				throw new NegativeCyleException();
			}
		}
		
		return dist;
	}
	
	public static void main(String[] args)
	{
		BellmanFord b = new BellmanFord();
		Graph<Integer> g = new Graph<Integer>(true);
		g.addEdge(0,1,4);
		g.addEdge(0,2,5);
		g.addEdge(0,3,6);
		g.addEdge(1,2,-3);
		g.addEdge(2,5,4);
		g.addEdge(5,4,1);
		g.addEdge(4,5,2);
		g.addEdge(3,4,2);
		g.addEdge(0,3,6);
		Vertex<Integer> sourceVertex=g.getAllVertices().iterator().next();
		Map<Vertex<Integer>,Integer> res=b.getShortestPath(g,sourceVertex);
		System.out.println(res);
	}
}
