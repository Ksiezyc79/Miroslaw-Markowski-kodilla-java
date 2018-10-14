package com.kodilla.stream.forumuser;

import java.util.ArrayList;
import java.util.List;

public class Forum {

    private final List<ForumUser> theForumUser = new ArrayList<>();

    public Forum() {

        theForumUser.add(new ForumUser(00001, "QWE", 'M', 1979, 6, 30, 0));
        theForumUser.add(new ForumUser(00002, "ASD", 'F', 1989, 6, 30, 5));
        theForumUser.add(new ForumUser(00003, "ZXC", 'M', 1999, 6, 30, 10));
        theForumUser.add(new ForumUser(00004, "UIO", 'F', 2009, 6, 30, 15));
        theForumUser.add(new ForumUser(00005, "JKL", 'M', 2018, 6, 30, 20));
    }
    public List<ForumUser> getUserList() {
        return new ArrayList<>(theForumUser);
        }
}
