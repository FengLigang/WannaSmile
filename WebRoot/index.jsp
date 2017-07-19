<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <title>My JSP 'index.jsp' starting page</title>
   	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	

<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="ALCHEMIST Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<link href="css/style.css" rel='stylesheet' type='text/css' />
<script src="js/jquery-1.11.0.min.js"></script>
<link href='http://fonts.useso.com/css?family=Lato:100,300,400,700,900,100italic,300italic,400italic,700italic,900italic' rel='stylesheet' type='text/css'>
<!--Start-smoth-scrolling-->
		<script type="text/javascript" src="js/move-top.js"></script>
		<script type="text/javascript" src="js/easing.js"></script>	
		<script type="text/javascript">
			jQuery(document).ready(function($) {
				$(".scroll").click(function(event){		
					event.preventDefault();
					$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
				});
			});
		</script>
<!--end-smoth-scrolling-->
<!--start-top-nav-script-->
		<script>
			$(function() {
				var pull 		= $('#pull');
					menu 		= $('nav ul');
					menuHeight	= menu.height();
				$(pull).on('click', function(e) {
					e.preventDefault();
					menu.slideToggle();
				});
				$(window).resize(function(){
	        		var w = $(window).width();
	        		if(w > 320 && menu.is(':hidden')) {
	        			menu.removeAttr('style');
	        		}
	    		});
			});
		</script>
<!--End-top-nav-script-->
<!--light-box-files -->
		<script src="js/jquery.chocolat.js"></script>
		<link rel="stylesheet" href="css/chocolat.css" type="text/css" media="screen" charset="utf-8" />
		<!--light-box-files -->
		<script type="text/javascript" charset="utf-8">
		$(function() {
			$('#example1 a').Chocolat();
		});
		</script>
    <base href="<%=basePath%>">
    
  

  </head>
  
  <body>
<<<<<<< HEAD
=======
    <!--start-header-->
	<div class="header" id="home">
		<div class="container">
			<div class="logo">
				<a href="index.jsp"><img src="images/logo.png" alt=""></a>  
			</div>
			<div class="quote">
				<a href="quote.jsp">登录</a>
			</div>
			<!--start-top-nav-->
			<nav class="top-nav">
				<ul class="top-nav">
					<li><a href="index.jsp"  class="active">主页</a></li>
					<li><a href="about.jsp">校内公告</a></li>
					<li><a href="404.jsp">工作招聘</a></li>
					<li><a href="contact.jsp">管理界面</a></li>
				</ul>
					<a href="#" id="pull"><img src="images/menu-icon.png" title="menu" /></a>
			</nav>
			<div class="clearfix"> </div>
		</div>
	</div>
	<!--end-header-->
	<!--start-banner-->
	<div class="banner">
		<div  id="top" class="callbacks_container">
			 <ul class="rslides" id="slider4">
			       <li>
						<div class="banner-1"></div>	
					</li>
					<li>
							<div class="banner-2"></div>	
					</li>
					<li>
							<div class="banner-3"></div>	
					</li>
			  </ul>
			</div>
	 	<div class="clearfix"> </div>
	</div>
		<!--End-banner-->
		<!--Slider-Starts-Here-->
				<script src="js/responsiveslides.min.js"></script>
			 <script>
			    // You can also use "$(window).load(function() {"
			    $(function () {
			      // Slideshow 4
			      $("#slider4").responsiveSlides({
			        auto: true,
			        pager: true,
			        nav: false,
			        speed: 500,
			        namespace: "callbacks",
			        before: function () {
			          $('.events').append("<li>before event fired.</li>");
			        },
			        after: function () {
			          $('.events').append("<li>after event fired.</li>");
			        }
			      });
			
			    });
			  </script>
			<!--End-slider-script-->
	<!--start-build-->
	<div class="build">
		<div class="container">
			<div class="build-mian">
				<div class="col-md-8 build-left">
					<h1>欢迎来到南京航空航天大学<br><span>就业信息网</span></h1>
					<p>飞天的梦想&nbsp;&nbsp;从这里起航</p>
				</div>
				<div class="col-md-4 build-right">
					<a href="#">现在注册</a>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!--End-build-->	
	<!--start-design-->	
	<div class="design">
		<div class="container">
			<div class="design-main">
				<div class="col-md-3 design-left">
					<div class="design-text">
						<img src="images/design-1.png" alt="" />
						<h3>校内公告</h3>
						<p>这里是校内公告</p>
					</div>
				</div>
				<div class="col-md-3 design-left">
					<div class="design-text">
						<img src="images/design-2.png" alt="" />
						<h3>招聘信息</h3>
						<p>这里是招聘信息</p>
					</div>
				</div>
				<div class="col-md-3 design-left">
					<div class="design-text">
						<img src="images/design-3.png" alt="" />
						<h3>工作查找</h3>
						<p>这里是工作查找</p>
					</div>
				</div>
				<div class="col-md-3 design-left">
					<div class="design-text">
						<img src="images/design-4.png" alt="" />
						<h3>信息管理</h3>
						<p>这里是个人信息管理</p>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!--End-design-->
	<!--start-work-->
	<div class="work">
		<div class="container">
			<div class="work-top">
				<h3>今日推荐</h3>
			</div>
			<div class="work-btm">
			<div  id="top" class="callbacks_container">
				<ul class="rslides" id="slider5">
					<li>	
							<div class="work-bottom">
								<div class="col-md-6 work-left">
									<img src="images/work-1.jpg" alt="">
								</div>
								<div class="col-md-6 work-right">
									<div class="work-mian">
										<p>工    作   名    称     <span class="one">&nbsp;:Project name here</span></p>
										<p>工 资 区 间<span class="two">:Austin, TX</span></p>
										<p>类  型   <span class="tre">&nbsp;:John Doe</span></p>
										<p>所  需  技  能  <span class="fvr">&nbsp;:Feb 2013</span></p>
										<p>学  历  要  求 <span class="fve">:JUNE 2014</span></p>
							 		</div>
										<div class="work-one">
											<p>推荐理由<label></label><span>Vivamus viverra nibh in quam bibendum interdum. Duis convallis est ante, id pulvinar tortor tempus sed. Pellentesque nulla tellus, Vivamus viverra nibh in quam bibendum interdum.  Duis convallis est ante, id pulvinar tortor tempus sed.  Pellentesque nulla tellus,</span></p>
										</div>
								</div>
								<div class="clearfix"></div>
							</div>
							<div class="pop-up">
								<a class="play-icon popup-with-zoom-anim" href="#small-dialog"><span> </span><img src="images/pop-up.png" alt="" /></a>
							</div>
						</li>
						<li>	
							<div class="work-bottom">
								<div class="col-md-6 work-left">
									<img src="images/work-2.jpg" alt="">
								</div>
								<div class="col-md-6 work-right">
									<div class="work-mian">
										<p>工    作   名    称     <span class="one">&nbsp;:Project name here</span></p>
										<p>工 资 区 间<span class="two">:Austin, TX</span></p>
										<p>类  型   <span class="tre">&nbsp;:John Doe</span></p>
										<p>所  需  技  能  <span class="fvr">&nbsp;:Feb 2013</span></p>
										<p>学  历  要  求 <span class="fve">:JUNE 2014</span></p>
							 		</div>
										<div class="work-one">
											<p>推荐理由<label></label><span> Viverra nibh in quam bibendum interdum. Duis convallis est ante, id pulvinar tortor tempus sed. Pellentesque nulla tellus, Vivamus viverra nibh in quam bibendum interdum.  Duis convallis est ante, id pulvinar tortor tempus sed.  Pellentesque nulla tellus,</span></p>
										</div>
								</div>
								<div class="clearfix"></div>
							</div>
							<div class="pop-up">
								<a class="play-icon popup-with-zoom-anim" href="#small-dialog1"><span> </span><img src="images/pop-up.png" alt="" /></a>
							</div>
						</li>
						<li>	
							<div class="work-bottom">
								<div class="col-md-6 work-left">
									<img src="images/work-3.jpg" alt="">
								</div>
								<div class="col-md-6 work-right">
									<div class="work-mian">
										<p>工    作   名    称     <span class="one">&nbsp;:Project name here</span></p>
										<p>工 资 区 间<span class="two">:Austin, TX</span></p>
										<p>类  型   <span class="tre">&nbsp;:John Doe</span></p>
										<p>所  需  技  能  <span class="fvr">&nbsp;:Feb 2013</span></p>
										<p>学  历  要  求 <span class="fve">:JUNE 2014</span></p>
							 		</div>
										<div class="work-one">
											<p>推荐理由<label></label><span>Vivamus quam bibendum interdum. Duis convallis est ante, id pulvinar tortor tempus sed. Pellentesque nulla tellus, Vivamus viverra nibh in quam bibendum interdum.  Duis convallis est ante, id pulvinar tortor tempus sed.  Pellentesque nulla tellus,</span></p>
										</div>
								</div>
								<div class="clearfix"></div>
							</div>
							<div class="pop-up">
								<a class="play-icon popup-with-zoom-anim" href="#small-dialog2"><span> </span><img src="images/pop-up.png" alt="" /></a>
							</div>
						</li>
							</ul>
						</div>
					<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!--End-work-->	
	<!--Slider-Starts-Here-->
			 <script>
			    // You can also use "$(window).load(function() {"
			    $(function () {
			      // Slideshow 4
			      $("#slider5").responsiveSlides({
			        auto: true,
			        pager: true,
			        nav: true,
			        speed: 500,
			        namespace: "callbacks",
			        before: function () {
			          $('.events').append("<li>before event fired.</li>");
			        },
			        after: function () {
			          $('.events').append("<li>after event fired.</li>");
			        }
			      });
			
			    });
			  </script>
			<!--End-slider-script-->
	<!---pop-up-box---->
		 <script type="text/javascript" src="js/modernizr.custom.min.js"></script>    
		 <link href="css/popup-box.css" rel="stylesheet" type="text/css" media="all"/>
		 <script src="js/jquery.magnific-popup.js" type="text/javascript"></script>
	 <!---//pop-up-box---->
	 <div id="small-dialog" class="mfp-hide">
						<div class="login">
							<img src="images/work-1.jpg" alt="" />
						</div>
	</div>
	<div id="small-dialog1" class="mfp-hide">
						<div class="login">
							<img src="images/work-2.jpg" alt="" />
						</div>
	</div>
	<div id="small-dialog2" class="mfp-hide">
						<div class="login">
							<img src="images/work-3.jpg" alt="" />
						</div>
	</div>				
					<script>
						$(document).ready(function() {
						$('.popup-with-zoom-anim').magnificPopup({
							type: 'inline',
							fixedContentPos: false,
							fixedBgPos: true,
							overflowY: 'auto',
							closeBtnInside: true,
							preloader: false,
							midClick: true,
							removalDelay: 300,
							mainClass: 'my-mfp-zoom-in'
						});
																						
						});
				</script>			
	<!--start-footer-->
	<!-- requried-jsfiles-for owl -->
		<link href="css/owl.carousel.css" rel="stylesheet">
		<script src="js/owl.carousel.js"></script>
			<script>
				$(document).ready(function() {
					$("#owl-demo").owlCarousel({
						items : 5,
						lazyLoad : true,
						autoPlay : true,
						pagination : false,
					});
				});
			</script>
		<!-- //requried-jsfiles-for owl -->
	<!--start-project-->
		<!-- start content_slider -->
	<div class="project">
		<div id="example1">
			<div id="owl-demo" class="owl-carousel text-center">
				<div class="item">
					<a href="images/zoom-1.jpg" title="Home" rel="title1">
						<img class="lazyOwl" data-src="images/project-1.jpg" alt="name">
					</a>
					<div class="project-name">
						<p>Project title here</p>
						<span> </span>
					</div>
				</div>
				<div class="item">
					<a href="images/project-2.jpg" title="Home" rel="title1">
						<img class="lazyOwl" data-src="images/project-2.jpg" alt="name">
					</a>
					<div class="project-name">
						<p>xx公司</p>
						<span> </span>
					</div>
				</div>
				<div class="item">
					<a href="images/project-3.jpg" title="Home" rel="title1">
						<img class="lazyOwl" data-src="images/project-3.jpg" alt="name">
					</a>
					<div class="project-name">
						<p>xx公司</p>
						<span> </span>
					</div>
				</div>
				<div class="item">
					<a href="images/project-4.jpg" title="Home" rel="title1">
						<img class="lazyOwl" data-src="images/project-4.jpg" alt="name">
					</a>
					<div class="project-name">
						<p>xx公司</p>
						<span> </span>
					</div>
				</div>
				<div class="item">
					<a href="images/project-5.jpg" title="Home" rel="title1">
						<img class="lazyOwl" data-src="images/project-5.jpg" alt="name">
					</a>
					<div class="project-name">
						<p>xx公司</p>
						<span> </span>
					</div>
				</div>
				<div class="item">
					<a href="images/project-1.jpg" title="Home" rel="title1">
						<img class="lazyOwl" data-src="images/project-1.jpg" alt="name">
					</a>
					<div class="project-name">
						<p>xx公司</p>
						<span> </span>
					</div>
				</div>
				<div class="item">
					<a href="images/project-2.jpg" title="Home" rel="title1">
						<img class="lazyOwl" data-src="images/project-2.jpg" alt="name">
					</a>
					<div class="project-name">
						<p>xx公司</p>
						<span> </span>
					</div>
				</div>
				<div class="item">
					<a href="images/project-3.jpg" title="Home" rel="title1">
						<img class="lazyOwl" data-src="images/project-3.jpg" alt="name">
					</a>
					<div class="project-name">
						<p>xx公司</p>
						<span> </span>
					</div>
				</div>
				<div class="item">
					<a href="images/project-4.jpg" title="Home" rel="title1">
						<img class="lazyOwl" data-src="images/project-4.jpg" alt="name">
					</a>
					<div class="project-name">
						<p>xx公司</p>
						<span> </span>
					</div>
				</div>
				<div class="item">
					<a href="images/project-5.jpg" title="Home" rel="title1">
						<img class="lazyOwl" data-src="images/project-5.jpg" alt="name">
					</a>
					<div class="project-name">
						<p>xx公司</p>
						<span> </span>
					</div>
				</div>
			</div>
		</div>
	</div>
			<!--//sreen-gallery-cursual---->
            <div class="copyrights">制作小组 <a href="http://www.cssmoban.com/" >WannaSmile</a></div>
	<!--end-project-->	
	<!--start-clients-->	
	<div class="clients">
		<div class="container">
			<div class="clients-top">
				<h3>效法 <span>羲和</span> 驭天马<br>&nbsp;&nbsp;&nbsp;志在 <span>长空</span> 牧群星</h3>
			</div>
			<div class="clients-btm">
				<div  id="top" class="callbacks_container">
			 	<ul class="rslides" id="slider6">
			       <li>
					<div class="clients-bottom">
						<h3>团结&nbsp;&nbsp;俭朴&nbsp;&nbsp;唯实&nbsp;&nbsp;创新</h3>
						<h4>南航<span>校风</span></h4>
					</div>
				</li>
				<li>
					<div class="clients-bottom">
						<h3>智周万物&nbsp;&nbsp;道济天下</h3>
						<h4>南航<span>校训</span></h4>
					</div>
				</li>
				<li>
					<div class="clients-bottom">
						<h3>特色发展 人才强校 开放办学 制度创新</h3>
						<h4>发展<span>战略</span></h4>
					</div>
				</li>
			  </ul>
			</div>
	 		<div class="clearfix"> </div>
			</div>
		</div>
	</div>
	<!--end-clients-->
	<!--Slider-Starts-Here-->
				<script src="js/responsiveslides.min.js"></script>
			 <script>
			    // You can also use "$(window).load(function() {"
			    $(function () {
			      // Slideshow 4
			      $("#slider6").responsiveSlides({
			        auto: true,
			        pager: false,
			        nav: false,
			        speed: 500,
			        namespace: "callbacks",
			        before: function () {
			          $('.events').append("<li>before event fired.</li>");
			        },
			        after: function () {
			          $('.events').append("<li>after event fired.</li>");
			        }
			      });
			
			    });
			  </script>
			<!--End-slider-script-->	
	<!--start-news-->	
	<div class="news">
		<div class="container">
			<div class="news-top">
				<h3>校内公告</h3>
				<p><span>最新资讯        一网打尽</span></p>
			</div>
			<div class="news-bottom">
				<div class="col-md-4 news-left">
					<img src="images/news-1.jpg" alt="" />
					<div class="news-main">
						<h4>公告一</h4>
						<ul>
							<li><span>By:david</span></li>
							<li><span>01/01/2014</span></li>
							<li><span>xxx</span></li>
						</ul>
						<p>爱国敬业诚信友善</p>
						<div class="news-btn">
							<a href="#">Read More</a>
						</div>
					</div>
				</div>
				<div class="col-md-4 news-left">
					<img src="images/news-2.jpg" alt="" />
					<div class="news-main">
						<h4>公告二</h4>
						<ul>
							<li><span>By:phon</span></li>
							<li><span>01/01/2014</span></li>
							<li><span>xxx</span></li>
						</ul>
						<p>自由平等公正法治</p>
						<div class="news-btn">
							<a href="#">Read More</a>
						</div>
					</div>
				</div>
				<div class="col-md-4 news-left">
					<img src="images/news-3.jpg" alt="" />
					<div class="news-main">
						<h4>公告三</h4>
						<ul>
							<li><span>By:noknow</span></li>
							<li><span>01/01/2014</span></li>
							<li><span>xxx</span></li>
						</ul>
						<p>富强民主文明和谐</p>
						<div class="news-btn">
							<a href="#">Read More</a>
						</div>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
			<div class="planning">
				<p>南航就业信息网，努力为您做到最好！</p>
			</div>
		</div>
	</div>
	<!--end-news-->	
	<!--start-touch-->	
	<div class="touch">
		<div class="container">
			<div class="touch-main">
				<div class="col-md-4 touch-left">
					<h3>Get in touch</h3>
					<p>34789 Magic City Avenue, Los Angeles, CA, 94048</p>
					<p>Call: 123 456 789<p>
					<p>E-mail:<a href="mailto:example@email.com">testmail@sitename.com</a>
	   					<span><a href="mailto:example@email.com">testmail@sitename.com</a></span></p>
				</div>
				<div class="col-md-4 touch-left">
					<h3>@twitter</h3>
					<p>@twitterCheck out this great #codecanyon item 'Responsive Login, Sign Up and Payment Form Wizard' codecanyon.net/item/responsiv…</p>
					<label>about 2days ago</label>
				</div>
				<div class="col-md-4 touch-right">
					<ul>
						<li><a href="#"><span class="fb"> </span></a></li>
						<li><a href="#"><span class="twt"> </span></a></li>
						<li><a href="#"><span class="g"> </span></a></li>
						<li><a href="#"><span class="p"> </span></a></li>
						<li><a href="#"><span class="drb"> </span></a></li>
					</ul>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!--end-touch-->	
	<!--start-footer-->	
	<div class="footer">
		<div class="container">
			<div class="footer-text">
				<p>已是最后一版，点击<a target="_blank" href="http://www.cssmoban.com/">回到顶部</a></p>
				<a href="#home" class="scroll"><img src="images/top-img.png" alt=""></a>
			</div>
		</div>
	</div>
	<!--End-footer-->			
>>>>>>> be6cadb54ea93f88b17d0d9e1c2dc345d2a669f1
  </body>
</html>
