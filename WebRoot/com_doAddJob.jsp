<%@page import="edu.nuaa.factory.ComDaoFactory"%>
<%@page import="edu.nuaa.dao.proxy.ComDaoProxy"%>
<%@page import="edu.nuaa.dao.impl.ComDaoImpl"%>
<%@page import="edu.nuaa.vo.Company" %>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'com_doAddJob.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <%
		request.setCharacterEncoding("utf-8");
	%>
	
	<%
		boolean flag = false;
		int comId = Integer.parseInt(request.getParameter("comId"));
		int jobId = Integer.parseInt(request.getParameter("jobId"));
		try {
			flag = ComDaoFactory.getIComDaoInstance().doDeleteJob(comId,jobId);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		if(flag ==true){
			out.print("删除成功！");
		}
		else{
			out.print("删除失败！");
		}
		
	%>
  </body>
</html>
