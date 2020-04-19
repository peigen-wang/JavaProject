package com.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;

/**
 * @author peigen
 */
@WebListener()
public class MyContentListener implements HttpSessionBindingListener {

    private String user;
    private UserInfoList container =UserInfoList.getInstance();
    // Public constructor is required by servlet spec
    public MyContentListener() {
        user="";
    }


    public void setUser(String user) {
        this.user = user;
    }

    public String getUser() {
        return user;
    }

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println("上线"+user);
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.println("下线"+user);
        container.removeUserInfo(user);
    }
}
