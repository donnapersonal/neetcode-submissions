class Tweet {
    private final int id;
    private final long timestamp;
    private Tweet next;
    public Tweet(int id, long timestamp) {
        this.id = id;
        this.timestamp = timestamp;
        this.next = null;
    }

    public int getId() {
        return id;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public Tweet getNext() {
        return next;
    }

    public void setNext(Tweet next) {
        this.next = next;
    }
}

class User {
    // Unique user ID.
    private final int id;
    // Points to the user's most recent tweet.
    private Tweet tweetHead;
    // Stores the IDs of users this user follows.
    private final Set<Integer> followedUserSet;

    public User(int id) {
        this.id = id;
        this.tweetHead = null;
        this.followedUserSet = new HashSet<>();
    }

    public int getId() {
        return id;
    }

    public Tweet getTweetHead() {
        return tweetHead;
    }

    public Set<Integer> getFollowedUserSet() {
        return followedUserSet;
    }

    // Adds another user's ID to the followed set.
    public void follow(User other) {
        followedUserSet.add(other.getId());
    }

    // Removes another user's ID from the followed set.
    public void unfollow(User other) {
        followedUserSet.remove(other.getId());
    }

    // Prepends the new tweet to this user's tweet list.
    public void post(Tweet tweet) {
        tweet.setNext(tweetHead);
        tweetHead = tweet;
    }

    // Two User objects are equal if their IDs are equal.
    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (!(object instanceof User)) {
            return false;
        }

        User other = (User) object;
        return this.id == other.id;
    }

    // Allows User objects to work correctly as hash keys or in sets.
    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}

class Twitter {

    // Simulates a global timestamp for all tweets.
    private long globalTime;

    // Maps user ID to User object.
    private final Map<Integer, User> idToUser;

    public Twitter() {
        globalTime = 0;
        idToUser = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        // Create the user if the user does not exist.
        idToUser.putIfAbsent(userId, new User(userId));

        User user = idToUser.get(userId);

        // Create the new tweet and prepend it to the user's tweet list.
        Tweet tweet = new Tweet(tweetId, globalTime);
        globalTime++;

        user.post(tweet);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();

        // Return an empty list if the user does not exist.
        if (!idToUser.containsKey(userId)) {
            return result;
        }

        User user = idToUser.get(userId);

        /*
         * Max-heap ordered by timestamp.
         *
         * Java's PriorityQueue is a min-heap by default, so the comparator
         * reverses the timestamp order. The newest tweet stays at the root.
         */
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>(
                (tweet1, tweet2) -> Long.compare(
                        tweet2.getTimestamp(),
                        tweet1.getTimestamp()
                )
        );

        // Add the user's own latest tweet.
        if (user.getTweetHead() != null) {
            maxHeap.offer(user.getTweetHead());
        }

        // Add every followed user's latest tweet.
        for (int followedUserId : user.getFollowedUserSet()) {
            User followedUser = idToUser.get(followedUserId);

            if (
                    followedUser != null
                    && followedUser.getTweetHead() != null
            ) {
                maxHeap.offer(followedUser.getTweetHead());
            }
        }

        /*
         * Perform a K-way merge of multiple users' tweet lists.
         * Each list is ordered from newest to oldest.
         */
        while (!maxHeap.isEmpty() && result.size() < 10) {
            Tweet newestTweet = maxHeap.poll();

            result.add(newestTweet.getId());

            // Add the next older tweet from the same user.
            if (newestTweet.getNext() != null) {
                maxHeap.offer(newestTweet.getNext());
            }
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {
        // Self-follow is unnecessary because users always see their own tweets.
        if (followerId == followeeId) {
            return;
        }

        // Ensure both users exist.
        idToUser.putIfAbsent(followerId, new User(followerId));
        idToUser.putIfAbsent(followeeId, new User(followeeId));

        User follower = idToUser.get(followerId);
        User followee = idToUser.get(followeeId);

        follower.follow(followee);
    }

    public void unfollow(int followerId, int followeeId) {
        // Self-unfollow should not affect the user's own tweets.
        if (followerId == followeeId) {
            return;
        }

        // Ignore the operation if either user does not exist.
        if (
                !idToUser.containsKey(followerId)
                || !idToUser.containsKey(followeeId)
        ) {
            return;
        }

        User follower = idToUser.get(followerId);
        User followee = idToUser.get(followeeId);

        follower.unfollow(followee);
    }
}
