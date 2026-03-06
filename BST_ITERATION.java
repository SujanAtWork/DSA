import java.util.*;

class Node{
    int data;
    Node left;
    Node right;

    Node(int data){
        data = data;
        left = null;
        right = null;
    }
};

class BST{
    Node root = new Node();
    // 1. Insert Function
    Node Insert(Node root, int data){
        Node temp = new Node(data);
        if(root == null){
            return root(data);
        }
        Node current = root;
        Node parent = null;
        while(current != null){
            parent = current;
            if(data < ptr.data){
                ptr = ptr.left;
            } else if(data > ptr.data) {
                ptr = ptr.right;
            } else {
                System.out.println("Duplicate Key! Enter Valid Input");
            }
        }

        if(data < parent.data){
            parent.left = temp;
        } else {
            parent.right = temp;
        }
        return root;
    }

    //  
}

