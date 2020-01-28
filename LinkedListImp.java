package AlgorithmsAndDataStructures;


class Node {
    Node next;
   int data;

    Node(int data){
        this.data = data;
    }

}



public class LinkedListImp {
    Node head;


    public void append(int data) {
        if(head == null) {
            head = new Node(data);
            return;
        }
        Node current = head;
        while(current.next != null) {
            current = current.next;
        }
        current.next = new Node(data);
    }

    public void prepend(int data) {
        if(head == null) {
            head = new Node(data);
            return;
        }
        Node current = head;
        Node newHead = new Node(data);
        newHead.next = head;
        head = newHead;

    }

    public void deleteWithValue(int data) {
        if(head == null) {
            return;
        }
        //special case
        if(head.data == data) {
            head = head.next;
            return;
        }
        Node current = head;
        while(current.next != null) {
            current.next = current.next.next;
            return;
        }
        current = current.next;
    }
}
