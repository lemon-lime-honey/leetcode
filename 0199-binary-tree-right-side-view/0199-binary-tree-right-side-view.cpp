class Solution {
public:
    vector<int> rightSideView(TreeNode* root) {
        vector<int> result;

        if (root == NULL) {
            return result;
        }

        queue<TreeNode*> que;
        que.push(root);

        while (!que.empty()) {
            int n = que.size();

            for (int i = 0; i < n; i++) {
                TreeNode* node = que.front();
                que.pop();

                if (i == 0) {
                    result.push_back(node->val);
                }
                if (node->right != NULL) {
                    que.push(node->right);
                }
                if (node->left != NULL) {
                    que.push(node->left);
                }
            }
        }

        return result;
    }
};