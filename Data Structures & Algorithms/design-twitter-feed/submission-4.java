/**
Optimal solution: instead of sorting each user tweets, just add then.
We only need the order when building the feed.add()
*/

class Twitter {
    Map<Integer, Set<Integer>> userFollowings; //{userId, set<userIds>}
    Map<Integer, List<int[]>>
        usersTweets; // {userrid, maxHeap PriorityQueue<int[timestamp, tweetId]> }
    int timestamp;

    public Twitter() {
        userFollowings = new HashMap<Integer, Set<Integer>>();
        usersTweets = new HashMap<>();
        timestamp = 0;
    }

    public void postTweet(int userId, int tweetId) {
        if (!usersTweets.containsKey(userId)) {
            List<int[]> tweets = new ArrayList<>(); // maxheap based on timestamp
            usersTweets.put(userId, tweets);
        }

        // add tweet to user maxHeap
        int[] tweet = new int[] {timestamp++, tweetId};
        List<int[]> userTweets = usersTweets.get(userId);
        userTweets.add(tweet);
    }

    /**
    use k-way merge technique
    */
    public List<Integer> getNewsFeed(int userId) {
        // maxHeap. most recent (bigger timestamp) first
        // int[timestamp, tweetId, userId, userTweetsIndex]
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        // Everyone the user follows
        Set<Integer> followees = userFollowings.getOrDefault(userId, new HashSet<>());
        followees.add(userId); // include the user aswell

        // add only the lastest tweet from ueach followe to the heap as candidates for the user feed
        // of 10
        //  if (!followees.isEmpty()) {
        for (int followeeId : followees) {
            List<int[]> tweets = getTweets(followeeId); // [timestamp, tweetid]

            // ignore users who dont have tweets
            if (tweets.isEmpty()) {
                continue;
            }

            // get index of this user latest tweet
            int userTweetsIndex = tweets.size() - 1;

            int[] tweet = tweets.get(userTweetsIndex);

            maxHeap.add(new int[] {tweet[0], tweet[1], followeeId, userTweetsIndex});
        }
        // }
        /**return lastest 10 tweets **/
        List<Integer> res = new ArrayList<>();

        while (!maxHeap.isEmpty() && res.size() < 10) {
            /* take the the most latest tweet and add to the res */
            int[] currTweet = maxHeap.poll(); // [timestamp, tweetId, userId, userTweetsIndex]

            res.add(currTweet[1]);

            int user = currTweet[2];

            // add that user other tweet to the maxHeap
            int index = --currTweet[3];

            if (index >= 0) {
                int[] tweet = getTweets(user).get(index); //[timestamp, tweetid]

                // add to the heap so it can compete with the other user's tweets
                maxHeap.add(new int[] {tweet[0], tweet[1], user, index});
            }
        }

        return res;
    }

    public List<int[]> getTweets(int userId) {
        List<int[]> userTweets = usersTweets.getOrDefault(userId, new ArrayList<>());
        return userTweets;
    }

    public void follow(int followerId, int followeeId) {
        // Map<Integer, Set<Integer>> userFollowings; //{userId, set<userIds>}
        if (followerId == followeeId)
            return;

        if (!userFollowings.containsKey(followerId)) {
            Set<Integer> userFollowees = new HashSet<>();
            userFollowings.put(followerId, userFollowees);
        }
        Set<Integer> userFollows = userFollowings.get(followerId);
        userFollows.add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        // check if the followerId is not in the map
        if (!userFollowings.containsKey(followerId)) {
            return;
        }

        // check if the user follows that person
        Set<Integer> userFollows = userFollowings.get(followerId);
        if (!userFollows.contains(followeeId)) {
            return;
        }

        userFollows.remove(followeeId);
    }
}
