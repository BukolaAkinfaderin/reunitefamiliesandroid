package com.reunitefamilies.reunitefamilies.fontViews;

import android.content.Context;
import android.util.AttributeSet;

import com.reunitefamilies.reunitefamilies.Utils.FontUtils;


/**
 * Created by bakinfaderin.
 */
public class FontEditText extends android.support.v7.widget.AppCompatEditText {

    /**
     * Constructor.
     *
     * @param context --
     */
    public FontEditText(final Context context) {
        super(context);

        FontUtils.applyCustomFont(context, null, this);
    }

    /**
     * Constructor.
     *
     * @param context --
     * @param attrs   --
     */
    public FontEditText(final Context context, final AttributeSet attrs) {
        super(context, attrs);

        FontUtils.applyCustomFont(context, attrs, this);
    }

    /**
     * Constructor.
     *
     * @param context  --
     * @param attrs    --
     * @param defStyle --
     */
    public FontEditText(final Context context, final AttributeSet attrs, final int defStyle) {
        super(context, attrs, defStyle);

        FontUtils.applyCustomFont(context, attrs, this);
    }
}
