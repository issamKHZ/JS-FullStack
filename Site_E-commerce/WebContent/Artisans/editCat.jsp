<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard - Edit Category</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.16/dist/tailwind.min.css" rel="stylesheet">
</head>
<body class="flex flex-col min-h-screen bg-gray-200">
    <!-- Sidebar -->
    <div class="flex-1 flex">
        <aside class="w-64 bg-gray-800 text-white">
           <%@include file="sidebar.jsp" %>
        </aside>
        <main class="flex-1 bg-white p-8">
            <h1 class="text-2xl font-bold mb-4">Edit Category ${category.name}</h1>
            
            <form action="updateCategory.cs" method="POST">
                <input type="hidden" name="id" value="${category.id}">
                
                <div class="mb-4">
                    <label for="name" class="block font-semibold mb-2">Name</label>
                    <input type="text" name="name" id="name" value="${category.name}" class="w-full px-4 py-2 border border-gray-300 rounded">
                </div>
                
                <div class="mb-4">
                    <label for="description" class="block font-semibold mb-2">Description</label>
                    <textarea name="description" id="description" class="w-full px-4 py-2 border border-gray-300 rounded">${category.description}</textarea>
                </div>
                
                <button type="submit" class="bg-blue-500 hover:bg-blue-700 text-white font-semibold px-4 py-2 rounded">Save</button>
            </form>
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
