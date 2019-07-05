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
    <!-- 订单管理 -->
            <div class="AccountManagement_c" id="ColumnManagement_c">
                <h3>订单管理 
                  
                </h3>
               

                <div class="list">
                    <ul class="list_h">
                        <li class="b20"><label><input type="checkbox" name="newsId"><span>序号</span></label></li>
                        <li class="b20"><label>订单编号</label></li>
                         <li class="b20"><label>备注</label></li>
                          <li class="b20"><label>下单时间</label></li>
                           <li class="b20"><label>订单状态</label></li>
                        <li class="b60"><label>操作</label></li>
                    </ul>
                    <div class="list_b_c">
                       
                      <c:forEach items = "${requestScope.pageUtil.list}" var="order" varStatus="status">   
                            <ul class="list_b">
                                <li class="b20"><label><input type="checkbox" name=""><span>${status.index+1}</span></label></li>
                                <li class="b20"><label>${order.oid }</label></li>
                                 <li class="b20"><label>${order.remark }</label></li>
                                  <li class="b20"><label>${order.ordertime }</label></li>
                                   <li class="b20"><label>${order.state }</label></li>
                                <li class="b60">
                            	<a href="orderedit.jsp"><div class="edit_btn df_btn fl text_center">编辑</div></a>
                        		<a href="ItemDeleteItem?newsId=${newsId}"><div class="delete_btn df_btn fl text_center">删除</div></a>
                        		</li>
                            </ul>
                      </c:forEach>
                     
                       
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
<script type="text/javascript" src="${contextPath}/back/js/jquery.js"></script>
<script type="text/javascript" src="${contextPath}/back/js/main.js"></script>
</html>