package com.divyanshu.thatfont;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by divyanshunegi on 3/1/17.
 * Project : CustomFontSample
 */

public class OpelFont extends TextView {

    private Typeface mTypeface;

    public OpelFont(Context context) {
        super(context);
        init(context,null);
    }

    public OpelFont(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    public OpelFont(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public OpelFont(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context,attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        int typeFace;
        TypedArray ta = getTypedArray(context,attrs, R.styleable.ThatFontType);
        try {
            typeFace = ta.getInt(R.styleable.ThatFontType_android_textStyle, Typeface.NORMAL);
        } finally {
            ta.recycle();
        }
        setTypeFace(context,typeFace);
    }

    private void setTypeFace(Context context, int typeFace) {
        String type = "Opel_Sans_Regular.ttf";
        if (mTypeface == null) {
            switch (typeFace){
                case 0:
                     type = "Opel_Sans_Regular.ttf";
                    break;
                case 1:
                     type = "Opel_Sans_Bold.ttf";
                    break;
                case 2:
                     type = "Opel_Sans_Italic.ttf";
                    break;
            }

            mTypeface = Typeface.createFromAsset(context.getAssets(), type);
        }
        setTypeface(mTypeface);
    }

    protected TypedArray getTypedArray(Context context, AttributeSet attributeSet, int[] attr) {
        return context.obtainStyledAttributes(attributeSet, attr, 0, 0);
    }

}
