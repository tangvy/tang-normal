package com.tangv.demo.controller;

import com.tangv.demo.dao.UserMapper;
import com.tangv.demo.model.User;
import com.tangv.demo.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Description:
 * Author:      TangWei
 * Date:        2020/2/28 5:44 下午
 */
@RestController
@RequestMapping("/test")
public class TestControlller {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @PostMapping("/test")
    public List<User> test(){
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserNicknameLike("%张%");
        return userMapper.selectByExample(userExample);
    }

    @PostMapping("/set")
    public String insertData(){
        redisTemplate.opsForValue().set("球星","詹姆斯");
        return redisTemplate.opsForValue().get("球星");
    }



    public static void main(String[] args) {

        int[] arr = {2,-6,3,-9,15,-10,8};
        int sum = 0;
        for (int i=0;i<arr.length-2;i++){
            int temp = arr[i]+arr[i+1]+arr[i+2];
            if (temp>sum){
                sum = temp;
            }
        }
        System.out.println(sum);
    }

}
