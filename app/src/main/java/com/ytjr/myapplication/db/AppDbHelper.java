package com.ytjr.myapplication.db;

import com.ytjr.myapplication.Student;
import com.ytjr.myapplication.dao.DaoMaster;
import com.ytjr.myapplication.dao.DaoSession;
import com.ytjr.myapplication.dao.StudentDao;

import java.util.List;

/**
 * author: JYX
 * date: 2019/6/19
 * desc:
 */
public class AppDbHelper implements DbHelper {

    private final DaoSession daoSession;


    public AppDbHelper(DbOpenHelper dbOpenHelper) {
        daoSession = new DaoMaster(dbOpenHelper.getWritableDb()).newSession();
    }

    /*
     * 添加数据 如果有重复就覆盖
     * */
    @Override
    public void insertStudent(Student student) {
        daoSession.getStudentDao().insertOrReplace(student);
    }

    /*
     * 删除数据
     * */
    @Override
    public void delete(Long id) {
        daoSession.getStudentDao().deleteByKey(id);
    }

    /*
     * 查询所有数据
     * */
    @Override
    public List<Student> queryAll() {
        return daoSession.getStudentDao().loadAll();
    }

    @Override
    public void clear() {

    }

    /*
     * 按条件查询
     * */
    @Override
    public List<Student> query(long id) {
        return daoSession.getStudentDao().queryBuilder().where(StudentDao.Properties.Type.eq(Student.TYPE_CART)).list();
    }

    /*
     * 更新数据
     * */
    @Override
    public void update(Student student) {
        daoSession.getStudentDao().update(student);
    }
}
