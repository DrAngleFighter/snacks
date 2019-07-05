<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="${contextPath}/back/css/main.css" rel="stylesheet">
</head>
<body>
<!-- 用户管理 -->
            <div class="AccountManagement_c" id="NewsManagement_c">
                <h3>用户管理 
                    <div class="amcl fr">
                        <input type="text" placeholder="用户名" class="fl" name="">
                        <div class="search fl"><img src="${contextPath}/back/images/search.png"></div>
                    </div> 
                </h3>
                <div class="list" id="release_news">
                    <ul class="list_h">
                        <li class="b80"><label>用户</label>
                        信息</li>
                    </ul>
                    <div class="list_b_c" id="release_news_in">
                        <div class="release_news">
                            <div class="news_title">
                                <label class="text_center">用户名</label>
                            ：</div>
                            <div class="news_title">
                               <label class="text_center">性别</label>
                            ：</div>
                             <div class="news_title">
                               <label class="text_center">生日</label>
                            ：</div>
                             <div class="news_title">
                               <label class="text_center">电话</label>
                            ：</div> 
                            <div class="release_news_ok_btn text_center">保存</div>
                        </div>
                    </div>
                </div>
            </div>
</body>
</html>