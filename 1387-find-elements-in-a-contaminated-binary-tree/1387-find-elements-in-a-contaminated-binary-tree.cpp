class FindElements {
private:
    TreeNode* root;

    void assign(TreeNode* node, int value) {
        node->val = value;
        if (node->left != NULL) assign(node->left, value * 2 + 1);
        if (node->right != NULL) assign(node->right, value * 2 + 2);
    }

    bool run(TreeNode* node, int value) {
        if (node->val == value) return true;

        if (node->left != NULL && node->right != NULL) return run(node->left, value) || run(node->right, value);
        else if (node->left != NULL) return run(node->left, value);
        else if (node->right != NULL) return run(node->right, value);

        return false;
    }

public:
    FindElements(TreeNode* root) {
        this->root = root;
        assign(this->root, 0);
    }
    
    bool find(int target) {
        return run(this->root, target);
    }
};
