package AZStriverPlaylist.Heap;

import java.util.*;

public class DesignTwitter2 {
    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5);
        System.out.println(twitter.getNewsFeed(1));
        twitter.follow(1, 2);
        twitter.postTweet(2, 6);
        System.out.println(twitter.getNewsFeed(1));
        twitter.unfollow(1, 2);
        System.out.println(twitter.getNewsFeed(1));
    }

}

class Twitter {
    static class Post {
        int postId;
        int timeStamp;

        Post(int postId, int timeStamp) {
            this.postId = postId;
            this.timeStamp = timeStamp;
        }
    }

    static class PostFeed {
        int index;
        int userId;
        Post post;

        PostFeed(int index, int userId, Post post) {
            this.index = index;
            this.userId = userId;
            this.post = post;
        }
    }

    Map<Integer, Set<Integer>> followMap;
    Map<Integer, List<Post>> userPost;
    int timeStamp = 0;

    public Twitter() {
        followMap = new HashMap<>();
        userPost = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        userPost.putIfAbsent(userId, new ArrayList<>());
        userPost.get(userId).add(new Post(tweetId, timeStamp++));
    }

    /*
     * More Optimised
     * Time Complexity : O((k+10) log k)
     * k -> k = total number of follows of an user
     */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<>();
        PriorityQueue<PostFeed> postFeed = new PriorityQueue<>((a, b) -> b.post.timeStamp - a.post.timeStamp);
        if (userPost.containsKey(userId)) {
            List<Post> posts = userPost.get(userId);
            postFeed.offer(new PostFeed(posts.size() - 1, userId, posts.get(posts.size() - 1)));
        }

        for (Integer followeeId : followMap.getOrDefault(userId, new HashSet<>())) {
            if (userPost.containsKey(followeeId)) {
                List<Post> posts = userPost.get(followeeId);
                postFeed.offer(new PostFeed(posts.size() - 1, followeeId, posts.get(posts.size() - 1)));
            }
        }
        int i = 0;
        while (!postFeed.isEmpty() && i < 10) {
            PostFeed singlePost = postFeed.poll();
            feed.add(singlePost.post.postId);
            if(singlePost.index!=0){
                Post nextPost = userPost.get(singlePost.userId).get(singlePost.index-1);
                postFeed.offer(new PostFeed(singlePost.index-1, singlePost.userId, nextPost));
            }
            i++;
        }

        return feed;
    }

    public void follow(int followerId, int followeeId) {
        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}