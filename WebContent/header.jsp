<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<link href="css/amazeui.css" rel="stylesheet" type="text/css" />
<link href="css/admin.css" rel="stylesheet" type="text/css" />
<link href="css/demo.css" rel="stylesheet" type="text/css" />
<link href="css/hmstyle.css" rel="stylesheet" type="text/css" />
<script src="js/jquery.min.js"></script>
<script src="js/amazeui.min.js"></script>
</head>

<body>

<!--顶部导航条 -->
<div class="am-container header">
  <ul class="message-l">
    <div class="topMessage">
      <c:if test="${sessionScope.user == null}">
        <div class="menu-hd"> <a href="login.jsp" target="_top" class="h">亲，请登录</a> <a href="register.jsp" target="_top">免费注册</a> </div>
      </c:if>
      <c:if test="${sessionScope.user != null}">
        <div>欢迎 <a href="person/index.jsp" target="_top">${sessionScope.user.username}</a> <a href="UserLogoutServlet" target="_top">退出登录</a></div>
      </c:if>
    </div>
  </ul>
  <ul class="message-r">
    <div class="topMessage home">
      <div class="menu-hd"><a href="LatestCommdityServlet" target="_top" class="h">商城首页</a></div>
    </div>
    <div class="topMessage my-shangcheng">
      <div class="menu-hd MyShangcheng"><a href="person/index.jsp" target="_top">个人中心</a></div>
    </div>
    <div class="topMessage mini-cart">
      <div class="menu-hd"><a id="mc-menu-hd" href="FindCartByUidServlet" target="_top"><span>购物车</span></a></div>
    </div>

    </div>
</ul>
</div>
<!--悬浮搜索框-->
<div class="nav white">
  <div class="logoBig">
    <li><img src="images/logobig1.png" /></li>
  </div>
  <div class="search-bar pr">
    <form action="search.jsp" target="_top" method="post">
      <input id="searchInput" name="index_none_header_sysc" type="text" placeholder="搜索" autocomplete="off">
      <input id="ai-topsearch" class="submit am-btn" value="搜索" index="1" type="submit">
    </form>
  </div>
</div>

</body>
</html>