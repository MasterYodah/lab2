<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "s" uri = "/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    

  </head>
  
  <body>
  	<base href="<%=basePath%>">
    
    <title>My JSP 'bookinfo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
    
    <table border = 1 align = "CENTER" >
    	<tr>
    		<td> TITLE </td>
    		<td> ISBN </td>
    		<td> PUBLISHER </td>
    		<td> PUBLISH DATE </td>
    		<td> PRICE </td>
    		<td> AUTHOR NAME </td>
    		<td> AUTHOR AGE </td>
    		<td> AUTHOR COUNTRY </td>
    	</tr>
    			<tr>
    				<td> <s:property value = "book_info.title"/> </td>
    				<td> <s:property value = "book_info.isbn"/> </td>
    				<td> <s:property value = "book_info.publisher"/> </td>
    				<td> <s:property value = "book_info.publish_date"/> </td>
    				<td> <s:property value = "book_info.price"/> </td>
    				<td> <s:property value = "book_info.author.name"/> </td>
    				<td> <s:property value = "book_info.author.age"/> </td>
    				<td> <s:property value = "book_info.author.country"/> </td>
    				
    			</tr>
    </table>
    	<s:form action = "DELETE">
    	<s:submit value = "Delete"/>
    	</s:form>
    	<s:form action = "QUERY">
    	<s:submit value = "Cancel"/>
    	</s:form>
  </body>
</html>
