/**
 * Definition for a binary tree node.
  * struct TreeNode {
   * int val;
    * TreeNode *left;
     * TreeNode *right;
      * TreeNode(int x) : val(x), left(NULL), right(NULL) {}
       * };
        */
        class Solution {
        public:
            TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
                    // Base case: if root is null or matches one of the nodes
                            if (!root || root == p || root == q) {
                                        return root;
                                                }

                                                        // Look for p and q in left and right subtrees
                                                                TreeNode* left = lowestCommonAncestor(root->left, p, q);
                                                                        TreeNode* right = lowestCommonAncestor(root->right, p, q);

                                                                                // If both left and right are non-null, this node is the LCA
                                                                                        if (left && right) {
                                                                                                    return root;
                                                                                                            }

                                                                                                                    // Otherwise, return the non-null child (the one that found p or q)
                                                                                                                            return left ? left : right;
                                                                                                                                }
                                                                                                                                };