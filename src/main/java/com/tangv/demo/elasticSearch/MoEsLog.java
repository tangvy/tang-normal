package com.tangv.demo.elasticSearch;

import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Id;

/**
 * Description:
 * Author:      TangWei
 * Date:        2020/6/11 10:37 上午
 */

@Document(indexName = "eslog")
public class MoEsLog {

    @Id
    private String id;

    private String message;

    private String dateTime;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
