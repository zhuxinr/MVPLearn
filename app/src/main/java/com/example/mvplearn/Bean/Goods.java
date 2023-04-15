/**
 * Copyright 2023 bejson.com
 */
package com.example.mvplearn.Bean;
import java.util.List;

/**
 * Auto-generated: 2023-04-10 20:54:24
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Goods {

    private int goodsId;
    private int spanSize;
    private List<String> bannners;
    private String imageUrl;
    private String text;
    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }
    public int getGoodsId() {
        return goodsId;
    }

    public void setSpanSize(int spanSize) {
        this.spanSize = spanSize;
    }
    public int getSpanSize() {
        return spanSize;
    }

    public void setBannners(List<String> bannners) {
        this.bannners = bannners;
    }
    public List<String> getBannners() {
        return bannners;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}