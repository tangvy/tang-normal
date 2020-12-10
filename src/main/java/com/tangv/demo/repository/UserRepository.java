package com.tangv.demo.repository;

import com.tangv.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

/**
 * Description:
 * Author:      TangWei
 * Date:        2020/3/7 10:35 上午
 */

@Repository
public interface UserRepository extends JpaRepository<User,Integer>, QuerydslPredicateExecutor<User> {

    User findByUsername(String username);
}
