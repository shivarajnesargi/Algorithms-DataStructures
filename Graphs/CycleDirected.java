package graph;

import java.util.HashSet;
import java.util.Set;

/**
*Author:Shivraj
*Date :Jul 16, 2017
*Time :7:01:34 PM
*Place:Brooklyn,Newyork
*
*/

public class CycleDirected {
	
	public boolean hasCycle(Graph<Integer> graph)
	{
		Set<Vertex<Integer>> whiteSet = new HashSet<>();
		Set<Vertex<Integer>> graySet = new HashSet<>();
		Set<Vertex<Integer>> blackSet = new HashSet<>();
		
		for(Vertex<Integer> v: graph.getAllVertices())
		{
			whiteSet.add(v);
		}
		
		while(whiteSet.size()>0)
		{
			Vertex<Integer> current = whiteSet.iterator().next();
			if(dfs(current,whiteSet,graySet,blackSet))
			{
				return true;
			}
		}
		
		return false;
	}
	
	private boolean dfs(Vertex<Integer> current,Set<Vertex<Integer>> whiteSet,
			Set<Vertex<Integer>> graySet,Set<Vertex<Integer>> blackSet)
	{
		moveVertex(current,whiteSet,graySet);
		
		for(Vertex<Integer> adjacent: current.getAllAdjacentVertices())
		{
			if(blackSet.contains(adjacent)) continue;
			if(graySet.contains(adjacent)) return true;
			
			if(dfs(adjacent,whiteSet,graySet,blackSet)) return true;
		}
		moveVertex(current,graySet,blackSet);
		return false;
	}
	
	private void moveVertex(Vertex<Integer> vertex,Set<Vertex<Integer>> set1,
			Set<Vertex<Integer>> set2)
	{
		set1.remove(vertex);
		set2.add(vertex);
	}
	
	public static void main(String[] args)
	{
		Graph<Integer> graph = new Graph<>(true);
		graph.addEdge(1,2);
		graph.addEdge(1,3);
		graph.addEdge(2,3);
		graph.addEdge(4,1);
		graph.addEdge(4,5);
		graph.addEdge(5,6);
		//graph.addEdge(3,4);
		//graph.addEdge(6,4);
		
		CycleDirected cd = new CycleDirected();
		boolean cycle=cd.hasCycle(graph);
		String result = cycle?"has":"doesn't have";
		System.out.println("The graph "+result+" a cycle");
		
		System.out.println(999000%1000);
	}

}
