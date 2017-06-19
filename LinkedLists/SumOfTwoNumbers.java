/** Program to add two numbers given two Linked Lists with the digits starting in reverse order 
i.e if the number is 295 Linked list would be 5->9->2**/

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

public class SumOfTwoNumbers
{
    //Function to remove duplicates
    public Node sumOfTwoNumbers(Node headA,Node headB)
    {
        int carry =0;
        if(headA==null && headB==null) return null;
        Node res = new Node(0);
        if(headA==null) return headB;
        else if(headB==null) return headA;
        
        res.data = headA.data+headB.data;
        if(res.data>9)
        {
            carry = res.data/10;
            res.data = res.data %10;
        }
        Node headRes =res;
        
        Node currA = headA.next;
        Node currB = headB.next;
        
        while(currA!=null || currB!=null)
        {
            if(currA!=null && currB!=null)
            {
                int sum = currA.data+currB.data+carry;
                carry=0;
                if(sum>9)
                {
                    res.next = new Node(sum%10);
                    carry = sum/10;
                }
                else res.next= new Node(sum);
            }
            
            else if(currA!=null && currB==null)
            {
                int sum = currA.data+carry;
                carry=0;
                if(sum>9)
                {
                    res.next = new Node(sum%10);
                    carry = sum/10;
                }
                else res.next= new Node(sum);
            }
            
            else if(currA==null && currB!=null)
            {
                int sum = currB.data+carry;
                carry=0;
                if(sum>9)
                {
                    res.next = new Node(sum%10);
                    carry = sum/10;
                }
                else res.next= new Node(sum);
            }
            
            if(currA!=null) currA = currA.next;
            if(currB!=null) currB = currB.next;
          	res=res.next;
        }
        
        return headRes;
        
    }
    
    //Function to print Linked List
    private static void printNodes(Node head)
    {
        while(head!=null) 
        {
            System.out.print(head.data);
            head=head.next;
        }    
    }
    
    
    public static void main (String[] args) throws java.lang.Exception
    {
      SumOfTwoNumbers s = new SumOfTwoNumbers();
      //For example purpose I have taken 2165+39 = 2204
      //But note that the number is printed in reverse order 4->0->2->2
      
      //Note: I haven't added any method to add LinkedList Nodes;
      Node n1 = new Node(5);
      Node n2 = new Node(6);
      n1.next = n2;
      Node n3 = new Node(1);
      n2.next = n3;
      Node n4 = new Node(2);
      n3.next = n4;
      Node head1= n1;
      
      Node n21 = new Node(9);
      Node n22 = new Node(3);
      n21.next = n22;
      Node head2= n21;
    
      Node res=s.sumOfTwoNumbers(head1,head2);
      //Check that output prints 1->2->4->5
      printNodes(res);
    }
    
}
   
    
