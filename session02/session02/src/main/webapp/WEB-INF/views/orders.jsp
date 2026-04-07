<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/7/2026
  Time: 3:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
  <title>Danh sách đơn hàng</title>
</head>
<body>
<h2>Xin chào, ${sessionScope.loggedUser}! Vai trò: ${sessionScope.role}</h2>
<a href="<c:url value='/logout'/>">Đăng xuất</a>

<hr>

<table border="1">
  <tr>
    <th>Mã đơn</th>
    <th>Sản phẩm</th>
    <th>Tổng tiền</th>
    <th>Ngày đặt</th>
  </tr>
  <c:forEach var="order" items="${orderList}">
    <tr>
      <td>${order.orderId}</td>
      <td><c:out value="${order.name}" /></td>
      <td>
        <fmt:formatNumber value="${order.price}" type="currency" currencyCode="VND"/>
      </td>
      <td>
        <fmt:formatDate value="${order.date}" pattern="dd/MM/yyyy" />
      </td>
    </tr>
  </c:forEach>
</table>

<p>
  <strong>Tổng lượt xem đơn hàng toàn hệ thống:</strong>
  <c:out value="${applicationScope.totalViewCount != null ? applicationScope.totalViewCount : 0}" />
</p>
</body>
</html>