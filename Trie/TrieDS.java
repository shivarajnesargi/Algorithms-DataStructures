import java.util.*;
import java.lang.*;

public class Main
{
  
  private class TrieNode
  {
    Map<Character,TrieNode> children;
    boolean endOfWord;
    
    public TrieNode()
    {
      children = new HashMap<>();
      endOfWord = false;
    }  
  }
  
  private final TrieNode root;
  
  public Main()
  {
    root = new TrieNode();
  }  
  
  public void insert(String word)
  {
    TrieNode current = root;
   	for(int i=0;i<word.length();i++)
    {
      char ch = word.charAt(i);
      TrieNode node = current.children.get(ch);
      if(node==null)
      {
        node = new TrieNode();
        current.children.put(ch,node);
      }
      current = node;
    }
    current.endOfWord = true;
  }
  
  public boolean search(String word)
  {
    TrieNode current = root;
   	for(int i=0;i<word.length();i++)
    {
      char ch = word.charAt(i);
      TrieNode node = current.children.get(ch);
      if(node==null)
      {
        return false;
      }
      current = node;
    }
    return current.endOfWord;
  } 
  
  public void delete(String word)
  {
    delete(root,word,0);
  }  
  
  private boolean delete(TrieNode current, String word,int index)
  {
    if(index==word.length())
    {
      if(!current.endOfWord) return false;
      current.endOfWord = false;
      return current.children.size()==0;
    }
    
    char ch = word.charAt(index);
    TrieNode node = current.children.get(ch);
    if(node == null)
    {
      return false;
    }
    
    boolean shouldDeleteCurrentNode = delete(node,word,index+1);
    if(shouldDeleteCurrentNode)
    {
      current.children.remove(ch);
      return current.children.size()==0;
    }  
    return false;
  } 
  
  public static void main(String[] args)
  {
    Main m = new Main();
    m.insert("abc");
    m.insert("abgl");
    m.insert("cdf");
    m.insert("abcd");
    m.insert("lmn");
    System.out.println(m.search("abc"));
    System.out.println(m.search("abgl"));
    System.out.println(m.search("cdf"));
    System.out.println(m.search("abcd"));
    System.out.println(m.search("lmo"));
    m.delete("abc");
    System.out.println(m.search("abc"));
    m.delete("a");
    
    System.out.println(m.search("abgl"));
    System.out.println(m.search("cdf"));
    System.out.println(m.search("abcd"));
    System.out.println(m.search("lmo"));
  } 
  
}
