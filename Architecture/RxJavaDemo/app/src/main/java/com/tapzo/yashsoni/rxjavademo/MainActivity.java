package com.tapzo.yashsoni.rxjavademo;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final LinearLayout rootView = (LinearLayout) findViewById(R.id.root_view);
        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progress_bar);

        progressBar.setVisibility(View.GONE);
        final Observable operationObservable =
                Observable.create(new Observable.OnSubscribe() {
                    @Override
                    public void call(Object o) {
                        Subscriber subscriber = (Subscriber)o;
                        subscriber.onNext(longRunningOperation());
                        subscriber.onCompleted();
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        Button startRxOperationButton = (Button) findViewById(R.id.start_btn);
        startRxOperationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                v.setEnabled(false);
                progressBar.setVisibility(View.VISIBLE);
                operationObservable.subscribe(new Subscriber() {
                    @Override
                    public void onCompleted() {
                        progressBar.setVisibility(View.GONE);
                        v.setEnabled(true);
                    }

                    @Override
                    public void onError(Throwable e) {}

                    @Override
                    public void onNext(Object o) {
                        String value = o.toString();
                        Snackbar.make(rootView, value, Snackbar.LENGTH_LONG).show();
                    }
                });
            }
        });

    }

    public String longRunningOperation() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // error
        }
        return "Complete!";
    }
}
