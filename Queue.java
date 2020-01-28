package AlgorithmsAndDataStructures;

class Queue {
    private static class QNode {
        private int data;
        private QNode next;
        private QNode(int data) {
            this.data = data;
        }
    }
    private QNode head; // remove things from the head
    private QNode tail; // add things to the tail

    private boolean isEmpty() {
        // if head is null then the queue is empty
        return head == null;
    }
    private int peek() {
        // it will throw an exception if the head is null
        return head.data;
    }
    private void add(int data) {
        // add to the tail
        QNode qnode = new QNode(data);
        if(tail != null) {
            tail.next = qnode;
        }
        // update the tail
        tail = qnode;
        // the case when the queue is completely empty
        if(head == null) {
            head = qnode;
        }
    }
    public int remove() {
        // get the initial head data
        int data = head.data;
        // move the head's pointer over to the next node
        head = head.next;
        // and if the head is now null,
        // make sure you setup tail as null too
        if(head == null) {
            tail = null;
        }
        // and then return that data
        return data;
    }

}



