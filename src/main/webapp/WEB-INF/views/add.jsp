<%--
  Created by IntelliJ IDEA.
  User: hung1
  Date: 8/14/2023
  Time: 7:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Thêm mới</h1>
<form action="/CustomerController" method="post" enctype="multipart/form-data">
  <table border="10" cellpadding="10" cellspacing="0">
    <tr>
      <th>FullName : </th>
      <td><input type="text" name="fullName"></td>
    </tr>
    <tr>
      <th>Age : </th>
      <td><input type="number" min="16" name="age"></td>
    </tr>
    <tr>
      <th>Sex : </th>
      <td><select name="sex">
        <option value="true">Nam</option>
        <option value="false">Nữ</option>
      </select></td>
    </tr>
    <tr>
      <th>Avatar : </th>
      <td><input type="file" name="avatar" accept="jpg,jpeg,png"></td>
    </tr>
    <tr>
      <th>Image : </th>
      <td><input type="file" name="image" multiple></td>
    </tr>
  </table>
  <input type="submit" name="action" value="ADD"/>
</form>
</body>
</html>
