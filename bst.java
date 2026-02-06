import java.util.*;

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

    // Insert
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

    // Traversals
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

    // Search
    boolean search(Node root, int key) {
        if (root == null) return false;
        if (key == root.data) return true;
        if (key < root.data) return search(root.left, key);
        return search(root.right, key);
    }

    // Mirror
    void mirrorImage(Node root) {
        if (root != null) {
            Node temp = root.left;
            root.left = root.right;
            root.right = temp;
            mirrorImage(root.left);
            mirrorImage(root.right);
        }
    }

    // Copy
    Node copy(Node root) {
        if (root == null) return null;
        Node temp = new Node(root.data);
        temp.left = copy(root.left);
        temp.right = copy(root.right);
        return temp;
    }

    // Display parent with children
    void displayParentWithChildren(Node root) {
        if (root == null) return;

        if (root.left != null || root.right != null) {
            System.out.println("Parent = " + root.data);
            System.out.println("Left Child = " + 
                (root.left != null ? root.left.data : "null"));
            System.out.println("Right Child = " + 
                (root.right != null ? root.right.data : "null"));
        }

        displayParentWithChildren(root.left);
        displayParentWithChildren(root.right);
    }

    // Display leaf nodes
    void displayLeafNodes(Node root) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            System.out.println(root.data);
        }
        displayLeafNodes(root.left);
        displayLeafNodes(root.right);
    }

    // Level order traversal
    void levelOrderDisplay(Node root) {
        if (root == null) return;

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            System.out.print(temp.data + " ");

            if (temp.left != null) queue.add(temp.left);
            if (temp.right != null) queue.add(temp.right);
        }
        System.out.println();
    }

    // Delete node
    Node deleteNode(Node root, int key) {
        if (root == null) {
            System.out.println("Tree is Empty");
            return null;
        }

        Node ptr = root;
        Node parent = null;

        while (ptr != null && ptr.data != key) {
            parent = ptr;
            if (key < ptr.data) ptr = ptr.left;
            else ptr = ptr.right;
        }

        if (ptr == null) {
            System.out.println("Key Not Found");
            return root;
        }

        // Case 1 & 2: 0 or 1 child
        if (ptr.left == null || ptr.right == null) {
            Node child = (ptr.left != null) ? ptr.left : ptr.right;

            if (parent == null) return child;

            if (parent.left == ptr) parent.left = child;
            else parent.right = child;

            return root;
        }

        // Case 3: 2 children
        Node successorParent = ptr;
        Node successor = ptr.right;

        while (successor.left != null) {
            successorParent = successor;
            successor = successor.left;
        }

        ptr.data = successor.data;

        if (successorParent.left == successor)
            successorParent.left = successor.right;
        else
            successorParent.right = successor.right;

        return root;
    }
}

public class bst {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
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
            System.out.println("10. Level wise Display");
            System.out.println("11. Delete Node");
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
                    tree.inorder(tree.root);
                    System.out.println();
                    break;

                case 3:
                    tree.preorder(tree.root);
                    System.out.println();
                    break;

                case 4:
                    tree.postorder(tree.root);
                    System.out.println();
                    break;

                case 5:
                    System.out.print("Enter key to search: ");
                    value = sc.nextInt();
                    System.out.println(tree.search(tree.root, value)
                            ? "Key Found" : "Key Not Found");
                    break;

                case 6:
                    tree.mirrorImage(tree.root);
                    System.out.println("Tree Mirrored");
                    break;

                case 7:
                    tree.copy(tree.root);
                    System.out.println("Tree Copied");
                    break;

                case 8:
                    tree.displayParentWithChildren(tree.root);
                    break;

                case 9:
                    tree.displayLeafNodes(tree.root);
                    break;

                case 10:
                    tree.levelOrderDisplay(tree.root);
                    break;

                case 11:
                    System.out.print("Enter key to delete: ");
                    value = sc.nextInt();
                    tree.root = tree.deleteNode(tree.root, value);
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 0);

        sc.close();
    }
}
