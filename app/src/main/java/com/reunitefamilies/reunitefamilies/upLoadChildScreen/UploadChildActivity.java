package com.reunitefamilies.reunitefamilies.upLoadChildScreen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.reunitefamilies.reunitefamilies.R;

public class UploadChildActivity extends AppCompatActivity {

    UploadChildPresenter mpresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_child);
    }

    public void provide(UploadChildPresenter presenter) {
        this.mpresenter = presenter;
    }
}
