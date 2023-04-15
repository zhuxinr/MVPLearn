package com.example.mvplearn.ui.home;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.mvplearn.Bean.Goods;
import com.example.mvplearn.R;
import com.example.mvplearn.ui.base.BaseFragment;
import com.example.mvplearn.ui.home.adapter.HomeRecyclerViewAdapter;
import com.example.mvplearn.ui.home.adapter.HomeSpanSizeLookup;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener,HomeContract.IHomeView {
    private HomeRecyclerViewAdapter homeRecyclerViewAdapter;
    private HomeContract.IHomePresenter homePresenter;
    private HomeSpanSizeLookup homeSpanSizeLookup;

    @Override
    protected void initViews() {
        SwipeRefreshLayout swipeRefreshLayout = find(R.id.home_swiperefresh);
        swipeRefreshLayout.setOnRefreshListener(this);

        RecyclerView recyclerView = find(R.id.home_recyclerview);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),
                4);
        List<Goods> goods = new ArrayList<>();
        homeSpanSizeLookup = new HomeSpanSizeLookup(goods);
        gridLayoutManager.setSpanSizeLookup(homeSpanSizeLookup);
        recyclerView.setLayoutManager(gridLayoutManager);

        homeRecyclerViewAdapter =
                new HomeRecyclerViewAdapter(getActivity(),goods);
        recyclerView.setAdapter(homeRecyclerViewAdapter);

        homePresenter = new HomePresenter(this);
        homePresenter.getData();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void onRefresh() {
        homePresenter.getData();
    }

    @Override
    public void onGoodsSucess(List<Goods> goods) {
        homeSpanSizeLookup.setGoods(goods);
        homeRecyclerViewAdapter.setGoods(goods);
    }

    @Override
    public void onGoodsError(Throwable throwable) {

    }
}
