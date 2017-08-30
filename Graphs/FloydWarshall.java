package graph;

import javax.swing.plaf.synth.SynthSeparatorUI;

/**
*Author:Shivraj
*Date :Aug 22, 2017
*Time :8:31:26 PM
*Place:Brooklyn,Newyork
*
*/

public class FloydWarshall {
	
	
	class NegativeCycleException extends RuntimeException
	{
		
	}
	
	private static final int INF = 1000000;
	
	
	public int[][] getAllPairShortestPaths(int[][] distanceMatrix)
	{
		int[][] dist = new int[distanceMatrix.length][distanceMatrix.length];
		int[][] path = new int[dist.length][dist.length];
		
		for(int i=0;i<distanceMatrix.length;i++)
		{
			for(int j=0;j<distanceMatrix.length;j++)
			{
				dist[i][j] = distanceMatrix[i][j];
				if(distanceMatrix[i][j]!=INF && i!=j)
				{
					path[i][j]=i;
				}
				else
				{
					path[i][j]=-1;
				}
			}
		}
		
		for(int k=0;k<distanceMatrix.length;k++)
		{
			for(int i=0;i<distanceMatrix.length;i++)
			{
				for(int j=0;j<distanceMatrix.length;j++)
				{
					if(dist[i][k]==INF|| dist[k][j]==INF) continue;
					else if(dist[i][j]>dist[i][k]+dist[k][j])
					{
						dist[i][j] = dist[i][k]+dist[k][j];
						path[i][j] = path[k][j];
					}
						
				}
			}
		}
		
		//Negative Cycle Detection
		for(int i=0;i<dist.length;i++)
			if(dist[i][i]<0)
				throw new NegativeCycleException();
		return dist;
	}
	public static void main(String[] args)
	{
		FloydWarshall fw = new FloydWarshall();
		int[][] distanceMatrix ={
				{0,3,6,15},
				{INF,0,-2,INF},
				{INF,INF,0,2},
				{1,INF,INF,0},
				}; 
		int[][] res=fw.getAllPairShortestPaths(distanceMatrix);
		for(int i=0;i<res.length;i++)
		{
			for(int j=0;j<res[i].length;j++)
			{
				System.out.print(res[i][j]+" ");
			}
			System.out.println();
		}
	}
}
