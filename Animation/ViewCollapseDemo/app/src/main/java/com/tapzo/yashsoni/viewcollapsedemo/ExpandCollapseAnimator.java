package com.tapzo.yashsoni.viewcollapsedemo;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.TextView;

/**
 * Created by yashsoni on 28/08/17.
 */

class ExpandCollapseAnimator {
    private static final String TAG = "EXPAND_COLLAPSE";
    private static final String EXPANDED = "View less";
    private static final String COLLAPSED = "View more";

    View view;
    TextView infoTextView;

    ExpandCollapseAnimator(View view, TextView textView) {
        this.view = view;
        infoTextView = textView;
    }

    void toggleView(int height) {
        if (height == 0) {
            expand();
        } else {
            collapse(0);
        }
    }

    private void expand() {
        final int initialHeight = view.getHeight();

        view.measure(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        int targetHeight = view.getMeasuredHeight();

        final int distanceToExpand = targetHeight - initialHeight;

        Animation a = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                if (interpolatedTime == 1) {
                    // Do this after expanded
                }

                view.getLayoutParams().height = (int) (initialHeight + (distanceToExpand * interpolatedTime));
                view.requestLayout();
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };

        a.setDuration((long) distanceToExpand);
        view.startAnimation(a);
        setText(EXPANDED);
    }

    private void collapse(int collapsedHeight) {
        final int initialHeight = view.getMeasuredHeight();

        final int distanceToCollapse = (int) (initialHeight - collapsedHeight);

        Animation a = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                if (interpolatedTime == 1) {
                    // Do this after collapsed
                }
                view.getLayoutParams().height = (int) (initialHeight - (distanceToCollapse * interpolatedTime));
                view.requestLayout();
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };

        a.setDuration((long) distanceToCollapse);
        view.startAnimation(a);
        setText(COLLAPSED);
    }

    private void setText(String text) {
        if (infoTextView != null) {
            infoTextView.setText(text);
        }
    }
}
