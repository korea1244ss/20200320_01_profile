package kr.uk.dh.a20200320_01_profile;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    public Context mContext = this;

    public abstract void setupEvets();
    public abstract void setValues();
}
