package com.divyanshu.thatfont;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatAutoCompleteTextView;
import android.util.AttributeSet;

/**
 * Created by divyanshunegi on 3/1/17.
 * Project : CustomFontSample
 */

public class AutoCompleteOpelFont extends AppCompatAutoCompleteTextView {

    private static Typeface[] mTypeface = new Typeface[3];

    public AutoCompleteOpelFont(Context context) {
        super(context);
        init(context,null);
    }

    public AutoCompleteOpelFont(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    public AutoCompleteOpelFont(Context context, AttributeSet attrs, int defStyleAttr) {
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
//            mTypeface[typeFace] = Typeface.createFromAsset(context.getAssets(), type);
            mTypeface[typeFace] = FontCache.getFont(context,type);
        }
        super.setTypeface(mTypeface[typeFace]);
    }

//    @Override
//    public void setTypeface(Typeface tf, int style) {
//        if (!this.isInEditMode()) {
//            if (style == Typeface.NORMAL) {
//                super.setTypeface(FontCache.getFont(getContext(), "Opel_Sans_Regular.ttf"));
//            } else if (style == Typeface.ITALIC) {
//                super.setTypeface(FontCache.getFont(getContext(), "Opel_Sans_Italic.ttf"));
//            } else if (style == Typeface.BOLD) {
//                super.setTypeface(FontCache.getFont(getContext(), "Opel_Sans_Bold.ttf"));
//            }
//        }
//    }

    protected TypedArray getTypedArray(Context context, AttributeSet attributeSet, int[] attr) {
        return context.obtainStyledAttributes(attributeSet, attr, 0, 0);
    }

}
