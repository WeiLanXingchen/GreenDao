# GreenDa
封装GreenDao数据库的增删改查使用以及版本升级
## 使用方法
### 步骤1：
在project.gradle添加 </br>
    buildscript { </br>
        dependencies { </br>
            classpath 'org.greenrobot:greendao-gradle-plugin:3.2.2' // add plugin  </br>
        }  </br>
    }   </br>

### 步骤2：
在app.gradle添加  </br>
    apply plugin: 'org.greenrobot.greendao'  </br>
    //数据库版本号以及文件路径  </br>
    greendao{  </br>
         //版本号，升级时可配置  </br>
                schemaVersion 4  </br>
                daoPackage 'com.ytjr.myapplication.dao'  </br>
                targetGenDir 'src/main/java'  </br>
    }  </br>
     //添加依赖  </br>
     compile 'org.greenrobot:greendao:3.2.0'  </br>

## 增删改查 版本升级封装

### 增（insert）

 insertInTx：插入一条或多条数据</br>
 insertOrReplace：插入或替换</br>
 insertOrReplaceInTx：插入或替换一条或者多条数据</br>

### 删（delete）

 delete：删除一个对象</br>
 deleteAll：删除所有数据</br>
 deleteByKey：根据id删除</br>
 deleteInTx：删除一个或多个对象</br>
 deleteByKeyInTx：根据一个或者多个key删除对象</br>
 
 ### 改（update）

  update：更改一个对象</br>
  updateInTx| 更改多个对象</br>
  insertOrReplaceInTx：插入或替换一条或者多条数据</br>
 
 ### 查（query）
 
   loadAll：查询所有</br>
   queryBuilder：根据语法查询</br>
 
 #### 查询条件
 
    //根据id查询
    daoSession.getStudentDao().queryBuilder().where(StudentDao.Properties.Id.eq(id)).build().unique();
    eq用来判断两个属性是否对等，unique()返回一个对象
 
 ## 创建实体类（创建好后，需要编译一下）
 参考Student类</br>
 @Entity 标注此类为数据库支持的实体类</br>
 @Id(autoincrement = true) 标注键，作为实体id，自增</br>
 @Property 标注属性</br>
 
 ## 数据库升级
 1：修改schemaVersion </br>
    greendao{ </br>
     schemaVersion 3 </br>
     targetGenDir 'src/main/java' </br>
    }
 3:DbOpenHelper中，如果新版本号大于旧版本，迁移数据库，否则删除重建数据库 </br>
     if (newVersion > oldVersion) { </br>
             // 升级、数据库迁移操作 </br>
             MigrationHelper.getInstance().migrate(db, UserDao.class); </br>
         }else { </br>
             // 默认操作 </br>
             dropAllTables(db, true); </br>
             onCreate(db); </br>
         }
         
 4：编译一下，再运行。 </br>
 本例将GreenDao进行一定程度上的封装，对于需要用的方法:
   在DbHelper中添加相应，在AppDbHelper中实现  </br>
    在ui中引用，在application中获取AppDbHelper的实例。
