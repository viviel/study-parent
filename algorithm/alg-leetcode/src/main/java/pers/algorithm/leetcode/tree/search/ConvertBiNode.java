package pers.algorithm.leetcode.tree.search;

import pers.algorithm.leetcode.tree.common.TreeNode;

/**
 * 二叉树数据结构TreeNode可用来表示单向链表（其中left置空，right为下一个链表节点）。
 * 实现一个方法，把二叉搜索树转换为单向链表，要求依然符合二叉搜索树的性质，转换操作应是原址的，也就是在原始的二叉搜索树上直接修改。
 * <p>
 * 返回转换后的单向链表的头节点。
 * <p>
 * 注意：本题相对原题稍作改动
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入： [4,2,5,1,3,null,6,0]
 * 输出： [0,null,1,null,2,null,3,null,4,null,5,null,6]
 * 提示：
 * <p>
 * 节点数量不会超过 100000。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binode-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class ConvertBiNode {

    TreeNode tail = new TreeNode();

    public TreeNode convertBiNode(TreeNode root) {
        TreeNode head = tail;
        traversal(root);
        return head.right;
    }

    private void traversal(TreeNode root) {
        if (null == root) {
            return;
        }
        traversal(root.left);
        tail.right = root;
        tail = tail.right;
        tail.left = null;
        traversal(root.right);
    }
}
