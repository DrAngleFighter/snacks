<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">

		<title>个人中心</title>
		<c:set var="contextPath" value="${pageContext.request.contextPath}" scope="application"/>
		<script>
			var contextPath = "${contextPath}";
		</script>
		<link href="${contextPath}/css/admin.css" rel="stylesheet" type="text/css">
		<link href="${contextPath}/css/amazeui.css" rel="stylesheet" type="text/css">
		<link href="${contextPath}/css/personal.css" rel="stylesheet" type="text/css">
		<link href="${contextPath}/css/vipstyle.css" rel="stylesheet" type="text/css">
		<script src="${contextPath}/js/jquery.min.js"></script>
		<script src="${contextPath}/js/amazeui.js"></script>
	</head>

	<body>
		<iframe src="${contextPath}/header.jsp" width="100%" height="150px" frameborder="0"></iframe>
		<div class="nav-table">
			<div class="long-title"><span class="all-goods">全部分类</span></div>
			<div class="nav-cont">
				
				
			</div>
		</div>
		<b class="line"></b>
		<div class="center">
			<div class="col-main">
				<div class="main-wrap">
					<div class="wrap-left">
						<div class="wrap-list">
							<div class="m-user">
								<!--个人信息 -->

								<div class="m-userinfo">
									<a href="${contextPath}/person/news.jsp">
										<div class="tipsBox"><i class="am-icon-envelope"></i></div>
									</a>
									<div class="m-baseinfo">
										<a class="m-pic" href="information.jsp">
											<img src="${contextPath}/images/getAvatar.do.jpg">
										</a>
										<div class="m-info">
											<em class="s-name">${sessionScope.user.username}</em>
				<div class="safeText">
												<div class="progressBar"><span style="left: -95px;" class="progress"></span></div>
											</div>
											<div class="m-address">
												<a href="${contextPath}/person/address.jsp" class="i-trigger">收货地址<i class="am-icon-angle-right" style="padding-left:5px ;"></i></a>
											</div>
										</div>
									</div>
									<div class="m-right">
										<div class="m-new">
											<a href="${contextPath}/person/news.jsp"><i class="am-icon-dropbox  am-icon-md" style="padding-right:5px ;"></i>消息盒子</a>
										</div>

									</div>
								</div>

								<!--个人资产-->
								<div class="m-userproperty" style="width:66%">
									<div class="s-bar">
										<i class="s-icon"></i>个人资产
									</div>
									
									<p class="m-wallet">
										<a href="${contextPath}/person/wallet.jsp">
											<em class="m-num">${requestScope.account.money}</em>
											<span class="m-title">账户余额</span>
										</a>
									</p>
									<p class="m-bill">
										<a href="${contextPath}/person/pointnew.jsp">
											<em class="m-num">10</em>
											<span class="m-title">总积分</span>
										</a>
									</p>
								</div>

								<!--我的钱包-->
								

							</div>
							<div class="box-container-bottom"></div>

							<!--订单 -->
							<div class="m-order">
								<div class="s-bar">
									<i class="s-icon"></i>我的订单
									<a class="i-load-more-item-shadow" href="${contextPath}/person/order.jsp">全部订单</a>
								</div>
								<ul>
									<li><a href="${contextPath}/person/order.jsp"><i><img src="${contextPath}/images/pay.png"/></i><span>待付款</span></a></li>
									<li><a href="${contextPath}/person/order.jsp"><i><img src="${contextPath}/images/send.png"/></i><span>待发货<em class="m-num">1</em></span></a></li>
									<li><a href="${contextPath}/person/order.jsp"><i><img src="${contextPath}/images/receive.png"/></i><span>待收货</span></a></li>
									<li><a href="${contextPath}/person/order.jsp"><i><img src="${contextPath}/images/comment.png"/></i><span>待评价<em class="m-num">3</em></span></a></li>
									<li><a href="${contextPath}/person/change.jsp"><i><img src="${contextPath}/images/refund.png"/></i><span>退换货</span></a></li>
								</ul>
								<c:forEach items="${requestScope.ordersList}" var="orders" varStatus="status">
									<div class="orderContentBox">
										<div class="orderContent">
											<div class="orderContentpic">
												<div class="imgBox">
													<a href="${contextPath}/person/orderinfo.jsp"><img src="${contextPath}/images/01_small.jpg"></a>
												</div>
											</div>
											<div class="detailContent">
												<a href="${contextPath}/person/orderinfo.jsp" class="delivery"><span id="state" onload="stateToString(${orders.state})"></span></a>
												<div class="orderID">
													<span class="time">${orders.ordertime}</span>
												</div>
												<div class="orderID">
													<span class="num">共 ${status.count}件商品</span>
												</div>
											</div>
											<div class="state">待评价</div>
											<div class="price"><span class="sym">¥</span>${orders.totalprice}</div>

										</div>
										<a href="javascript:void(0);" class="btnPay">再次购买</a>
									</div>
								</c:forEach>
								<script type="text/javascript">
									function stateToString(state) {
										if (state == 1) {
											document.getElementById(state).val("待付款");
										} else if (state == 2) {
											document.getElementById(state).val("待发货");
										} else if (state == 3) {
											document.getElementById(state).val("待收货");
										}else if (state == 4) {
											document.getElementById(state).val("待发货");
										} else {
											document.getElementById(state).val("错误");
										}
									}
								</script>
								<div class="orderContentBox">
									<div class="orderContent">
										<div class="orderContentpic">
											<div class="imgBox">
												<a href="orderinfo.jsp"><img src="${contextPath}/images/01_small.jpg"></a>
											</div>
										</div>
										<div class="detailContent">
											<a href="${contextPath}/person/orderinfo.jsp" class="delivery">派件</a>
											<div class="orderID">
												<span class="time">2016-03-09</span>
												<span class="splitBorder">|</span>
												<span class="time">21:52:47</span>
											</div>
											<div class="orderID">
												<span class="num">共2件商品</span>
											</div>
										</div>
										<div class="state">已发货</div>
										<div class="price"><span class="sym">¥</span>246.<span class="sym">50</span></div>

									</div>
									<a href="javascript:void(0);" class="btnPay">再次购买</a>
								</div>
							</div>
							<!--九宫格-->
							<div class="user-squaredIcon">
								<div class="s-bar">
									<i class="s-icon"></i>我的常用
								</div>
								<ul>
									<a href="${contextPath}/person/order.jsp">
										<li class="am-u-sm-4"><i class="am-icon-truck am-icon-md"></i>
											<p>物流查询</p>
										</li>
									</a>
									<a href="${contextPath}/person/collection.jsp">
										<li class="am-u-sm-4"><i class="am-icon-heart am-icon-md"></i>
											<p>我的收藏</p>
										</li>
									</a>
									<a href="${contextPath}/person/foot.jsp">
										<li class="am-u-sm-4"><i class="am-icon-paw am-icon-md"></i>
											<p>我的足迹</p>
										</li>
									</a>
									<a href="#">
										<li class="am-u-sm-4"><i class="am-icon-gift am-icon-md"></i>
											<p>为你推荐</p>
										</li>
									</a>
									<a href="${contextPath}/person/blog.jsp">
										<li class="am-u-sm-4"><i class="am-icon-share-alt am-icon-md"></i>
											<p>我的分享</p>
										</li>
									</a>
									<a href="${contextPath}/home/home2.jsp">
										<li class="am-u-sm-4"><i class="am-icon-clock-o am-icon-md"></i>
											<p>限时活动</p>
										</li>
									</a>

								</ul>
							</div>

							<div class="user-suggestion">
								<div class="s-bar">
									<i class="s-icon"></i>会员中心
								</div>
								<div class="s-bar">
									<a href="suggest.jsp"><i class="s-icon"></i>意见反馈</a>
								</div>
							</div>


						</div>
					</div>
					<div class="wrap-right">

						<!-- 日历-->
						<div class="day-list">
							<div class="s-title">
								每日新鲜事
							</div>
							<div class="s-box">
								<ul>
									<li><a><p>粮油冲锋周 满128减18</p></a></li>
									<li><a><p>防晒这么重要的事怎能随意</p></a></li>
									<li><a><p>春日护肤面膜不可少，你选对了吗？</p></a></li>
									<li><a><p>纯粹时尚，摩登出游，吸睛美衣</p></a></li>
									<li><a><p>粮油冲锋周 满128减18</p></a></li>
									<li><a><p>春日护肤面膜不可少，你选对了吗？</p></a></li>									
								</ul>
							</div>
						</div>
						<!--新品 -->
						<div class="new-goods">
							<div class="s-bar">
								<i class="s-icon"></i>今日新品
								<a class="i-load-more-item-shadow">15款新品</a>
							</div>
							<div class="new-goods-info">
								<a class="shop-info" href="#">
									<div class="face-img-panel">
										<img src="${contextPath}/images/imgsearch1.jpg" alt="">
									</div>
									<span class="new-goods-num ">4</span>
									<span class="shop-title">剥壳松子</span>
								</a>
						
							</div>
						</div>						

						</div>

				</div>
				<!--底部-->
				<iframe src="${contextPath}/footer.jsp" width="100%" height="150px" frameborder="0" scrolling="no"></iframe>

			</div>

			<aside class="menu">
				<ul>
					<li class="person active">
						<a href="${contextPath}/person/index.jsp"><i class="am-icon-user"></i>个人中心</a>
					</li>
					<li class="person">
						<p><i class="am-icon-newspaper-o"></i>个人资料</p>
						<ul>
							<li> <a href="${contextPath}/person/information.jsp">个人信息</a></li>
							<li> <a href="${contextPath}/person/safety.jsp">安全设置</a></li>
							<li> <a href="${contextPath}/person/address.jsp">地址管理</a></li>
						</ul>
					</li>
					<li class="person">
						<p><i class="am-icon-balance-scale"></i>我的交易</p>
						<ul>
							<li><a href="${contextPath}/person/order.jsp">订单管理</a></li>
							<li> <a href="${contextPath}/person/change.jsp">退款售后</a></li>
							<li> <a href="${contextPath}/person/comment.jsp">评价商品</a></li>
						</ul>
					</li>
					<li class="person">
						<p><i class="am-icon-dollar"></i>我的资产</p>
						<ul>
							<li> <a href="${contextPath}/person/points.jsp">我的积分</a></li>
							<li> <a href="${contextPath}/person/walletlist.jsp">账户余额</a></li>
							<li> <a href="${contextPath}/person/bill.jsp">账单明细</a></li>
						</ul>
					</li>

					
						</ul>
					</li>
				</ul>

			</aside>
		</div>
		
		</div>
	</body>

</html>