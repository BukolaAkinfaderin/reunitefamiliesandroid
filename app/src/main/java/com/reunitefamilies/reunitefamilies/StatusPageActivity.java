package com.reunitefamilies.reunitefamilies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.reunitefamilies.reunitefamilies.main.BaseActivity;
import com.reunitefamilies.reunitefamilies.preferences.AppPreferences;

public class StatusPageActivity extends BaseActivity {

    ImageView selectedVolunteeer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_page);
        selectedVolunteeer = findViewById(R.id.selected_volunteer);
        AppPreferences preferences = new AppPreferences(this);
        selectedVolunteeer.setImageResource(preferences.getChosenVolunteer());
    }
}
