<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>OrdredProduct</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.15/dist/tailwind.min.css" rel="stylesheet">
    <style>
        body {
            display: flex;
            flex-direction: column;
            min-height: 100vh;
        }

        .container {
            flex: 1;
        }
    </style>
</head>
<body class="bg-gray-100">
    <%@include file="navbar.jsp" %>
    <div class="container mx-auto py-10">
        <h1 class="text-2xl font-bold mb-4">OrdredProduct Details</h1>
        <table class="min-w-full bg-white border border-gray-300">
              <table class="min-w-full bg-white border border-gray-300">
        <thead>
            <tr>
                <th class="py-4 px-6 bg-gray-200 font-bold uppercase text-sm text-gray-700 text-left">Image</th>
                <th class="py-4 px-6 bg-gray-200 font-bold uppercase text-sm text-gray-700 text-left">Order Date</th>
                <th class="py-4 px-6 bg-gray-200 font-bold uppercase text-sm text-gray-700 text-left">Order Number</th>
                <th class="py-4 px-6 bg-gray-200 font-bold uppercase text-sm text-gray-700 text-left">Status</th>
                <th class="py-4 px-6 bg-gray-200 font-bold uppercase text-sm text-gray-700 text-left">Quantity</th>
                <th class="py-4 px-6 bg-gray-200 font-bold uppercase text-sm text-gray-700 text-left">Total Price</th>
                <th class="py-4 px-6 bg-gray-200 font-bold uppercase text-sm text-gray-700 text-left">User</th>
                <th class="py-4 px-6 bg-gray-200 font-bold uppercase text-sm text-gray-700 text-left">Order Detail</th>
                <th class="py-4 px-6 bg-gray-200 font-bold uppercase text-sm text-gray-700 text-left">Article</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${ordredProducts}" var="ordredProduct">
                <tr>
                    <td class="py-4 px-6 border-b border-gray-300">
                       <div class="flex items-center space-x-4">
		          			<img src="images/${ordredProduct.article.image}" alt="Article Image" class="w-16 h-16 rounded">
		          		<div>
                    </td>
                    <td class="py-4 px-6 border-b border-gray-300">
                    	    <fmt:formatDate value="${ordredProduct.orderDate}" pattern="yyyy-MM-dd hh:mm:ss" />
                    	
                    </td>
                    <td class="py-4 px-6 border-b border-gray-300">${ordredProduct.orderNumb}</td>
                    <td class="py-4 px-6 border-b border-gray-300">${ordredProduct.status}</td>
                    <td class="py-4 px-6 border-b border-gray-300">${ordredProduct.quantity}</td>
                    <td class="py-4 px-6 border-b border-gray-300">${ordredProduct.total}</td>
                    <td class="py-4 px-6 border-b border-gray-300">${ordredProduct.user.username}</td>
                    <td class="py-4 px-6 border-b border-gray-300">${ordredProduct.orderDetail.adress}</td>
                    <td class="py-4 px-6 border-b border-gray-300">${ordredProduct.article.name}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
        </table>
    </div>
    <c:choose>
        <c:when test="${empty sessionScope.id}">
            <c:redirect url="login.us" />
        </c:when>
    </c:choose>
    <%@include file="footer.jsp"%>
</body>
</html>
