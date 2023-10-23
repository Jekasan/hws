package hw11;

public class hw11p2 {
    public static class SortedArrayToBST {
        public Node convert(int[] arrA, int start, int end) {
            if (start > end) {
                return null;
            }
            int mid = (start + end) / 2;
            Node root = new Node(arrA[mid]);
            root.left = convert(arrA, start, mid - 1);
            root.right = convert(arrA, mid + 1, end);
            return root;
        }
        static class Node {
            int data;
            Node left;
            Node right;

            public Node(int data) {
                this.data = data;
                left = null;
                right = null;
            }
        }

        public void displayTree(Node root) {
            if (root != null) {
                displayTree(root.left);
                System.out.print(" " + root.data);
                displayTree(root.right);
            }
        }

        Node insert(Node node, int key) {
            if (node == null) {
                node = new Node(key);
                return node;
            }

            if (key < node.data)
                node.left = insert(node.left, key);
            else if (key > node.data)
                node.right = insert(node.right, key);
            return node;
        }
        Node search(Node root, int key) {
            if (root == null || root.data == key)
                return root;

            if (root.data < key)
                return search(root.right, key);
            return search(root.left, key);
        }

    }

    public static void main(String args[]) {
        int[] arrA = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        SortedArrayToBST tree = new SortedArrayToBST();
        SortedArrayToBST.Node x = tree.convert(arrA, 0, arrA.length - 1);
        System.out.print("Двоичное дерево: ");
        tree.displayTree(x);
        System.out.println();

        x.data = 4;
        if (tree.search(x, x.data) == null)
            System.out.println(x.data + " not found");
        else
            System.out.println(x.data + " found");

        tree.insert(x, 0);

        System.out.print("Двоичное дерево: ");
        tree.displayTree(x);
    }
}
