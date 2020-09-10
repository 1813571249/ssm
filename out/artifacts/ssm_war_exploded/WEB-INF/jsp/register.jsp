<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Home</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="utf-8">
<meta name="keywords" content="" />
<link href="${pageContext.request.contextPath}/css/font-awesome.min.css" rel="stylesheet" type="text/css" media="all">
<link href="${pageContext.request.contextPath}/css/register-style.css" rel="stylesheet" type="text/css" media="all"/>
<link href="http://fonts.googleapis.com/css?family=Raleway:400,500,600,700,800,900" rel="stylesheet">
</head>
<body>
<div class="signupform">
	<div class="container">
		<h1></h1>
		<div class="agile_info">
			<div class="w3l_form">
				<div class="left_grid_info">
					<h3>欢迎 !</h3>
					<h4>开创美好未来的第一步！</h4>
					<p> </p>
					<ul class="social_section_1info">
						<li><a href="#" class="w3_facebook"><i class="fa fa-facebook"></i></a></li>
						<li><a href="#" class="w3_twitter"><i class="fa fa-twitter"></i></a></li>
						<li><a href="#" class="w3_instagram"><i class="fa fa-instagram"></i></a></li>
						<li><a href="#" class="w3_google"><i class="fa fa-google-plus"></i></a></li>
						<li><a href="#" class="w3_pinterest"><i class="fa fa-pinterest"></i></a></li>
						<li><a href="#" class="w3_vimeo"><i class="fa fa-vimeo"></i></a></li>
					</ul>
				</div>
			</div>
			<div class="w3_info">
				<h2>创建账户</h2>
				<p>${message }</p>
						<form action="${pageContext.request.contextPath}/registerHandle.action" method="post">
						<div class="input-group">
							<span><i class="fa fa-user" aria-hidden="true"></i></span>
							<input type="text" name="username" placeholder="username" required=""> 
						</div>
						<div class="input-group">
							<span><i class="fa fa-user" aria-hidden="true"></i></span>
							<input type="text" name="telephone" placeholder="telephone" required=""> 
						</div>
						<div class="input-group">
							<span><i class="fa fa-envelope" aria-hidden="true"></i></span>
							<input type="email" name="email" placeholder="Email" required=""> 
						</div>
						<div class="input-group">
							<span><i class="fa fa-lock" aria-hidden="true"></i></span>
							<input type="Password" name="password" placeholder="Password" required="">
						</div>
						<div class="input-group">
							<span><i class="fa fa-lock" aria-hidden="true"></i></span>
							<input type="Password" name="password2" placeholder="Confirm Password" required="">
						</div>
							<input type="checkbox" value="remember-me" /> <h4>Send me latest updates </h4>        
							<button class="btn btn-danger btn-block" type="submit">创建账户</button >                
					</form>
			</div>
			<div class="clear"></div>
			</div>
			
		</div>
		<div class="footer">
 </div>
	</div>
	</body>
</html>