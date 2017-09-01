
import java.lang.IllegalStateException;
import java.util.*;

public class Main
{
  private int capacity;
  private int size=0;
  private int[] items;
  
  Main(int capacity)
  {
   this.capacity= capacity; 
   items = new int[capacity];
  }
  
  private int getLeftChildIndex(int parentIndex) {return (2*parentIndex+1);}
  private int getRightChildIndex(int parentIndex) {return (2*parentIndex+2);}
  private int getParentIndex(int index) {return (index-1)/2;}
  
  private boolean hasLeftChild(int index) {return getLeftChildIndex(index)<size;}
  private boolean hasRightChild(int index) {return getRightChildIndex(index)<size;}
  private boolean hasParent(int index) {return getParentIndex(index)<size;}
  
  private int leftChild(int index) {return items[getLeftChildIndex(index)];}
  private int rightChild(int index) {return items[getRightChildIndex(index)];}
  private int parent(int index) {return items[getParentIndex(index)];}
  
  private int peek()
  {
    if(size==0) throw new IllegalStateException();
    return items[0];
  }
  
  private int poll()
  {
    if(size==0) throw new IllegalStateException();
    int item = items[0];
    items[0] = items[size-1];
    size--;
    heapifyDown();
    return item;
  }
  
  private void swap(int index1, int index2)
  {
    int temp = items[index1];
    items[index1] = items[index2];
    items[index2] = temp;
  }
  
  private void ensureCapacity()
  {
    if(size==capacity)
    {
      items = Arrays.copyOf(items,capacity*2);
      capacity*=2;
    }  
  }
  
  private void add(int item)
  {
    ensureCapacity();
    items[size] = item;
    size++;
    heapifyUp();
  }
  
  private void heapifyDown()
  {
    int index= 0;
    while(hasLeftChild(index))
    {
      int smallerChildIndex = getLeftChildIndex(index);
      if(hasRightChild(index) && rightChild(index) < items[smallerChildIndex])
      {
        smallerChildIndex = getRightChildIndex(index); 
      }
      
      if(items[index] < items[smallerChildIndex])
      {
        break;
      }
      else
      {
        swap(index,smallerChildIndex);
        index = smallerChildIndex;
      }  
    }  
  }
  
  private void heapifyUp()
  {
    int index = size-1;
    while(hasParent(index) && parent(getParentIndex(index)) >items[index])
    {
      swap(index,getParentIndex(index));
      index = getParentIndex(index);  
    }  
  }  
  
  public static void main(String[] args)
  {
    Main m = new Main(6);
    m.add(4);
   	System.out.println(m.poll());
  }  
}  