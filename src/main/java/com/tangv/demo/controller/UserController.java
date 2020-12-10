package com.tangv.demo.controller;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.tangv.demo.dao.UserMapper;
import com.tangv.demo.model.User;
import com.tangv.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
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
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public User login(@RequestBody User user,HttpServletRequest request){
        User user1 = userService.getUser(user.getUsername());
        if (user1 != null){
            if (!user.getPassword().equals(user1.getPassword())){
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

    @RequestMapping(value = "success",produces = {"text/plain;charset=UTF-8"})
    public String loginSuccess() {
        return userService.getUsername()+"登陆成功";
    }

    /*public static void main(String[] args) {
        Snowflake snowflake = IdUtil.createSnowflake(2, 4);
        System.out.println(snowflake.nextId());
    }*/


    @RequestMapping("/testSession")
    public User loginWithSession(HttpServletRequest request,HttpServletResponse response){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        User user1 = userService.getUser(user.getUsername());
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
    public String insertData(){
        redisTemplate.opsForValue().set("球星","詹姆斯");
        return redisTemplate.opsForValue().get("球星");
    }

    @RequestMapping("/index")
    public String index(){
        return "login";
    }

}
