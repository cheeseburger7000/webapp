# webapp
- 项目基于maven构建
- 巩固javaweb基础知识，涉及路径，乱码，转发和重定向等

## javaweb乱码问题
### 1.处理post乱码
### 2.处理get乱码

## 会话管理

## 过滤器，Spring MVC拦截器

## javaweb网站路径问题
### 1.如何在servlet中将请求转发到WEB-INF下的jsp？
语法规则如下：
```
request.getRequestDispatcher("/WEB-INF/jsp/forward.jsp").forward(request, response);
```

Q：为什么你需要将网站中所有的jsp页面都存储在`WEB-INF`？
A:能够保护你的jsp。
用户无法直接访问`WEB-INF`。
如果用户直接访问jsp页面，由于四个域对象中不包含任何被服务器处理过的数据，那么tomcat在解析jsp的过程中就会出错。

Q：index.jsp也需要放在`WEB-INF`下吗？
A：没错！你可以为你的index.jsp准备一个IndexServlet，映射路径为`/`。当用户访问网页主页时，就能够正常显示网站主页。

### 2.用户无法访问WEB-INF下的内容，那么可以访问哪些位置？
工程中webapp目录下除了`WEB-INF`以外的所有目录。

webapp在项目中就是classpath？
不是哦！
classes和resource下，才是classpath

### 3.在Servlet中如何获取Maven工程resouces下的文件，例如favicon.ico？
classpath：classes和resource。

classpath的位置？
```
String classPath = request.getSession().getServletContext().getRealPath("/WEB-INF/classes/");
```

两种url：
1. 给服务器使用, 代表web工程根路径(webroot) 。这里：`request.getSession().getServletContext().getRealPath("/");`
2. 给浏览器使用, 代表tomcat 目录下的webapps文件夹，不包括web-inf
	
## 转发和重定向
转发-站内。重定向-站内和站外
转发-url不改变。重定向-url改变
重定向之后，request中的数据丢失。

### 1.转发
#### 转发保持http请求类型。  
用户发送get请求访问servlet，servlet默认以get转发。
若用户发送post请求，那么servlet默认以post转发。
即servlet转发方式以用户的请求类型保持一致。
但是重定向只有get请求。

#### jsp本质就是servlet，而servlet的本质就是`实现javax.http.Servlet的java类`。
因此转发到jsp和servlet都是一样的。
因为jsp本质上就是一个“都是输出的servlet”。

#### 转发和http响应码
转发成功之后，http响应码为200。
如果与之前请求一致（请求参数不变），那么http响应码为304。

### 2.重定向
两种形式：
1.重定向到站外
2.重定向到站内servlet

http响应码为302
响应头Location为重定向的地址。

## jstl
- `<c:if>`
```
<c:if test="${empty param.age}">
    没有年龄...
</c:if>
<c:if test="${param.age>=12 and param.age<30}">
    年龄符合...
</c:if>
```

- `<c:forEach>`
```
<c:forEach items="${goods}" var="good">
    ${good.name}
</c:forEach>
```
