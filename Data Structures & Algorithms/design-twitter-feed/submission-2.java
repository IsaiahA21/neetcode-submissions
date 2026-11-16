/**
" Tweets IDs should be ordered from most recent to least recent." ->
option 1: stack of all tweets
{
[userid, tweetid]
}
- drawback, I have to search and get the 10 most recent tweets from ppl I follow.
or we can have a stack of each persons tweet and then sort the thing by time(sorting algorthim)

option 2:  heap. mostrecent (timestamp or if tweetId is increasilty we can use that). we track each
users most recent tweets. and so when we to return tweets that a user follows we combine the heaps
into 1 and return 10. con: getting top 10 recent is O(n log n)-sosrting algo

{userrid, max PriorityQueue<int[timestamp, tweetId]> } sorting algo = (a,b) -> b[0] - a[0].
pro: getting top 10 recent is O(10 * log n)


"following and unfollow " - we need to track who the person follows. the person follows them self

Map<followerid, List<followee>> userFollowering => {userid, [anyone they follow]}
*/

class Twitter {
    Map<Integer, Set<Integer>> userFollowings; //{userId, set<userIds>}
    Map<Integer, PriorityQueue<int[]>>
        usersTweets; // {userrid, maxHeap PriorityQueue<int[timestamp, tweetId]> }
    int timestamp;

    public Twitter() {
        userFollowings = new HashMap<Integer, Set<Integer>>();
        usersTweets = new HashMap<>();
        timestamp = 0;
    }

    public void postTweet(int userId, int tweetId) {
        if (!usersTweets.containsKey(userId)) {
            PriorityQueue<int[]> tweets =
                new PriorityQueue<>((a, b) -> b[0] - a[0]); // maxheap based on timestamp
            usersTweets.put(userId, tweets);
        }

        // add tweet to user maxHeap
        int[] tweet = new int[] {timestamp++, tweetId};
        PriorityQueue<int[]> userTweets = usersTweets.get(userId);
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

    public PriorityQueue<int[]> getTweets(int userId) {
        PriorityQueue<int[]> userTweets =
            usersTweets.getOrDefault(userId, new PriorityQueue<>((a, b) -> b[0] - a[0]));
        return userTweets;
    }

    public void follow(int followerId, int followeeId) {
        // Map<Integer, Set<Integer>> userFollowings; //{userId, set<userIds>}

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
