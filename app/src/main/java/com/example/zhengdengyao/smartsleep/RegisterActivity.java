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
import android.widget.Toast;

import com.example.zhengdengyao.smartsleep.data.UserBean;

public class RegisterActivity extends BaseActivity implements View.OnClickListener {
    private Context mContext = this;
    private static final String TAG = "LoginMainAvt";

    ImageView iv_cancel;
    EditText et_password;
    EditText et_username;
    Button btn_login;

    boolean isUserNameEmpty = true;
    boolean isPasswordEmpty = true;
    ImageView iv_cancel_username;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        StatusBarUtils.statusbar(this);
        btn_login = (Button) findViewById(R.id.btn_login);
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
                register();
            }
        });
    }

    public void register() {
        if (btn_login.getTag().equals("canClick")) {
            String username = et_username.getText().toString();
            String password = et_password.getText().toString();
            if (userDAO.queryForId(username) == null) {
                userDAO.add(new UserBean(username,password));
                Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            } else {
                et_username.setText("");
                et_password.setText("");
                Toast.makeText(mContext, "用户已存在", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, RegisterActivity.class);
        context.startActivity(intent);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_cancel:
                et_password.setText("");
                break;

            case R.id.iv_cancel_username:
                et_username.setText("");
                break;
        }
    }
}
