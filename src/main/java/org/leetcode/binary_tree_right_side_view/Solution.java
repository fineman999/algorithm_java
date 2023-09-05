package org.leetcode.binary_tree_right_side_view;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<Integer> result = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        preorder(root, 0);
        return result;
    }
    private void preorder(TreeNode root, int depth) {
        if (root == null) return;
        if (result.size() <= depth)
            result.add(root.val);
        else {
            result.remove(depth);
            result.add(depth, root.val);
        }
        preorder(root.left, depth + 1);
        preorder(root.right, depth + 1);
    }


    private void postorder(TreeNode root, int depth) {
        if (root == null) return;
        postorder(root.left, depth + 1);
        postorder(root.right, depth + 1);
        if (result.size() <= depth)
            result.add(root.val);
        else {
            result.remove(depth);
            result.add(depth, root.val);
        }
    }

    public class TreeNode {
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
