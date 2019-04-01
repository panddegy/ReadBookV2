<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootpath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
	<%@include file="/WEB-INF/views/include/include-head.jspf" %>
</head>
<script>
$(function(){
	$("#btn-write").click(function(){
		location.href="${rootpath}/write"
	})
	$("#btn-submit").click(function(){
		$("form").submit()
	})
})
</script>
<style>

</style>
<body>
<header>
<a href="${rootpath}/">Read Books</a>
<nav>
<a href="${rootpath}/">Home</a>
<a href="${rootpath}/list">List</a>
<a href="${rootpath}/write">Write</a>
<a href="#">About</a>
</nav>
</header>
<section id="main-section">
<c:if test="${BODY=='MAIN'}">
	<%@include file="/WEB-INF/views/bodies/book_main.jspf" %>
</c:if>
<c:if test="${BODY=='WRITE'}">
	<%@include file="/WEB-INF/views/bodies/write_form.jspf" %>
</c:if>
<c:if test="${BODY=='LIST'}">
	<%@include file="/WEB-INF/views/bodies/book_list.jspf" %>
</c:if>
<c:if test="${BODY=='UPDATE'}">
	<%@include file="/WEB-INF/views/bodies/update_form.jspf" %>
</c:if>
</section>
<div class="btn-wrapper">
<c:if test="${BODY=='WRITE'}">
	<button class="btns" id="btn-submit">Submit</button>
</c:if>
<c:if test="${BODY=='UPDATE'}">
	<button class="btns" id="btn-submit">Update</button>
</c:if>
<c:if test="${BODY=='UPDATE'}">
	<button class="btns" id="btn-delete">Delete</button>
</c:if>
</div>
</body>
</html>












