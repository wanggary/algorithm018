package com.wsj.algorithm.week2.BinaryTree.No144_preorderTraversal;

import com.wsj.algorithm.week2.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树前序遍历
 * 时间复杂度：O(n), n为节点个数
 * 空间复杂度：平均情况为O(logn), 最坏情况为O(n), 即树为为单链表形式
 */
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
