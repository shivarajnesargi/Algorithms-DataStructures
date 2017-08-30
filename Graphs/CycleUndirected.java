package graph;
/**
*Author:Shivraj
*Date :Jul 16, 2017
*Time :5:38:29 PM
*Place:Brooklyn,Newyork
*
*/

public class CycleUndirected {

	public boolean hasCycle(Graph<Integer> graph)
	{
		DisjointSet d = new DisjointSet();
		for(Vertex<Integer> v: graph.getAllVertices())
		{
			d.makeSet(v.getId());
		}
		
		for(Edge<Integer> e: graph.getAllEdges())
		{
			long rep1 = d.findSet(e.getVertex1().getId());
			long rep2 = d.findSet(e.getVertex2().getId());
			if(rep1==rep2) return true;
			else
			{
				d.union(e.getVertex1().getId(), e.getVertex2().getId());
			}
		}
		return false;
	}
	
	public static void main(String[] args)
	{
		Graph<Integer> graph = new Graph<>(false);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(3, 4);
		graph.addEdge(4, 5);
		graph.addEdge(5, 6);
		graph.addEdge(3, 6);
		
		CycleUndirected cu = new CycleUndirected();
		boolean cycle=cu.hasCycle(graph);
		String result = cycle?"has":"doesn't have";
		System.out.println("The graph "+result+" a cycle");
	}
}
