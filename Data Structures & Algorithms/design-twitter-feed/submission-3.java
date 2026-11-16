/**
Optimal solution: instead of sorting each user tweets, just add then.
We only need the order when building the feed.add()
*/

class Twitter {
    Map<Integer, Set<Integer>> userFollowings; //{userId, set<userIds>}
    Map<Integer, List<int[]>> usersTweets; // {userrid, maxHeap PriorityQueue<int[timestamp, tweetId]> }
    int timestamp;

    public Twitter() {
        userFollowings = new HashMap<Integer, Set<Integer>>();
        usersTweets = new HashMap<>();
        timestamp = 0;
    }

    public void postTweet(int userId, int tweetId) {
        if (!usersTweets.containsKey(userId)) {
            List<int[]> tweets =
                new ArrayList<>(); // maxheap based on timestamp
            usersTweets.put(userId, tweets);
        }

        // add tweet to user maxHeap
        int[] tweet = new int[] {timestamp++, tweetId};
        List<int[]> userTweets = usersTweets.get(userId);
        userTweets.add(tweet);
    }

    /**
    get the 10 most recent news for the user. Its based on who the user follows or can be the user
    own tweets
    */
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> allTweets = new PriorityQueue<>(
            (a, b) -> b[0] - a[0]); // maxHeap. most recent (bigger timestamp) first

        allTweets.addAll(getTweets(userId)); // get user tweets

        // get user followee tweets
        //    Map<Integer, Set<Integer>> userFollowings; //{userId, set<userIds>}
        Set<Integer> userFollows = userFollowings.getOrDefault(userId, new HashSet<>());
        if (!userFollows.isEmpty()) {
            for (Integer followeeId : userFollows) {
                allTweets.addAll(getTweets(followeeId));
            }
        }

        List<Integer> res = new ArrayList<>();
        int k = 10;
        while (!allTweets.isEmpty() && k != 0) {
            res.add(allTweets.poll()[1]);
            k--;
        }

        return res;
    }

    public List<int[]> getTweets(int userId) {
        List<int[]> userTweets =
            usersTweets.getOrDefault(userId, new ArrayList<>());
        return userTweets;
    }

    public void follow(int followerId, int followeeId) {
        // Map<Integer, Set<Integer>> userFollowings; //{userId, set<userIds>}
        if (followerId== followeeId) return; 
        
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
