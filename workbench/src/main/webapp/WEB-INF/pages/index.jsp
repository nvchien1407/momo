<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>

	<c:if test="${not empty lists}">
		<table>
			<c:forEach var="p" items="${lists}">
				<tr>
					<td>${p.id}</td>
					<td>${p.price}</td>
					<td>${p.productName}</td>
					<td>${p.productDescription}</td>
					<td>${p.stockQty}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

</body>
</html>