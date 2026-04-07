<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/7/2026
  Time: 7:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<html>
<head>
  <title>Title</title>
</head>
<body>

<nav style="background: #f4f4f4; padding: 10px;">
  <strong>HR Portal</strong> |
  <a href="<c:url value='/employees'/>">Danh sách NV</a>
  <c:if test="${sessionScope.role == 'hr_manager'}">
    | <a href="#">Quản lý lương (Admin)</a>
  </c:if>
</nav>
<table border="1">
  <tr>
    <th>STT</th>
    <th>Họ tên</th>
    <th>Phòng</th>
    <th>Lương</th>
    <th>Ngày vào</th>
    <th>Trạng thái</th>
    <th>Thao tác</th>
  </tr>
  <c:forEach var="emp" items="${employeeList}" varStatus="status">
    <tr>
      <td>${status.count}</td>
      <td><c:out value="${emp.name}"/></td>
      <td>${emp.department}</td>
      <td><fmt:formatNumber value="${emp.salary}" type="currency" currencyCode="VND"/></td>
      <td><fmt:formatDate value="${emp.date}" pattern="dd/MM/yyyy"/></td>
      <td>
        <c:choose>
          <c:when test="${emp.status == 'Đang làm'}"><span style="color:green">${emp.status}</span></c:when>
          <c:when test="${emp.status == 'Nghỉ phép'}"><span style="color:orange">${emp.status}</span></c:when>
          <c:otherwise><span style="color:blue">${emp.status}</span></c:otherwise>
        </c:choose>
      </td>
      <td><a href="<c:url value='/employees/${emp.code}'/>">Chi tiết</a></td>
    </tr>
  </c:forEach>
</table>
<p><strong>Tổng lương phòng Kỹ thuật: </strong>
  <fmt:formatNumber value="${techTotalSalary}" type="currency" currencyCode="VND"/></p>
</body>
</html>