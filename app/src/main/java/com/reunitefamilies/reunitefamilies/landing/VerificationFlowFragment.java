package com.reunitefamilies.reunitefamilies.landing;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.reunitefamilies.reunitefamilies.R;


/**
 * Created by administrator on 1/26/16.
 */
public class VerificationFlowFragment extends Fragment {

    @NonNull
    private int layoutId;


    private OnFragmentClickListener mOnFragmentClickListener;

    /**
     * interface OnFragmentClickListener.
     */
    public interface OnFragmentClickListener extends View.OnClickListener {
    }

    /**
     * constractor.
     */
    public VerificationFlowFragment() { }

    /**.
     * mOnFragmentClickListener
     * @param onFragmentClickListener mOnFragmentClickListener
     */
    public void setmOnFragmentClickListener(final OnFragmentClickListener onFragmentClickListener) {
        this.mOnFragmentClickListener = onFragmentClickListener;
    }

    /**
     * imageId.

     * @return return
     */
    public static VerificationFlowFragment newInstance(final int layout_id) {
        final VerificationFlowFragment fragment = new VerificationFlowFragment();
        fragment.layoutId = layout_id;


        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {

        final View view = inflater.inflate(layoutId, container, false);
       //Button actionButton = view.findViewById(R.id.verify_next_button);



       // actionButton.setOnClickListener(mOnFragmentClickListener);

        return view;
    }
}
