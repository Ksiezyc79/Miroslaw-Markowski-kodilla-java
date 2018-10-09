package com.kodilla.testing.forumm.statics;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestForumStatics {

    @Test
    public void testCalculateAdvStaticsPostsZero() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        when(statisticsMock.postsCount()).thenReturn(0);
        ForumStatistics forumStatistics = new ForumStatistics();
        //When
        forumStatistics.calculateAdvStatics(statisticsMock);
        //Then
        Assert.assertEquals(0, forumStatistics.getNumberPosts() );
    }

    @Test
    public void testCalculateAdvStaticsPostsThousand() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        when(statisticsMock.postsCount()).thenReturn(1000);
        ForumStatistics forumStatistics = new ForumStatistics();
        //When
        forumStatistics.calculateAdvStatics(statisticsMock);
        //Then
        Assert.assertEquals(1000, forumStatistics.getNumberPosts() );
    }

    @Test
    public void testCalculateAdvStaticsCommentsZero() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        when(statisticsMock.commentsCount()).thenReturn(0);
        ForumStatistics forumStatistics = new ForumStatistics();
        //When
        forumStatistics.calculateAdvStatics(statisticsMock);
        //Then
        Assert.assertEquals(0, forumStatistics.getNumberComments());
    }

    @Test
    public void testCalculateAdvStaticsNumberCommentsLessThanNumberPosts() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        when(statisticsMock.commentsCount()).thenReturn(50);
        when(statisticsMock.postsCount()).thenReturn(100);
        ForumStatistics forumStatistics = new ForumStatistics();
        //When
        forumStatistics.calculateAdvStatics(statisticsMock);
        //Then
        Assert.assertEquals(0.5 , forumStatistics.calculateAverageNumberCommentsPerPost(), 0.5);
    }

    @Test
    public void testCalculateAdvStaticsNumberCommentsMoreThanNumberPosts() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        when(statisticsMock.commentsCount()).thenReturn(100);
        when(statisticsMock.postsCount()).thenReturn(50);
        ForumStatistics forumStatistics = new ForumStatistics();
        //When
        forumStatistics.calculateAdvStatics(statisticsMock);
        //Then
        Assert.assertEquals( 2, forumStatistics.getAverageNumberCommentsPerPost(), 1);
    }

    @Test
    public void testCalculateAdvStatisticsUsersZero() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> user = new ArrayList<>();
        when(statisticsMock.usersNames()).thenReturn(user);
        ForumStatistics forumStatistics = new ForumStatistics();
        //When
        forumStatistics.calculateAdvStatics(statisticsMock);
        //Then
        Assert.assertEquals(0, forumStatistics.getNumberUsers());
    }

    @Test
    public void testCalculateAdvStatisticsUsersHundred() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> user = new ArrayList<>();
        for(int i = 0; i<100; i++) {
            user.add("XYZ");
        }
        when(statisticsMock.usersNames()).thenReturn(user);
        ForumStatistics forumStatistics = new ForumStatistics();
        //When
        forumStatistics.calculateAdvStatics(statisticsMock);
        //Then
        Assert.assertEquals(100, forumStatistics.getNumberUsers());
    }
}



