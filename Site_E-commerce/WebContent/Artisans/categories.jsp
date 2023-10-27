
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
			<h1 class="text-2xl font-bold mb-4">Mes categorys</h1>
            <table class="min-w-full bg-white border border-gray-300">
                <thead>
                    <tr>
                        <th class="px-4 py-2">Categorie</th>
                        <th class="px-4 py-2">Name</th>
                        <th class="px-4 py-2">Description</th>
                        <th class="px-4 py-2">Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${categories}" var="category">
                        <tr>
                  
                            <td class="border px-4 py-2">${category.id}</td>
                            <td class="border px-4 py-2">${category.name}</td>
                            <td class="border px-4 py-2">${category.description}</td>
                            <td class="border px-4 py-2">
                                <a href="editCategory.cs?id=${category.id}" class="text-blue-500 hover:text-blue-700 mr-2">Modifier</a>
                                <a href="deleteCategory.cs?id=${category.id}" class="text-red-500 hover:text-red-700">Supprimer</a>
                            </td>
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
    </c:choose>    <footer class="bg-gray-800 text-white py-4 text-center">
        <p class="text-center text-gray-500">© 2023 Artisanat. All rights reserved | made by @me</p>
    </footer>
</body>
</html>