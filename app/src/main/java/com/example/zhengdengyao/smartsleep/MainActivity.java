package com.example.zhengdengyao.smartsleep;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv_id)
    TextView mTvId;
    @BindView(R.id.tv_login)
    TextView mTvLogin;
    @BindView(R.id.alarm)
    LinearLayout mAlarm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        String username = getIntent().getStringExtra("username");
        if (username == null){
            mTvId.setText("未登陆");
        }else {
            mTvId.setText(username);
        }

        StatusBarUtils.statusbar(this);
    }

    @OnClick({R.id.tv_id, R.id.tv_login, R.id.alarm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_id:
                break;
            case R.id.tv_login:
                LoginActivity.start(this);
                break;
            case R.id.alarm:
                AlarmActivity.start(this);
                break;
        }
    }

}
