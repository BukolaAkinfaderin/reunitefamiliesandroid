package com.reunitefamilies.reunitefamilies.landing;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.reunitefamilies.reunitefamilies.R;
import com.reunitefamilies.reunitefamilies.preferences.AppPreferences;

import java.util.ArrayList;


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


        if (layoutId == R.layout.activity_verification){
            ArrayList<TextView> textViewArrayList = new ArrayList<>();
            TextView add1 = view.findViewById(R.id.not_added1);
            TextView add2 = view.findViewById(R.id.not_added2);
            TextView add3 = view.findViewById(R.id.not_added3);
            textViewArrayList.add(add1);
            textViewArrayList.add(add2);
            textViewArrayList.add(add3);
            for (int i = 0; i < textViewArrayList.size(); i++){
                int finalI = i;
                int finalI1 = i;
                textViewArrayList.get(i).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        textViewArrayList.get(finalI).setTextColor(getActivity().getApplicationContext().getResources()
                                .getColor(R.color.mdtp_red));
                        textViewArrayList.get(finalI1).setText("Added");
                    }
                });
            }
        }

        if (layoutId == R.layout.add_child){
            ImageView child = view.findViewById(R.id.chidImage);
            child.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    child.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.child_sep));
                }
            });
        }

        if (layoutId == R.layout.case_submitted){
            ArrayList<ImageView> imageViews = new ArrayList<>();
            CardView image1 = view.findViewById(R.id.volunteer1);
             CardView image2 = view.findViewById(R.id.volunteer2);
            CardView image3 = view.findViewById(R.id.volunteer3);
            ImageView check1 = view.findViewById(R.id.checkmark1);
            ImageView check2 = view.findViewById(R.id.checkmark2);
            ImageView check3 = view.findViewById(R.id.checkmark3);
            AppPreferences preferences = new AppPreferences(getContext());

            image1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    preferences.saveChosenVolunteer(R.drawable.volunteer1);
                    check1.setVisibility(View.VISIBLE);
                    check2.setVisibility(View.INVISIBLE);
                    check3.setVisibility(View.INVISIBLE);
                }
            });
            image2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    preferences.saveChosenVolunteer(R.drawable.volunteer2);
                    check2.setVisibility(View.VISIBLE);
                    check1.setVisibility(View.INVISIBLE);
                    check3.setVisibility(View.INVISIBLE);
                }
            });
            image3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    preferences.saveChosenVolunteer(R.drawable.volunteer3);
                    check3.setVisibility(View.VISIBLE);
                    check1.setVisibility(View.INVISIBLE);
                    check2.setVisibility(View.INVISIBLE);
                }
            });
        }

       // actionButton.setOnClickListener(mOnFragmentClickListener);

        return view;
    }
}
