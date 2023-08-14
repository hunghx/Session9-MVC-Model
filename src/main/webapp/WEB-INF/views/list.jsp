<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hung1
  Date: 8/14/2023
  Time: 6:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Danh sách khách hàng</h1>
<a href="/CustomerController?action=ADD">Create new Customer</a>
<table border="10" cellspacing="10" cellpadding="10">
<thead>
<tr>
  <th>STT</th>
  <th>FullName</th>
  <th>Age</th>
  <th>Avatar</th>
  <th>Gen</th>
  <th colspan="2" >Action</th>
</tr>

</thead>
  <tbody>
  <c:forEach items="${customers}" var="c" varStatus="loop">
    <tr>
      <td>${loop.count}</td>
      <td>${c.fullName}</td>
      <td>${c.age}</td>
      <td><a href="/CustomerController?id=${c.id}&action=DETAIL"><img width=100px" style="object-fit: cover" height="100px" src="<%=request.getContextPath()%>/image/${c.avatar}" alt="#"></a></td>
      <td>${c.sex}</td>
      <td>EDIT</td>
      <td>DELETE</td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>
