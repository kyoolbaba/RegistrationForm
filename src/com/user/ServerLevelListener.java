package com.user;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServerLevelListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("server Context level Listener initiated");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("server Context level Listener destroyed");

    }
}
