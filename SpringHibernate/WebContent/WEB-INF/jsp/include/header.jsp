<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%
Object relPath  = request.getAttribute("context");
Object user = session.getAttribute("user");
String basePath = "";
if(relPath != null && !relPath.equals("")){
	basePath = "../";
}
%>
<title>Employee</title>

<link rel="stylesheet" media="screen,projection" type="text/css" href="<%=basePath%>css/reset.css" />
<link rel="stylesheet" media="screen,projection" type="text/css" href="<%=basePath%>css/main.css" />
<link rel="stylesheet" media="screen,projection" type="text/css" href="<%=basePath%>css/2col.css" title="2col" />
<%-- <link rel="stylesheet" type="text/css" href="<%=basePath%>css/ext-all.css" /> --%>
<link rel="alternate stylesheet" media="screen,projection" type="text/css" href="<%=basePath%>css/1col.css" title="1col" />
<!--[if lte IE 6]><link rel="stylesheet" media="screen,projection" type="text/css" href="css/main-ie6.css" /><![endif]-->
<link rel="stylesheet" media="screen,projection" type="text/css" href="<%=basePath%>css/style-landing.css" />
<link rel="stylesheet" media="screen,projection" type="text/css" href="<%=basePath%>css/mystyle.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/jquery.fancybox.css" media="screen" />

<script type="text/javascript" src="<%=basePath%>js/jquery-1.11.0.js"></script>

<script type="text/javascript" src="<%=basePath%>js/switcher.js"></script>
<script type="text/javascript" src="<%=basePath%>js/toggle.js"></script>
<script type="text/javascript" src="<%=basePath%>js/ui.core.js"></script>
<script type="text/javascript" src="<%=basePath%>js/ui.tabs.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.fancybox.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$(".tabs > ul").tabs();
	});
	</script>
</head>
<body>
<div id="main">
  <!-- Tray -->
  <div id="tray" class="box">
    <p class="f-left box">      
      <img alt="1 Column" src="<%=basePath%>design/logo.png" width="30%" height ="2%">      
    </p>
    <p class="f-right">User: <strong><a href="#"><%=user%></a></strong> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong><a href="../logout.do" id="logout">Log out</a></strong></p>
  </div>
  <!--  /tray -->
 
  <!-- Menu -->
  <div id="menu" class="box">
    
    <ul class="box">
      <li id="menu-active"><a href="#"><span>Home</span></a></li>
      <!-- Active -->
      <li><a href="#"><span>Menu 2</span></a></li>
      <li><a href="#"><span>Menu 3</span></a></li>
      <li><a href="#"><span>Menu 4</span></a></li>
      <li><a href="#"><span>Menu 5</span></a></li>
      <li><a href="#"><span>Menu 6</span></a></li>
      <li><a href="#"><span>Menu 7</span></a></li>
    </ul>
  </div>
  <!-- /header -->