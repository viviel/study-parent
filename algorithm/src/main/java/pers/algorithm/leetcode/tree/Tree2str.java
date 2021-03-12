package pers.algorithm.leetcode.tree;

import pers.algorithm.leetcode.tree.common.TreeNode;

/**
 * 你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
 * <p>
 * 空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 二叉树: [1,2,3,4]
 * |       1
 * |     /   \
 * |    2     3
 * |   /
 * |  4
 * <p>
 * 输出: "1(2(4))(3)"
 * <p>
 * 解释: 原本将是“1(2(4)())(3())”，
 * 在你省略所有不必要的空括号对之后，
 * 它将是“1(2(4))(3)”。
 * <p>
 * 示例 2:
 * <p>
 * 输入: 二叉树: [1,2,3,null,4]
 * |     1
 * |   /   \
 * |  2     3
 * |   \
 * |    5
 * <p>
 * 输出: "1(2()(4))(3)"
 * <p>
 * 解释: 和第一个示例相似，
 * 除了我们不能省略第一个对括号来中断输入和输出之间的一对一映射关系。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-string-from-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Tree2str {

    /**
     * Expected :1(2()(5))(3)
     * Actual   :1(2(5()))(3())
     */
    public String tree2str(TreeNode t) {
        if (null == t) {
            return "";
        }
        String r = traversal(t);
        return r.substring(1, r.length() - 1);
    }

    private String traversal(TreeNode t) {
        if (null == t) {
            return "()";
        }
        String l = traversal(t.left);
        String r = traversal(t.right);
        if (r.equals("()")) {
            r = "";
            if (l.equals("()")) {
                l = "";
            }
        }
        return "(" + t.val + l + r + ")";
    }

    public String tree2str2(TreeNode t) {
        if (null == t) {
            return "";
        }
        StringBuilder r = new StringBuilder();
        traversal2(t, r);
        return r.substring(1, r.length() - 1);
    }

    private void traversal2(TreeNode t, StringBuilder sb) {
        if (null == t) {
            sb.append("()");
            return;
        }
        sb.append("(").append(t.val);
        if (null != t.left || null != t.right) {
            traversal2(t.left, sb);
            if (null != t.right) {
                traversal2(t.right, sb);
            }
        }
        sb.append(")");
    }

    public String tree2str3(TreeNode t) {
        if (null == t) {
            return "";
        }
        StringBuilder r = new StringBuilder();
        traversal3(t, r);
        return r.toString();
    }

    private void traversal3(TreeNode t, StringBuilder sb) {
        if (null == t) {
            return;
        }
        sb.append(t.val);
        if (null != t.left || null != t.right) {
            sb.append("(");
            traversal3(t.left, sb);
            sb.append(")");
            if (null != t.right) {
                sb.append("(");
                traversal3(t.right, sb);
                sb.append(")");
            }
        }
    }
}