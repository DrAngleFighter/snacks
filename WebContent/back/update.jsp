<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="${contextPath}/back/css/main.css" rel="stylesheet">
</head>
<body>
<!-- 新闻管理 -->
            <div class="AccountManagement_c" id="NewsManagement_c">
                <h3>电影管理 
                    <div class="amcl fr">
                        <select class="fl NewsManagement_search">
                            <option>教务处</option>
                            <option>教务处</option>
                            <option>教务处</option>
                            <option>教务处</option>
                            <option>教务处</option>
                        </select>
                        <input type="text" placeholder="用户名" class="fl" name="">
                        <div class="search fl"><img src="${contextPath}/back/images/search.png"></div>
                    </div> 
                </h3>
                <div class="list" id="release_news">
                    <ul class="list_h">
                        <li class="b80"><label>发布电影</label></li>
                    </ul>
                    <div class="list_b_c" id="release_news_in">
                        <div class="release_news">
                            <div class="news_title">
                                <label class="text_center">标题</label>
                                <input type="text" placeholder="填写标题" name="">
                            </div>
                            <div class="column_name">
                                <label class="text_center">栏目</label>
                                <select class="column_name_release">
                                    <option>教务处</option>
                                    <option>教务处</option>
                                    <option>教务处</option>
                                    <option>教务处</option>
                                    <option>教务处</option>
                                    <option>教务处</option>
                                </select>
                            </div>
                            <textarea class="release_news_content" rows="50" cols="60" placeholder="编辑正文"></textarea>     
                            <div class="release_news_ok_btn text_center">发<i>我</i>布</div>
                        </div>
                    </div>
                </div>
            </div>
</body>
</html>