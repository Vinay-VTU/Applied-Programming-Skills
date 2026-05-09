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
                    TreeNode* curr = root;
                            
                                    while (curr) {
                                                // If both nodes are greater than current, move to the right subtree
                                                            if (p->val > curr->val && q->val > curr->val) {
                                                                            curr = curr->right;
                                                                                        }
                                                                                                    // If both nodes are smaller than current, move to the left subtree
                                                                                                                else if (p->val < curr->val && q->val < curr->val) {
                                                                                                                                curr = curr->left;
                                                                                                                                            }
                                                                                                                                                        // If they split (one is left, one is right) or we hit p or q, this is the LCA
                                                                                                                                                                    else {
                                                                                                                                                                                    return curr;
                                                                                                                                                                                                }
                                                                                                                                                                                                        }
                                                                                                                                                                                                                return nullptr;
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                    };