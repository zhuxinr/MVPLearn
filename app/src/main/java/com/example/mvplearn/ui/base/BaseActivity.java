package com.example.mvplearn.ui.base;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.IdRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(intgetLayoutId());
        initViews();
    }

    protected abstract void initViews();
    protected abstract int intgetLayoutId();

    protected <T extends View> T find(@IdRes int id){
        return findViewById(id);

    }
}
