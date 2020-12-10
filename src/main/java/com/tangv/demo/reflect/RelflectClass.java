package com.tangv.demo.reflect;

import com.tangv.demo.model.User;

/**
 * Description:
 * Author:      TangWei
 * Date:        2020/5/8 5:44 下午
 */
public class RelflectClass {

    public static void main(String[] args) {
        try {
            Class<?> userClass = Class.forName("com.tangv.demo.model.User");
            Object userObj = userClass.newInstance();
            User user = (User) userObj;
            user.setUserId(1);
            user.setUsername("路易十三");
            System.out.println(user.getUsername()+user.getUserId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
