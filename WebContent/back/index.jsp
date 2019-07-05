<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>口袋小食管理平台</title>
<c:set var="contextPath" value="${pageContext.request.contextPath}" scope="application"/> 
<script>  
	   var contextPath = "${contextPath}";  
</script>  
<meta name="description" content="">
<meta name="keywords" content="">
<link href="${contextPath}/back/css/main.css" rel="stylesheet">
</head>
<body>

    <div class="header">
        <div class="header_in">
            <img src="${contextPath}/back/img/ss.ico">
            <font id="wz">口袋小食管理平台</font>
            <a href="${contextPath}/UserLogoutServlet">
                <div class="quit text_center">安全退出</div>
            </a>

        </div>
    </div>

    <div class="content ">
        <div class="user">
            <div class="user_status fl text_center">当前用户： <span>${sessionScope.user.username}</span></div>
            <div class="user_location fl">当前： 首页-<span>用户管理</span>  </div>
        </div>
        <div class="nav_side text_center fl">
            <div class="nav UserManagement active">用户管理</div>
            <div class="nav KindManagement">类型管理</div>
            <div class="nav BrandManagement">品牌管理</div>
            <div class="nav FoodManagement">食品管理</div>
            <div class="nav OrdersManagement">订单管理</div>
            <div class="nav AccountManagement">账户管理</div>
        </div>

        <div class="main_fx">
            <div class="AccountManagement_c_iframe">
                <iframe id="MainFrame" src="${contextPath}/FindUserByPageServlet"></iframe>
            </div>
        </div>
    </div>

</body>
<script type="text/javascript" src="${contextPath}/back/js/jquery.js"></script>
<script type="text/javascript" src="${contextPath}/back/js/main.js"></script>

</html>
