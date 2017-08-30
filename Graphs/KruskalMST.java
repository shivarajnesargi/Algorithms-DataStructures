package graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
*Author:Shivraj
*Date :Jul 14, 2017
*Time :1:11:12 PM
*Place:Brooklyn,Newyork
*
*/

public class KruskalMST {
	
	public List<Edge<Integer>> getMST(Graph<Integer> g)
	{
		List<Edge<Integer>> edges = g.getAllEdges();
		Collections.sort(edges,(o1,o2)->o1.getWeight()-o2.getWeight());
		List<Edge<Integer>> resultEdges = new ArrayList<>();
		DisjointSet disjointSet = new DisjointSet();
		
		for(Vertex<Integer> vertex:g.getAllVertices())
		{
			disjointSet.makeSet(vertex.getId());
		}
		
		for(Edge<Integer> edge: edges)
		{
			long root1 = disjointSet.findSet(edge.getVertex1().getId());
			long root2 = disjointSet.findSet(edge.getVertex2().getId());
			if(root1==root2) continue;
			else
			{
				resultEdges.add(edge);
				disjointSet.union(edge.getVertex1().getId()
						, edge.getVertex2().getId());
			}
		}
		
		return resultEdges;
	}

	public static void main(String[] args)
	{
		Graph<Integer> g = new Graph<>(false);
		g.addEdge(1, 2, 20);
		g.addEdge(1, 3, 50);
		g.addEdge(1, 4, 70);
		g.addEdge(1, 5, 90);
		g.addEdge(2, 3, 30);
		g.addEdge(3, 4, 40);
		g.addEdge(4, 5, 60);
		
		
		KruskalMST k = new KruskalMST();
		List<Edge<Integer>> edges= k.getMST(g);
		System.out.println("The Kruskal minimum spanning tree is");
		int sum=0;
		for(Edge<Integer> edge: edges)
		{
		sum+=edge.getWeight();
		}
		System.out.println(sum);
	}
	
	

}
