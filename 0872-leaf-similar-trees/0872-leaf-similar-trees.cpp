class Solution {
    vector<int> seq1;
    vector<int> seq2;

    void getSequence(TreeNode* node, vector<int>&list) {
        if (node->left == NULL && node->right == NULL) {
            list.push_back(node->val);
        }
        if (node->left != NULL) {
            getSequence(node->left, list);
        }
        if (node->right != NULL) {
            getSequence(node->right, list);
        }
    }

public:
    bool leafSimilar(TreeNode* root1, TreeNode* root2) {
        getSequence(root1, seq1);
        getSequence(root2, seq2);

        return seq1 == seq2;
    }
};