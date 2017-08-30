import java.util.ArrayList;
import java.util.List;

/**
*Author:Shivraj
*Date :Aug 17, 2017
*Time :12:27:00 PM
*Place:Brooklyn,Newyork
*
*/

class Position
{
	int row;
	int col;
	public Position(int row, int col)
	{
		this.row = row;
		this.col = col;
	}
}

public class NQueens {
	
	public Position[] solveNQueensOne(int n)
	{
		Position[] pos = new Position[n];
		boolean hasSolution = solveNQueensOneUtil(n,0,pos);
		if(hasSolution) return pos;
		return new Position[0];
	}
	
	private boolean solveNQueensOneUtil(int n,int row,Position[] pos)
	{
		if(n==row) return true;
		for(int col=0;col<n;col++)
		{
			boolean foundSafe= true;
			for(int queen=0;queen<row;queen++)
			{
				if(pos[queen].col==col||pos[queen].row-pos[queen].col==row-col
						||pos[queen].row+pos[queen].col==row+col)
				{
					foundSafe=false;
					break;
				}
			}
			if(foundSafe)
			{
				pos[row] = new Position(row,col);
				if(solveNQueensOneUtil(n,row+1,pos)) return true;
			}
		}
		return false;
	}
	
	public List<List<String>> solveNQueens(int n)
	{
		Position[] pos = new Position[n];
		List<List<String>> res = new ArrayList<List<String>>();
		solveNQueensUtil(n,0,pos,res);
		return res;
	}
	
	private void solveNQueensUtil(int n,int row,Position[] pos,List<List<String>> res)
	{
		
		if(n==row)
		{
			List<String> oneRes= new ArrayList<>();
			for(Position p:pos)
			{
				StringBuffer buff =new StringBuffer();
				for(int col=0;col<n;col++)
				{
					if(p.col==col) buff.append("Q");
					else buff.append(".");
				}
				oneRes.add(buff.toString());
				buff = new StringBuffer();
			}
			res.add(oneRes);
			return;
		}
		for(int col=0;col<n;col++)
		{
			boolean foundSafe= true;
			for(int queen=0;queen<row;queen++)
			{
				if(pos[queen].col==col||pos[queen].row-pos[queen].col==row-col
						||pos[queen].row+pos[queen].col==row+col)
				{
					foundSafe=false;
					break;
				}
			}
			if(foundSafe)
			{
				pos[row] = new Position(row,col);
				solveNQueensUtil(n,row+1,pos,res);
			}
		}	
		
	}

	public static void main(String[] args)
	{
		int n=4;
		NQueens nq = new NQueens();
		Position[] res = new Position[n];
		res=nq.solveNQueensOne(n);
		for(int i=0;i<res.length;i++)
		{
			System.out.println(res[i].row+" "+res[i].col);
		}
		System.out.println("MULTIPLE SOLUTIONS");
		List<List<String>> res1 = new ArrayList<List<String>>();
		res1 = nq.solveNQueens(n);
		for(List<String> ls:res1)
		{
			for(String s:ls) System.out.println(s);
			System.out.println();
			System.out.println();
		}
	}
}
