package com.reunitefamilies.reunitefamilies.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

import com.reunitefamilies.reunitefamilies.R;


/**
 * Maintains an aspect ratio based on either width or height. Disabled by default.
 */
public class AspectRatioImageView extends AppCompatImageView {
    // NOTE: These must be kept in sync with the AspectRatioImageView attributes in attrs.xml.
    public static final int MEASUREMENT_WIDTH = 0;
    public static final int MEASUREMENT_HEIGHT = 1;

    private static final float DEFAULT_ASPECT_RATIO = 1f;
    private static final boolean DEFAULT_ASPECT_RATIO_ENABLED = false;
    private static final int DEFAULT_DOMINANT_MEASUREMENT = MEASUREMENT_WIDTH;

    private float mAspectRatio;
    private boolean mAspectRatioEnabled;
    private int mDominantMeasurement;

    /**
     * Constructor.
     * @param context --
     */
    public AspectRatioImageView(final Context context) {
        this(context, null);
    }

    /**
     * Constructor.
     * @param context --
     * @param attrs --
     */
    public AspectRatioImageView(final Context context, final AttributeSet attrs) {
        super(context, attrs);

        final TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.AspectRatioImageView);
        mAspectRatio = a.getFloat(R.styleable.AspectRatioImageView_aspectRatio, DEFAULT_ASPECT_RATIO);
        mAspectRatioEnabled = a.getBoolean(R.styleable.AspectRatioImageView_aspectRatioEnabled,
                DEFAULT_ASPECT_RATIO_ENABLED);
        mDominantMeasurement = a.getInt(R.styleable.AspectRatioImageView_dominantMeasurement,
                DEFAULT_DOMINANT_MEASUREMENT);
        a.recycle();
    }

    @Override
    protected void onMeasure(final int widthMeasureSpec, final int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (!mAspectRatioEnabled) {
            return;
        }

        final int newWidth;
        final int newHeight;
        switch (mDominantMeasurement) {
            case MEASUREMENT_WIDTH:
                newWidth = getMeasuredWidth();
                newHeight = (int) (newWidth * mAspectRatio);
                break;

            case MEASUREMENT_HEIGHT:
                newHeight = getMeasuredHeight();
                newWidth = (int) (newHeight * mAspectRatio);
                break;

            default:
                throw new IllegalStateException("Unknown measurement with ID " + mDominantMeasurement);
        }

        setMeasuredDimension(newWidth, newHeight);
    }

    /**
     * Get the aspect ratio for this image view.
     * @return float
     */
    public float getAspectRatio() {
        return mAspectRatio;
    }

    /**
     * Set the aspect ratio for this image view. This will update the view instantly.
     * @param aspectRatio -- ratio to constrain to
     */
    public void setAspectRatio(final float aspectRatio) {
        this.mAspectRatio = aspectRatio;
        if (mAspectRatioEnabled) {
            requestLayout();
        }
    }

    /**
     * Get whether or not forcing the aspect ratio is enabled.
     * @return if enabled
     */
    public boolean getAspectRatioEnabled() {
        return mAspectRatioEnabled;
    }

    /**
     * Set whether or not forcing the aspect ratio is enabled. This will re-layout the view.
     * @param aspectRatioEnabled -- if aspect ratio constraint should be enabled
     */
    public void setAspectRatioEnabled(final boolean aspectRatioEnabled) {
        mAspectRatioEnabled = aspectRatioEnabled;
        requestLayout();
    }

    /**
     * Get the dominant measurement for the aspect ratio.
     * @return #MEASUREMENT_WIDTH or #MEASUREMENT_HEIGHT
     */
    public int getDominantMeasurement() {
        return mDominantMeasurement;
    }

    /**
     * Set the dominant measurement for the aspect ratio.
     * @param dominantMeasurement -- the dominant measurement
     * @see #MEASUREMENT_WIDTH
     * @see #MEASUREMENT_HEIGHT
     */
    public void setDominantMeasurement(final int dominantMeasurement) {
        if (dominantMeasurement != MEASUREMENT_HEIGHT && dominantMeasurement != MEASUREMENT_WIDTH) {
            throw new IllegalArgumentException("Invalid measurement type.");
        }
        this.mDominantMeasurement = dominantMeasurement;
        requestLayout();
    }
}