package com.tangv.demo.model;

import java.util.Date;

public class Page {
    private Integer pageId;

    private String pageKey;

    private String pageTitle;

    private Date pageCreateTime;

    private Date pageUpdateTime;

    private Integer pageViewCount;

    private Integer pageCommentCount;

    private Integer pageStatus;

    private String pageContent;

    public Page(Integer pageId, String pageKey, String pageTitle, Date pageCreateTime, Date pageUpdateTime, Integer pageViewCount, Integer pageCommentCount, Integer pageStatus, String pageContent) {
        this.pageId = pageId;
        this.pageKey = pageKey;
        this.pageTitle = pageTitle;
        this.pageCreateTime = pageCreateTime;
        this.pageUpdateTime = pageUpdateTime;
        this.pageViewCount = pageViewCount;
        this.pageCommentCount = pageCommentCount;
        this.pageStatus = pageStatus;
        this.pageContent = pageContent;
    }

    public Page() {
        super();
    }

    public Integer getPageId() {
        return pageId;
    }

    public void setPageId(Integer pageId) {
        this.pageId = pageId;
    }

    public String getPageKey() {
        return pageKey;
    }

    public void setPageKey(String pageKey) {
        this.pageKey = pageKey == null ? null : pageKey.trim();
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle == null ? null : pageTitle.trim();
    }

    public Date getPageCreateTime() {
        return pageCreateTime;
    }

    public void setPageCreateTime(Date pageCreateTime) {
        this.pageCreateTime = pageCreateTime;
    }

    public Date getPageUpdateTime() {
        return pageUpdateTime;
    }

    public void setPageUpdateTime(Date pageUpdateTime) {
        this.pageUpdateTime = pageUpdateTime;
    }

    public Integer getPageViewCount() {
        return pageViewCount;
    }

    public void setPageViewCount(Integer pageViewCount) {
        this.pageViewCount = pageViewCount;
    }

    public Integer getPageCommentCount() {
        return pageCommentCount;
    }

    public void setPageCommentCount(Integer pageCommentCount) {
        this.pageCommentCount = pageCommentCount;
    }

    public Integer getPageStatus() {
        return pageStatus;
    }

    public void setPageStatus(Integer pageStatus) {
        this.pageStatus = pageStatus;
    }

    public String getPageContent() {
        return pageContent;
    }

    public void setPageContent(String pageContent) {
        this.pageContent = pageContent == null ? null : pageContent.trim();
    }
}