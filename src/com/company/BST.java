package com.company;

import com.company.ds.TreeNode;
import java.util.*;

public class BST {
    // isValid BST
    public Integer findMax (Integer a, Integer b) {
        if (a == null && b == null) {
            return null;
        }
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        return Math.max(a, b);
    }
    public Integer findMin (Integer a, Integer b) {
        if (a == null && b == null) {
            return null;
        }
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        return Math.min(a, b);
    }
    public Integer findGreaterNumber(int value, TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.val >= value) {
            return root.val;
        }
        else {
            return findMax(findGreaterNumber(value, root.right), findGreaterNumber(value, root.left));
        }
    }

    public Integer findSmallerNumber(int value, TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.val <= value) {
            return root.val;
        }
        else {
            return findMin(findSmallerNumber(value, root.right), findSmallerNumber(value, root.left));
        }
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left != null && root.left.val >= root.val) {
            return false;
        }
        if (root.right!= null && root.right.val <= root.val) {
            return false;
        }
        Integer greaterNumber = findGreaterNumber(root.val, root.left);
        Integer smallerNumber = findSmallerNumber(root.val, root.right);
        if (greaterNumber != null || smallerNumber != null) {
            return false;
        }
        return isValidBST(root.left) && isValidBST(root.right);
    }

    // inorder successor
    public TreeNode findSuccessor(TreeNode root) {
        if (root.left == null) {
            return root;
        }
        return findSuccessor(root.left);
    }
    public TreeNode inorderSuccessorRec(TreeNode root, TreeNode p, TreeNode maxValue) {
        // if root's left is p then successor of p must be either root or something to the right of root
        if (root.left != null && root.left.val == p.val) {
            // if p does not have a right tree then current root is the successor
            if (root.left.right == null) {
                return root;
            } else {
                // find the minimum value in the right branch which would be the successor
                return findSuccessor(root.left.right);
            }
        }
        if (root.val == p.val) {
            if (root.right == null) {
                if (maxValue.val > p.val) {
                    return maxValue;
                } else {
                    return null;
                }
            } else {
                return findSuccessor(root.right);
            }
        }

        if (root.val > p.val) {
            return inorderSuccessorRec(root.left, p, root);
        } else {

            return inorderSuccessorRec(root.right, p, maxValue);
        }
    }
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        return inorderSuccessorRec(root, p, root);
    }

    // level order traversal : works for any binary tree
    public void levelOrderRec(TreeNode root, int level, List<List<Integer>> result) {
        if (result.size() == level) {
            result.add(level, new ArrayList<Integer>());
        }
        List <Integer> currentLevel = result.get(level);

        currentLevel.add(root.val);
        if (root.left != null) {
            levelOrderRec(root.left, level + 1, result);
        }
        if (root.right != null) {
            levelOrderRec(root.right, level + 1, result);
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>> ();
        if (root == null) {
            return result;
        }

        levelOrderRec(root, 0, result);
        return result;
    }
}