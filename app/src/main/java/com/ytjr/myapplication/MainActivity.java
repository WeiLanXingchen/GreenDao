package com.ytjr.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.ytjr.myapplication.db.AppDbHelper;

import java.util.ArrayList;
import java.util.List;
/*
* greenDao 数据库 增删改查以及版本更新（插入或者删除表结构的字段）方法：
*    1.添加相关配置文件
*          注：build.gradle文件设置greendao配置：版本号、导包名（报名+文件名)、数据库文件目录
*    2.创建一个实体类 加入@Entity和@Id Build—>Make Project
*    3.MyApplication建表名 配置数据库
*    4.版本升级时修改build文件的版本号 同时增加或删除实体类的字段
*
* */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private List<Student> students;
    private ListView listView;
    private StudentListAdapter studentListAdapter;
    private AppDbHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn_add = findViewById(R.id.btn_add);
        Button btn_delete = findViewById(R.id.btn_delete);
        Button btn_edit = findViewById(R.id.btn_edit);
        Button btn_query = findViewById(R.id.btn_query);
        listView = findViewById(R.id.listView);
        btn_add.setOnClickListener(this);
        btn_delete.setOnClickListener(this);
        btn_edit.setOnClickListener(this);
        btn_query.setOnClickListener(this);
        dbHelper= MyApplication.appDbHelper;
        initData();
    }

    /*
     * 数据初始化
     * */
    private void initData() {
        students = new ArrayList<Student>();
//        students = StudentHelper.queryAll();
        students=dbHelper.queryAll();
        studentListAdapter = new StudentListAdapter(this, students);
        listView.setAdapter(studentListAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add:
                addData();
                break;
            case R.id.btn_delete:
                deleteData();
                break;
            case R.id.btn_edit:
                editData();
                break;
            case R.id.btn_query:
                initData();
                break;
        }
    }
    /*
    * 查找数据
    * */
    private void queryData() {

    }

    /*
     * 修改数据
     * */
    private void editData() {
        Student student = students.get(students.size()-1);
        student.name="王麻子";
//        StudentHelper.update(student);
        dbHelper.update(student);
        initData();
    }

    /*
     * 删除数据
     * */
    private void deleteData() {
        if (!students.isEmpty()) {
//            StudentHelper.delete(students.get(0).getId());
            dbHelper.delete(students.get(0).getId());
            initData();
        }
    }

    /*
     * 添加数据
     * */
    private void addData() {
        Student student = new Student();
        student.name = "张三";
        student.percent = "90";
        student.str="你猜我是谁";
//        StudentHelper.insertStudent(student);
        dbHelper.insertStudent(student);
        initData();
    }
}
