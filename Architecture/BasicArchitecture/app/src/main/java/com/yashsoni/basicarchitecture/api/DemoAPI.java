package com.yashsoni.basicarchitecture.api;

import com.yashsoni.basicarchitecture.models.DemoResponseModel;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by yashsoni on 18/02/18.
 */

public interface DemoAPI {

    @GET("demopath/")
    Observable<DemoResponseModel> getDemoObject();
}
