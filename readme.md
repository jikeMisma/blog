## 关于项目
该项目试基于SpringBoot2.X+Thymeleaf 实现的完整博客系统。
部分的前端展示页面和css样式等借鉴了部分网络作者的开源项目，在此向其作者表示感谢！
因为博主的能力有限，重构计划一直拖后，但是对于自己项目的目标还是有的：未来计划后台采用vuejs，前台选用更加清晰的模板引擎，在整体的项目基础上实现前后端分离，使
用Redis中间件做缓存。


## 博客特点

 1. 使用现如今流行的java语言及springboot框架开发，体系完整，结构清晰，是一套不错的学习项目
 2. 整体的后端开发模式使用MVC，分层清楚，逻辑清楚，适合学者参考学习
 3. 在博客的文档编辑、博客目录的生成与展示等地方使用了开源插件，实现了动态的js和对于makedown文档的编辑支持，整体上符合现如今流行的博客编辑器。
 4. 整体的前端使用semantic的模板引擎，使得界面简洁好看，整体布局合理，js的交互性良好。

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200616175401924.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L216Y19sb3Zl,size_16,color_FFFFFF,t_70)


## 功能介绍
本博客系统基于 SpringBoot 2.x ，支持快速开发，部署，服务器采用tomcat。

数据库采用常见的关系型数据库Mysql，ORM框架采用JPA

模板引擎采用Thymeleaf （对于为何使用Thymeleaf 作为模板引擎，可以阅读此文章[为何选择Thymeleaf](https://blog.csdn.net/mzc_love/article/details/106591561)），由于精力及能力有限没有采用vue，在后期更新中考虑后台改为vue实现，敬请期待！

**博客功能导图：**
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200616174352410.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L216Y19sb3Zl,size_16,color_FFFFFF,t_70#pic_center)

#### 整体功能
**前台部分：**

 1. 首页：展示博客、展示所有的分类及标签、点击进入博客详情
 2. 分类：类型对博客进行划分并分别展示
 3. 标签：按标签对博客进行划分与展示
 4. 归档：整体按照年份对博客进行归档，可以进行博客内容查询
 5. 关于我：展示博主有关信息

**后台部分（管理员部分）**

 1. 博客管理：实现博客的增删改查
 2. 分类管理：实现分类的增删改查
 3. 标签管理：实现标签的增删改查

## 整体架构
**博客系统整体分层如下：**
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200616174450504.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L216Y19sb3Zl,size_16,color_FFFFFF,t_70#pic_center)

## 页面预览
**代码结构预览**
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200615160157432.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L216Y19sb3Zl,size_16,color_FFFFFF,t_70)

**博客主页**

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200615160232994.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L216Y19sb3Zl,size_16,color_FFFFFF,t_70)

**博客详情展示**![](https://img-blog.csdnimg.cn/20200615160258526.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L216Y19sb3Zl,size_16,color_FFFFFF,t_70)
**博客分类：**
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200616174752826.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L216Y19sb3Zl,size_16,color_FFFFFF,t_70#pic_center)
**按标签展示**
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200616174808212.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L216Y19sb3Zl,size_16,color_FFFFFF,t_70#pic_center)
**关于我**
![在这里插入图片描述](https://img-blog.csdnimg.cn/2020061617482413.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L216Y19sb3Zl,size_16,color_FFFFFF,t_70#pic_center)
**后台管理**
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200615160334323.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L216Y19sb3Zl,size_16,color_FFFFFF,t_70)

## 项目结构和数据库
数据库整体使用musql，ORM采用jpa。


**数据库结构预览**
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200615160611112.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L216Y19sb3Zl,size_16,color_FFFFFF,t_70#pic_center)

##  关于开源
目前由于部分代码存在缺陷，所以还未对代码进行开源，等之后有时间将一些常见的bug进行修改解决之后将会对系统进行开源，敬请期待。


