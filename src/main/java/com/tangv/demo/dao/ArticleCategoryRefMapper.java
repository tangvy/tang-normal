package com.tangv.demo.dao;

import com.tangv.demo.model.ArticleCategoryRef;
import com.tangv.demo.model.ArticleCategoryRefExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArticleCategoryRefMapper {
    long countByExample(ArticleCategoryRefExample example);

    int deleteByExample(ArticleCategoryRefExample example);

    int insert(ArticleCategoryRef record);

    int insertSelective(ArticleCategoryRef record);

    List<ArticleCategoryRef> selectByExample(ArticleCategoryRefExample example);

    int updateByExampleSelective(@Param("record") ArticleCategoryRef record, @Param("example") ArticleCategoryRefExample example);

    int updateByExample(@Param("record") ArticleCategoryRef record, @Param("example") ArticleCategoryRefExample example);
}