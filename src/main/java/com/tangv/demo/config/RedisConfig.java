package com.tangv.demo.config;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

/**
 * Description:
 * Author:      TangWei
 * Date:        2020/2/29 2:11 下午
 */

@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {

}
