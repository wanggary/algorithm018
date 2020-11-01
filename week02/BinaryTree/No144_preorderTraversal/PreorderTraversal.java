package com.wsj.algorithm.week2.BinaryTree.No144_preorderTraversal;

import com.wsj.algorithm.week2.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal {

    public List<Integer> traversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (null != root) {
            list.add(root.val);
            list.addAll(traversal(root.left));
            list.addAll(traversal(root.right));
        }

        return list;
    }
}
