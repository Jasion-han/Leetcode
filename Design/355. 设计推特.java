#### [355. 设计推特](https://leetcode-cn.com/problems/design-twitter/) + 设计思想结合链表，哈希表，pq，list数组等

难度：Median

### 解题思路

- 结合 `OOD` 的一道题目，很值得一做，结合的东西很多，真正掌握好了就会学到很多。

### 代码

```java
class Twitter {

    private int timestamp = 0;
    private Map<Integer, User> map;
    
    class Tweet{
        public int id;
        public int time;
        public Tweet next;
        public Tweet(int id, int time) {
            this.id = id;
            this.time = time;
            next = null;
        }
    }
    
    class User{
        public int id;
        public Set<Integer> followed;
        public Tweet tweetHead;
        public User(int id) {
            this.id = id;
            followed = new HashSet<>();
            tweetHead = null;
            // 首先关注一下自己
            follow(id);
        }
        public void follow(int id) {
            followed.add(id);
        }
        public void unFollow(int id) {
            // 不可以取关自己
            if (id != this.id) {
                followed.remove(id);
            }
        }
        public void post(int id) {
            Tweet tweet = new Tweet(id, timestamp);
            timestamp++;
            // 将新建的推文插入链表头
            // 越靠前的推文 time 值越大
            tweet.next = tweetHead;
            tweetHead = tweet;
        }
    }
    
    /** Initialize your data structure here. */
    public Twitter() {
        map = new HashMap<>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        // 若 userId 不存在，则新建 userId
        if (!map.containsKey(userId)) {
            User user = new User(userId);
            map.put(userId, user);
        }
        // 对应的 userId 发布 tweetId
        map.get(userId).post(tweetId);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ans = new ArrayList<>();
        if (!map.containsKey(userId)) {
            return ans;
        }
        // 关注列表的用户 Id
        Set<Integer> users = map.get(userId).followed;
        // 自动通过 time 属性从大到小排序，容量为 users 的大小
        PriorityQueue<Tweet> pq = new PriorityQueue<>(users.size(), (a, b) -> (b.time - a.time));
        for (int user : users) {
            // 先将所有链表头节点插入优先级队列
            Tweet tweet = map.get(user).tweetHead;
            if (tweet == null) {
                continue;
            }
            pq.offer(tweet);
        }
        
        while (!pq.isEmpty()) {
            // 最多返回 10 条就够了
            if (ans.size() == 10) {
                break;
            }
            // 弹出 time 值最大的（最新发表的）
            Tweet tweet = pq.poll();
            ans.add(tweet.id);
            // 将下一篇 Tweet 插入 pq 进行排序
            if (tweet.next != null) {
                pq.offer(tweet.next);
            }
        }
        return ans;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        // 若 follower 不存在，则新建
        if (!map.containsKey(followerId)) {
            User user = new User(followerId);
            map.put(followerId, user);
        }
        // 若 followee 不存在，则新建
        if (!map.containsKey(followeeId)) {
            User user = new User(followeeId);
            map.put(followeeId, user);
        }
        map.get(followerId).follow(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (map.containsKey(followerId)) {
            User flwer = map.get(followerId);
            flwer.unFollow(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */

作者：Jasion_han
链接：https://leetcode-cn.com/problems/design-twitter/solution/355-she-ji-tui-te-she-ji-si-xiang-jie-he-lian-biao/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

