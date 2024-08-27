<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<ul id="menu">
	<li><a href="home.do">HOME</a></li>
	<li>
		<a href="m_insert.do">MEMBER</a>
		<ul>
			<li><a href="m_insert.do">m_insert.do</a></li>
			<li><a href="m_selectAll.do">m_selectAll.do</a></li>
		</ul>
	</li>
	<li>
		<c:if test="${user_id == null}">
			<li><a href="m_login.do">login</a></li>
		</c:if>
		<c:if test="${user_id != null}">
			<a>${user_id}</a>
			<ul>
				<li><a href="m_logout.do">logout</a></li>
			</ul>
		</c:if>
	</li>
</ul>
<hr>