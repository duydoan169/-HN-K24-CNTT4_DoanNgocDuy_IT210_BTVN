<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh sách nhân viên</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 30px;
        }

        table {
            border-collapse: collapse;
            width: 80%;
        }

        th, td {
            border: 1px solid #ccc;
            padding: 10px;
            text-align: left;
            color: black;
        }

        th {
            background-color: black;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        .high {
            font-weight: bold;
        }
    </style>
</head>
<body>
<h2>Danh sách nhân viên - Phòng Đào Tạo</h2>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Họ Tên</th>
        <th>Phòng Ban</th>
        <th>Lương</th>
        <th>Đánh Giá</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="emp" items="${employees}">
        <tr>
            <td>${emp.id}</td>
            <td>${emp.fullName}</td>
            <td>${emp.department}</td>
            <td>${emp.salary}</td>
            <td>
                <c:choose>
                    <c:when test="${emp.salary >= 10000}">
                        <span class="high">Mức lương cao</span>
                    </c:when>
                    <c:otherwise>
                        <span class="basic">Mức lương cơ bản</span>
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>