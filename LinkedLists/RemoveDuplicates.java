/** Program to delete duplicates in unsorted LinkedList(with Buffer Space) **/

import java.util.HashSet;

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

public class RemoveDuplicates
{
    //Function to remove duplicates
    public Node removeDuplicates(Node head)
    {
        //Sanity Check
        if(head==null || head.next==null) return head;
        
        Node prev=null;
        Node curr =head;
        HashSet<Integer> set = new HashSet<Integer>();//Used as buffer space
        
        //Loop through the entire LinkedList
        while(curr!=null)
        {
           /**If there is duplicate point the previous Node to next of the 
           duplicate Node
           Else add that Node data to the HashSet and continue**/
           if(set.contains(curr.data))
           {
               prev.next = curr.next;
               curr= null;
               curr = prev.next; 
           }
           else
           {
               set.add(curr.data);
               prev=curr;
               curr=curr.next;
           }
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
      RemoveDuplicates rd = new RemoveDuplicates();
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
   
    
