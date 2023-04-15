package com.example.mvplearn.network;

import java.lang.ref.Cleaner;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static volatile RetrofitClient mInstance;

    private static final String BASE_URL = "https://raw.githubusercontent.com/";
    private Retrofit retrofit;
    private RetrofitClient(){

    }
    public static RetrofitClient getInstance(){
        if(mInstance == null){
            synchronized (RetrofitClient.class){
                if (mInstance == null)
                    mInstance = new RetrofitClient();
            }
        }
        return mInstance;
    }
    public <T> T getService(Class<T> cls){
        return getRetrofit().create(cls);
    }

    private synchronized Retrofit getRetrofit() {
        if (retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                    .build();
        }

        return retrofit;
    }
}
