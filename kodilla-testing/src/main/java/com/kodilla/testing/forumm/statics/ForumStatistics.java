package com.kodilla.testing.forumm.statics;

public class ForumStatistics {
    private int numberUsers;
    private int numberPosts;
    private int numberComments;
    private double averageNumberPostsPerUser;
    private double numberCommentsPerUser;
    private double averageNumberCommentsPerPost;

    public int getNumberUsers() {
        return numberUsers;
    }

    public int getNumberPosts() {
        return numberPosts;
    }

    public int getNumberComments() {
        return numberComments;
    }

    public double getAverageNumberPostsPerUser() {
        return averageNumberPostsPerUser;
    }

    public double getNumberCommentsPerUser() {
        return numberCommentsPerUser;
    }

    public double getAverageNumberCommentsPerPost() {
        return averageNumberCommentsPerPost;
    }

    public void calculateAdvStatics(Statistics statistics) {
        numberUsers = statistics.usersNames().size();
        numberPosts = statistics.postsCount();
        numberComments = statistics.commentsCount();
        averageNumberPostsPerUser = calculateAverageNumberPostsPerUser();
        numberCommentsPerUser = calculateNumberCommentsPerUser();
        averageNumberCommentsPerPost = calculateAverageNumberCommentsPerPost();
    }

    public double calculateAverageNumberPostsPerUser() {
        if (numberUsers > 0) {
            return numberPosts / numberUsers;
        } else {
            return 0;
        }
    }

    public double calculateNumberCommentsPerUser() {
        if (numberUsers > 0) {
            return numberComments / numberUsers;
        } else {
            return 0;
        }
    }

    public double calculateAverageNumberCommentsPerPost() {
        if (numberComments > 0) {
            return numberComments / numberPosts;
        } else {
            return 0;
        }
    }

    public void showStatistics() {
        System.out.println("Liczba użytkowników " + numberUsers);
        System.out.println("Liczba postów " + numberPosts);
        System.out.println("Liczba komentarzy " + numberComments);
        System.out.println("Srednia liczba postów na użytkownika " + averageNumberPostsPerUser);
        System.out.println("Srednia liczba komentarzy na użytkownika " + numberCommentsPerUser);
        System.out.println("Srednia liczba komentarzy na post " + averageNumberCommentsPerPost);
    }
}