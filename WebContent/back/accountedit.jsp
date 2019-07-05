<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="${contextPath}/back/css/main.css" rel="stylesheet">
</head>
<body>
<!-- 账户管理 -->
            <div class="AccountManagement_c" id="NewsManagement_c">
                <h3>账户管理 
                    
                </h3>
                <div class="list" id="release_news">
                    <ul class="list_h">
                        <li class="b80"><label>账户编辑</label></li>
                    </ul>
                    <div class="list_b_c" id="release_news_in">
                        <div class="release_news">
                        	<div class="news_title">
                                <label class="text_center">账户名：</label>
                                <input type="text" placeholder="填写账户名" name="" value="张三">
                            </div>
                            <div class="news_title">
                                <label class="text_center">密码：</label>
                                <input type="password" placeholder="填写密码" name="" >
                            </div>
                            <div class="news_title">
                                <label class="text_center">确认密码：</label>
                                <input type="password" placeholder="填写确认密码" name="">
                            </div>
                            <div class="release_news_ok_btn text_center">保存</div>
                        </div>
                    </div>
                </div>
            </div>
</body>
</html>