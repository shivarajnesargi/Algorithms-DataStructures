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

public class RDWithoutBuffer
{
    //Function to remove duplicates
    public Node removeDuplicates(Node head)
    {
        //Sanity Check
        if(head==null || head.next==null) return head;
        
        Node prev=head;
        Node curr =head.next;
        
        //Loop through the entire LinkedList
        while(curr!=null)
        {
            Node runner =head;
            while(runner!=curr)
            {
                if(runner.data==curr.data)
                {
                    prev.next = curr.next;
                    curr=prev;
                    break;
                }
                runner=runner.next;
            }
            prev =curr;
            curr=curr.next;
        }
        return head;
    }
    
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
      RDWithoutBuffer rd = new RDWithoutBuffer();
      //For example purpose I have taken 5->4->5->3->5->4 
      
      //Note: I haven't added any method to add LinkedList Nodes;
      Node n1 = new Node(5);
      Node n2 = new Node(4);
      n1.next = n2;
      Node n3 = new Node(5);
      n2.next = n3;
      Node n4 = new Node(3);
      n3.next = n4;
      Node n5 = new Node(5);
      n4.next = n5;
      Node n6 = new Node(4);
      n5.next = n6;
      Node head = rd.removeDuplicates(n1);
      printNodes(head);
    }
    
}
   
    
