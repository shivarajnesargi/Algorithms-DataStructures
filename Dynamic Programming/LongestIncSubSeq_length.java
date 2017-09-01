public class LongestIncSubSeq
  
{
 
  public int longestIncSubSeq(int[] ar)
  {
    int[] T = new int[ar.length];
    for(int i=0;i<T.length;i++)
    {
      T[i]=1;
    }
    for(int i=1;i<T.length;i++)
    {
      for(int j=0;j<=i;j++)
      {
        if(ar[i]>ar[j]) T[i] = Math.max(T[i],T[j]+1);
      }
    }
    
    return maxElement(T);
  }
  
  public int maxElement(int[] ar)
  {
    int max = ar[0];
    for(int i=1;i<ar.length;i++)
    {
      if(ar[i]>max) max =ar[i];
    }
    
    return max;
  }
  
  public static void main(String[] args)
  {
    LongestIncSubSeq lis = new LongestIncSubSeq();
    int[] arr={50, 3, 10, 7, 40, 80};
    int len = lis.longestIncSubSeq(arr);
    System.out.println(len);
  }
}  