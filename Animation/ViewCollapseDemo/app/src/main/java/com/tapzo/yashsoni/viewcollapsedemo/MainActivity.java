package com.tapzo.yashsoni.viewcollapsedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    LinearLayout collapsableViewInfo;
    LinearLayout collapsableView;
    TextView collapsableViewText;
    ImageView collapsableViewImage;
    ExpandCollapseAnimator expandCollapseAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        collapsableView = (LinearLayout) findViewById(R.id.collapsable_view);
        collapsableViewInfo = (LinearLayout) findViewById(R.id.collapsable_view_info);

        collapsableViewText = (TextView) findViewById(R.id.collapsable_view_text);
        collapsableViewImage = (ImageView) findViewById(R.id.collapsable_view_image);

        expandCollapseAnimator = new ExpandCollapseAnimator(collapsableView, collapsableViewText);

        collapsableViewInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expandCollapseAnimator.toggleView(collapsableView.getHeight());
                collapsableViewImage.setRotation(collapsableViewImage.getRotation() + 180);
            }
        });
    }
}
