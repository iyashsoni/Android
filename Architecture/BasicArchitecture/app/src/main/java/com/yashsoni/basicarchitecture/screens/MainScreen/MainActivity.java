package com.yashsoni.basicarchitecture.screens.MainScreen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.yashsoni.basicarchitecture.R;
import com.yashsoni.basicarchitecture.models.DemoResponseModel;

public class MainActivity extends AppCompatActivity implements ViewPresenterContract.View {

    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
        setListeners();

        presenter = new MainPresenter(this);
        presenter.fetchData();
    }

    private void initializeViews() {

    }

    private void setListeners() {

    }

    @Override
    public void showAnimation(boolean toShow) {

    }

    @Override
    public void updateUI(DemoResponseModel qotdModel) {

    }
}
