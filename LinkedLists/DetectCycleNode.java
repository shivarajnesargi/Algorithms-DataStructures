/** Program to detect cycle in a linked list and return the node where 
the cycle begins**/

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

public class DetectCycleNode
{
    //Function to detectCycle
    public Node detectCycle(Node head)
    {
      	//Sanity Check
      	if(head == null || head.next==null) return null;
      	Node slow = head;
        Node fast = head;
      
      	//Run the loop till you detect a Cycle.
		while(fast.next!=null)
        {
          slow = slow.next;
          fast = fast.next.next;
        	
          	if(slow==fast)
            {
              break;
            }
          
        }
      	if(fast.next==null) return null;
      	
      	slow = head;
      	while(slow!=fast)
      	{
      	    slow = slow.next;
      	    fast = fast.next;
      	}
      	return slow;
        
    }
    
    
    public static void main (String[] args) throws java.lang.Exception
    {
      DetectCycleNode dc = new DetectCycleNode();
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
  	  n5.next = n4;
  	  Node res = dc.detectCycle(n1);
  	  String val = (res==null)?"No Cycle":"Cycle at: "+res.data;
      System.out.println(val);
    }
    
}