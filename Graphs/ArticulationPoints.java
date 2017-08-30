package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
*Author:Shivraj
*Date :Aug 23, 2017
*Time :1:42:26 PM
*Place:Brooklyn,Newyork
*
*/

public class ArticulationPoints {

	private int time;
	
	public Set<Vertex<Integer>> findArticulationPoints(Graph<Integer> graph)
	{
		time=0;
		Set<Vertex<Integer>> ap = new HashSet<>();
		Set<Vertex<Integer>> visited = new HashSet<>();
		Map<Vertex<Integer>,Vertex<Integer>> parent = new HashMap<>();
		Map<Vertex<Integer>,Integer> visitedTime = new HashMap<>();
		Map<Vertex<Integer>,Integer> lowTime = new HashMap<>();
		Vertex<Integer> startVertex = graph.getAllVertices().iterator().next();
		dfs(ap,visited,parent,visitedTime,lowTime,startVertex);
		return ap;
	}
	
	private void dfs(Set<Vertex<Integer>> ap,Set<Vertex<Integer>> visited,
			Map<Vertex<Integer>,Vertex<Integer>> parent,
			Map<Vertex<Integer>,Integer> visitedTime,
			Map<Vertex<Integer>,Integer> lowTime,Vertex<Integer> vertex)
	{
		
		time++;
		visitedTime.put(vertex,time);
		lowTime.put(vertex,time);
		visited.add(vertex);
		
		int child=0;
		boolean artFlag=false;
		
		
		for(Vertex<Integer> adj:vertex.getAllAdjacentVertices())
		{
			if(adj.equals(parent.get(vertex))) continue;
			if(!visited.contains(adj))
			{
				parent.put(adj, vertex);
				child++;
				dfs(ap,visited,parent,visitedTime,lowTime,adj);
				if(visitedTime.get(vertex)<=lowTime.get(adj))
				{
					artFlag=true;
				}
				else
				{
					lowTime.compute(vertex, (key,value)->(
							value=Math.min(lowTime.get(adj),value)
						));
				}
				
			}
			else
			{
				lowTime.compute(vertex, (key,value)->(
					value=Math.min(lowTime.get(adj),value)
				));
			}
		}
		
		if((parent.get(vertex)==null && child>=2)|| 
				(parent.get(vertex)!=null && artFlag))
		{
			ap.add(vertex);
		}
	}
	
	public static void main(String[] args)
	{
		Graph<Integer> graph = new Graph<>(false);
		ArticulationPoints ap = new ArticulationPoints();
		/*graph.addEdge(0,1);
		graph.addEdge(1,2);
		graph.addEdge(2,3);
		graph.addEdge(2,0); */
		 graph.addEdge(1, 2);
	        graph.addEdge(2, 3);
	        graph.addEdge(1, 3);
	        graph.addEdge(1, 4);
	        graph.addEdge(4, 5);
	        graph.addEdge(5, 6);
	        graph.addEdge(6, 7);
	        graph.addEdge(7, 5);
	        graph.addEdge(6, 8);
	        Set<Vertex<Integer>> res=ap.findArticulationPoints(graph);
		System.out.println(res);
	}
}
