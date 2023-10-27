<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Artisan Dashboard</title>
  <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.16/dist/tailwind.min.css" rel="stylesheet">
</head>
<body class="bg-gray-100">
  <div class="flex">
    <!-- Sidebar -->
    <%@ include file="sidebar.jsp" %>
    <div class="flex-1 p-8">
      <h2 class="text-2xl font-bold mb-6">Articles</h2>
      <ul class="bg-white rounded-lg shadow-md p-4 mb-8">
		  <c:forEach items="${articles}" var="article" varStatus="loopStatus">
		    <c:if test="${loopStatus.index < 3}">
		      <li class="flex items-center justify-between py-2 border-b">
		        <div class="flex items-center space-x-4">
		          <img src="images/${article.image}" alt="Article Image" class="w-16 h-16 rounded">
		          <div>
		            <h3 class="text-lg font-bold">${article.name}</h3>
		            <p class="text-gray-600">Category: ${article.category.name}</p>
		          </div>
		        </div>
		      </li>
		    </c:if>
		  </c:forEach>
		  <a href="articles.ars?idArt=${sessionScope.artisan.id}" class="text-blue-500 hover:underline">View All</a>
		</ul>


      <h2 class="text-2xl font-bold mb-6">Categories</h2>
      <ul class="bg-white rounded-lg shadow-md p-4 mb-8">
      	<c:forEach items="${categories}" var="c"  varStatus="loopStatus">
      	  <c:if test="${loopStatus.index < 3}">
        	<li class="flex items-center justify-between py-2 border-b">
         		 <p class="text-lg font-bold">${c.name }</p>
				<a href="/ProjectJPA/articlespercat.as?idCat=${c.id}" class="text-blue-500 hover:underline">View Articles</a>
			</li>
      	</c:if>
      	</c:forEach>
				</ul>
				
		
      <h2 class="text-2xl font-bold mb-6">Stocks</h2>
      <ul class="bg-white rounded-lg shadow-md p-4 mb-8">
      	<c:forEach items="${stocks}" var="c"  varStatus="loopStatus">
      	  <c:if test="${loopStatus.index < 3}">
        	<li class="flex items-center justify-between py-2 border-b">
         		 <p class="text-lg font-bold">${c.nom }</p>
				<a href="/ProjectJPA/stocks.ars?idCat=${c.id}" class="text-blue-500 hover:underline">View Stocks</a>
			</li>
      	</c:if>
      	</c:forEach>
				</ul>
				
				<h2 class="text-2xl font-bold mb-6">Add Article</h2>
				<!-- Add Article Form -->
				<form action="/ProjectJPA/add.as"  method="POST" class="bg-white rounded-lg shadow-md p-4 mb-8" enctype="multipart/form-data">
				  <label for="articleTitle" class="block mb-2">Name:</label>
				  <input type="text" id="articleTitle" name="name" required class="border border-gray-300 rounded-lg px-4 py-2 w-full mb-4">
					
					<label for="articleFile" class="block mb-2">Upload File:</label>
					<input type="file" id="articleFile" name="image" required class="border border-gray-300 rounded-lg px-4 py-2 w-full mb-4">
						
						
					
				  <label for="articleCategory" class="block mb-2">Category:</label>
				  <select id="articleCategory" name="idCat" class="border border-gray-300 rounded-lg px-4 py-2 w-full mb-4">
					<option value="">Choose Category</option>
					<c:forEach items="${categories}" var="c">
				    	<option value="${c.id}">${c.name}</option>
					</c:forEach>
				  </select>
				
				  <label for="articleContent" class="block mb-2">Details:</label>
				  <textarea id="articleContent" name="details" required class="border border-gray-300 rounded-lg px-4 py-2 w-full mb-4"></textarea>
				
				  <label for="price" class="block mb-2">Prix:</label>
				  <input id="price" name="price"  type="text" pattern="[0-9]+([.,][0-9]+)?" required class="border border-gray-300 rounded-lg px-4 py-2 w-full mb-4">
					
					<label for="poids" class="block mb-2">Poids en KG:</label>
				  <input id="poids" name="poids" type="text" pattern="[0-9]+([.,][0-9]+)?" required class="border border-gray-300 rounded-lg px-4 py-2 w-full mb-4">
				
					<input id="poids" name="idArt" value="${sessionScope.artisan.id }" type="hidden" required class="border border-gray-300 rounded-lg px-4 py-2 w-full mb-4">
					
					<label for="qte" class="block mb-2">Quantite</label>
				  <input id="poids" name="qte" type="number" required class="border border-gray-300 rounded-lg px-4 py-2 w-full mb-4">
					
				<label for="articleCategory" class="block mb-2">Stock:</label>
				  <select id="articleCategory" name="idStock" class="border border-gray-300 rounded-lg px-4 py-2 w-full mb-4">
					<option value="">Choose Stock</option>
					<c:forEach items="${stocks}" var="s">
				    	<option value="${s.id}">${s.nom}</option>
					</c:forEach>
				  </select>
				
					
				  <input type="submit" class="bg-blue-900 text-white rounded-lg px-4 py-2 cursor-pointer" value="Add Article">
				</form>
				
				<h2 class="text-2xl font-bold mb-6">Add Category</h2>
				<!-- Add Category Form -->
				<form action="/ProjectJPA/postcat.cs"  method="POST" class="bg-white rounded-lg shadow-md p-4">
				  <label for="name" class="block mb-2">Category Name:</label>
				  <input type="text" id="categoryName" name="name" required class="border border-gray-300 rounded-lg px-4 py-2 w-full mb-4">
					
					<label for="name" class="block mb-2">Category Description:</label>
				  <input type="text" id="categoryName" name="desc" required class="border border-gray-300 rounded-lg px-4 py-2 w-full mb-4">
					
					
				  <input type="submit" class="bg-blue-900 text-white rounded-lg px-4 py-2 cursor-pointer" value="Add Category">
				</form>
				
				<h2 class="text-2xl font-bold mb-6">Add Stock</h2>
				<!-- Add Category Form -->
				<form action="/ProjectJPA/add.ss"  method="POST" class="bg-white rounded-lg shadow-md p-4">
				  <label for="name" class="block mb-2">Stock Name:</label>
				  <input type="text" id="categoryName" name="name" required class="border border-gray-300 rounded-lg px-4 py-2 w-full mb-4">
					
				  <input type="submit" class="bg-blue-900 text-white rounded-lg px-4 py-2 cursor-pointer" value="Add Stock">
				</form>
</div>
</div>
   <c:choose>
        <c:when test="${empty sessionScope.artisan}">
            <c:redirect url="login.us" />
        </c:when>
    </c:choose>
   <footer class="bg-gray-800 text-white py-4 text-center">
        <p class="text-center text-gray-500">© 2023 Artisanat. All rights reserved | made by @me</p>
    </footer></body>
  
</html>
