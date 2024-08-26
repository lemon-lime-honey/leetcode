class Solution {
    void traverse(Node* node, vector<int>& result) {
        if (node == NULL) return;
        for (int i = 0; i < node->children.size(); i++) {
            traverse(node->children[i], result);
        }
        result.push_back(node->val);
    }

public:
    vector<int> postorder(Node* root) {
        vector<int> result;
        traverse(root, result);
        return result;
    }
};