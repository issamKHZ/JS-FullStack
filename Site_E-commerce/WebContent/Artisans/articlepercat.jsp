
<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.16/dist/tailwind.min.css" rel="stylesheet">
</head>
<body class="flex flex-col min-h-screen bg-gray-200">
    <!-- Sidebar -->
    <div class="flex-1 flex">
        <aside class="w-64 bg-gray-800 text-white">
           <%@include file="sidebar.jsp" %>
        </aside>
        <main class="flex-1 bg-white p-8">
			<h1 class="text-2xl font-bold mb-4">Mes Articles</h1>
            <table class="min-w-full bg-white border border-gray-300">
                <thead>
                    <tr>
                        <th class="px-4 py-2">Image</th>
                        <th class="px-4 py-2">Name</th>
                        <th class="px-4 py-2">Category</th>
                        <th class="px-4 py-2">Price</th>
                        <th class="px-4 py-2">Details</th>
                        <th class="px-4 py-2">En Stock</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${articles}" var="article">
                        <tr>
                            <td class="border px-4 py-2">
                                <img src="images/${article.image}" alt="Article Image" class="w-16 h-16 rounded">
                            </td>
                            <td class="border px-4 py-2">${article.name}</td>
                            <td class="border px-4 py-2">${article.category.name}</td>
                            <td class="border px-4 py-2">${article.price} DH</td>
                            <td class="border px-4 py-2">${article.details}</td>
                            <td class="border px-4 py-2">${article.quantite}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </main>
    </div>
       <c:choose>
        <c:when test="${empty sessionScope.artisan}">
            <c:redirect url="login.us" />
        </c:when>
    </c:choose>
    <footer class="bg-gray-800 text-white py-4 text-center">
        <p class="text-center text-gray-500">© 2023 Artisanat. All rights reserved | made by @me</p>
    </footer>
</body>
</html>