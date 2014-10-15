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
    
    <title>My JSP 'booklist.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <h1 align = "CENTER" > Query found:  </h1> <br>
    
    
    <table border = 1 align = "CENTER" >
    	<tr>
    		<td> Author </td>
    		<td> Composition </td>
    		<td> ISBN </td>
    	</tr>
    	<s:iterator value = "books" id = "i" status = "struts" >
    			<tr>
    				<td> <s:property value = "#i.author.name"/> </td>
    				<td> <s:property value = "#i.title"/> </td>
    				<td> <s:property value = "#i.isbn"/> </td>
    				
    				<td>
    					<s:form id = "detailURL" action = "QUERY_DETAIL" >
    					<s:submit value = "info">
    						<s:hidden name = "isbn" value = "%{#i.isbn}"/> </s:submit>
    					</s:form> 
    				</td>
    			</tr>
    	</s:iterator>
    </table>
    <td> 
    	<s:form action = "BACK">
    	<s:submit value = "Back"/>
    	</s:form>
    </td>
  </body>
</html>
