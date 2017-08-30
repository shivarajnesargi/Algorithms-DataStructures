/**
*Author:Shivraj
*Date :Aug 18, 2017
*Time :3:22:39 PM
*Place:Brooklyn,Newyork
*
*/

public class KnightTour {
	
	public void solveKnightTour(int n)
	{
		int[][] board = new int[8][8];
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				board[i][j]=-1;
		board[0][0]=0;
		//Optimal Sequence to get the solution;
		int xMove[] = {2, 1, -1, -2, -2, -1, 1, 2};
		int yMove[] = {1, 2, 2, 1, -1, -2, -2, -1};
		boolean hasSolution = solveKnightUtil(0,0,1,xMove,yMove,board);
		if(hasSolution) printBoard(board);
		else System.out.println("Doesnt't have solution");
	}
	
	private boolean solveKnightUtil(int x,int y,int moves, 
			int[] xMove,int[] yMove,int[][] board)
	{
		int n = board.length;
		if(moves==n*n) return true;
		int k,xNext,yNext;
		for(k=0;k<n;k++)
		{
			xNext = x+xMove[k];
			yNext = y+yMove[k];
			if(isValid(xNext,yNext,board))
			{
				board[xNext][yNext] = moves;
				if(solveKnightUtil(xNext,yNext,moves+1,xMove,yMove,board))
				{
					return true;
				}
				else
				{
					board[xNext][yNext]=-1;
				}
			}
		}
		return false;
	}
	
	private boolean isValid(int x,int y,int[][] board)
	{
		int n = board.length;
		return (x>=0 &&x<n &&y>=0 &&y<n&&board[x][y]==-1);
	}
	
	private void printBoard(int[][] board)
	{
		for(int i=0;i<board.length;i++)
		{
			for(int j=0;j<board.length;j++)
			{
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}	
	}
	
	public static void main(String[] args)
	{
		KnightTour k = new KnightTour();
		int n=8;
		k.solveKnightTour(n);
	}
}
