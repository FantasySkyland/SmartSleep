package com.example.zhengdengyao.smartsleep;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AlarmActivity extends AppCompatActivity {
    public static void start(Context context){
        Intent intent = new Intent(context,AlarmActivity.class);
        context.startActivity(intent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        StatusBarUtils.statusbar(this);
    }
}
