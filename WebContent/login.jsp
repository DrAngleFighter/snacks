<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>登录</title>
		

		<link rel="stylesheet" href="css/amazeui.css" />
		<link href="css/dlstyle.css" rel="stylesheet" type="text/css">
	</head>

	<body>

		<iframe src="header.jsp" width="100%" height="120px" frameborder="0"></iframe>
		<br>
		<div class="login-banner">
			<div class="login-main">
				<div class="login-banner-bg"><span></span><img src="images/big.jpg" /></div>
                <form method="post" action="UserLoginServlet">
				<div class="login-box">

							 <br>
        <h3 class="title">登录商城</h3>
		 <br> <br>

							<div class="clear"></div>
						
						<div class="login-form">
							   <div class="user-name">
								 
								    <input type="text" name="username" id="user" placeholder="用户名">
                 </div>
                 <div class="user-pass">
	
								    <input type="password" name="password" id="password" placeholder="请输入密码">
                 </div>
				
           	</div>
		   	<font color="red">${requestScope.msg}</font>
            <div class="login-links">
          <a href="#" class="am-fr">忘记密码</a>
          <br />
        </div>
								<div class="am-cf">
									<input type="submit" name="" value="登 录" class="am-btn am-btn-primary am-btn-sm">
								</div>
<div align="right"><a href="register.jsp" style="font-size:13px;">还没有账号，注册一个</a></div>
         
				</div>
                </form>
			</div>
		</div>

			<iframe src="footer.jsp" width="100%" height="150px" frameborder="0"></iframe>

	</body>

</html>