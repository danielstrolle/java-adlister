<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:if test="${param.username == 'admin' && param.pwd == 'password'}">

    <% request.getRequestDispatcher("profile.jsp").forward(request,response); %>
</c:if>

