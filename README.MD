# Spring Security 实战

## 简介

## 从一个小例子开始

### 创建不受 Spring Security 保护的应用

### 将应用纳入 Spring Security 保护

### POM中加入相关依赖
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```
### 访问控制-认证与授权

### 获取当前用户信息

### 总结

## Spring Security 核心类

### 用户信息接口类 UserDetails
`org.springframework.security.core.userdetails.UserDetails`

`UserDetails` 定义了一系列方法在认证过程中均会被调用，这个接口只定义了它的实现类（用户类）所必须要的一些动作，这些方法的返回不允许为`null`。
它的实现类允许开发者添加一些其他的属性，如：Email、手机号码、家庭住址等。

### 用户角色接口类 GrantedAuthority
`org.springframework.security.core.GrantedAuthority`

`GrantedAuthority`代表了授权给用户的权限或者角色。`getAuthority()`返回的是字符串，表示了对应的角色或者权限。用户可以拥有多个`GrantedAuthority`。

### 密码加解密类 PasswordEncoder
`org.springframework.security.crypto.password.PasswordEncoder`

密码的加解和匹配密码的接口类，该类 SpringSecurity 有多个默认实现每种实现的加密方法均不一样。默认没有加入spring容器管理。
为了提高加解密的通用性，SpringSecurity 实现了 `DelegatingPasswordEncoder`，这个类为多种加密和匹配提供了统一代理。
`DelegatingPasswordEncoder`内部维护了一个Map，key 为加密名称，value`PasswordEncoder`各种算法的实现。
这个类生成密码时会在前面加上大括号，如： {加密名称}XXXX，括号内为加密方法的名称。匹配密码时，会先从截取大括号内的加密方法，然后取出对应的 `PasswordEncoder` 进行密码匹配。
值得注意的是，PasswordEncoder 只提供了两个方法必须要实现的方法`String encode(CharSequence rawPassword)`和`boolean matches(CharSequence rawPassword, String encodedPassword)`，也就是说加密过后的密码不一定能解密。

### 用户信息查询类 UserDetailsService
`org.springframework.security.core.userdetails.UserDetailsService`

加载用户特定数据的核心接口。SpringSecurity并没有规定用户信息要存储到哪里存储内容是什么样子。
它会被DaoAuthenticationProvider调用，该接口只需要一个只读方法，这简化了对新数据访问策略的支持。

### 安全核心配置类 WebSecurityConfigurerAdapter
`org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter`

为创建 WebSecurityConfigurer 提供了一个方便的基类实例。该实现允许通过覆盖方法进行定制。
`void configure(AuthenticationManagerBuilder auth)`用来配置认证管理器AuthenticationManager，说白了就是所有 UserDetails 相关的它都管，包含 PasswordEncoder 密码机。

`void configure(HttpSecurity http)`安全过滤器链配置方法。这个是我们使用最多的，用来配置 HttpSecurity 
HttpSecurity 用于构建一个安全过滤器链 SecurityFilterChain，SecurityFilterChain 最终被注入核心过滤器。

`void configure(WebSecurity web)`核心过滤器配置方法，而 WebSecurity 是基于 Servlet Filter 用来配置 springSecurityFilterChain。
而 springSecurityFilterChain 又被委托给了 Spring Security 核心过滤器 Bean DelegatingFilterProxy 
使用较多的使其ignoring() 方法用来忽略 Spring Security 对静态资源的控制

### 安全数据标记类 FilterInvocationSecurityMetadataSource
`org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource`

### 用户审计类 AuditorAware
`org.springframework.data.domain.AuditorAware`

### SecurityContext

### SecurityContextHolder

### Authentication

### AuthenticationManager


## 一个稍微复杂的例子


## Spring Security 核心注解
@PreAuthorize()
@PostAuthorize()
@PostFilter()
@PreFilter()
@AuthenticationPrincipal()

## Spring Security 自定义注解

## Spring Security 会话管理

## Spring Security 认证原理
### SecurityContextPersistenceFilter 解析

### UsernamePasswordAuthenticationFilter 解析

## Spring Security 自定义认证逻辑-图形验证码实现

## Spring Security 授权原理

### FilterSecurityInterceptor 解析

### SecurityMetadataSource 解析

### AccessDecisionManager 解析

### AccessDecisionVoter 解析

## Spring Security 自定义授权逻辑

## 前端对密码进行加密处理

## 



## Spring Security 与 JPA 结合








