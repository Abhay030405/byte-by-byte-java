public class Introduction {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static int index = -1;
    static Node buildTree(int[] arr) {
        index++;
        if (index >= arr.length || arr[index] == -1) {
            return null;
        }
        Node node = new Node(arr[index]);
        node.left = buildTree(arr);
        node.right = buildTree(arr);
        return node;
    }

    public static void inorder(Node root) {
        // Inorder traversal: Left -> Root -> Right
        if(root == null) {
            System.out.print("-1 ");
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void postorder(Node root) {
        // Postorder traversal: Left -> Right -> Root
        if(root == null) {
            System.out.print("-1 ");
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    public static void preorder(Node root) {
        // Preorder traversal: Root -> Left -> Right
        if(root == null) {
            System.out.print("-1 ");
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static int height(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static int count(Node root) {
        if (root == null) {
            return 0;
        }
        int leftCount = count(root.left);
        int rightCount = count(root.right);
        return leftCount + rightCount + 1;
    }

    public static int sum(Node root) {
        if (root == null) {
            return 0;
        }
        int leftSum = sum(root.left);
        int rightSum = sum(root.right);
        // Return the sum of the current node's data and the sums of its left and right subtrees
        return root.data + leftSum + rightSum;
    }

    public static int diameter(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        int currentDiameter = leftHeight + rightHeight + 1;

        int leftDiameter = diameter(root.left);
        int rightDiameter = diameter(root.right);

        return Math.max(currentDiameter, Math.max(leftDiameter, rightDiameter));
    }
    static class Info{
        int height;
        int diameter;

        Info(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }
    }
    public static Info optDiameter(Node root) {
        if(root==null) {
            return new Info(0,0);
        }
        Info leftInfo =  optDiameter(root.left);
        Info rightInfo = optDiameter(root.right);
        
        int height = Math.max(leftInfo.height , rightInfo.height) + 1;
        int diameter = Math.max(leftInfo.height+rightInfo.height+1 , Math.max(leftInfo.diameter , rightInfo.diameter));

        return new Info(height,diameter);
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        Node root = buildTree(arr);
        System.out.println("Binary tree constructed successfully.");
        // You can add more code here to traverse or manipulate the tree
        System.out.println("Root node data: " + root.data);  
        System.out.print("Preorder traversal of the tree: ");
        preorder(root); 
        System.out.println();
        System.out.print("Inorder traversal of the tree: ");
        inorder(root);
        System.out.println();
        System.out.print("Postorder traversal of the tree: ");
        postorder(root);
        System.out.println();
        System.out.println("Traversal completed.");
        System.out.println("Height of the tree: " + height(root));
        System.out.println("Count of nodes in the tree: " + count(root));
        System.out.println("Sum of all nodes in the tree: " + sum(root));

        System.out.println("Diameter of the tree: " + diameter(root));
        Info result = optDiameter(root);
        System.out.println("Optimized Diameter of the tree: " + result.diameter);
        System.out.println("Height of the tree: " + result.height);
    }
}