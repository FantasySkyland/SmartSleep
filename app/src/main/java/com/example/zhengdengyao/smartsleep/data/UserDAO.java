package com.example.zhengdengyao.smartsleep.data;

import android.content.Context;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;

public class UserDAO {
    private Dao<UserBean, Integer> userDao;
    private DBHelper dbHelper;
    Context context;

    /**
     * 构造方法
     * 获得数据库帮助类实例，通过传入 Class 对象得到相应的 Dao
     *
     * @param context
     */
    public UserDAO(Context context) {
        dbHelper = DBHelper.getHelper(context);
        try {
            userDao = dbHelper.getDBDao(UserBean.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.context = context;
    }

    /**
     * 添加一条记录
     *
     * @param userBean
     */
    public void add(UserBean userBean) {
        try {
            userDao.create(userBean);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除一条记录
     *
     * @param userBean
     */
    public void delete(UserBean userBean) {
        try {
            userDao.delete(userBean);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 更新一条记录
     *
     * @param userBean
     */
    public void update(UserBean userBean) {
        try {
            userDao.update(userBean);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询一条记录
     *
     * @param userName
     * @return
     */
    public UserBean queryForId(String userName) {
        UserBean userBean = null;
        try {
            userBean = userDao.queryForEq("userName", userName).get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userBean;
    }
}
