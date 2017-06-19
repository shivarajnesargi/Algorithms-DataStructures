/** This file contains the breadth first travesal algorithm which is implemented  
using Stack in an iterative fashion **/

import java.util.LinkedList;
import java.util.Iterator;
import java.util.ListIterator;



class BFSGraph
{
    private int vertex; // Number of nodes/vertices in the graph
    private LinkedList<Integer> adj[]; // Adjacency Lists
   
   //Constructor
    public BFSGraph(int v)
    {
        vertex = v;
        adj = new LinkedList[v];
        for(int i=0;i<v;i++)
        {
            adj[i] = new LinkedList<Integer>();
        }
    }   
    
    /**This method is used for adding vertices to the adjaceny list based on the
    edges**/   
    public void addEdge(int s,int n)
    {
        adj[s].add(n);
    }
   
    
    public void bfs()
    {
        //Creating visited boolean list and initialized all nodes to false
        boolean[] visited = new boolean[vertex];
        
        /**Calling an utility function for BFS and ensuring that BFS works fine
        including disconnected graph**/
        for(int i=0;i<vertex;i++)
        {
            bfsUtil(i,visited);
        }
    }
   
    //Function for BFS algorithm
    private void bfsUtil(int v,boolean[] visited)
    {
         // Creating Queue for DFS
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(v); //add the given vertex/node into the queue
        System.out.print(v+" "); // Print out the given node
        visited[v]=true; // Mark it as visited
        
        /**
         * We need to follow two steps in this case
         * While queue is not empty
         * 1)Dequeue the latest node and get the neighbors of that vertex/node.
         * 2) Iterate through the adjacency list and add a node to queue from the 
         * adjacency list if it's not visited.
         **/
        while(queue.size()!=0)
        {
            int curr = queue.poll();
            Iterator<Integer> i = adj[curr].listIterator();
            while(i.hasNext())
            {
                int neighbor = i.next();
                if(!visited[neighbor])
                {
                    queue.add(neighbor);
                    visited[neighbor] = true;
                }   
            }
        }
    }
   
    public static void main (String[] args) throws java.lang.Exception
    {
        //
        int noOfVertices = 6;
        //Creating a graph with 6 vertices
        BFSGraph g = new BFSGraph(noOfVertices);
        //Adding Edges
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.addEdge(4,5);
        g.addEdge(5,4);
       
        g.bfs();   
       
    }
}
