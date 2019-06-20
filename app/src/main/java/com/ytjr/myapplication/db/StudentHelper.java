package com.ytjr.myapplication.db;

import com.ytjr.myapplication.MyApplication;
import com.ytjr.myapplication.Student;
import com.ytjr.myapplication.dao.StudentDao;

import java.util.List;
/**
 * author: JYX
 * date: 2019/6/19
 * desc:
 */
public class StudentHelper {
    /*
     * 添加数据 如果有重复就覆盖
     * */
//    public static void insertStudent(Student student) {
//        MyApplication.getDaoInstant().getStudentDao().insertOrReplace(student);
//
//    }
//
//    /*
//     * 删除数据
//     * */
//    public static void delete(Long id) {
//        MyApplication.getDaoInstant().getStudentDao().deleteByKey(id);
//    }
//
//    /*
//     * 更新数据
//     * */
//    public static void update(Student student) {
//        MyApplication.getDaoInstant().getStudentDao().update(student);
//    }
//    /*
//     * 查询数据
//     * */
//    public static List<Student> queryAll(){
//        return MyApplication.getDaoInstant().getStudentDao().loadAll();
//    }
//    /*
//     * 按条件查询
//     * */
//    public static List<Student> queryStudent(){
//        return MyApplication.getDaoInstant().getStudentDao().queryBuilder()
//                .where(StudentDao.Properties.Type.eq(Student.TYPE_CART)).list();
//    }
}
