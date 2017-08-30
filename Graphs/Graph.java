package graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
*Author:Shivraj
*Date :Jul 14, 2017
*Time :11:41:07 AM
*Place:Brooklyn,Newyork
*
*/

public class Graph<T> 
{
	private List<Edge<T>> allEdges;
	private Map<Long,Vertex<T>> allVertices;
    boolean isDirected = false;
	
	public Graph(boolean isDirected)
	{
		allEdges = new ArrayList<Edge<T>>();
		allVertices = new HashMap<Long,Vertex<T>>();
		this.isDirected = isDirected;
	}
	
	public void addEdge(long id1,long id2)
	{
		addEdge(id1,id2,0);
	}
	
	public void addEdge(long id1,long id2,int weight)
	{
		Vertex<T> vertex1 =null;
		if(allVertices.containsKey(id1))
		{
			vertex1 = allVertices.get(id1);
		}
		else
		{
			vertex1 = new Vertex<T>(id1);
			allVertices.put(id1, vertex1);
		}
		
		Vertex<T> vertex2 =null;
		if(allVertices.containsKey(id2))
		{
			vertex2 = allVertices.get(id2);
		}
		else
		{
			vertex2 = new Vertex<T>(id2);
			allVertices.put(id2, vertex2);
		}
		
		Edge<T> edge = new Edge<T>(vertex1,vertex2,isDirected,weight);
		allEdges.add(edge);
		
		vertex1.addAdjacentVertex(edge,vertex2);
		if(!isDirected)
		{
			vertex2.addAdjacentVertex(edge,vertex1);
		}
	}
	
	public List<Edge<T>> getAllEdges()
	{
		return allEdges;
	}
	
	public Collection<Vertex<T>> getAllVertices()
	{
		return allVertices.values();
	}
	
	public Vertex<T> getVertex(long id)
	{
		return allVertices.get(id);
	}
}

class Vertex<T>
{
	private long id;
	private List<Vertex<T>> adjacentVertices = new ArrayList<>();
	private List<Edge<T>> edges = new ArrayList<>();
	
	Vertex(long id)
	{
		this.id =id;
	}
	
	public long getId()
	{
		return id;
	}
	
	public void addAdjacentVertex(Edge<T> e,Vertex<T> vertex)
	{
		adjacentVertices.add(vertex);
		edges.add(e);
	}
	
	public List<Edge<T>> getEdges()
	{
		return edges;
	}
	
	public List<Vertex<T>> getAllAdjacentVertices()
	{
		return adjacentVertices;  
	}
	
	public String toString()
	{
		return String.valueOf(id);
	}
}

class Edge<T>
{
	private Vertex<T> vertex1;
	private Vertex<T> vertex2;
	private boolean isDirected=false;
	private int weight;
	
	Edge(Vertex<T> vertex1, Vertex<T> vertex2)
	{
		this.vertex1 = vertex1;
		this.vertex2 = vertex2;
	}
	
	Edge(Vertex<T> vertex1, Vertex<T> vertex2,boolean isDirected)
	{
		this.vertex1 = vertex1;
		this.vertex2 = vertex2;
		this.isDirected = isDirected;
	}
	
	Edge(Vertex<T> vertex1, Vertex<T> vertex2,boolean isDirected,int weight)
	{
		this.vertex1 = vertex1;
		this.vertex2 = vertex2;
		this.isDirected = isDirected;
		this.weight = weight;
	}
	
	public Vertex<T> getVertex1()
	{
		return vertex1;
	}
	
	public Vertex<T> getVertex2()
	{
		return vertex2;
	}
	
	public boolean isDirected()
	{
		return isDirected;
	}
	
	public int getWeight()
	{
		return weight;
	}
	
	

	    @Override
	    public String toString() {
	        return "Edge [isDirected=" + isDirected + ", vertex1=" + vertex1
	                + ", vertex2=" + vertex2 + ", weight=" + weight + "]";
	    }
	
}