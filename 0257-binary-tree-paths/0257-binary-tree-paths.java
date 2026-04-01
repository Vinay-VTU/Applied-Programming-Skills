import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root != null) dfs(root, "", result);
        return result;
    }

    private void dfs(TreeNode node, String path, List<String> result) {
        if (node == null) return;

        // Build path string
        String newPath = path.isEmpty() ? String.valueOf(node.val) : path + "->" + node.val;

        // Leaf check
        if (node.left == null && node.right == null) {
            result.add(newPath);
        } else {
            dfs(node.left, newPath, result);
            dfs(node.right, newPath, result);
        }
    }
}
