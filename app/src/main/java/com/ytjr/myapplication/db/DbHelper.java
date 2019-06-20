package com.ytjr.myapplication.db;

import com.ytjr.myapplication.Student;

import java.util.List;

/**
 * author: JYX
 * date: 2019/6/19
 * desc:
 */
public interface DbHelper {

    void insertStudent(Student student) ;

    void delete(Long id) ;

    List<Student> queryAll();

    void clear();

    List<Student> query(long id);

    void update(Student student);

}
