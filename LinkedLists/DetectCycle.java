/** Program to detect cycle in a linked list **/

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

public class DetectCycle
{
    //Function to detectCycle
    public boolean detectCycle(Node head)
    {
      	//Sanity Check
      	if(head == null || head.next==null) return false;
      	Node slow = head;
        Node fast = head.next;
      
      	//Run the loop till you detect a Cycle.
		while(fast.next.next!=null)
        {
        	
          	if(slow==fast)
            {
              return true;
            }
          slow = slow.next;
          fast = fast.next.next;
        }
      	return false;
        
    }
    
    
    public static void main (String[] args) throws java.lang.Exception
    {
      DetectCycle dc = new DetectCycle();
      //For example purpose I have taken 1->2->3->4->5-3
      //Output should print True
      
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
  	  n5.next = n3;
      System.out.println(dc.detectCycle(n1));
    }
    
}