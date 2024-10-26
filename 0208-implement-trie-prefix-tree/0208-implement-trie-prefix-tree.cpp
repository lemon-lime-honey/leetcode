class TrieNode {
public:
    unordered_map<char, TrieNode*> children;
    bool last;
    char value;

    TrieNode() {
        last = false;
    }
};

class Trie {
public:
    TrieNode* root;

    Trie() {
        root = new TrieNode();
    }
    
    void insert(string word) {
        TrieNode* node = root;

        for (int i = 0; i < word.length(); i++) {
            if (node->children.find(word[i]) != node->children.end()) {
                node = node->children[word[i]];
            } else {
                TrieNode* temp = new TrieNode();
                temp->value = word[i];
                node->children[word[i]] = temp;
                node = node->children[word[i]];
            }
            if (i == word.length() - 1) {
                node->last = true;
            }
        }
    }
    
    bool search(string word) {
        TrieNode* node = root;

        for (int i = 0; i < word.length(); i++) {
            if (node->children.find(word[i]) != node->children.end()) {
                node = node->children[word[i]];
            } else {
                return false;
            }
        }

        return node->last;
    }
    
    bool startsWith(string prefix) {
        TrieNode* node = root;

        for (int i = 0; i < prefix.length(); i++) {
            if (node->children.find(prefix[i]) != node->children.end()) {
                node = node->children[prefix[i]];
            } else {
                return false;
            }
        }

        return true;
    }
};
