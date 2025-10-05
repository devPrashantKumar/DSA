package AZStriverPlaylist.Heap;

import java.util.*;

public class DesignTwitter {
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

        Post(int postId, int timeStamp){
            this.postId=postId;
            this.timeStamp=timeStamp;
        }
    }

    Map<Integer, Set<Integer>> followMap;
    Map<Integer, Set<Post>> userPost;
    int timeStamp=0;

    public Twitter() {
        followMap = new HashMap<>();
        userPost = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        userPost.putIfAbsent(userId, new HashSet<>());
        userPost.get(userId).add(new Post(tweetId,timeStamp++));
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<>();
        List<Post> postFeed = new ArrayList<>();
        PriorityQueue<Post> pq = new PriorityQueue<>((a,b)->b.timeStamp-a.timeStamp);
        pq.addAll(userPost.getOrDefault(Integer.valueOf(userId),new HashSet<>()));
        for (Integer followeeId : followMap.getOrDefault(userId, new HashSet<>())) {
            pq.addAll(userPost.getOrDefault(followeeId,new HashSet<>()));
        }
        int i=0;
        while(!pq.isEmpty() && i<10){
            Post post = pq.poll();
            feed.add(post.postId);
            postFeed.add(post);
            i++;
        }
        pq.addAll(postFeed);
        return feed;
    }

    public List<Integer> getNewsFeed2(int userId) {
        List<Integer> feed = new ArrayList<>();
        List<Post> postFeed = new ArrayList<>();
        
        return feed;
    }

    public void follow(int followerId, int followeeId) {
        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        followMap.getOrDefault(followerId,new HashSet<>()).remove(Integer.valueOf(followeeId));
    }
}