package com.reunitefamilies.reunitefamilies.fontViews;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;

import com.reunitefamilies.reunitefamilies.R;
import com.reunitefamilies.reunitefamilies.Utils.FontUtils;


/**
 * FontButton.
 * Created by administrator on 2/15/16.
 */
public class FontButton extends android.support.v7.widget.AppCompatButton {

    /**
     * Constructor.
     *
     * @param context --
     */
    public FontButton(final Context context) {
        super(context);

        FontUtils.applyCustomFont(context, null, this);
    }

    /**
     * Constructor.
     *
     * @param context --
     * @param attrs   --
     */
    public FontButton(final Context context, final AttributeSet attrs) {
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
    public FontButton(final Context context, final AttributeSet attrs, final int defStyle) {
        super(context, attrs, defStyle);

        FontUtils.applyCustomFont(context, attrs, this);
    }


    @Override
    public void setEnabled(final boolean enabled) {
        super.setEnabled(enabled);

        final int textColor = enabled ? Color.WHITE : ContextCompat.getColor(getContext(), R.color.gray2);
        setTextColor(textColor);
    }
}
