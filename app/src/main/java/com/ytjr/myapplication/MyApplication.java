package com.ytjr.myapplication;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.ytjr.myapplication.dao.DaoMaster;
import com.ytjr.myapplication.dao.DaoSession;
import com.ytjr.myapplication.db.AppDbHelper;
import com.ytjr.myapplication.db.DbOpenHelper;

public class MyApplication  extends Application {
    public static DaoSession daoSession;
    public static AppDbHelper appDbHelper;
    @Override
    public void onCreate() {
        super.onCreate();
        //配置数据库
//        setupDatabase();
        setUpDatabase();
    }
    /*
    * 配置数据库
    * */
    private void setUpDatabase() {
      appDbHelper=new AppDbHelper(new DbOpenHelper(this,Config.DB_NAME));
    }

    /*
    * 配置数据库
    * */
    private void setupDatabase() {
        //创建数据库shop.db
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "shop.db", null);
        //获取可写数据库
        SQLiteDatabase db = helper.getWritableDatabase();
        //获取数据库对象
        DaoMaster daoMaster = new DaoMaster(db);
//        //获取dao对象管理者
        daoSession = daoMaster.newSession();
    }
//    public static DaoSession getDaoInstant() {
//        return daoSession;
//    }
}
