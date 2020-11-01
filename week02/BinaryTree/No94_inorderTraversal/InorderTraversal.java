package com.wsj.algorithm.week2.BinaryTree.No94_inorderTraversal;

import com.wsj.algorithm.week2.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树中序遍历
 */
public class InorderTraversal {

    public List<Integer> traversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (null != root) {
            list.addAll(traversal(root.left));
            list.add(root.val);
            list.addAll(traversal(root.right));
        }

        return list;
    }
}
