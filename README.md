# GreenDa
封装GreenDao数据库的增删改查使用以及版本升级
## 使用方法
### 步骤1：
在project.gradle添加
    buildscript {
        dependencies {
            classpath 'org.greenrobot:greendao-gradle-plugin:3.2.2' // add plugin
        }
    }

### 步骤2：
在app.gradle添加
    apply plugin: 'org.greenrobot.greendao'
    //数据库版本号以及文件路径
    greendao{
         //版本号，升级时可配置
                schemaVersion 4
                daoPackage 'com.ytjr.myapplication.dao'
                targetGenDir 'src/main/java'
    }
     //添加依赖
     compile 'org.greenrobot:greendao:3.2.0'

## 增删改查 版本升级封装

### 增（insert）

 insertInTx：插入一条或多条数据|
 insertOrReplace：插入或替换|
 insertOrReplaceInTx：插入或替换一条或者多条数据|

### 删（delete）

 |     方法名    |   介绍    | 
 |--------------|:----------|
 |    delete    |删除一个对象|
 |deleteAll| 删除所有数据|
 |deleteByKey|根据id删除|
 |deleteInTx|删除一个或多个对象|
 |deleteByKeyInTx|根据一个或者多个key删除对象|
 
 ### 改（update）
 
  |     方法名    |   介绍    | 
  |--------------|:----------|
  |    update    |更改一个对象|
  |updateInTx| 更改多个对象|
  |insertOrReplaceInTx|插入或替换一条或者多条数据|
 
 ### 查（query）
 
  |     方法名    |   介绍    | 
   |--------------|:----------|
   |    loadAll    |查询所有|
   |queryBuilder| 根据语法查询|
 
 #### 查询条件
 
    //根据id查询
    daoSession.getStudentDao().queryBuilder().where(StudentDao.Properties.Id.eq(id)).build().unique();
    eq用来判断两个属性是否对等，unique()返回一个对象
 
 ## 创建实体类（创建好后，需要编译一下）
 参考Student类
 @Entity 标注此类为数据库支持的实体类
 @Id(autoincrement = true) 标注键，作为实体id，自增
 @Property 标注属性
 
 ## 数据库升级
 1：修改schemaVersion
    greendao{
     schemaVersion 3
     targetGenDir 'src/main/java'
    }
 3:DbOpenHelper中，如果新版本号大于旧版本，迁移数据库，否则删除重建数据库
     if (newVersion > oldVersion) {
             // 升级、数据库迁移操作
             MigrationHelper.getInstance().migrate(db, UserDao.class);
         }else {
             // 默认操作
             dropAllTables(db, true);
             onCreate(db);
         }
         
 4：编译一下，再运行。
 本例将GreenDao进行一定程度上的封装，对于需要用的方法，
 在DbHelper中添加相应，在AppDbHelper中实现，在ui中引用，在application中获取AppDbHelper的实例。
