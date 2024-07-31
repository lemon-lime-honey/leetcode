class Twitter:
    def __init__(self):
        self.tweet = list()
        self.following = defaultdict(set)
        self.index = 0

    def postTweet(self, userId: int, tweetId: int) -> None:
        heapq.heappush(self.tweet, (self.index, tweetId, userId))
        self.index -= 1

    def getNewsFeed(self, userId: int) -> List[int]:
        result = list()
        temp = copy.deepcopy(self.tweet)

        while temp and len(result) < 10:
            index, tweetId, authorId = heapq.heappop(temp)
            if authorId == userId or authorId in self.following[userId]:
                result.append(tweetId)

        return result

    def follow(self, followerId: int, followeeId: int) -> None:
        self.following[followerId].add(followeeId)

    def unfollow(self, followerId: int, followeeId: int) -> None:
        self.following[followerId].discard(followeeId)
