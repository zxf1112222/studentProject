此文档只适合小白阅读

一介绍
	1前端：vue和element、axios 
	2后端：ssm 通用mapper插件
	3主要实现功能：登陆，前台分页，简单crud
 
二、安装教程
	1首先将包下的databaseTables.sql导入到数据库中
	2然后把ssm_oundation_project导入到idea中，修改src——resources——setting.properties中数据库的账号密码
	3进入登陆页面，登陆账号03163080，密码：123（密码经过加密所以后台看不到  ）

三、开发说明：大神可以忽略
1、该工程中的前后端分工
	1）后端只负责提供数据的url地址
	2）前端只负责页面页面跳转，并通过axios动态获取后台数据 

2、前后端的交互：
	1）前端是首先要建一个项目：https://blog.csdn.net/qq_34306360/article/details/80400201（创建教程），目前使用的是文件中有一个my-project01的项目（已经引入element、axios ）
	2）进入开发完成的包，然后通过 npm run build 会产生一个dist文件
	3）将dist文件放在后台项目webapp下面，前台就算是引入
	

三、前端开发
	1首先要安装相对应的环境包括node.js和vue
	2在cmd中进去到my-project01文件夹中npm run dev相当于运行前端项目。
	3在idea或者hbuildx中开发。

四、后端开发的几个使用：
	一个md5类用于加密
	乱码工具类
	通用mapper避免重复简单的crud
