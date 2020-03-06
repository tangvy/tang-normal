package com.tangv.demo.model;

import java.util.Date;

public class ArticleWithBLOBs extends Article {
    private String articleContent;

    private String articleSummary;

    public ArticleWithBLOBs(Integer articleId, Integer articleUserId, String articleTitle, Integer articleViewCount, Integer articleCommentCount, Integer articleLikeCount, Integer articleIsComment, Integer articleStatus, Integer articleOrder, Date articleUpdateTime, Date articleCreateTime, String articleContent, String articleSummary) {
        super(articleId, articleUserId, articleTitle, articleViewCount, articleCommentCount, articleLikeCount, articleIsComment, articleStatus, articleOrder, articleUpdateTime, articleCreateTime);
        this.articleContent = articleContent;
        this.articleSummary = articleSummary;
    }

    public ArticleWithBLOBs() {
        super();
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent == null ? null : articleContent.trim();
    }

    public String getArticleSummary() {
        return articleSummary;
    }

    public void setArticleSummary(String articleSummary) {
        this.articleSummary = articleSummary == null ? null : articleSummary.trim();
    }
}