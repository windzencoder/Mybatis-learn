<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<% 
	String basePath=request.getContextPath(); 
	String path = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort() + basePath;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<meta http-equiv="X-UA-Compatible"content="IE=9; IE=8; IE=7; IE=EDGE" />
		<title>内容列表页面</title>
		<link href="<%= path %>/resources/css/all.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="<%= path %>/resources/js/common/jquery-1.8.0.min.js"></script>
		<script type="text/javascript" src="<%= path %>/resources/js/back/list.js"></script>
	</head>
	<body style="background: #e1e9eb;">

		<form action="<%= path %>/List.action" id="mainForm" method="post">
			<div class="right">
				<div class="current">当前位置：<a href="javascript:void(0)" style="color:#6E6E6E;">内容管理</a> &gt; 内容列表</div>
				<div class="rightCont">
					<p class="g_title fix">内容列表 
						<a class="btn03" href="#">新 增</a>&nbsp;&nbsp;&nbsp;&nbsp;
						<a class="btn03" href="javascript:deleteBatch('<%=path %>');">删 除</a>
					</p>
					<table class="tab1">
						<tbody>
							<tr>
								<td width="90" align="right">指令名称：</td>
								<td>
									<input name="command"  type="text" class="allInput" value="${command }"/>
								</td>
								<td width="90" align="right">描述：</td>
								<td>
									<input name="description" type="text" class="allInput" value="${description }"/>
								</td>
	                            <td width="85" align="right"><input type="submit" class="tabSub" value="查 询" /></td>
	       					</tr>
						</tbody>
					</table>
					<div class="zixun fix">
						<table class="tab2" width="100%">
							<tbody>
								<tr>
								    <th><input type="checkbox" id="all" /></th>
								    <th>序号</th>
								    <th>指令名称</th>
								    <th>描述</th>
								    <th>操作</th>
								</tr>
								<c:forEach items="${messageList}" var="message" varStatus="status">
									<tr <c:if test="${status.index %2 != 0 }">style="background-color:#ECF6EE;"</c:if>>
										<td><input type="checkbox" name="id" value="${message.ID}" /></td>
										<td>${status.index + 1 }</td>
										<td>${message.command }</td>
										<td>${message.description }</td>
										<td>
											<a href="#">修改</a>&nbsp;&nbsp;&nbsp;
											<a href="<%= path %>/DeleteOne.action?id=${message.ID}">删除</a>
											<!-- POST方式的删除 -->
											
										</td>
									</tr>
								</c:forEach>
					
							</tbody>
						</table>
						<div class='page fix'>
							共 <b>4</b> 条
							<a href='###' class='first'>首页</a>
							<a href='###' class='pre'>上一页</a>
							当前第<span>1/1</span>页
							<a href='###' class='next'>下一页</a>
							<a href='###' class='last'>末页</a>
							跳至&nbsp;<input type='text' value='1' class='allInput w28' />&nbsp;页&nbsp;
							<a href='###' class='go'>GO</a>
						</div>
					</div>
				</div>
			</div>
	    </form>
	    
	    
	<!-- 删除状态的提示 -->
	<c:choose>
	  <c:when test="${deleteStatus == 'true' }">
	    <script>alert("删除成功")</script>
	  </c:when>
	  <c:when test="${deleteStatus == 'false'  }">
	    <script>alert("删除失败")</script>
	  </c:when>
	  <c:otherwise>
	  </c:otherwise>
	</c:choose>
	
	<%
		request.removeAttribute("deleteStatus");
	%>
	    
	    
	</body>
</html>