# _springBoot 高级实战_ 

=======

## springboot+angularJs+bootstrap

失败(后续解决)

## SpringBoot的数据访问

### spring Data JPA实战


1.  引入依赖

```
		//google 工具类-大量的Java常用工具类
		<dependency>
			<groupId>com.google.guava</groupId>
			<artifactId>guava</artifactId>
			<version>18.0</version>
		</dependency>
		
```
oracle 用户名/密码：springboot/sanduo

**注意：配置** 
    sql-script-encoding: utf-8
    driver-class-name: oracle.jdbc.driver.OracleDriver 
    url: jdbc:oracle:thin:@192.168.35.33:1521:xe 
    username: springboot //必须url 不是data-username
    password: sanduo //必须url 不是data-password


2.  因为反射下面接口没有实现
http://localhost:8888/auto

3.引入swagger2

*   依赖

```依赖
		<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-swagger2</artifactId>
			<version>2.2.2</version>
		</dependency>
		<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-swagger-ui</artifactId>
			<version>2.2.2</version>
		</dependency>
```

*	配置类
	com.sanduo.springboot.Swagger2Config


### Spring Data Rest（开始添加swagger）

* 	开启支持

```依赖
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-rest</artifactId>
		</dependency>
```

*	两种配置方式

> 继承
> 配置类导入 RepositoryRestMvcConfiguration(Import(RepositoryRestMvcConfiguration.class))


***注意** 	
	集成到SpringBoot 只需要引入依赖，因为springboot已经对其进行实现

#### 实战（表：Perosn.sql(oracle)）


1.  查询用户列表
访问：http://localhost:8888/api/peoples
2.  获取单一对象
http://localhost:8888/api/peoples/1
3.	使用自定义查询
http://localhost:8888/api/peoples/search/nameStartsWith?name=sanduo
4.	分页查询
http://localhost:8888/api/peoples/?page=1&size=2
5.	排序
http://localhost:8888/api/peoples/?sort=age,desc
6.	保存
----
请求方式:POST
请求路径：http://localhost:8888/api/peoples
参数：{
	"name":"孙斌",
	"address":"河南",
	"age":29
}

返回：
{
  "name": "孙斌",
  "age": 29,
  "address": "河南",
  "_links": {
    "self": {
      "href": "http://localhost:8888/api/peoples/11"
    },
    "people": {
      "href": "http://localhost:8888/api/peoples/11"
    }
  }
}
----

7.	更新

请求方式：PUT
请求路径：http://localhost:8888/api/peoples/10

8.	删除

请求方式：DELETE
请求路径：http://localhost:8888/api/peoples/10


### 事务管理

#### 实战

1.  依赖支持

```
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		<dependency>
			<groupId>com.oracle</groupId>
			<artifactId>ojdbc6</artifactId>
			<version>11.2.0.1.0</version>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
```
2.  访问

访问路径：http://localhost:8888/swagger-ui.html
controller：transaction-controller 
方法：
	PUT /noRollback-----保存不回滚
	PUT /rollback-----保存回滚



### 数据缓存Cache

#### 实战


1.  引入依赖

```
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>com.oracle</groupId>
			<artifactId>ojdbc6</artifactId>
			<version>11.2.0.1.0</version>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-cache</artifactId>
		</dependency>
```

2.  开启缓存支持
	@EnableCaching//开启缓存支持
3.	测试

访问地址：http://localhost:8888/swagger-ui.html#!/cache45controller

**注意**
	测试 POST /findById 时，如果缓存中已经有了，就会直接从缓存中取，如果没有就会走service重新查询数据库。 
	


##### 切换缓存

1.	EhCache（未测试）

引入依赖

```
	<dependency>
		<groupId>net.sf.ehcache</groupId>
		<artifactId>ehcache</artifactId>
	</dependency>
```
编写配置文件：
ehcache.xml，方到xml


### 非关系型数据库

#### MongoDB

##### 实战

1.  引入依赖

```
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-data-mongodb</artifactId>
	</dependency>
	<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
	</dependency>
```



2.  配置地址和用户名密码

```
spring
  data:
    mongodb:
      uri: mongodb://192.168.35.33:27017
      database: admin
      username: xxx
      password: xxx
```
3.	测试

访问地址：http://localhost:8888/swagger-ui.html#!/mongo45db45controller



#### Redis


##### 实战


1.  引入依赖

```
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-data-redis</artifactId>
	</dependency>
```
		
2.  second_item

































