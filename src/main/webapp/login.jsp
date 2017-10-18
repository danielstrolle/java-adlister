<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:if test="${param.username == 'admin' && param.pwd == 'password'}">

    <% response.sendRedirect("profile.jsp?username=" + request.getParameter("username")); %>
</c:if>

<%@include file="partials/login-form.jsp"%>

