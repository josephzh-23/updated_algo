package Design


/*
Her using the set it can take O(1) answer as said
Each key will then have
key:
[userId]:
value:
    {followee: tweet}   and then that's it here

    Create an arraylist of all the tweets posted, the latest will be at the end here
   to get the lateset will then iterate from the end

   The map:
   {userId: [set of userids who follows that user]}     set has add/delete O(1) operations
 */



internal class Twitter {
    internal inner class Tweet(var user: Int, var tweetId: Int)

    // the user id, and the list of followees that follow this user
    private var followings: HashMap<Int, MutableSet<Int>?> = HashMap()
    private var tweets: MutableList<Tweet> = ArrayList()

    fun postTweet(userId: Int, tweetId: Int) {
        tweets.add(Tweet(userId, tweetId))
    }

    /*
    Each item returned most be posted by users :
    1. Who follows this user
    2. Or by the user himself
It will iterate in the tweets list and checks for the userId of the that particular tweet.
if equals,
     */
    fun getNewsFeed(userId: Int): List<Int> {
        val n = tweets.size
        val ans: MutableList<Int> = ArrayList()

        // A lis of ids that the user follows
        val follows: Set<Int>? = followings[userId]

        // So we iterate from the back
        for (i in n - 1 downTo 0) {
            if (ans.size >= 10) return ans
            val t = tweets[i]
            if (t.user == userId || follows != null && follows.contains(t.user)) {
                ans.add(t.tweetId)
            }
        }
        return ans
    }

    fun follow(followerId: Int, followeeId: Int) {
        val set: MutableSet<Int>?


        if (followings.containsKey(followerId)) {
            set = followings[followerId]
        } else {
            set = HashSet()
            followings[followerId] = set
        }
        set!!.add(followeeId)
    }

    fun unfollow(followerId: Int, followeeId: Int) {
        val set = followings[followerId]
        set?.remove(followeeId)
    }
}














