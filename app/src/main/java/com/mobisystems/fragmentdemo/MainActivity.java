package com.mobisystems.fragmentdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        try {
            Button btn = findViewById(R.id.btn);
            if (btn != null){
                btn.setOnClickListener((v) -> changeFragment());
                changeFragment();
            }
        } catch (Exception e) {
        }
    }

    private void changeFragment() {
        try{
            Log.d("BASI", "changeFragment");
            Fragment fragment = getNextFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
        }catch (Exception e){
            Log.d("BASI","gr", e);
        }

    }

    private boolean firstFragmentShown = false;

    private Fragment getNextFragment() {
        Fragment result;
        if (firstFragmentShown)
            result = new SecondFragment();
        else
            result = new FirstFragment();
        firstFragmentShown = !firstFragmentShown;
        return result;
    }
}
