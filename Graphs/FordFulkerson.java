package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
*Author:Shivraj
*Date :Aug 25, 2017
*Time :11:15:30 AM
*Place:Brooklyn,Newyork
*
*/

public class FordFulkerson {

	public int findMaxFlow(int[][] capacity,int source,int sink)
	{
		int maxFlow=0;
		int[][] residual= new int[capacity.length][capacity[0].length];
		for(int i=0;i<capacity.length;i++)
		{
			for(int j=0;j<capacity.length;j++)
			{
				residual[i][j] = capacity[i][j];
			}
		}
		
		//Parent map for storing the parent of each node during traversal
		Map<Integer,Integer> parent = new HashMap<>();
		
		//List to store the augmented Paths
		List<List<Integer>> augmentedPaths = new ArrayList<>();
		
		while(hasPathBFS(residual,source,sink,parent))
		{
			List<Integer> augmentedPath = new ArrayList<>();
			int v = sink;
			int flow = Integer.MAX_VALUE;
			while(v!=source)
			{
				int u = parent.get(v);
				augmentedPath.add(v);
				if(flow>residual[u][v])
				{
					flow = residual[u][v];
				}
				v = u;
			}
			augmentedPath.add(source);
			Collections.reverse(augmentedPath);
			augmentedPaths.add(augmentedPath);
			maxFlow+=flow;
			
			v = sink;
			while(v!=source)
			{
				int u = parent.get(v);
				residual[u][v]-=flow;
				residual[v][u]+=flow;
				v=u;
			}
		}
		
		return maxFlow;
	}
	
	private boolean hasPathBFS(int[][] residual,int source,int sink,
			Map<Integer,Integer> parent)
	{
		boolean hasPath = false;
		Queue<Integer> queue = new LinkedList<>();
		Set<Integer> visited = new HashSet<>();
		queue.add(source);
		visited.add(source);
		while(!queue.isEmpty())
		{
			int u = queue.poll();
			for(int v=0;v<residual.length;v++)
			{
				if(!visited.contains(v)&&residual[u][v]>0)
				{
					//Add the node to queue
					queue.add(v);
					//Add the node to visited set
					visited.add(v);
					//Add the parent of v,i.e u to parentMap
					parent.put(v,u);
					
					if(v==sink) {
						hasPath=true;
						break;
					}
				}
			}
		}
		return hasPath;
	}
	
	public static void main(String[] args)
	{
		FordFulkerson ff = new FordFulkerson();
		int[][] capacity = {
				{0,3,0,3,0,0,0},
				{0,0,4,0,0,0,0},
				{0,0,0,1,2,0,0},
				{0,0,0,0,2,6,0},
				{0,0,0,0,0,0,1},
				{0,0,0,0,0,0,9},
				{0,0,0,0,0,0,0}
		};
		System.out.println("The maximum flow of the graph is: "
		+ff.findMaxFlow(capacity,0,6));
	}

}
