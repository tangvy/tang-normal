package com.tangv.security;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Description:
 * Author:      TangWei
 * Date:        2020/6/14 9:12 下午
 */
@RunWith(SpringRunner.class)
public class TestBCrypt {

    @Test
    public void testBCrypt() {
        String password = BCrypt.hashpw("123456", BCrypt.gensalt());
        System.out.println(password);
    }

}
