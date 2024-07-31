class Data implements Comparable<Data> {
    int index;
    int tweetId;
    int authorId;

    public Data(int index, int tweetId, int authorId) {
        this.index = index;
        this.tweetId = tweetId;
        this.authorId = authorId;
    }

    @Override
    public int compareTo(Data o) {
        if (this.index < o.index) return 1;
        else if (this.index == o.index) return 0;
        return -1;
    }
}

class Twitter {
    private PriorityQueue<Data> que;
    private Map<Integer, Set<Integer>> following;
    private int index;

    public Twitter() {
        que = new PriorityQueue<>();
        following = new HashMap<>();
        index = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        que.add(new Data(index++, tweetId, userId));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        Stack<Data> temp = new Stack<>();

        while (!que.isEmpty() && result.size() < 10) {
            int index = que.peek().index;
            int tweetId = que.peek().tweetId;
            int authorId = que.peek().authorId;
            if (authorId == userId || (following.containsKey(userId)
                    && following.get(userId).contains(authorId))) {
                result.add(tweetId);
            }
            temp.push(que.poll());
        }

        while (!temp.isEmpty()) {
            que.add(temp.pop());
        }

        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        if (!following.containsKey(followerId)) {
            following.put(followerId, new HashSet<>());
        }
        following.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (!following.containsKey(followerId)) return;
        following.get(followerId).remove(followeeId);
    }
}
