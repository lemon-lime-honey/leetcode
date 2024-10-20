class Solution {
public:
    int findBottomLeftValue(TreeNode* root) {
        int result = 0;
        queue<TreeNode*> que;

        que.push(root);

        while (!que.empty()) {
            int n = que.size();

            for (int i = 0; i < n; i++) {
                if (i == 0) {
                    result = que.front()->val;
                }
                if (que.front()->left != NULL) {
                    que.push(que.front()->left);
                }
                if (que.front()->right != NULL) {
                    que.push(que.front()->right);
                }
                que.pop();
            }
        }

        return result;
    }
};