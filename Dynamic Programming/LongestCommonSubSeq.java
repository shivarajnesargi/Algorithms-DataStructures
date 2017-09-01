public class Main
{
  
public int longestCommonSubsequence(String a,String b)
{
  int[][] T = new int[a.length()+1][b.length()+1];
  for(int i=0;i<=a.length();i++)
  {
    T[i][0] = 0;
  }
  
  for(int i=0;i<=b.length();i++)
  {
    T[0][i] = 0;
  }
  
  for(int i=1;i<=a.length();i++)
  {
    for(int j=1;j<=b.length();j++)
    {
      if(a.charAt(i-1)==b.charAt(j-1)) 
      {
        T[i][j] = T[i-1][j-1]+1;
      } 
      else
      {
        T[i][j] = Math.max(T[i][j-1],T[i-1][j]);
      }  
    }  
  }
  
  return T[a.length()][b.length()];
  
}  
  
  
public static void main(String[] args)
{
  String a = "acbcf";
  String b = "abcdaf";
  Main m = new Main();
  System.out.println("The length of the longest subsequence is : "+m.longestCommonSubsequence(a,b));
  
}
  
}


 