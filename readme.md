﻿## 关于项目
该项目试基于SpringBoot2.X+Thymeleaf 实现的完整博客系统。
部分的前端展示页面和css样式等借鉴了部分网络作者的开源项目，在此向其作者表示感谢！
因为博主的能力有限，重构计划一直拖后，但是对于自己项目的目标还是有的：未来计划后台采用vuejs，前台选用更加清晰的模板引擎，在整体的项目基础上实现前后端分离，使用Redis中间件做缓存。

## 功能介绍
本博客系统基于 SpringBoot 2.x ，支持快速开发，部署，服务器采用tomcat。

数据库采用常见的关系型数据库Mysql，ORM框架采用JPA

模板引擎采用Thymeleaf （对于为何使用Thymeleaf 作为模板引擎，可以阅读此文章[为何选择Thymeleaf](https://blog.csdn.net/mzc_love/article/details/106591561)），由于精力及能力有限没有采用vue，在后期更新中考虑后台改为vue实现，敬请期待！

本博客系统支持用户的登录注册。

## 页面预览
**代码结构预览**
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200615160157432.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L216Y19sb3Zl,size_16,color_FFFFFF,t_70)

**博客主页**

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200615160232994.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L216Y19sb3Zl,size_16,color_FFFFFF,t_70)

**博客详情展示**![](https://img-blog.csdnimg.cn/20200615160258526.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L216Y19sb3Zl,size_16,color_FFFFFF,t_70)
**后台管理**
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200615160334323.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L216Y19sb3Zl,size_16,color_FFFFFF,t_70)

## 项目结构和数据库
数据库整体使用musql，ORM采用jpa。


**数据库结构预览**
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200615160611112.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L216Y19sb3Zl,size_16,color_FFFFFF,t_70#pic_center)

##  关于开源
目前由于部分代码存在缺陷，所以还未对代码进行开源，等之后有时间将一些常见的bug进行修改解决之后将会对系统进行开源，敬请期待。


