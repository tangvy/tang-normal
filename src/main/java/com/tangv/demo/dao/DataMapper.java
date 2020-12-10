package com.tangv.demo.dao;

import com.tangv.demo.model.Data;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.common.special.InsertListMapper;

/**
 * Description:
 * Author:      TangWei
 * Date:        2020/8/10 2:33 下午
 */
@Mapper
public interface DataMapper extends tk.mybatis.mapper.common.Mapper<Data> , InsertListMapper<Data> {
}
