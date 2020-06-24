package com.user;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class ServletReqListener implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        System.out.println("ServletRequestListener Destroyed");
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        System.out.println("ServletRequestListener Initialised");

    }
}
