package com.company;

import com.company.ds.TreeNode;

public class TreeTraversal {
    public int maxDepthRec(TreeNode root, int maxDepth) {
        if (root == null) {
            return maxDepth;
        }
        maxDepth += 1;
        maxDepth = Math.max(
                maxDepthRec(root.left, maxDepth),
                maxDepthRec(root.right, maxDepth)
        );
        return maxDepth;
    }
    public int maxDepth(TreeNode root) {
        return maxDepthRec(root, 0);
    }
}
