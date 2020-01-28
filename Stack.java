package AlgorithmsAndDataStructures;

public class Stack {
 public static class SNode {
     private int data;
     private SNode next;
     private SNode top;

     private SNode(int data) {
         this.data = data;
     }



 // Don't need head and the tail anymore

  public boolean isEmpty() {
      return top == null;
  }
  public int peek() {
      /*For peek() I'm gonna ignore null-pointer check for this example */
      return top.data;

  }
  public void push(int data) {
      SNode sNode = new SNode(data);
      // points over to the old top
      sNode.next = top;
      // top points to the newly inserted node
      top = sNode;
  }
  public int pop() {
      // first, get that data
      int data = top.data;
      // top's pointer moved over the next element down
      top = top.next;
      // then we just need to return that data
      return data;
  }
 }
}
