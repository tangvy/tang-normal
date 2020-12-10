package com.tangv.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * Description:
 * Author:      TangWei
 * Date:        2020/6/14 11:07 上午
 */

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    /*
    * 定义用户信息服务
    * */
    /*@Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("user1").password("123").authorities("p1").build());
        manager.createUser(User.withUsername("user2").password("123").authorities("p2").build());
        return manager;
    }*/

    /*
    * 密码编辑器
    * */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(HttpSecurity security) throws Exception {
        security.authorizeRequests()
                .antMatchers("/r/r1").hasAuthority("p1")
                .antMatchers("/r/r2").hasAuthority("p2")
                .antMatchers("/r/**").authenticated() //所有/r/**的请求必须认证通过
                .anyRequest().permitAll()
                .and()
                .csrf().disable() //关闭CSRF，post也能访问了
                .formLogin()
        .successForwardUrl("/success");
    }
}
