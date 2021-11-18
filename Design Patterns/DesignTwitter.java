class Twitter {
    
    private static int timeStamp;
    private Map<Integer, User> userMap;
    
    private class Tweet{
        public int id;
        public Tweet next;
        public int time;
       
        
        public Tweet(int id){
            this.id= id;
            time= timeStamp++;
        }
    }
    
    private class User{
        public int id;
        public Set<Integer> followers;
        public Tweet tweetHead;
        
        public User(int id){
            this.id= id;
            followers= new HashSet<>();
            follow(id);
        }
        
        public void follow(int id){
            followers.add(id);
        }
        
        public void unfollow(int id){
            followers.remove(id);
        }
        
         public void post(int userId){
            Tweet t= new Tweet(userId);
            t.next= tweetHead;
             tweetHead= t;
             
        }
        
    }

    public Twitter() {
        userMap= new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        
        if(!userMap.containsKey(userId)){
            User user= new User(userId);
            userMap.put(userId, user);
        }
        userMap.get(userId).post(tweetId);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res= new LinkedList<>();
        
        if(!userMap.containsKey(userId)) return res;
        
        Set<Integer> users= userMap.get(userId).followers;
        
        PriorityQueue<Tweet> pq= new PriorityQueue<>((a, b) -> b.time - a.time);
        for(int user: users){
            Tweet t= userMap.get(user).tweetHead;
            
            if(t!= null){
                pq.add(t);
            }
        }
        
        int count=0;
        while(!pq.isEmpty() && count < 10){
            Tweet t= pq.poll();
            count++;
            res.add(t.id);
            
            if(t.next != null){
                pq.add(t.next);
            }
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        
        if(!userMap.containsKey(followerId)){
            User user= new User(followerId);
            userMap.put(followerId, user);
        }
        
        if(!userMap.containsKey(followeeId)){
            User user= new User(followeeId);
            userMap.put(followeeId, user);
        }
        
        userMap.get(followerId).follow(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId) || followerId== followeeId)
            return;
        userMap.get(followerId).unfollow(followeeId);
        
    }
}


class DesignTwitter{
	public static void main(String[] args) {
		//Design twiiter class where the user will be able to post and follow and unfollowr people and
		//when we excuete the getTWeets commands it shoudl returm the 10 latest tweets including its foolowers and itself
		["Twitter", "postTweet", "getNewsFeed", "follow", "postTweet", "getNewsFeed", "unfollow", "getNewsFeed"]
[[], [1, 5], [1], [1, 2], [2, 6], [1], [1, 2], [1]]
Output
[null, null, [5], null, null, [6, 5], null, [5]]

Explanation
Twitter twitter = new Twitter();
twitter.postTweet(1, 5); // User 1 posts a new tweet (id = 5).
twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5]. return [5]
twitter.follow(1, 2);    // User 1 follows user 2.
twitter.postTweet(2, 6); // User 2 posts a new tweet (id = 6).
twitter.getNewsFeed(1);  // User 1's news feed should return a list with 2 tweet ids -> [6, 5]. Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
twitter.unfollow(1, 2);  // User 1 unfollows user 2.
twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5], since user 1 is no longer following user 2.
	}
} 