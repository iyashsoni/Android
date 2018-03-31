package com.yashsoni.basicarchitecture.widgets;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

/**
 * Created by yashsoni on 08/09/17.
 */

public class RegularTextView extends android.support.v7.widget.AppCompatTextView {
    private static final String fontPath ="fonts/quote_fonts.ttf";

    public RegularTextView(Context context) {
        super(context);
        applyCustomFont(context);
    }

    public RegularTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        applyCustomFont(context);
    }

    public RegularTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        applyCustomFont(context);
    }

    private void applyCustomFont(Context context) {
        Typeface face = Typeface.createFromAsset(context.getAssets(), fontPath);
        this.setTypeface(face);
    }
}
