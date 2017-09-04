public class AVLTree {
    
    private class Node {
        int data;
        int height;
        Node left;
        Node right;

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
            if (left != null && right != null)
                height = Math.max(left.height, right.height) + 1;
            else if (left != null)
                height = left.height + 1;
            else if (right != null)
                height = right.height + 1;
            else
                height = 0;
        }
    }

    Node root;
    
    public AVLTree() {

    }

    public int height() {
        return height(root);
    }
    
    private int height(Node node) {
        if (node.left == null && node.right == null) return 0;
        if (node.left == null)
            return 1 + height(node.right);
        if (node.right == null)
            return 1 + height(node.left);
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public int insert(int data) {
        root = insert(root, data);
        return data;
    }

    private Node insert(Node node, int data) {
        if (node == null) return new Node(data, null, null);
        if (data < node.data)
            return restruct(new Node(node.data, insert(node.left, data), node.right));
        else
            return restruct(new Node(node.data, node.left, insert(node.right, data)));
    }

    public int remove(int data) {
        root = remove(root, data);
        return data;
    }

    private Node remove(Node node, int data) {
        if (node == null) return node;
        if (data < node.data)
            return restruct(new Node(node.data, remove(node.left, data), node.right));
        if (data > node.data)
            return restruct(new Node(node.data, node.left, remove(node.right, data)));
        if (node.left != null && node.right != null) {
            Node min = node.right;
            while (min.left != null)
                min = min.left;
            return restruct(new Node(min.data, node.left, remove(node.right, min.data)));
        }
        if (node.left != null)
            return restruct(node.left);
        if (node.right != null)
            return restruct(node.right);
        else
            return null;
    }

    private Node restruct(Node a) {
        int rightHeight = -1;
        if (a.right != null) rightHeight = a.right.height;
        int leftHeight = -1;
        if (a.left != null) leftHeight = a.left.height;
        if (leftHeight > rightHeight + 1)
            return restructL(a, a.left);
        if (rightHeight > leftHeight + 1)
            return restructR(a, a.right);
        else
            return a;
    }

    private Node restructL(Node a, Node b) {
        // System.out.println("restructL " + a.data);
        int rightHeight = -1;
        int leftHeight = -1;
        if (b.right != null) rightHeight = b.right.height;
        if (b.left != null) leftHeight = b.left.height;
 
        if (leftHeight >= rightHeight)
            return restructureLL(a, b, b.left);
        else
            return restructureLR(a, b, b.right);
    }

    private Node restructR(Node a, Node b) {
        // System.out.println("resturctR " + a.data);
        int rightHeight = -1;
        int leftHeight = -1;
        if (b.right != null) rightHeight = b.right.height;
        if (b.left != null) leftHeight = b.left.height;
        
        if (leftHeight >= rightHeight)
            return restructureRL(a, b, b.left);
        else
            return restructureRR(a, b, b.right);
    }

    // some of these new nodes have same data/left/right as already made nodes
    // so you could just put in the original node but i like to keep the pattern

    private Node restructureLR(Node a, Node b, Node c) {
        return new Node(c.data, new Node(b.data, b.left, c.left), new Node(a.data, c.right, a.right));
    }

    private Node restructureLL(Node a, Node b, Node c) {
        return new Node(b.data, new Node(c.data, c.left, c.right), new Node(a.data, b.left, a.right));
    }

    private Node restructureRR(Node a, Node b, Node c) {
        return new Node(b.data, new Node(a.data, a.left, b.left), new Node(c.data, c.left, c.right));
    }

    private Node restructureRL(Node a, Node b, Node c) {
        return new Node(c.data, new Node(a.data, a.left, c.left), new Node(b.data, c.right, b.right));
    }
}
