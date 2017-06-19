/** Program to delete center Node given center Node but maintain the LinkedList 
structure, return Nothing **/

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

public class DeleteCenterNode
{
    //Function to remove duplicates
    public void deleteCenterNode(Node center)
    {
        //Sanity Check
        if(center==null ||center.next==null)
        {
            System.out.println("Node cannot be deleted");
        }
        else
        {
            center.data = center.next.data;
            center.next = center.next.next;
        }
        
        
    }
    
    //Function to print Linked List
    private static void printNodes(Node head)
    {
        while(head!=null) 
        {
            System.out.print(head.data+" ");
            head=head.next;
        }    
    }
    
    
    public static void main (String[] args) throws java.lang.Exception
    {
      DeleteCenterNode dc = new DeleteCenterNode();
      //For example purpose I have taken 1->2->3->4->5
      
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
      dc.deleteCenterNode(n3);
      //Check that output prints 1->2->4->5
      printNodes(n1);
    }
    
}
   
    
