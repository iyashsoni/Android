package com.yashsoni.basicarchitecture.api;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.yashsoni.basicarchitecture.commons.AppConstants.API_URL;

/**
 * Created by yashsoni on 18/02/18.
 */

public class RetrofitHelper {

    private Retrofit createRetrofit(String baseUrl) {
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create());

        return builder.build();
    }

    public DemoAPI getDemoAPI() {
        final Retrofit retrofit = createRetrofit(API_URL);
        return retrofit.create(DemoAPI.class);
    }
}
