package com.tangv.demo.service;

import com.tangv.demo.dao.UserMapper;
import com.tangv.demo.model.User;
import com.tangv.demo.model.UserExample;
import com.tangv.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * Description:
 * Author:      TangWei
 * Date:        2020/3/6 7:03 下午
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;

    public User getUser(String username){

        User user = userRepository.findByUserName(username);
        if(user != null){
            return user;
        }
        return null;
    }
}
