package com.androiddev.blogger;

import java.io.Serializable;
import java.util.ArrayList;

public class PostsUsersDB implements Serializable {

    private static ArrayList<Posts> postsArrayList = new ArrayList<Posts>();
    private static ArrayList<Users> usersArrayList = new ArrayList<Users>();

    public static ArrayList<Posts> getPostsArrayList() {return postsArrayList;};
    public static ArrayList<Users> getUsersArrayList() {return usersArrayList;};


    public static void addToPostsList(Posts post ){
        postsArrayList.add(post);
    }

    public static void addToUsersList (Users user ){
        usersArrayList.add(user);
    }

    public static void setUsersArrayList (ArrayList<Users> user ){ usersArrayList = user; }

    public static void setPostsArrayList (ArrayList<Posts> post ){ postsArrayList = post; }

}
