package org.leetcode.kth_smallest_element_in_a_bst;

public class Solution {
    int count = 0;
    int k = 0;
    int result = Integer.MAX_VALUE;
    public int kthSmallest(TreeNode root, int k) {
        count = 0;
        this.k = k;
        inorder(root);
        return result;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        count++;
        if (count == k)
            result = root.val;
        inorder(root.right);
    }


    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
