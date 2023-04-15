package com.example.mvplearn.ui.home;

import com.example.mvplearn.Bean.BaseBean;
import com.example.mvplearn.Bean.Goods;

import java.util.List;

import io.reactivex.rxjava3.core.Flowable;

public interface HomeContract {
    interface IHomePresenter{
        void getData();
    }
    interface IHomeModel{
        Flowable<BaseBean<List<Goods>>> getData();
    }
    interface IHomeView{
        void onGoodsSucess(List<Goods> goods);
        void onGoodsError(Throwable throwable);
    }
}
