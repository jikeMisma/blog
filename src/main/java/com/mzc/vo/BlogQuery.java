package com.mzc.vo;

/**
 * @author mazhicheng
 * @date 2020/5/21 - 13:35
 */
public class BlogQuery {

    private  String title;
    private  Long typeId;
    private  boolean recommened;

    public BlogQuery() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public boolean isRecommened() {
        return recommened;
    }

    public void setRecommened(boolean recommened) {
        this.recommened = recommened;
    }
}
