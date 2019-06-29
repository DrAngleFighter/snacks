<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="css/main.css" rel="stylesheet">
</head>
<body>
    <!-- 订单管理 -->
            <div class="AccountManagement_c" id="ColumnManagement_c">
                <h3>订单管理 
                  
                </h3>
               

                <div class="list">
                    <ul class="list_h">
                        <li class="b20"><label><input type="checkbox" name="newsId"><span>序号</span></label></li>
                        <li class="b20"><label>订单编号</label></li>
                         <li class="b20"><label>食品名称</label></li>
                          <li class="b20"><label>数量</label></li>
                           <li class="b20"><label>订单状态</label></li>
                        <li class="b60"><label>操作</label></li>
                    </ul>
                    <div class="list_b_c">
                       

                            <ul class="list_b">
                                <li class="b20"><label><input type="checkbox" name=""><span>1</span></label></li>
                                <li class="b20"><label>5435345342424</label></li>
                                 <li class="b20"><label>三只松鼠 夏威夷果</label></li>
                                  <li class="b20"><label>4</label></li>
                                   <li class="b20"><label>代发货</label></li>
                                <li class="b60">
                            	<a href="orderedit.jsp"><div class="edit_btn df_btn fl text_center">编辑</div></a>
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




</body>
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/main.js"></script>
</html>