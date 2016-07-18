<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	${message}

	<h4>List of Available Products</h4>
	<form:form method="post" action="updateProducts" modelAttribute="Product">
		<table width=50%>

			<tr>

				<th>S.No</th>
				<th>ID</th>
				<th>Name</th>
				<th>Price</th>
				<th>Quantity</th>
				<th>Description</th>
			</tr>

			<c:forEach items="${productList}" var="product" varStatus="status">
				<tr>
					<td align="center">${status.count}</td>
					
					<td><input name="productList[${status.index}].id" readonly="readonly" value="${product.id}" /></td>
						
					<td><input name="productList[${status.index}].categoryID" readonly="readonly" value="${product.categoryID}" /></td>

					<td><input name="productList[${status.index}].name" value="${product.name}" /></td>
						
					<td><input name="productList[${status.index}].price" value="${product.price}" /></td>
						
					<td><input name="productList[${status.index}].description" value="${product.description}" /></td>
				
					<td><input name="productList[${status.index}].supplierID" readonly="readonly" value="${product.supplierID}" /></td>
				
				</tr>
			</c:forEach>
		</table>
	</form:form>


</body>
</html>