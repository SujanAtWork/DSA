import java.util.*;
import java.util.Queue;
import java.util.ArrayDeque;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class BST {
    Node root;

    // BST insertion
    Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }

        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }
        return root;
    }

    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    void preorder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }

    boolean search(Node root, int key) {
        if (root == null) return false;

        if (key == root.data) return true;
        else if (key < root.data) return search(root.left, key);
        else return search(root.right, key);
    }

//    void deleteNode(Node root,int key){
//        if (root == null) System.out.println("Tree is Empty");
//        Node ptr = root;
//
//    }

    void mirrorImage(Node root){
        if (root != null){
            Node temp = root.left;
            root.left = root.right;
            root.right = temp;
            mirrorImage(root.left);
            mirrorImage(root.right);
        }
    }

    Node copy(Node root){
        if (root == null){
            return null;
        }
        Node temp = new Node(root.data);
        temp.left = copy(root.left);
        temp.right = copy(root.right);
        return temp;
    }

    void displayParentWithChildren(Node root){
        if(root == null ) return;
        if(root.left != null || root.right != null){
            System.out.println("Parent = " + root.data);
            if(root.left != null){
                System.out.println("Left Child = " + root.left.data);
            } else {
                System.out.println("Left Child = null");
            }

            if(root.right != null){
                System.out.println("Right Child = " + root.right.data);
            } else {
                System.out.println("Right Child = null");
            }
        }
        displayParentWithChildren(root.left);
        displayParentWithChildren(root.right);
    }

    void displayLeafNodes(Node root){
        if (root == null) return;
        if(root.left == null && root.right == null){
            System.out.println(root.data);
        }
        displayLeafNodes(root.left);
        displayLeafNodes(root.right);
    }

    void levelOrderDisplay(Node root){
        if (root == null) return;
        queue.add(root);

        while(!queue.isEmpty()){
            Node temp = queue.poll();
            System.out.println(temp.data);
            if(temp.left != null){
                queue.add(root.left);
            }
            if(temp.right != null){
                queue.add(root.right);
            }
        }
    }
}

public class bst {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Node> queue = new ArrayDeque<>();
        BST tree = new BST();
        int choice, value;

        do {
            System.out.println("\n==== BST Menu ====");
            System.out.println("1. Insert");
            System.out.println("2. Inorder Traversal");
            System.out.println("3. Preorder Traversal");
            System.out.println("4. Postorder Traversal");
            System.out.println("5. Search");
            System.out.println("6. Mirror Tree");
            System.out.println("7. Copy Tree");
            System.out.println("8. Display Parent With Child");
            System.out.println("9. Display Leaf Node");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value: ");
                    value = sc.nextInt();
                    tree.root = tree.insert(tree.root, value);
                    break;

                case 2:
                    System.out.print("Inorder: ");
                    tree.inorder(tree.root);
                    System.out.println();
                    break;

                case 3:
                    System.out.print("Preorder: ");
                    tree.preorder(tree.root);
                    System.out.println();
                    break;

                case 4:
                    System.out.print("Postorder: ");
                    tree.postorder(tree.root);
                    System.out.println();
                    break;

                case 5:
                    System.out.print("Enter key to search: ");
                    value = sc.nextInt();
                    if (tree.search(tree.root, value))
                        System.out.println("Key found");
                    else
                        System.out.println("Key not found");
                    break;

                case 6:
                    System.out.println("Mirroring...");
                    tree.mirrorImage(tree.root);
                    break;

                case 7:
                    System.out.println("Copying...");
                    tree.copy(tree.root);
                    break;

                case 8:
                    System.out.println("Display Parent With Children");
                    tree.displayParentWithChildren(tree.root);
                    break;

                case 9:
                    System.out.println("Display Leaf Nodes...");
                    tree.displayLeafNodes(tree.root);
                    break;

                case 10:
                    System.out.println("Level Wise Display...");
                    tree.levelOrderDisplay(tree.root);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid Input! Try Again.");
            }
        } while (choice != 0);

        sc.close();
    }
}
