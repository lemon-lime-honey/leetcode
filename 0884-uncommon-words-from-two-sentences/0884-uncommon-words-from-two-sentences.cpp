class Solution {
    vector<string> split(string ipt, char delimiter) {
        vector<string> answer;
        stringstream ss(ipt);
        string temp;

        while (getline(ss, temp, delimiter)) {
            answer.push_back(temp);
        }

        return answer;
    }

public:
    vector<string> uncommonFromSentences(string s1, string s2) {
        unordered_map<string, int> wordDict;
        vector<string> res;

        for (string word : split(s1, ' ')) {
            if (wordDict.find(word) == wordDict.end()) {
                wordDict.insert({word, 1});
            } else {
                wordDict[word] = wordDict[word] + 1;
            }
        }

        for (string word : split(s2, ' ')) {
            if (wordDict.find(word) == wordDict.end()) {
                wordDict.insert({word, 1});
            } else {
                wordDict[word] = wordDict[word] + 1;
            }
        }

        for (auto elem = wordDict.begin(); elem != wordDict.end(); elem++) {
            if (elem->second == 1) {
                res.push_back(elem->first);
            }
        }

        return res;
    }
};