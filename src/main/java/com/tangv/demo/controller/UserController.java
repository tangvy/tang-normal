package com.tangv.demo.controller;

import com.tangv.demo.dao.UserMapper;
import com.tangv.demo.model.User;
import com.tangv.demo.model.UserExample;
import com.tangv.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Description:
 * Author:      TangWei
 * Date:        2020/2/28 5:44 下午
 */
@Slf4j
@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public User login(@RequestBody User user,HttpServletRequest request){
        User user1 = userService.getUser(user.getUserName());
        if (user1 != null){
            if (!user.getUserPass().equals(user1.getUserPass())){
                log.error("用户名或密码错误");
                throw new RuntimeException("用户名或密码错误");
            }
        }else{
            log.error("查无此用户");
            throw new RuntimeException("查无此用户");
        }
        HttpSession session = request.getSession();
        session.setAttribute("user",user1);
        return user1;
    }


    @RequestMapping("/testSession")
    public User loginWithSession(HttpServletRequest request,HttpServletResponse response){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        User user1 = userService.getUser(user.getUserName());
        return user1;
    }

    @RequestMapping("/loginout")
    public void loginout(HttpServletRequest request,HttpServletResponse response){
        HttpSession session = request.getSession();
        session.invalidate();
    }

    @RequestMapping("/r/r1")
    public  String didr1(){
        return "r1权限访问成功";
    }

    @RequestMapping("/r/r2")
    public String didr2(){
        return "r2权限访问成功";
    }


    @PostMapping("/set")
    public String set(){
        redisTemplate.opsForValue().set("球星","詹姆斯");
        return redisTemplate.opsForValue().get("球星");
    }

    @RequestMapping("/index")
    public String index(){
        return "login";
    }

}
