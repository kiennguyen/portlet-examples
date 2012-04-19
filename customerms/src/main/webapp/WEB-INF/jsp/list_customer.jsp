<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
</head>
<body>
<h1>Customer ms</h1>

<h2>List All Customers</h2>

<c:if test="${not empty list}">
	<c:forEach items="${list}" var="consumer">
	    <table>
		    <tr>
						<td><c:out value="${consumer.customerId}"></c:out></td>
						<td><c:out value="${consumer.name}"></c:out></td>
						<td><c:out value="${consumer.address}"></c:out></td>
				</tr>
			</table>
	</c:forEach>
</c:if>

<br/>
<br/>
</body>
</html>