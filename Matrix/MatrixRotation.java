public class Main
{
  
  public void rotateMatrix(int[][] matrix, int n,int totalLevels)
  {
    int last = n-1;
    int level = 0;
    while(level<totalLevels)
    {  
    for(int i=level;i<last;i++)
    {
      swap(matrix,level,i,i,last);
      swap(matrix,level,i,last,last-i+level);
      swap(matrix,level,i,last-i+level,level);
    }
     level++;
     last--;
    }
    printMatrix(matrix,n);
  }
  
  public void swap(int[][] matrix, int i, int j, int m, int n)
  {
    int temp = matrix[i][j];
    matrix[i][j] = matrix[m][n];
    matrix[m][n] = temp;
  }  
  
  public void printMatrix(int[][] matrix, int n)
  {
    for(int i=0; i< n;i++)
    {
      for(int j=0;j<n;j++)
      {  
       System.out.print(matrix[i][j]+" ");
      }
      System.out.println();
    }
    
  }  
  
 
  
  public static void main(String[] args)
  {
    Main m = new Main();
    int n = 10;
    int count=0;
    int level =n/2;
    int[][] matrix = new int[n][n];
    for(int i=0; i< n;i++)
    {
      for(int j=0;j<n;j++)
      {  
       matrix[i][j] = count++;
      }  
    }
    System.out.println("----------Original Matrix---------------");
    m.printMatrix(matrix,n);
    System.out.println();
    System.out.println("----------Rotated Matrix---------------");
    m.rotateMatrix(matrix,n,level);
  } 
}  