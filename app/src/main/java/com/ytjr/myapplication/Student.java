package com.ytjr.myapplication;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * author: JYX
 * date: 2019/6/19
 * desc:
 */
@Entity
public class Student {
    //表示是购物车列表
    public static final int TYPE_CART = 0x01;
    @Id(autoincrement = true)
    private Long id;
    public String name;
    public String percent;
    public int type;
    public String str;
    @Generated(hash = 1658908562)
    public Student(Long id, String name, String percent, int type, String str) {
        this.id = id;
        this.name = name;
        this.percent = percent;
        this.type = type;
        this.str = str;
    }
    @Generated(hash = 1556870573)
    public Student() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPercent() {
        return this.percent;
    }
    public void setPercent(String percent) {
        this.percent = percent;
    }
    public int getType() {
        return this.type;
    }
    public void setType(int type) {
        this.type = type;
    }
    public String getStr() {
        return this.str;
    }
    public void setStr(String str) {
        this.str = str;
    }
    

}
