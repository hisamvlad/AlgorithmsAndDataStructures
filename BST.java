package AlgorithmsAndDataStructures;

class BSTNode {
    BSTNode left, right;
    int data;
    public BSTNode(int data) {
        this.data = data;
    }


public void insert(int value) {
        if(value <= data) {
            if(left == null) {
                left = new BSTNode(value);
            }
            else  {
                left.insert(value);
            }

        }  else {
            if(right == null ) {
                right = new BSTNode(value);
            } else {
                right.insert(value);
            }

        }
    }

    public boolean find(int value) {
        if(value == data) {
            return true;
        } else if(value < data) {
            // it should be on the left hand side
            // if there's no left node, then return false
            if (left == null) {
                return false;
            } else {
                return left.find(value);
            }
        } else {
            //tis on the right hand side
            if(right == null) {
                return false;
            } else {
                // go ask my right child and return its answer
                return right.find(value);
            }
        }
    }


public void traversalPrint() {
    if(left != null) {
        left.traversalPrint();
    }
    System.out.println(data);
    if(right !=null) {
        right.traversalPrint();
    }
}

}
public class BST {
}
