package com.example.mvplearn.ui.home;

import com.example.mvplearn.Bean.BaseBean;
import com.example.mvplearn.Bean.Goods;
import com.example.mvplearn.network.RetrofitClient;
import com.example.mvplearn.network.service.GoodsService;

import java.util.List;

import io.reactivex.rxjava3.core.Flowable;

public class HomeModel implements HomeContract.IHomeModel{
    @Override
    public Flowable<BaseBean<List<Goods>>> getData() {
        return RetrofitClient.getInstance().getService(GoodsService.class)
                .getGoods();
    }
}
