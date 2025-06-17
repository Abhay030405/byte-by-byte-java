public class Introduction {
    static class Node {
        int data;
        Node right;
        Node left;
        Node(int data) {
            this.data = data;
        }       
    }
    public static Node insert(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }
        if (val < root.data) {
            root.left = insert(root.left, val);
        } else if (val > root.data) {
            root.right = insert(root.right, val);
        }
        return root;
    }
    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    public static Node search(Node root,int val){
        if (root == null || root.data == val) {
            return root;
        }
        if (val < root.data) {
            return search(root.left, val);
        } else {
            return search(root.right, val);
        }
    }
    public static void main(String[] args) {
        int values[] = {5,1,3,4,2,7};
        Node root = null;
        for (int val : values) {
            root = insert(root, val);
        }
        System.out.println("Inorder traversal of the BST:");
        inorder(root);
        System.out.println();
        System.out.println("The root of the BST is: " + root.data);
        int searchValue = 3;
        Node foundNode = search(root, searchValue);
        if (foundNode != null) {
            System.out.println("Found value " + searchValue + " in the BST.");
        } else {
            System.out.println("Value " + searchValue + " not found in the BST.");
        }
    }
}

// BST :       5
//            / \
//           1   7
//            \ 
//             3
//            / \
//           2   4