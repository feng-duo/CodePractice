package com.code.basic.algorithm.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的中序遍历
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 * <p>
 * 示例 1：
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 * <p>
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：root = [1]
 * 输出：[1]
 *
 * @author FengDuo
 * @date 2024/03/14 12:21
 */
public class BinaryTreeInorderTraversal {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        traversal(root, resultList);
        return resultList;
    }


    private void traversal(TreeNode root, List<Integer> resultList) {
        if (root != null) {
            if (root.left != null) {
                traversal(root.left, resultList);
            }
            resultList.add(root.val);
            if (root.right != null) {
                traversal(root.right, resultList);
            }
        }
    }
}
