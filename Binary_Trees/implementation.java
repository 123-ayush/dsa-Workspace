import java.util.*;

public class implementation {
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

    public static class BinaryTree {
        static int idx = -1;

        public Node buildTree(int[] val) {
            idx++;

            if (val[idx] == -1)
                return null;

            Node newNode = new Node(val[idx]);
            newNode.left = buildTree(val);
            newNode.right = buildTree(val);

            return newNode;
        }

        public void preorder(Node root) {
            if (root == null) {
                return;
            }

            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }

        public void inorder(Node root) {
            if (root == null) {
                return;
            }

            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }

        public void postorder(Node root) {
            if (root == null) {
                return;
            }

            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }

        public void levelOrder(Node root) {
            if (root == null) {
                return;
            }

            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while (!q.isEmpty()) {
                Node top = q.remove();
                if (top == null) {
                    if (q.isEmpty()) {
                        return;
                    }
                    System.out.println();
                    q.add(top);
                    continue;
                }

                System.out.print(top.data + " ");

                if (top.left != null)
                    q.add(top.left);
                if (top.right != null)
                    q.add(top.right);
            }
        }

        public int height(Node root) {
            if (root == null) {
                return 0;
            }

            int left = height(root.left);
            int right = height(root.right);

            return 1 + Math.max(left, right);
        }

        public int countNodes(Node root) {
            if (root == null) {
                return 0;
            }

            int left = countNodes(root.left);
            int right = countNodes(root.right);

            return 1 + left + right;
        }

        public int diameter(Node root) {
            if (root == null) {
                return 0;
            }

            int ldim = diameter(root.left);
            int rdim = diameter(root.right);
            int lh = height(root.left);
            int rh = height(root.right);

            int self = 1 + lh + rh;

            return Math.max(self, Math.max(ldim, rdim));
        }

        public boolean isIdentical(Node root1, Node root2) {
            if (root1 == null && root2 == null) {
                return true;
            }

            if (root1 == null || root2 == null) {
                return false;
            }

            if (root1.data != root2.data) {
                return false;
            }

            boolean left = isIdentical(root1.left, root2.left);
            boolean right = isIdentical(root1.right, root2.right);

            return left && right;
        }

        public boolean subtree(Node root1, Node root2) {
            if (root1 == null) {
                return false;
            }

            if (root1.data == root2.data) {
                if (isIdentical(root1, root2)) {
                    return true;
                }
            }

            boolean lroot = subtree(root1.left, root2);
            boolean rroot = subtree(root1.right, root2);

            return lroot || rroot;
        }

        public void topView(Node root, Map<Integer, Node> map, int idx) {
            if (root == null) {
                return;
            }

            if (!map.containsKey(idx)) {
                map.put(idx, root);
            }

            topView(root.left, map, idx - 1);
            topView(root.right, map, idx + 1);
        }

        public void bottomView(Node root, Map<Integer, Node> map, int idx) {
            if (root == null) {
                return;
            }

            map.put(idx, root);

            bottomView(root.left, map, idx - 1);
            bottomView(root.right, map, idx + 1);
        }

        public boolean findPath(Node root, int end, List<Node> path) {
            if(root == null){
                return false;
            }
            
            path.add(root);

            if (root.data == end) {
                return true;
            }

            boolean left = findPath(root.left, end, path);
            boolean right = findPath(root.right, end, path);

            if (left || right) {
                return true;
            }

            path.remove(path.size() - 1);
            return false;
        }

        public Node lca(Node root, int n1, int n2) {
            ArrayList<Node> p1 = new ArrayList<>();
            ArrayList<Node> p2 = new ArrayList<>();

            findPath(root, n1, p1);
            findPath(root, n2, p2);

            int i = 0;
            for (; i < p1.size() - 1 && i < p2.size() - 1; i++) {
                if (p1.get(i).data != p2.get(i).data) {
                    break;
                }
            }

            return p1.get(i-1);
        }

        public void revertBT(Node root){
            if(root == null){
                return;
            }

            Node temp = root.left;
            root.left = root.right;
            root.right = temp;

            revertBT(root.left);
            revertBT(root.right);
        }
    }

    public static void main(String[] args) {
        int val[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};

        BinaryTree bt = new BinaryTree();

        Node root = bt.buildTree(val);

        bt.revertBT(root);

        bt.levelOrder(root);

        // System.out.println(bt.lca(root, 4, 6).data);

        // Map<Integer, Node> map = new TreeMap<>();

        // bt.bottomView(root, map, 0);

        // for(Node n : map.values()){
        //     System.out.print(n.data + " ");
        // }

        // Node root1 = new Node(1);
        // root1.left = new Node(2);
        // root1.right = new Node(3);
        // root1.left.left = new Node(4);
        // root1.left.right = new Node(5);
        // root1.right.left = new Node(6);
        // root1.right.right = new Node(7);

        // Node root2 = new Node(3);
        // root2.right = new Node(7);
        // root2.left = new Node(6);

        // System.out.println(bt.subtree(root1, root2));

        return;
    }
}
