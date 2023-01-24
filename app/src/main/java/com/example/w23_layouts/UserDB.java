package com.example.w23_layouts;

import java.util.ArrayList;

public class UserDB {


    ArrayList<User> allUsers = new ArrayList<>(0);

    public void addNewUser(User user){
        allUsers.add(user);
    }


}
