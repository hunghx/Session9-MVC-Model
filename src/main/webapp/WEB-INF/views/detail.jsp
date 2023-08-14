<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hung1
  Date: 8/14/2023
  Time: 8:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${customer.images}" var="c" >
    <img width="200" height="200" style="object-fit: cover" src="<%=request.getContextPath()%>/image/${c}" alt="">
</c:forEach>
</body>
</html>
