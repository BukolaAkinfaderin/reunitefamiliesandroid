package com.reunitefamilies.reunitefamilies.fontViews;

import android.content.Context;
import android.util.AttributeSet;

import com.reunitefamilies.reunitefamilies.Utils.FontUtils;


/**
 * Created by administrator on 2/12/16.
 */
public class FontTextView extends android.support.v7.widget.AppCompatTextView {

    /**
     * Constructor.
     *
     * @param context --
     */
    public FontTextView(final Context context) {
        super(context);

        FontUtils.applyCustomFont(context, null, this);
    }

    /**
     * Constructor.
     *
     * @param context --
     * @param attrs   --
     */
    public FontTextView(final Context context, final AttributeSet attrs) {
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
    public FontTextView(final Context context, final AttributeSet attrs, final int defStyle) {
        super(context, attrs, defStyle);

        FontUtils.applyCustomFont(context, attrs, this);
    }


    /**
     * Set custon font name.
     *
     * @param fontName - fontName
     */
    public void setFontName(final String fontName) {
        FontUtils.applyCustomFontName(getContext(), fontName, this);
    }
}
