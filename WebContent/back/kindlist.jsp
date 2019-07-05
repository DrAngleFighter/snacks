<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="${contextPath}/back/css/main.css" rel="stylesheet">
</head>
<body>
    <!-- 类型管理 -->
            <div class="AccountManagement_c" id="ColumnManagement_c">
                <h3>类型管理 
                    <div class="amcl fr">
                        <input type="text" placeholder="类型名" class="fl" name="">
                        <div class="search fl"><img src="${contextPath}/back/images/search.png"></div>
                    </div> 
                </h3>
                <div class="AM_ct text_center">
                    <div class="AM_ct_in">
                        <a href="kindadd.jsp"><div class="add_btn df_btn fl" id="add_column_btn">添加</div></a>
                    </div>
                </div>

                <div class="list">
                    <ul class="list_h">
                        <li class="b20"><label><input type="checkbox" name="newsId"><span>序号</span></label></li>
                        <li class="b20"><label>一级类型名称</label></li>  <li class="b20"><label>二级类型名称</label></li>
                        <li class="b60"><label>操作</label></li>
                    </ul>
                    <div class="list_b_c">
                       
	                    
                            <ul class="list_b">
                                <li class="b20"><label><input type="checkbox" name=""><span>1</span></label></li>
                                <li class="b20"><label>休闲食品</label></li>
                                 <li class="b20"><label>饼干蛋糕</label></li>
                                <li class="b60">
                            	<a href="kindedit.jsp"><div class="edit_btn df_btn fl text_center">编辑</div></a>
                        		<a href="ItemDeleteItem?newsId=${newsId}"><div class="delete_btn df_btn fl text_center">删除</div></a>
                        		</li>
                            </ul>
  
            
                        
                        
                        
                     
                       
                    </div>

                    <div class="pull_page">
                        <div class="fl pull_page_up">上一页</div>
                            <ul>
                                <li class="on">1</li>
                                <li>2</li>
                                <li>3</li>
                                <li>4</li>
                                <li class="pull_page_df_btn">…</li>
                                <li>12</li>
                            </ul>
                        <div class="fl pull_page_down">下一页</div>
                    </div>

                    
                </div>
            </div>


            <!-- 添加栏目 -->
    <div class="add_Account dn" id="add_column">
        <div class="add_Account_c">
            <div class="add_Account_h">
                <div class="add_Account_h_in">
                    添加栏目
                    <span class="fr add_Account_close"><img src="${contextPath}/back/images/close.png"></span>
                </div>
            </div>
            <div class="user_name user_i">
                <label>栏目名</label> <input type="text" placeholder="输入栏目名" name="">     
            </div>
            <div class="user_password user_i">
                <label>序<i>调</i>号</label> <input type="text" placeholder="输入序号" name="">     
            </div>
            <div class="add_Account_ok_btn text_center" id="add_column_ok_btn">确<i>皮</i>定</div>
        </div>
    </div>

    <!-- 编辑栏目 -->
    <div class="add_Account dn" id="edit_column">
        <div class="add_Account_c">
            <div class="add_Account_h">
                <div class="add_Account_h_in">
                    编辑栏目
                    <span class="fr add_Account_close"><img src="${contextPath}/back/images/close.png"></span>
                </div>
            </div>
            <div class="user_name user_i">
                <label>栏目名</label> <input type="text" placeholder="输入栏目名" name="">     
            </div>
            <div class="user_password user_i">
                <label>序<i>调</i>号</label> <input type="text" placeholder="输入序号" name="">     
            </div>
            <div class="add_Account_ok_btn text_center" id="edit_column_ok_btn">确<i>皮</i>定</div>
        </div>
    </div>

    <!-- 删除栏目 -->
    <div class="add_Account dn" id="delete_column">
        <div class="add_Account_c">
            <div class="add_Account_h">
                <div class="add_Account_h_in">
                    删除栏目
                    <span class="fr add_Account_close"><img src="${contextPath}/back/images/close.png"></span>
                </div>
            </div>
            <div class="delete_text">确定删除“ <span>jiaopwuchu</span> ”栏目吗？</div>
            <div class="add_Account_ok_btn text_center" id="delete_column_ok_btn">确<i>皮</i>定</div>
        </div>
    </div>


</body>
<script type="text/javascript" src="${contextPath}/back/js/jquery.js"></script>
<script type="text/javascript" src="${contextPath}/back/js/main.js"></script>
</html>