/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        // Inorder traversal gives sorted order in BST
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            // Go left as far as possible
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            // Process node
            curr = stack.pop();
            k--;
            if (k == 0) return curr.val;
            // Move to right subtree
            curr = curr.right;
        }
        return -1; // Should never happen if k is valid
    }
}
