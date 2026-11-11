
class Twitter {

    class Tweet {
        int tweetId;
        int timestamp;

        Tweet(int tweetId, int timestamp) {
            this.tweetId = tweetId;
            this.timestamp = timestamp;
        }
    }

    class TweetEntry {
        int userId;
        int index;
        Tweet tweet;

        TweetEntry(int userId, int index, Tweet tweet) {
            this.userId = userId;
            this.index = index;
            this.tweet = tweet;
        }
    }

    Map<Integer, Set<Integer>> following;
    Map<Integer, List<Tweet>> tweets;
    int timestamp;

    public Twitter() {
        following = new HashMap<>();
        tweets = new HashMap<>();
        timestamp = 0;
    }

    public void postTweet(int userId, int tweetId) {

        tweets.putIfAbsent(userId, new ArrayList<>());

        tweets.get(userId).add(
            new Tweet(tweetId, timestamp++)
        );
    }

    public List<Integer> getNewsFeed(int userId) {

        PriorityQueue<TweetEntry> pq =
            new PriorityQueue<>(
                (a, b) -> Integer.compare(
                    b.tweet.timestamp,
                    a.tweet.timestamp
                )
            );

        Set<Integer> users = new HashSet<>();

        users.add(userId);

        if (following.containsKey(userId)) {
            users.addAll(following.get(userId));
        }

        for (int user : users) {

            List<Tweet> list = tweets.get(user);

            if (list != null && !list.isEmpty()) {

                int index = list.size() - 1;

                pq.offer(
                    new TweetEntry(user, index, list.get(index))
                );
            }
        }

        List<Integer> result = new ArrayList<>();

        while (!pq.isEmpty() && result.size() < 10) {

            TweetEntry curr = pq.poll();

            result.add(curr.tweet.tweetId);

            int nextIndex = curr.index - 1;

            List<Tweet> list = tweets.get(curr.userId);

            if (nextIndex >= 0) {

                pq.offer(
                    new TweetEntry(
                        curr.userId,
                        nextIndex,
                        list.get(nextIndex)
                    )
                );
            }
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {

        following.putIfAbsent(
            followerId,
            new HashSet<>()
        );

        following.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {

        if (following.containsKey(followerId)) {
            following.get(followerId).remove(followeeId);
        }
    }
}
