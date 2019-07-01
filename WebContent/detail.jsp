<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>详情页面</title>
<link href="css/admin.css" rel="stylesheet" type="text/css" />
<link href="css/amazeui.css" rel="stylesheet" type="text/css" />
<link href="css/demo.css" rel="stylesheet" type="text/css" />
<link type="text/css" href="css/optstyle.css" rel="stylesheet" />
<link type="text/css" href="css/style.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.7.min.js"></script>
<script type="text/javascript" src="js/quick_links.js"></script>
<script type="text/javascript" src="js/amazeui.js"></script>
<script type="text/javascript" src="js/jquery.imagezoom.min.js"></script>
<script type="text/javascript" src="js/jquery.flexslider.js"></script>
<script type="text/javascript" src="js/list.js"></script>
</head>

<body>
<iframe src="header.jsp" width="100%" height="120px" frameborder="0" scrolling="no"></iframe>
<div class="listMain">

<!--分类-->
<div class="nav-table">

<div class="nav-cont">

  <br>
  <br>
  <script type="text/javascript">
					$(function() {});
					$(window).load(function() {
						$('.flexslider').flexslider({
							animation: "slide",
							start: function(slider) {
								$('body').removeClass('loading');
							}
						});
					});
				</script> 
</div>
<div class="scoll">
  <section class="slider">
    <div class="flexslider">
      <ul class="slides">
        <li> <img src="images/01.jpg" title="pic" /> </li>
        <li> <img src="images/02.jpg" /> </li>
        <li> <img src="images/03.jpg" /> </li>
      </ul>
    </div>
  </section>
</div>
</div>
<!--放大镜-->

<div class="item-inform">
  <div class="clearfixLeft" id="clearcontent">
    <div class="box"> 
      <script type="text/javascript">
								$(document).ready(function() {
									$(".jqzoom").imagezoom();
									$("#thumblist li a").click(function() {
										$(this).parents("li").addClass("tb-selected").siblings().removeClass("tb-selected");
										$(".jqzoom").attr('src', $(this).find("img").attr("mid"));
										$(".jqzoom").attr('rel', $(this).find("img").attr("big"));
									});
								});
							</script>
      <div class="tb-booth tb-pic tb-s310"> <a href="images/01.jpg"><img src="images/${requestScope.commodity.img}" alt="细节展示放大镜特效" rel="images/01.jpg" class="jqzoom" /></a> </div>
      <ul class="tb-thumb" id="thumblist">
        <li class="tb-selected">
          <div class="tb-pic tb-s40"> <a href="#"><img src="images/01_small.jpg" mid="images/01_mid.jpg" big="images/01.jpg"></a> </div>
        </li>
        <li>
          <div class="tb-pic tb-s40"> <a href="#"><img src="images/02_small.jpg" mid="images/02_mid.jpg" big="images/02.jpg"></a> </div>
        </li>
        <li>
          <div class="tb-pic tb-s40"> <a href="#"><img src="images/03_small.jpg" mid="images/03_mid.jpg" big="images/03.jpg"></a> </div>
        </li>
      </ul>
    </div>
    <div class="clear"></div>
  </div>
  <div class="clearfixRight"> 
    
    <!--规格属性--> 
    <!--名称-->
    <div class="tb-detail-hd">
      <h1> ${requestScope.commodity.cname} </h1>
    </div>
    <div class="tb-detail-list"> 
      <!--价格-->
      <div class="tb-detail-price">
        <li class="price iteminfo_price">
          <dt>促销价</dt>
          <dd><em>¥</em><b class="sys_item_price">${requestScope.commodity.promotional_price}</b> </dd>
        </li>
        <li class="price iteminfo_mktprice">
          <dt>原价</dt>
          <dd><em>¥</em><b class="sys_item_mktprice">${requestScope.commodity.original_price}</b></dd>
        </li>
        <div class="clear"></div>
      </div>
      
     
      <div class="clear"></div>
      
     
      <div class="clear"></div>
      
      <!--各种规格-->
      <dl class="iteminfo_parameter sys_item_specpara">
        <dt class="theme-login">
          <div class="cart-title">可选规格<span class="am-icon-angle-right"></span></div>
        </dt>
        <dd>
        <!--操作页面-->
        
        <div class="theme-popover-mask"></div>
        <div class="theme-popover">
          <div class="theme-span"></div>
          <div class="theme-poptit"> <a href="javascript:;" title="关闭" class="close">×</a> </div>
          <div class="theme-popbod dform">
            <form class="theme-signin" name="loginform" action="" method="post">
              <div class="theme-signin-left">
                <div class="theme-options">
                  <div class="cart-title">口味</div>
                  <ul>
                    <li class="sku-line selected">原味<i></i></li>
                    <li class="sku-line">奶油<i></i></li>
                    <li class="sku-line">炭烧<i></i></li>
                    <li class="sku-line">咸香<i></i></li>
                  </ul>
                </div>
                <div class="theme-options">
                  <div class="cart-title number">数量</div>
           
                  <input id="min" class="am-btn am-btn-default" name="" type="button" value="-" />
                  <input id="text_box" name="" type="text" value="1" style="width:30px;" />
                  <input id="add" class="am-btn am-btn-default" name="" type="button" value="+" />
                  <span id="Stock" class="tb-hidden">库存<span class="stock">1000</span>件</span>
             
                </div>
                <div class="clear"></div>
                <div class="btn-op">
                  <div class="btn am-btn am-btn-warning">确认</div>
                  <div class="btn close am-btn am-btn-warning">取消</div>
                </div>
              </div>
              <div class="theme-signin-right">
                <div class="img-info"> <img src="images/songzi.jpg" /> </div>
                <div class="text-info"> <span class="J_Price price-now">¥39.00</span> <span id="Stock" class="tb-hidden">库存<span class="stock">1000</span>件</span> </div>
              </div>
            </form>
          </div>
        </div>
  
      </dl>
      <div class="clear"></div>
     
    </div>
    <div class="pay">
      <div class="pay-opt"> <a href="home.jsp"><span class="am-icon-home am-icon-fw">首页</span></a> <a><span class="am-icon-heart am-icon-fw">收藏</span></a> </div>
      <li>
        <div class="clearfix tb-btn tb-btn-buy theme-login"> <a id="LikBuy" title="点此按钮到下一步确认购买信息" href="pay.jsp">立即购买</a> </div>
      </li>
      <li>
        <div class="clearfix tb-btn tb-btn-basket theme-login"> <a id="LikBasket" title="加入购物车" href="shopcart.jsp"><i></i>加入购物车</a> </div>
      </li>
    </div>
  </div>
  <div class="clear"></div>
</div>


<!-- introduce-->

<div class="introduce">
<div class="browse">
  <div class="mc">
    <ul>
      <div class="mt">
        <h2>看了又看</h2>
      </div>
      <li class="first">
        <div class="p-img"> <a  href="#"> <img class="" src="images/browse1.jpg"> </a> </div>
        <div class="p-name"><a href="#"> 【三只松鼠_开口松子】零食坚果特产炒货东北红松子原味 </a> </div>
        <div class="p-price"><strong>￥35.90</strong></div>
      </li>
    </ul>
  </div>
</div>
<div class="introduceMain">
<div class="am-tabs" data-am-tabs>
  <ul class="am-avg-sm-3 am-tabs-nav am-nav am-nav-tabs">
    <li class="am-active"> <a href="#"> <span class="index-needs-dt-txt">宝贝详情</span></a> </li>
    <li> <a href="#"> <span class="index-needs-dt-txt">全部评价</span></a> </li>
  </ul>
  <div class="am-tabs-bd">
    <div class="am-tab-panel am-fade am-in am-active">
      <div class="J_Brand">
        <div class="attr-list-hd tm-clear">
          <h4>产品参数：</h4>
        </div>
        <div class="clear"></div>
        <ul id="J_AttrUL">
          <li title="">产品类型:&nbsp;${requestScope.commodity.commodityParam.type}</li>
          <li title="">原料产地:&nbsp;${requestScope.commodity.commodityParam.product_area}</li>
          <li title="">产地:&nbsp;${requestScope.commodity.commodityParam.product_place}</li>
          <li title="">配料表:&nbsp;${requestScope.commodity.commodityParam.ingredients}</li>
          <li title="">产品规格:&nbsp;${requestScope.commodity.commodityParam.product_specification}</li>
          <li title="">保质期:&nbsp;${requestScope.commodity.commodityParam.expiration_date}</li>
          <li title="">产品标准号:&nbsp;${requestScope.commodity.commodityParam.standard_number}</li>
          <li title="">生产许可证编号：&nbsp;${requestScope.commodity.commodityParam.license_number}</li>
          <li title="">储存方法：&nbsp;${requestScope.commodity.commodityParam.storage_method} </li>
          <li title="">食用方法：&nbsp;${requestScope.commodity.commodityParam.usage}</li>
        </ul>
        <div class="clear"></div>
      </div>
      <div class="details">
        <div class="attr-list-hd after-market-hd">
          <h4>商品细节</h4>
        </div>
        <div class="twlistNews"> <img src="images/tw1.jpg" /> </div>
      </div>
      <div class="clear"></div>
    </div>
    <div class="am-tab-panel am-fade">
      <div class="actor-new">
        
      <div class="clear"></div>
     
      <div class="clear"></div>
      <ul class="am-comments-list am-comments-list-flip">
        <li class="am-comment"> 
          <!-- 评论容器 --> 
          <a href=""> <img class="am-comment-avatar" src="images/hwbn40x40.jpg" /> 
          <!-- 评论者头像 --> 
          </a>
          <div class="am-comment-main"> 
            <!-- 评论内容容器 -->
            <header class="am-comment-hd"> 
              <!--<h3 class="am-comment-title">评论标题</h3>-->
              <div class="am-comment-meta"> 
                <!-- 评论元数据 --> 
                <a href="#link-to-user" class="am-comment-author">b***1 (匿名)</a> 
                <!-- 评论者 --> 
                评论于
                <time datetime="">2015年11月02日 17:46</time>
              </div>
            </header>
            <div class="am-comment-bd">
              <div class="tb-rev-item " data-id="255776406962">
                <div class="J_TbcRate_ReviewContent tb-tbcr-content "> 摸起来丝滑柔软，不厚，没色差，颜色好看！买这个衣服还接到诈骗电话，我很好奇他们是怎么知道我买了这件衣服，并且还知道我的电话的！ </div>
              </div>
            </div>
            <!-- 评论内容 --> 
          </div>
        </li>
        <li class="am-comment"> 
          <!-- 评论容器 --> 
          <a href=""> <img class="am-comment-avatar" src="images/hwbn40x40.jpg" /> 
          <!-- 评论者头像 --> 
          </a>
          <div class="am-comment-main"> 
            <!-- 评论内容容器 -->
            <header class="am-comment-hd"> 
              <!--<h3 class="am-comment-title">评论标题</h3>-->
              <div class="am-comment-meta"> 
                <!-- 评论元数据 --> 
                <a href="#link-to-user" class="am-comment-author">l***4 (匿名)</a> 
                <!-- 评论者 --> 
                评论于
                <time datetime="">2015年10月28日 11:33</time>
              </div>
            </header>
            <div class="am-comment-bd">
              <div class="tb-rev-item " data-id="255095758792">
                <div class="J_TbcRate_ReviewContent tb-tbcr-content "> 没有色差，很暖和……美美的 </div>
             
              </div>
            </div>
            <!-- 评论内容 --> 
          </div>
        </li>
        <li class="am-comment"> 
          <!-- 评论容器 --> 
          <a href=""> <img class="am-comment-avatar" src="images/hwbn40x40.jpg" /> 
          <!-- 评论者头像 --> 
          </a>
          <div class="am-comment-main"> 
            <!-- 评论内容容器 -->
            <header class="am-comment-hd"> 
              <!--<h3 class="am-comment-title">评论标题</h3>-->
              <div class="am-comment-meta"> 
                <!-- 评论元数据 --> 
                <a href="#link-to-user" class="am-comment-author">b***1 (匿名)</a> 
                <!-- 评论者 --> 
                评论于
                <time datetime="">2015年11月02日 17:46</time>
              </div>
            </header>
            <div class="am-comment-bd">
              <div class="tb-rev-item " data-id="255776406962">
                <div class="J_TbcRate_ReviewContent tb-tbcr-content "> 摸起来丝滑柔软，不厚，没色差，颜色好看！买这个衣服还接到诈骗电话，我很好奇他们是怎么知道我买了这件衣服，并且还知道我的电话的！ </div>
              </div>
            </div>
            <!-- 评论内容 --> 
          </div>
        </li>
        <li class="am-comment"> 
          <!-- 评论容器 --> 
          <a href=""> <img class="am-comment-avatar" src="images/hwbn40x40.jpg" /> 
          <!-- 评论者头像 --> 
          </a>
          <div class="am-comment-main"> 
            <!-- 评论内容容器 -->
            <header class="am-comment-hd"> 
              <!--<h3 class="am-comment-title">评论标题</h3>-->
              <div class="am-comment-meta"> 
                <!-- 评论元数据 --> 
                <a href="#link-to-user" class="am-comment-author">h***n (匿名)</a> 
                <!-- 评论者 --> 
                评论于
                <time datetime="">2015年11月25日 12:48</time>
              </div>
            </header>
            <div class="am-comment-bd">
              <div class="tb-rev-item " data-id="258040417670">
                <div class="J_TbcRate_ReviewContent tb-tbcr-content "> 式样不错，初冬穿 </div>
               
              </div>
            </div>
            <!-- 评论内容 --> 
          </div>
        </li>
        <li class="am-comment"> 
          <!-- 评论容器 --> 
          <a href=""> <img class="am-comment-avatar" src="images/hwbn40x40.jpg" /> 
          <!-- 评论者头像 --> 
          </a>
          <div class="am-comment-main"> 
            <!-- 评论内容容器 -->
            <header class="am-comment-hd"> 
              <!--<h3 class="am-comment-title">评论标题</h3>-->
              <div class="am-comment-meta"> 
                <!-- 评论元数据 --> 
                <a href="#link-to-user" class="am-comment-author">b***1 (匿名)</a> 
                <!-- 评论者 --> 
                评论于
                <time datetime="">2015年11月02日 17:46</time>
              </div>
            </header>
            <div class="am-comment-bd">
              <div class="tb-rev-item " data-id="255776406962">
                <div class="J_TbcRate_ReviewContent tb-tbcr-content "> 摸起来丝滑柔软，不厚，没色差，颜色好看！买这个衣服还接到诈骗电话，我很好奇他们是怎么知道我买了这件衣服，并且还知道我的电话的！ </div>
              </div>
            </div>
            <!-- 评论内容 --> 
          </div>
        </li>
        <li class="am-comment"> 
          <!-- 评论容器 --> 
          <a href=""> <img class="am-comment-avatar" src="images/hwbn40x40.jpg" /> 
          <!-- 评论者头像 --> 
          </a>
          <div class="am-comment-main"> 
            <!-- 评论内容容器 -->
            <header class="am-comment-hd"> 
              <!--<h3 class="am-comment-title">评论标题</h3>-->
              <div class="am-comment-meta"> 
                <!-- 评论元数据 --> 
                <a href="#link-to-user" class="am-comment-author">l***4 (匿名)</a> 
                <!-- 评论者 --> 
                评论于
                <time datetime="">2015年10月28日 11:33</time>
              </div>
            </header>
            <div class="am-comment-bd">
              <div class="tb-rev-item " data-id="255095758792">
                <div class="J_TbcRate_ReviewContent tb-tbcr-content "> 没有色差，很暖和……美美的 </div>
              
              </div>
            </div>

            <!-- 评论内容 --> 
          </div>
        </li>
      </ul>
      <div class="clear"></div>
      
      <!--分页 -->
      <ul class="am-pagination am-pagination-right">
        <li class="am-disabled"><a href="#">&laquo;</a></li>
        <li class="am-active"><a href="#">1</a></li>
        <li><a href="#">2</a></li>
        <li><a href="#">3</a></li>
        <li><a href="#">4</a></li>
        <li><a href="#">5</a></li>
        <li><a href="#">&raquo;</a></li>
      </ul>
      <div class="clear"></div>
     
    </div>
      </div>
    </div> </div>
    </div>     
      </div> </div>
    </div>     
      
</div>
      <div class="clear" style="clear:both"><iframe src="footer.jsp" width="100%" height="150px" frameborder="0" scrolling="no"></iframe></div>

<!--底部-->
				
</body>
</html>