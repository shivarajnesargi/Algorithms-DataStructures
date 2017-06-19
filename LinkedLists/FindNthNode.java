/** Program to delete duplicates in unsorted LinkedList(without Buffer Space) **/

class Node
{
    public int data;
    public Node next;
    
    //Constructor to initialize LinkedList Node with data
    Node(int data)
    {
        this.data =data;
        next =null;
    }
}

public class FindNthNode
{
    //Function to remove duplicates
    public Node findNthNodeFromLast(Node head,int n)
    {
        //Sanity Check
        if(head==null || head.next==null) 
        {
            if(n==1) return head;
            return null;
        }    
        
        Node curr=head;
        int size =0;
        while(curr!=null)
        {
            size++;
            curr=curr.next;
        }
        curr = head;
        int nLast = size -n;
        //Sanity Check
        if(nLast<0) return null;
        for(int i=0;i<nLast;i++) curr=curr.next;
        return curr;
        
    }
    
    
    public static void main (String[] args) throws java.lang.Exception
    {
      FindNthNode fn = new FindNthNode();
      //For example purpose I have taken 5->4->5->3->5->4 
      
      //Note: I haven't added any method to add LinkedList Nodes;
      Node n1 = new Node(1);
      Node n2 = new Node(2);
      n1.next = n2;
      Node n3 = new Node(3);
      n2.next = n3;
      Node n4 = new Node(4);
      n3.next = n4;
      Node n5 = new Node(5);
      n4.next = n5;
      Node n6 = new Node(6);
      n5.next = n6;
      int n = 8;
      Node found = fn.findNthNodeFromLast(n1,n);
      String val = (found==null)?"Error in value of n": "The " +n+ "th Node from the last is "+found.data;
      System.out.println(val);
    }
    
}
   
    
