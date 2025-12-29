public class binarySearchTree {
    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int val) {
            this.data = val;
            this.left = null;
            this.right = null;
        }
    }

    public static class BST {
        public Node buildBST(Node root, int val) {
            if (root == null) {
                root = new Node(val);
                return root;
            }

            if (root.data > val) {
                root.left = buildBST(root.left, val);
            } else {
                root.right = buildBST(root.right, val);
            }

            return root;
        }

        public Node searchNode(Node root, int val) {
            if (root == null) {
                return null;
            }

            if (root.data == val) {
                return root;
            } else if (root.data < val) {
                return searchNode(root.right, val);
            } else {
                return searchNode(root.left, val);
            }
        }

        public Node inorderSuccessor(Node root) {
            while (root.left != null) {
                root = root.left;
            }
            return root;
        }

        public Node delNode(Node root, int val) {
            if (root == null) {
                return null;
            }

            if (val < root.data) {
                root.left = delNode(root.left, val);
            } else if (val > root.data) {
                root.right = delNode(root.right, val);
            } else {

                if (root.left == null && root.right == null) {
                    return null;
                }

                if (root.left == null) {
                    return root.right;
                }
                if (root.right == null) {
                    return root.left;
                }

                Node inorderSucc = inorderSuccessor(root.right);
                root.data = inorderSucc.data;
                root.right = delNode(root.right, inorderSucc.data);
            }

            return root;
        }
    }

    public static void main(String[] args) {
        int val[] = { 5, 1, 3, 4, 2, 7 };
        BST bst = new BST();

        Node root = null;
        for (int i = 0; i < val.length; i++) {
            root = bst.buildBST(root, val[i]);
        }

        System.out.println(bst.searchNode(root, 1));

        return;
    }
}
