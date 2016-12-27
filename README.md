# spring-boot-web
spring mvc + freemarker + mybatis 骨架工程
## 入口
WebController.java为Web接口(FreeMarker)
DataController.java为数据接口(Rest)
对应单测为ControllerTest.java
## 配置
工程整体配置：resources/application.yaml
多数据源配置：MyBatis多数据源基于AOP实现，如有变动请修改DaoAop.java、DataSourceType.java、application.yaml
Demo中用到的数据库：resources/schema/user.sql
