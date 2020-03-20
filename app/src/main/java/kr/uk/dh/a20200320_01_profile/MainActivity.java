package kr.uk.dh.a20200320_01_profile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import kr.uk.dh.a20200320_01_profile.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
