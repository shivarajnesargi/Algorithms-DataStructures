import java.util.*;
import java.lang.*;
import java.io.*;

public class CoinsChange
{
    
    public int bottomUpCoinChange(int[] coins,int total)
    {
        int[] T = new int[total+1];
        int[] R = new int[total+1];
        T[0] = 0;
        for(int i=1;i<=total;i++)
        {
            T[i] = Integer.MAX_VALUE-1;
            R[i] = -1;
            
        }
        
        for(int j=0;j<coins.length;j++)
        {
            for(int i=1;i<=total;i++)
            {
                if(i>=coins[j])
                {
                    if(1+T[i-coins[j]]<T[i])
                    {
                        T[i] = 1+T[i-coins[j]];
                        R[i] = j;
                    }
                }
            }
        }
        
        printCoins(coins,R);
      	return T[total];
        
    }
  
  	public int topDownCoinChange(int total, int[] coins, Map<Integer,Integer> map)
    {
      
      if(total==0) return 0;
      if(map.containsKey(total)) return map.get(total);
      
      int min = Integer.MAX_VALUE;
      for(int i=0;i<coins.length;i++)
      {
        if(coins[i]>total)
        {
          continue;
        }
        
        int val = topDownCoinChange(total-coins[i],coins,map);
        if(val<min)
        {
          min=val;
        }
      }
      
      min= (min==Integer.MAX_VALUE)?min:min+1;
      map.put(total,min);  
      return min;
    }  
    
    public void printCoins(int[] coins,int[] R)
    {
        if(R[R.length-1]==-1)
        {
            System.out.println("No solution is possible");
            return;
        }
        int start = R.length-1;
      	System.out.println("Coins used for the total");
        while(start!=0)
        {
            int j= R[start];
            System.out.print(coins[j]+" ");
            start = start-coins[j];
        }
      System.out.println("\n");
    }
    
	public static void main (String[] args) throws java.lang.Exception
	{
		int[] coins = {7,2,3,6};
		int total =11;
      	Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		CoinsChange c = new CoinsChange();
		int minimumCoinsBottomUp=c.bottomUpCoinChange(coins,total);
      	int minimumCoinsTopDown= c.topDownCoinChange(total,coins,map);
      	System.out.println("Minimum number of coins BottomUp approach required for a total of "+total+" is "+minimumCoinsBottomUp);
      	System.out.println("Minimum number of coins in TopDown Memoization approach required for a total of "+total+" is "+minimumCoinsBottomUp);
	}
}
