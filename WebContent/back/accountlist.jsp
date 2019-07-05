<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="${contextPath}/back/css/main.css" rel="stylesheet">
</head>
<body>
			<div class="AccountManagement_c " id="AccountManagement_c">
                <h3>账户管理 
                </h3>

                <div class="list">
                    <ul class="list_h">
                        <li class="b20"><label><input type="checkbox" name=""><span>用户名</span></label></li>
                        <li class="b20"><label>密码</label></li>
                        <li class="b20"><label>角色</label></li>
                        <li class="b60"><label>操作</label></li>
                    </ul>
                    <div class="list_b_c">
                            
                       <c:forEach items = "${requestScope.pageUtil.list}" var="user" varStatus="status">    
                        <ul class="list_b">
                            <li class="b20"><label><input type="checkbox" name=""><span>${user.username}</span></label></li>
                            <li class="b20"><label>${user.password}</label></li>
                            <li class="b20"><label>管理员</label></li>
                            <li class="b60"> 
                            		<a href="/back/accountedit.jsp" ><div class="edit_btn df_btn fl text_center">编辑</div></a>
                        			<a href=""><div class="delete_btn df_btn fl text_center">删除</div></a>
                            </li>
                        </ul>
                      </c:forEach>
                       
                        
                    </div>

                   
                    
                </div>
            </div>



   
    
</body>
<script type="text/javascript" src="${contextPath}/back/js/jquery.js"></script>
<script type="text/javascript" src="${contextPath}/back/js/main.js"></script>
</html>