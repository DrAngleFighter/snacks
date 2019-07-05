<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>注册</title>
		

		<link rel="stylesheet" href="css/amazeui.min.css" />
		<link href="css/dlstyle.css" rel="stylesheet" type="text/css">
		<script src="js/jquery.min.js"></script>
		<script src="js/amazeui.min.js"></script>
		<script src="js/check.js"></script>

	</head>

	<body>

		<iframe src="header.jsp" width="100%" height="120px" frameborder="0"></iframe>
<br>
		<div class="res-banner">
			<div class="res-main">
				<div class="login-banner-bg"><span></span><img src="images/big.jpg" /></div>
				<div class="login-box">

						<div class="am-tabs" id="doc-my-tabs">
							<ul class="am-tabs-nav am-nav am-nav-tabs am-nav-justify">
								<li class="am-active"><a href=""  style="text-align:left; padding:0; margin:0">邮箱注册</a></li>
								
							</ul>

							<div class="am-tabs-bd">
								<div class="am-tab-panel am-active">
									<form method="post" action="UserRegisterServlet" onsubmit="return check()">
										
							   <div class="user-email">
							     <input type="text" name="username" id="username" placeholder="请输入邮箱账号" onblur="checkExistName()">
								</div>
								<font color ="red" id="usernameMsg"></font>
                 <div class="user-pass">
                   <input type="password" name="password" id="userPassword" placeholder="设置密码">
                 </div>										
                 <div class="user-pass">
                   <input type="password" name="" id="userPasswordRepeat" placeholder="确认密码">
                 </div>	
                 
                 
                 
								 <div class="login-links">
										<label for="reader-me">
											<input id="reader-me" type="checkbox"> 点击表示您同意商城《服务协议》
										</label>
							  	</div>
										<div class="am-cf">
											<input type="submit" name="" value="注册" class="am-btn am-btn-primary am-btn-sm am-fl">
										</div>


				</form>

								<div class="am-tab-panel">
									<form method="post">
                 <div class="user-phone">
								    <label for="phone"><i class="am-icon-mobile-phone am-icon-md"></i></label>
								    <input type="tel" name="" id="phone" placeholder="请输入手机号">
                 </div>																			
										<div class="verification">
											<label for="code"><i class="am-icon-code-fork"></i></label>
											<input type="tel" name="" id="code" placeholder="请输入验证码">
											<a class="btn" href="javascript:void(0);" onclick="sendMobileCode();" id="sendMobileCode">
												<span id="dyMobileButton">获取</span></a>
										</div>
                 <div class="user-pass">
								    <label for="password"><i class="am-icon-lock"></i></label>
								    <input type="password" name="" id="password" placeholder="设置密码">
                 </div>										
                 <div class="user-pass">
								    <label for="passwordRepeat"><i class="am-icon-lock"></i></label>
								    <input type="password" name="" id="passwordRepeat" placeholder="确认密码">
                 </div>	
									</form>
								 <div class="login-links">
										<label for="reader-me">
											<input id="reader-me" type="checkbox"> 点击表示您同意商城《服务协议》
										</label>
							  	</div>
										<div class="am-cf">
											<input type="submit" name="" value="注册" class="am-btn am-btn-primary am-btn-sm am-fl">
										</div>
								
									<hr>
								</div>

								<script>
									$(function() {
									    $('#doc-my-tabs').tabs();
									  })
								</script>

							</div>
						</div>

				</div>
			</div>
			
			<iframe src="footer.jsp" width="100%" height="150px" frameborder="0"></iframe>
	</body>

</html>