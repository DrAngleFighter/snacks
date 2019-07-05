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
    <!-- 食品管理 -->
            <div class="AccountManagement_c" id="ColumnManagement_c">
                <h3>食品管理 
                    <div class="amcl fr">
                        <input type="text" placeholder="食品名" class="fl" name="">
                        <div class="search fl"><img src="${contextPath}/back/images/search.png"></div>
                    </div> 
                </h3>
                <div class="AM_ct text_center">
                    <div class="AM_ct_in">
                        <a href="back/foodadd.jsp"><div class="add_btn df_btn fl" id="add_column_btn">添加</div></a>
                    </div>
                </div>

                <div class="list">
                    <ul class="list_h">
                        <li class="b20"><label><input type="checkbox" name="newsId"><span>序号</span></label></li>
                        <li class="b20"><label>食品名称</label></li>
                         <li class="b20"><label>品牌</label></li>
                          <li class="b20"><label>类型</label></li>
                        <li class="b60"><label>操作</label></li>
                    </ul>
                    <div class="list_b_c">
                       
						<c:forEach items = "${requestScope.pageUtil.list }" var="commodity" varStatus="status">
                            <ul class="list_b">
                                <li class="b20"><label><input type="checkbox" name=""><span>${status.index+1}</span></label></li>
                                <li class="b20"><label>${commodity.cname }</label></li>
                                 <li class="b20"><label>${commodity.brand_name }</label></li>
                                  <li class="b20"><label>${commodity.category_name }</label></li>
                                <li class="b60">
                            	<a href="foodedit.jsp"><div class="edit_btn df_btn fl text_center">编辑</div></a>
                        		<a href="javascript:deleteCommodity(${commodity.commodity_id })"><div class="delete_btn df_btn fl text_center">删除</div></a>
                        		</li>
                            </ul>
                      	</c:forEach>
                    	<script>
                    		function deleteCommodity(id){
                    			if (confirm("确认要删除吗？")){
                    				location.href="${pageContext.request.contextPath }/DeleteCommodityByIdServlet?commodity_id=" + id;
                    			}
                    		}
                    	</script>
                       
                    </div>

                    <div class="pull_page">
                        <div class="fl pull_page_up"><a href="${pageContext.request.contextPath }//FindCommodityByPageServlet?currentPage=1">首页</a></div>
                            <ul>
                                <li><a href="${pageContext.request.contextPath }//FindCommodityByPageServlet?currentPage=${requestScope.pageUtil.currentPage==1?1:requestScope.pageUtil.currentPage-1 }">上一页</a></li>
                                <li><a href="${pageContext.request.contextPath }//FindCommodityByPageServlet?currentPage=${requestScope.pageUtil.currentPage==requestScope.pageUtil.totalPage?requestScope.pageUtil.totalPage:requestScope.pageUtil.currentPage+1 }">下一页</a></li>
                            </ul>
                        <div class="fl pull_page_down"><a href="${pageContext.request.contextPath }//FindCommodityByPageServlet?currentPage=${requestScope.pageUtil.totalPage}">尾页</a></div>
       
                       	<div style="float: left;line-height: 65px;margin-left:30px">当前第${requestScope.pageUtil.currentPage }页/共${requestScope.pageUtil.totalPage }页</div>
                    </div>

                </div>
            </div>




           

</body>
<script type="text/javascript" src="${contextPath}/back/js/jquery.js"></script>
<script type="text/javascript" src="${contextPath}/back/js/main.js"></script>
</html>