package com.ytjr.myapplication.db;

import android.content.Context;
import android.util.Log;

import com.ytjr.myapplication.dao.DaoMaster;
import com.ytjr.myapplication.dao.StudentDao;

import org.greenrobot.greendao.database.Database;

import static com.ytjr.myapplication.dao.DaoMaster.dropAllTables;

/**
 * author: JYX
 * date: 2019/6/19
 * desc:
 */

public class DbOpenHelper  extends DaoMaster.OpenHelper{

    public DbOpenHelper(Context context, String name) {
        super(context, name);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);
        Log.d("DEBUG", "DB_OLD_VERSION : " + oldVersion + ", DB_NEW_VERSION : " + newVersion);
        if (newVersion > oldVersion) {
            // 升级、数据库迁移操作
            MigrationHelper.getInstance().migrate(db, StudentDao.class);
        }else {
            // 默认操作
            dropAllTables(db, true);
            onCreate(db);
        }

    }


}