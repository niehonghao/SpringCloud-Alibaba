## SpringCloud Alibaba

## 目录

## 介绍

Spring Cloud Alibaba 为分布式应用开发提供一站式解决方案。它包含开发分布式应用程序所需的所有组件，使您可以轻松使用 Spring Cloud 开发应用程序。

使用Spring Cloud Alibaba，只需要添加一些注解和少量的配置，就可以将Spring Cloud应用接入阿里巴巴的分布式解决方案，使用阿里巴巴中间件构建分布式应用系统。

SpringCloud官网：https://spring.io/projects/spring-cloud

SringCloud-Alibab官网：https://github.com/alibaba/spring-cloud-alibaba

**SpringBoot和SpringCloud版本依赖关系**：https://start.spring.io/actuator/info 

**POM**

```xml
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-alibaba-dependencies</artifactId>
            <version>{project-version}</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>
```

## 主要功能

- **服务限流降级**：默认支持 WebServlet、WebFlux、OpenFeign、RestTemplate、Spring Cloud Gateway、Zuul、Dubbo 和 RocketMQ 限流降级功能的接入，可以在运行时通过控制台实时修改限流降级规则，还支持查看限流降级 Metrics 监控。
- **服务注册与发现**：适配 Spring Cloud 服务注册与发现标准，默认集成了 Ribbon 的支持。
- **分布式配置管理**：支持分布式系统中的外部化配置，配置更改时自动刷新。
- **消息驱动能力**：基于 Spring Cloud Stream 为微服务应用构建消息驱动能力。
- **分布式事务**：使用 @GlobalTransactional 注解， 高效并且对业务零侵入地解决分布式事务问题。
- **阿里云对象存储**：阿里云提供的海量、安全、低成本、高可靠的云存储服务。支持在任何应用、任何时间、任何地点存储和访问任意类型的数据。
- **分布式任务调度**：提供秒级、精准、高可靠、高可用的定时（基于 Cron 表达式）任务调度服务。同时提供分布式的任务执行模型，如网格任务。网格任务支持海量子任务均匀分配到所有 Worker（schedulerx-client）上执行。
- **阿里云短信服务**：覆盖全球的短信服务，友好、高效、智能的互联化通讯能力，帮助企业迅速搭建客户触达通道。

![CloudAlibaba](https://typora-nhh.oss-cn-chengdu.aliyuncs.com/SpringCloudAlibaba/CloudAlibaba.png)

## 微服务架构编码构建

### 字符编码

![字符编码](https://typora-nhh.oss-cn-chengdu.aliyuncs.com/SpringCloudAlibaba/%E5%AD%97%E7%AC%A6%E7%BC%96%E7%A0%81.png)

### 注解生效激活

![注解生效激活](https://typora-nhh.oss-cn-chengdu.aliyuncs.com/SpringCloudAlibaba/%E6%B3%A8%E8%A7%A3%E7%94%9F%E6%95%88%E6%BF%80%E6%B4%BB.png)

### Java编译版本选择8

![Java编译版本8](https://typora-nhh.oss-cn-chengdu.aliyuncs.com/SpringCloudAlibaba/Java%E7%BC%96%E8%AF%91%E7%89%88%E6%9C%AC8.png)

### File Type 过滤

![File Type 过滤](https://typora-nhh.oss-cn-chengdu.aliyuncs.com/SpringCloudAlibaba/File%20Type%20%E8%BF%87%E6%BB%A4.png)

Git提交时候过滤掉一些不必要提交的文件

### 父工程POM

```xml
<?xml version="1.0" encoding="UTF-8"?>

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>com.nhh.springcloud</groupId>
  <artifactId>SpringCloud-Alibaba</artifactId>
  <version>1.0-SNAPSHOT</version>
  <modules>
    <module>cloud-api-commons</module>
  </modules>
  <packaging>pom</packaging>

  <!-- 统一管理jar包版本 -->
  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <maven.compiler.source>1.8</maven.compiler.source>
    <maven.compiler.target>1.8</maven.compiler.target>
    <junit.version>4.12</junit.version>
    <log4j.version>1.2.17</log4j.version>
    <lombok.version>1.16.18</lombok.version>
    <mysql.version>8.0.27</mysql.version>
    <druid.version>1.1.16</druid.version>
    <mybatis.spring.boot.version>1.3.0</mybatis.spring.boot.version>
    <mybatis.plus.version>3.5.1</mybatis.plus.version>
  </properties>

  <!-- 子模块继承之后，提供作用：锁定版本+子modlue不用写groupId和version  -->
  <dependencyManagement>
    <dependencies>
      <!--spring boot 2.2.2-->
      <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-dependencies</artifactId>
        <version>2.2.2.RELEASE</version>
        <type>pom</type>
        <scope>import</scope>
      </dependency>
      <!--spring cloud Hoxton.SR1-->
      <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-dependencies</artifactId>
        <version>Hoxton.SR1</version>
        <type>pom</type>
        <scope>import</scope>
      </dependency>
      <!--spring cloud alibaba 2.1.0.RELEASE-->
      <dependency>
        <groupId>com.alibaba.cloud</groupId>
        <artifactId>spring-cloud-alibaba-dependencies</artifactId>
        <version>2.1.0.RELEASE</version>
        <type>pom</type>
        <scope>import</scope>
      </dependency>
      <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>${mysql.version}</version>
      </dependency>
      <dependency>
        <groupId>com.alibaba</groupId>
        <artifactId>druid</artifactId>
        <version>${druid.version}</version>
      </dependency>
      <dependency>
        <groupId>org.mybatis.spring.boot</groupId>
        <artifactId>mybatis-spring-boot-starter</artifactId>
        <version>${mybatis.spring.boot.version}</version>
      </dependency>
      <dependency>
        <groupId>com.baomidou</groupId>
        <artifactId>mybatis-plus-boot-starter</artifactId>
        <version>${mybatis.plus.version}</version>
      </dependency>
      <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>${junit.version}</version>
      </dependency>
      <dependency>
        <groupId>log4j</groupId>
        <artifactId>log4j</artifactId>
        <version>${log4j.version}</version>
      </dependency>
      <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <version>${lombok.version}</version>
        <optional>true</optional>
      </dependency>
    </dependencies>
  </dependencyManagement>

  <build>
    <plugins>
      <plugin>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-maven-plugin</artifactId>
        <configuration>
          <fork>true</fork>
          <addResources>true</addResources>
        </configuration>
      </plugin>
    </plugins>
  </build>
  
</project>
```

### Maven工程细节

#### Maven中的DependencyManagement和Dependencies

Maven 使用dependencyManagement 元素来提供了一种管理依赖版本号的方式。

通常会在一个组织或者项目的最顶层的父POM 中看到dependencyManagement 元素。

使用pom.xml 中的dependencyManagement 元素能让所有在子项目中引用一个依赖而不用显式的列出版本号。
Maven 会沿着父子层次向上走，直到找到一个拥有dependencyManagement 元素的项目，然后它就会使用这个
dependencyManagement 元素中指定的版本号。

![DependencyManagement和Dependencies](https://typora-nhh.oss-cn-chengdu.aliyuncs.com/SpringCloudAlibaba/DependencyManagement%E5%92%8CDependencies.png)

这样做的好处就是：如果有多个子项目都引用同一样依赖，则可以避免在每个使用的子项目里都声明一个版本号，这样当想升级或切换到另一个版本时，只需要在顶层父容器里更新，而不需要一个一个子项目的修改 ；另外如果某个子项目需要另外的一个版本，只需要声明version就可。

**dependencyManagement里只是声明依赖，并不实现引入，因此子项目需要显示的声明需要用的依赖。**

**如果不在子项目中声明依赖，是不会从父项目中继承下来的；只有在子项目中写了该依赖项，并且没有指定具体版本，才会从父项目中继承该项，并且version和scope都读取自父pom;**

 如果子项目中指定了版本号，那么会使用子项目中指定的jar版本。

#### Maven中跳过单元测试

![Maven跳过单元测试](https://typora-nhh.oss-cn-chengdu.aliyuncs.com/SpringCloudAlibaba/Maven%E8%B7%B3%E8%BF%87%E5%8D%95%E5%85%83%E6%B5%8B%E8%AF%95.png)

## Nacos

官网：https://github.com/alibaba/nacos

官网：https://nacos.io/zh-cn/index.html

### 介绍

一个更易于构建云原生应用的动态服务发现、配置管理和服务管理平台。

Nacos就是注册中心+配置中心的组合

### 功能

- **服务发现及管理**：动态服务发现对以服务为中心的（例如微服务和云原生）应用架构方式非常关键。Nacos支持DNS-Based和RPC-Based（Dubbo、gRPC）模式的服务发现。Nacos也提供实时健康检查，以防止将请求发往不健康的主机或服务实例。借助Nacos，您可以更容易地为您的服务实现断路器。
- **动态配置服务**：动态配置服务让您能够以中心化、外部化和动态化的方式管理所有环境的配置。动态配置消除了配置变更时重新部署应用和服务的需要。配置中心化管理让实现无状态服务更简单，也让按需弹性扩展服务更容易。
- **动态DNS服务**：通过支持权重路由，动态DNS服务能让您轻松实现中间层负载均衡、更灵活的路由策略、流量控制以及简单数据中心内网的简单DNS解析服务。动态DNS服务还能让您更容易地实现以DNS协议为基础的服务发现，以消除耦合到厂商私有服务发现API上的风险。

### 注册中心

#### POM

```xml
<dependency>
    <groupId>com.alibaba.cloud</groupId>
    <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
</dependency>
```

#### YML：服务提供者

```yaml
server:
  port: ***

spring:
  application:
    name: nacos-provider
  cloud:
    nacos:
      discovery:
        server-addr: ***:8848 #配置Nacos地址

management:
  endpoints:
    web:
      exposure:
        include: '*'
```

#### YML：服务消费者

```yaml
server:
  port: ***


spring:
  application:
    name: nacos-consumer
  cloud:
    nacos:
      discovery:
        server-addr: ***:8848


#消费者将要去访问的微服务名称(注册成功进nacos的微服务提供者)
service-url:
  nacos-user-service: http://nacos-provider
```

#### 主启动

`@EnableDiscoveryClient`

### 配置中心

#### POM

```xml
<dependency>
    <groupId>com.alibaba.cloud</groupId>
    <artifactId>spring-cloud-starter-alibaba-nacos-config</artifactId>
</dependency>
```

#### YML

Nacos同springcloud-config一样，在项目初始化时，要保证先从配置中心进行配置拉取，拉取配置之后，才能保证项目的正常启动。

springboot中配置文件的加载是存在优先级顺序的，bootstrap优先级高于application。

bootstrap.yml

```yaml
# nacos配置
server:
  port: ***

spring:
  application:
    name: nacos-config
  cloud:
    nacos:
      discovery:
        server-addr: ***:8848 #Nacos服务注册中心地址
      config:
        server-addr: ***:8848 #Nacos作为配置中心地址
        file-extension: yaml #指定yaml格式的配置
 
 
# ${spring.application.name}-${spring.profile.active}.${spring.cloud.nacos.config.file-extension}
```

application.yml

```yaml
spring:
  profiles:
    active: dev # 表示开发环境
```

#### 配置自动更新

通过使用 SpringCloud 原生注解 `@RefreshScope` 实现配置自动更新
