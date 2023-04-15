package com.example.mvplearn;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.mvplearn.ui.base.BaseActivity;
import com.example.mvplearn.ui.cart.CartFragment;
import com.example.mvplearn.ui.home.HomeFragment;
import com.example.mvplearn.ui.mine.MineFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends BaseActivity implements NavigationBarView.OnItemReselectedListener {

    private Fragment[] fragments;
    private int lastFragmentIndex = 0;

    @Override
    protected int intgetLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_MVPLearn);
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void initViews() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.main_buttom_navigation);
        bottomNavigationView.setOnItemReselectedListener(this);

        fragments = new Fragment[]{
                new HomeFragment(), 
                new CartFragment(),
                new MineFragment()};

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.main_frame,fragments[0])
                .commit();
    }

    @Override
    public void onNavigationItemReselected(@NonNull MenuItem item) {
        item.setCheckable(true);
        switch (item.getItemId()){
            case R.id.buttom_home:
                switchFragment(0);
                break;
            case R.id.buttom_cart:
                switchFragment(1);
                break;
            case R.id.buttom_mine:
                switchFragment(2);
                break;
        }
    }
    private void switchFragment(int to){
        if(lastFragmentIndex == to){
            return;
        }
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        if(!fragments[to].isAdded()){
            fragmentTransaction.add(R.id.main_frame,fragments[to]);
        }else {
            fragmentTransaction.show(fragments[to]);
        }
        fragmentTransaction.hide(fragments[lastFragmentIndex]).commitAllowingStateLoss();

        lastFragmentIndex = to;

    }
}