package com.example.zhengdengyao.smartsleep.data;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "th_user")
public class UserBean {
    @DatabaseField(id = true, columnName = "userName")
    private String userName;
    @DatabaseField(columnName = "passWord")
    private String passWord;
    @DatabaseField(columnName = "sleepData")
    private String sleepData;

    public UserBean() {
    }

    public UserBean(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getSleepData() {
        return sleepData;
    }

    public void setSleepData(String sleepData) {
        this.sleepData = sleepData;
    }
}
