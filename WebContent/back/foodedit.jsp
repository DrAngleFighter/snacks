<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="${contextPath}/back/main.css" rel="stylesheet">
</head>
<body>
<!-- 食品管理 -->
            <div class="AccountManagement_c" id="NewsManagement_c">
                <h3>食品管理 
                    <div class="amcl fr">
                     
                        <input type="text" placeholder="食品名" class="fl" name="">
                        <div class="search fl"><img src="${contextPath}/back/images/search.png"></div>
                    </div> 
                </h3>
                <div class="list" id="release_news">
                    <ul class="list_h">
                        <li class="b80"><label>编辑食品</label></li>
                    </ul>
                    <div class="list_b_c" id="release_news_in">
                        <div class="release_news">
                            <div class="news_title">
                                <label class="text_center">名字</label>
                                <input type="text" placeholder="填写食品名" name="" value="良品铺子 手剥松子218g 坚果炒货 巴西松子">
                            </div>
                            <br>
                            <div class="news_title">
                                <label class="text_center">单价</label>
                                <input type="text" placeholder="填写单价" name="" value="54">
                            </div>
                             
                             <div class="column_name">
                                <label class="text_center">口味</label>
                                <input type="checkbox" checked>麻辣 &nbsp; &nbsp;<input type="checkbox" >番茄
                            </div>
                            <div class="column_name">
                                <label class="text_center">类型</label>
                                <select class="column_name_release">
                                    <option>休闲食品</option>
                                    <option></option>
                                    <option></option>
                                    <option></option>
                                    <option></option>
                                    <option></option>
                                </select>
                            </div>
                            <div class="column_name">
                                <label class="text_center">品牌</label>
                                <select class="column_name_release">
                                    <option>良品铺子</option>
                                    <option></option>
                                    <option></option>
                                    <option></option>
                                    <option></option>
                                    <option></option>
                                </select>
                            </div>
                            <br>
                            <div class="news_title">
                                <label class="text_center">图片</label>
                                <input type="file" placeholder="选择图片" name="">
                            </div>
                           
                            <div class="release_news_ok_btn text_center">保存</div>
                        </div>
                    </div>
                </div>
            </div>
</body>
</html>