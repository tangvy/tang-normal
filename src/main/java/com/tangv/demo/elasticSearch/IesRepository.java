package com.tangv.demo.elasticSearch;

import com.github.pagehelper.PageInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Description:
 * Author:      TangWei
 * Date:        2020/6/11 10:40 上午
 */

@Repository
public interface IesRepository extends ElasticsearchRepository<MoEsLog,String> {

    List<MoEsLog> findByMessageLike(String message);
}
