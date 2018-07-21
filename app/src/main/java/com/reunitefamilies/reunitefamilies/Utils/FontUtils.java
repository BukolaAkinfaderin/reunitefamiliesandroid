package com.reunitefamilies.reunitefamilies.Utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;


import com.reunitefamilies.reunitefamilies.R;

import java.util.HashMap;

/**
 * Created by bakinfaderin.
 */
public class FontUtils {

    private static final String FONTS_FOLDER = "fonts/";

    private static Typeface selectTypeface(final Context context, final String fontName) {
        return FontCache.getTypeface(FONTS_FOLDER + fontName, context);
    }

    /**
     * applyCustomFont.
     *
     * @param context --
     * @param attrs   --
     * @param toView  --
     */
    public static void applyCustomFont(final Context context, final AttributeSet attrs, final TextView toView) {

        final TypedArray attributeArray = context.obtainStyledAttributes(
                attrs,
                R.styleable.Font);

        final String fontName = attributeArray.getString(R.styleable.Font_font_font);
        final Typeface customFont = selectTypeface(context, fontName);
        toView.setTypeface(customFont);

        attributeArray.recycle();
    }

    /**
     * applyCustomFont.
     *
     * @param context  --
     * @param fontName --
     * @param toView   --
     */
    public static void applyCustomFontName(final Context context, final String fontName, final TextView toView) {
        final Typeface customFont = selectTypeface(context, fontName);
        toView.setTypeface(customFont);
    }


    /**
     * FontCache.
     */
    private static class FontCache {

        private static HashMap<String, Typeface> sFontCache = new HashMap<>();

        public static Typeface getTypeface(final String fontname, final Context context) {

            Typeface typeface = sFontCache.get(fontname);

            if (typeface == null) {
                try {
                    typeface = Typeface.createFromAsset(context.getAssets(), fontname);
                } catch (Exception e) {
                    return null;
                }

                sFontCache.put(fontname, typeface);
            }

            return typeface;
        }
    }
}
