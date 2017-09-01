public class Main
{
  
  public int calcMinEditDistance(String str1,String str2)
  {
    int[][] T = new int[str1.length()+1][str2.length()+1];
    for(int i=0;i<=str1.length();i++)
    {
      T[i][0] = i;
    }
    
    for(int j=0;j<=str2.length();j++)
    {
      T[0][j] = j;
    }
    
    for(int i=1;i<=str1.length();i++)
    {
      for(int j=1;j<=str2.length();j++)
      {
        if(str2.charAt(j-1)==str1.charAt(i-1)) T[i][j] = T[i-1][j-1];
        else
        {
          T[i][j]= Math.min(Math.min(T[i][j-1],T[i-1][j-1]),T[i-1][j])  +1;
        }  
      }
    }  
    
    printEdits(T,str1,str2);  
    return T[str1.length()][str2.length()];  
  }  
  
 public void printEdits(int[][] T,String str1, String str2)
  {
    
    int i = str1.length();
    int j = str2.length();
    
   while(true)
    {
      if(i==0||j==0) break;
     
      if(str1.charAt(i-1)==str2.charAt(j-1))
      {
        i=i-1;
        j=j-1;
      }  
    
      else if(T[i-1][j-1]+1==T[i][j])
      {
        System.out.println("Edit the char "+str1.charAt(i-1)+" in string1 to "+str2.charAt(j-1)+" in string2");
        i=i-1;
        j=j-1;
      }
     
     else if(T[i-1][j]+1==T[i][j])
      {
        System.out.println("Delete the char "+str1.charAt(i-1)+" in string1");
        i=i-1;
      }
      
      else if(T[i][j-1]+1==T[i][j])
      {
        System.out.println("Delete the char "+str2.charAt(j-1)+" in string2");
        j=j-1;
      }
         
      else
      {
        throw new IllegalArgumentException("Pass valid parameters");
      }  
      
    }  
    
  } 
  
  
  public static void main(String[] args)
  {
    Main med = new Main();
    String  a ="sunday";
    String  b ="saturday";
    int minDist= med.calcMinEditDistance(a,b);
    System.out.println("Number of edits required to change string "+a+" to string "+b+" is "+minDist);
  }
  
  
}