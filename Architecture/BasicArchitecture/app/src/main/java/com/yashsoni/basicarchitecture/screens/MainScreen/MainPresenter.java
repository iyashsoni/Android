package com.yashsoni.basicarchitecture.screens.MainScreen;

import android.util.Log;

import com.yashsoni.basicarchitecture.api.DemoAPI;
import com.yashsoni.basicarchitecture.api.RetrofitHelper;
import com.yashsoni.basicarchitecture.models.DemoResponseModel;
import com.yashsoni.basicarchitecture.screens.MainScreen.ViewPresenterContract.*;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by yashsoni on 12/03/18.
 */

public class MainPresenter implements Presenter {
    private final String TAG = MainPresenter.class.getSimpleName();

    View view;
    DemoAPI demoAPI;

    MainPresenter(View view) {
        this.view = view;
        demoAPI = new RetrofitHelper().getDemoAPI();
    }

    @Override
    public void fetchData() {
        view.showAnimation(true);
        demoAPI.getDemoObject()
                .subscribeOn(Schedulers.io()) // “work” on io thread
                .observeOn(AndroidSchedulers.mainThread()) // “listen” on UIThread;
                .subscribe(new Observer<DemoResponseModel>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DemoResponseModel demoResponseModel) {
                        view.updateUI(demoResponseModel);
                        onComplete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, e.getLocalizedMessage());
                    }

                    @Override
                    public void onComplete() {
                        view.showAnimation(false);
                    }
                });

    }
}
