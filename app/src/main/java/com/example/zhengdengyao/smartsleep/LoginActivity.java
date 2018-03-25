package com.example.zhengdengyao.smartsleep;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zhengdengyao.smartsleep.data.BaseActivity;
import com.example.zhengdengyao.smartsleep.data.UserBean;

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private static final String TAG = "LoginMainAvt";

    ImageView iv_cancel;
    EditText et_password;
    EditText et_username;
    Button btn_login;
    TextView tv_register;
    boolean isUserNameEmpty = true;
    boolean isPasswordEmpty = true;
    ImageView iv_cancel_username;


    public static void start(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        //设置无标题
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        //设置全屏
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login_main);
        StatusBarUtils.statusbar(this);
        btn_login = (Button) findViewById(R.id.btn_login);
        tv_register = (TextView) findViewById(R.id.tv_register);
        tv_register.setOnClickListener(this);
        iv_cancel_username = (ImageView) findViewById(R.id.iv_cancel_username);
        iv_cancel_username.setOnClickListener(this);
        iv_cancel = (ImageView) findViewById(R.id.iv_cancel);
        iv_cancel.setOnClickListener(this);
        et_password = (EditText) findViewById(R.id.et_password);
        et_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s != null && s.length() > 0) {
                    iv_cancel.setVisibility(View.VISIBLE);
                    isPasswordEmpty = false;
                    if (!isUserNameEmpty) {
                        btn_login.setBackgroundResource(R.drawable.login_btn_red);
                        btn_login.setClickable(true);
                        btn_login.setTag("canClick");
                    } else {
                        btn_login.setBackgroundResource(R.drawable.login_btn_gray);
                        btn_login.setClickable(false);
                        btn_login.setTag("cannotClick");
                    }
                } else {
                    iv_cancel.setVisibility(View.GONE);
                    isPasswordEmpty = true;
                    btn_login.setClickable(false);
                    btn_login.setTag("cannotClick");
                    btn_login.setBackgroundResource(R.drawable.login_btn_gray);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        et_username = (EditText) findViewById(R.id.et_username);
        et_username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s != null && s.length() > 0) {
                    isUserNameEmpty = false;
                    iv_cancel_username.setVisibility(View.VISIBLE);
                    if (!isPasswordEmpty) {
                        btn_login.setBackgroundResource(R.drawable.login_btn_red);
                        btn_login.setClickable(true);
                        btn_login.setTag("canClick");
                    } else {
                        btn_login.setClickable(false);
                        btn_login.setTag("cannotClick");
                        btn_login.setBackgroundResource(R.drawable.login_btn_gray);
                    }
                } else {
                    isUserNameEmpty = true;
                    iv_cancel_username.setVisibility(View.GONE);
                    btn_login.setClickable(false);
                    btn_login.setTag("cannotClick");
                    btn_login.setBackgroundResource(R.drawable.login_btn_gray);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        ImageView iv_return = (ImageView) findViewById(R.id.iv_return);
        iv_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }
    public void login() {
        if (btn_login.getTag().equals("canClick")) {
            String username = et_username.getText().toString();
            String password = et_password.getText().toString();
            UserBean userBean = userDAO.queryForId(username);
            if (userBean == null) {
                Toast.makeText(LoginActivity.this, "用户不存在", Toast.LENGTH_SHORT).show();
            } else if (!username.equals(userBean.getUserName())) {
                Toast.makeText(LoginActivity.this, "用户名不存在", Toast.LENGTH_SHORT).show();
            } else if (!password.equals(userBean.getPassWord())) {
                Toast.makeText(LoginActivity.this, "密码错误", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.putExtra("username", username);
                startActivity(intent);
                finish();
            }


        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_cancel:
                et_password.setText("");
                break;
            case R.id.tv_register:
                RegisterActivity.start(this);
                break;
            case R.id.iv_cancel_username:
                et_username.setText("");
                break;
        }
    }
}
