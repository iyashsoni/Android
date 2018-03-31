package com.yashsoni.basicarchitecture.screens.MainScreen;


import com.yashsoni.basicarchitecture.models.DemoResponseModel;

/**
 * Created by yashsoni on 12/03/18.
 */

public interface ViewPresenterContract {
    interface View {
        void showAnimation(boolean toShow);
        void updateUI(DemoResponseModel qotdModel);
    }

    interface Presenter {
        void fetchData();
    }
}
