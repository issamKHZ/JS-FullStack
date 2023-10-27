<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard - Edit Article</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.16/dist/tailwind.min.css" rel="stylesheet">
</head>
<body class="flex flex-col min-h-screen bg-gray-200">
    <!-- Sidebar -->
    <div class="flex-1 flex">
        <aside class="w-64 bg-gray-800 text-white">
           <%@include file="sidebar.jsp" %>
        </aside>
        <main class="flex-1 bg-white p-8">
            <h1 class="text-2xl font-bold mb-4">Edit Article ${article.name}</h1>
            
            <form action="update.as" method="POST" enctype="multipart/form-data">
                <input type="hidden" name="id" value="${article.id}">
                <input type="hidden" name="idArtisan" value="${sessionScope.artisan.id}">
                
                <div class="mb-4">
                    <label for="name" class="block font-semibold mb-2">Name</label>
                    <input type="text" name="name" id="name" value="${article.name}" class="w-full px-4 py-2 border border-gray-300 rounded">
                </div>
                
                  <div class="mb-4">
                      <label for="articleFile" class="block mb-2">Upload File:</label>
					<input type="file" id="articleFile" value="${article.image}" name="image" required class="border border-gray-300 rounded-lg px-4 py-2 w-full mb-4">
					
                </div>
                
              	
                
                <div class="mb-4">
                    <label for="category" class="block font-semibold mb-2">Category</label>
                    <select name="category" id="category" class="w-full px-4 py-2 border border-gray-300 rounded">
                        <option value="">Select a category</option>
                        <c:forEach items="${categories}" var="category">
				            <option value="${category.id}">${category.name}</option>
                        </c:forEach>
                    </select>
                </div>
                
                <div class="mb-4">
                    <label for="price" class="block font-semibold mb-2">Price</label>
                    <input type="number" name="price" id="price" value="${article.price}" class="w-full px-4 py-2 border border-gray-300 rounded">
                </div>
                
                  <div class="mb-4">
                    <label for="price" class="block font-semibold mb-2">Poids</label>
                    <input type="number" name="poids" id="price" value="${article.poids}" class="w-full px-4 py-2 border border-gray-300 rounded">
                </div>
                
                <div class="mb-4">
                    <label for="details" class="block font-semibold mb-2">Details</label>
                    <textarea name="details" id="details" class="w-full px-4 py-2 border border-gray-300 rounded">${article.details}</textarea>
                </div>
                
                <div class="mb-4">
                    <label for="quantite" class="block font-semibold mb-2">Quantity</label>
                    <input type="number" name="quantite" id="quantite" min="0" max="${article.quantite}" value="${article.quantite}" class="w-full px-4 py-2 border border-gray-300 rounded">
                </div>
                
					
                
                 <div class="mb-4">
                    <label for="category" class="block font-semibold mb-2">Stock</label>
                    <select name="stock" id="category" class="w-full px-4 py-2 border border-gray-300 rounded">
                        <option value="">Select a Stock</option>
                        <c:forEach items="${stocks}" var="stock">
				            <option value="${stock.id}">${stock.nom}</option>
                        </c:forEach>
                    </select>
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
