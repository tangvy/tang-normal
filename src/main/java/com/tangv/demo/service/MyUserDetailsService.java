package com.tangv.demo.service;

import com.tangv.demo.model.User;
import com.tangv.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

/**
 * Description:
 * Author:      TangWei
 * Date:        2020/6/14 8:42 下午
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(s);
        if (Objects.isNull(user)) {
            return null;
        }
        UserDetails userDetails = org.springframework.security.core.userdetails.User.withUsername(user.getUsername()).password(user.getPassword()).authorities("p1").build();
        return userDetails;
    }

    public static void main(String[] args) {
        System.out.println(UUID.randomUUID().toString().replace("-","").substring(0,10));
    }
}
