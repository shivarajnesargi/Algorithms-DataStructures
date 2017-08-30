package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
*Author:Shivraj
*Date :Jul 18, 2017
*Time :12:10:16 PM
*Place:Brooklyn,Newyork
*
*/

public class StronglyConnected {
	
	public List<Set<Vertex<Integer>>> getStronglyConnectedComponents(Graph<Integer> graph)
	{
		Set<Vertex<Integer>> visited = new HashSet<>();
		Stack<Vertex<Integer>> stk = new Stack<>();
		List<Set<Vertex<Integer>>> result = new ArrayList<>();
		
		for(Vertex<Integer> v: graph.getAllVertices())
		{
			if(visited.contains(v)) continue;
			dfsUtil(v,visited,stk);
		}
		

		Graph<Integer> reverseGraph = reverseGraph(graph);
		visited.clear();
		
		while(!stk.isEmpty())
		{
			Vertex<Integer> v = reverseGraph.getVertex(stk.pop().getId());
			if(visited.contains(v)) continue;
			Set<Vertex<Integer>> set = new HashSet<>();
			dfsReverseUtil(v,visited,set);
			result.add(set);
		}
		
		return result;
	}
	
	public void dfsUtil(Vertex<Integer> v,Set<Vertex<Integer>> visited,Stack<Vertex<Integer>> stk)
	{
		visited.add(v);
		for(Vertex<Integer> adjVertex: v.getAllAdjacentVertices())
		{
			if(visited.contains(adjVertex)) continue;
			dfsUtil(adjVertex,visited,stk);
		}
		stk.push(v);
	}
	
	public void dfsReverseUtil(Vertex<Integer> v,Set<Vertex<Integer>> visited,Set<Vertex<Integer>> set)
	{
		visited.add(v);
		set.add(v);
		for(Vertex<Integer> adjVertex:v.getAllAdjacentVertices())
		{
			if(visited.contains(adjVertex)) continue;
			dfsReverseUtil(adjVertex,visited,set);
		}
	}
	
	public Graph<Integer> reverseGraph(Graph<Integer> graph)
	{
		Graph<Integer> reverseGraph = new Graph<Integer>(true);
		for(Edge<Integer> e: graph.getAllEdges())
		{
			reverseGraph.addEdge(e.getVertex2().getId(),e.getVertex1().getId());
		}
		return reverseGraph;
	}
	
	public static void main(String[] args)
	{
		Graph<Integer> graph = new Graph<Integer>(true);
		graph.addEdge(1,2);
		graph.addEdge(2,3);
		graph.addEdge(3,1);
		graph.addEdge(2,4);
		graph.addEdge(4,5);
		graph.addEdge(5,6);
		graph.addEdge(6,4);
		graph.addEdge(7,6);
		graph.addEdge(7,8);
		graph.addEdge(8,9);
		graph.addEdge(9,10);
		graph.addEdge(10,7);
		graph.addEdge(10,11);
		StronglyConnected sc = new StronglyConnected();
		List<Set<Vertex<Integer>>> res=sc.getStronglyConnectedComponents(graph);
		System.out.println(res);
	}

}
