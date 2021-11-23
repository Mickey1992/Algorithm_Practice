package leetcode;

public class InsertIntoBinarySearchTree {

    public static void main(String[] args){
        TreeNode root = new TreeNode(4, new TreeNode(2),
                new TreeNode(7));
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);


        insertIntoBST(root, 5);
        System.out.println("end");
    }

    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        if(root.val > val) {
            root = insertIntoBSTLeaf(root, val, Integer.MIN_VALUE, root.val);
        }else{
            root = insertIntoBSTLeaf(root, val, root.val, Integer.MAX_VALUE);
        }

        return root;
    }

    public static TreeNode insertIntoBSTLeaf(TreeNode root, int val, int rootMin, int rootMax) {
        int leftMin = rootMin;
        int leftMax = root.val;
        int rightMin = root.val;
        int rightMax = rootMax;
        if(leftMin < val && val <leftMax){
            if(root.left == null) {
                root.left = new TreeNode(val);
            }else{
                insertIntoBSTLeaf(root.left, val, leftMin, leftMax);
            }
        }else if(rightMin < val && val <rightMax){
            if(root.right == null) {
                root.right = new TreeNode(val);
            }else{
                insertIntoBSTLeaf(root.right, val, rightMin, rightMax);
            }
        }
        return root;
    }

    static class TreeNode {
        int val;
        InsertIntoBinarySearchTree.TreeNode left;
        InsertIntoBinarySearchTree.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, InsertIntoBinarySearchTree.TreeNode left, InsertIntoBinarySearchTree.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
