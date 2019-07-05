<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="${contextPath}/back/css/main.css" rel="stylesheet">
</head>
<body>
<!-- 品牌管理 -->
            <div class="AccountManagement_c" id="NewsManagement_c">
                <h3>品牌管理 
                    <div class="amcl fr">
                        <input type="text" placeholder="品牌名" class="fl" name="">
                        <div class="search fl"><img src="${contextPath}/back/search.png"></div>
                    </div> 
                </h3>
                <div class="list" id="release_news">
                    <ul class="list_h">
                        <li class="b80"><label>添加品牌</label></li>
                    </ul>
                    <div class="list_b_c" id="release_news_in">
                        <div class="release_news">
                        	<div class="news_title">
                                <label class="text_center">品牌名称：</label>
                                <input type="text" placeholder="填写品牌名称" name="">
                            </div>
                            <div class="news_title">
                                <label class="text_center">负责人：</label>
                                <input type="text" placeholder="填写负责人" name="">
                            </div>
                            <div class="news_title">
                                <label class="text_center">联系电话：</label>
                                <input type="text" placeholder="填写联系电话" name="">
                            </div>
                            <div class="news_title">
                                <label class="text_center">供货地址：</label>
                                <input type="text" placeholder="填写供货地址" name="">
                            </div>
                            <div class="release_news_ok_btn text_center">保存</div>
                        </div>
                    </div>
                </div>
            </div>
</body>
</html>