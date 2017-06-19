/** This file contains the depth first travesal algorithm which is implemented  
using Stack in an iterative fashion **/


// Importing required packages

import java.util.LinkedList;
import java.util.Stack;
import java.util.Iterator;
import java.util.ListIterator;

class DFSGraph{

    private int nodes; // Number of nodes/vertices in the graph
    private LinkedList<Integer> adj[]; // Adjacency Lists
    
    public DFSGraph(int v)
    {
        nodes = v;
        adj = new LinkedList[v];
        for(int i=0;i<nodes;i++)
        {
            adj[i] = new LinkedList<Integer>();
        }
    }    
    
    /**This method is used for adding vertices to the adjaceny list based on the
    edges**/
    public void addEdge(int source,int node)
    {
        adj[source].add(node);
    }
    
    public void dfs()
    {
        //Creating visited boolean list and initialized all nodes to false
        boolean[] visited = new boolean[nodes];
        
        /**Calling an utility function for DFS and ensuring that DFS works fine
        including disconnected graph**/
        for(int i=0;i<nodes;i++)
        {
            dfsUtil(i,visited);
        }
    }
    
    //Function for DFS algorithm
    private void dfsUtil(int v, boolean[] visited)
    {
        // Creating Stack for DFS
        Stack<Integer> stk = new Stack<Integer>();
        stk.push(v); //push the given vertex/node into the stack
        
        /**
         * We need to follow two steps in this case
         * While stack is not empty
         * 1)pop out the latest node and check if that node is visited,if its 
         * not visited Print out that node and mark it as visited.
         * 2) Iterate through the adjacency list and push a node from the 
         * adjacency list if it's not visited.
         **/
        
        while(!stk.empty())
        {
            int curr = stk.pop();
            if(!visited[curr])
            {
                System.out.print(curr+" ");
                visited[curr] = true;
            }
            
            Iterator<Integer> i = adj[curr].listIterator();
            while(i.hasNext())
            {
                int neighbor = i.next();
                if(!visited[neighbor]) stk.push(neighbor);
            }
        }
    }
    
	public static void main (String[] args) throws java.lang.Exception
	{
		int noOfVertices = 4;//Creating a graph with 4 vertices
		DFSGraph g = new DFSGraph(noOfVertices);
		//Adding Edges
	    g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        
        //call dfs on the graph
    	g.dfs();	
		
	}
}
