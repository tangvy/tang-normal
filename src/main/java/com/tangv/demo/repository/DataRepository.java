package com.tangv.demo.repository;

import com.tangv.demo.model.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

/**
 * Description:
 * Author:      TangWei
 * Date:        2020/8/10 2:53 下午
 */

@Repository
public interface DataRepository extends JpaRepository<Data,Long>, QuerydslPredicateExecutor<Data> {
}
