package com.divyanshu.thatfont;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by divyanshunegi on 3/1/17.
 * Project : CustomFontSample
 */

public class OpelFont extends TextView {

    private static Typeface[] mTypeface = new Typeface[3];

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


    private void init(Context context, AttributeSet attrs) {
        int typeFace;
        TypedArray ta = getTypedArray(context,attrs, R.styleable.ThatFontType);
        try {
            typeFace = ta.getInt(R.styleable.ThatFontType_android_textStyle, Typeface.NORMAL);
        } finally {
            ta.recycle();
        }

        setCustomTypeFace(context,typeFace);
    }

    private void setCustomTypeFace(Context context, int typeFace) {
        String type = "Opel_Sans_Regular.ttf";
        if (mTypeface[typeFace] == null) {
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
            mTypeface[typeFace] = Typeface.createFromAsset(context.getAssets(), type);
        }

        super.setTypeface(mTypeface[typeFace]);
    }

    protected TypedArray getTypedArray(Context context, AttributeSet attributeSet, int[] attr) {
        return context.obtainStyledAttributes(attributeSet, attr, 0, 0);
    }

}
