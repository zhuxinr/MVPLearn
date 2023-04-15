package com.example.mvplearn.network.service;

import com.example.mvplearn.Bean.BaseBean;
import com.example.mvplearn.Bean.Goods;

import java.util.List;

import io.reactivex.rxjava3.core.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GoodsService {
    @GET("edu-lance/edu-lance.github.io/master/goods_list")
    Flowable<BaseBean<List<Goods>>> getGoods();

    @GET("edu-lance/edu-lance.github.io/master/goods_detail")
    Flowable<BaseBean<List<Goods>>> getGoodsDetail(@Query("goodsId") int goodsId);
}
