### springboot-learning
自学做的一个学生成绩管理的小项目
------------------------------
9.13功能
1.表单登录跳转，不过貌似直接输入学生管理的主界面能直接登录，没有拦截，完整功能有待更新  
2.学生成绩的增删改查功能  
  当数据超过5个以上时，会开启分页，根据学号查询详情，学号生成规则是自动递增，导致删除某个学生之后，就无法创建此学号的学生，有待改正。  
第一次做项目，希望随着不断学习，继续完善功能，目前准备做异常处理的功能
------------------------------
9.14修改
1.添加拦截器，必须登录，不然不能访问资源
