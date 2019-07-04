<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>付款成功页面</title>
<link rel="stylesheet"  type="text/css" href="css/amazeui.css"/>
<link href="css/admin.css" rel="stylesheet" type="text/css">
<link href="css/demo.css" rel="stylesheet" type="text/css" />
<link href="css/sustyle.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.7.min.js"></script>

</head>

<body>

			<iframe src="header.jsp" width="100%" height="120px" frameborder="0"></iframe>
            
<div class="take-delivery">
 <div class="status">
   <h2>您已成功付款</h2>
   <div class="successInfo">
     <ul>
       <li>付款金额<em>${total_price}</em></li>
       <div class="user-info">
         <p>收货人：${address.name}</p>
         <p>联系电话：${address.phone}</p>
         <p>收货地址：${address.full_address}</p>
       </div>
             请认真核对您的收货信息，如有错误请联系客服
                               
     </ul>
     <div class="option">
       <span class="info">您可以</span>
        <a href="person/order.jsp" class="J_MakePoint">查看<span>已买到的宝贝</span></a>
        <a href="person/orderinfo.jsp" class="J_MakePoint">查看<span>交易详情</span></a>
     </div>
    </div>
  </div>
</div>


			<iframe src="footer.jsp" width="100%" height="150px" frameborder="0"></iframe>


</body>
</html>
