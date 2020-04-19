package com.listener;

import java.util.Vector;

public class UserInfoList {
    private static UserInfoList user = new UserInfoList();
    private Vector vector = null;

    public UserInfoList() {
        this.vector = new Vector();
    }

    public static UserInfoList getInstance() {
        return user;
    }

    public boolean addUserInfo(String user) {
        if (user != null) {
            vector.add(user);
            return true;
        } else {
            return false;
        }
    }

    public Vector getlist(){
        return  vector;
    }

    public void  removeUserInfo(String user){
        if(null!=user)
        {
            vector.removeElement(user);
        }
    }
}
