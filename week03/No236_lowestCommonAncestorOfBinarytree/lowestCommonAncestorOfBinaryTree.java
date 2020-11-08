package com.wsj.algorithm.week3.No236_lowestCommonAncestorOfBinarytree;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 */
public class lowestCommonAncestorOfBinaryTree {
    /**
     * 时间复杂度：O(n)，所有节点只访问一次
     * 空间复杂度：O(n)，二叉树最坏情况为链式结构，高度为n
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) {
            val = x;
        }
    }

    private TreeNode ancestor = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ancestor;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        // 遍历整个二叉树
        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);

        /**
         * 两种情况：
         * 1.p，q都不是根节点，则左右子树必须包含p和q
         * 2.p或q有一个是根节点，则另一个只要在左子树或右子树即可
         */
        if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
            ancestor = root;
        }
        return lson || rson || (root.val == p.val || root.val == q.val);
    }
}
