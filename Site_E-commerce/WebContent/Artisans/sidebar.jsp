<link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.16/dist/tailwind.min.css" rel="stylesheet">
<div class="bg-gray-800 text-white w-64 py-8 px-4">
    <h1 class="text-2xl font-bold mb-6">Artisan Dashboard</h1>
    <ul class="space-y-2">
        <li><a href="dashboard.ars" class="block py-2 px-4 rounded hover:bg-gray-700">Dashboard</a></li>
        <li><a href="articles.ars?idArt=${sessionScope.artisan.id}" class="block py-2 px-4 rounded hover:bg-gray-700">Articles</a></li>
        <li><a href="categories.ars" class="block py-2 px-4 rounded hover:bg-gray-700">Categories</a></li>
        <li><a href="stocks.ars" class="block py-2 px-4 rounded hover:bg-gray-700">Stocks</a></li>
    </ul>
    <div class="mt-20">
	    <hr>
        <form action="logout.ars" method="post">
            <button type="submit" class="flex items-center py-2 px-4 rounded hover:bg-gray-700">
                <img alt="" src="images/logout.svg" class="h-4 w-4 text-white">&ensp;
                Logout
            </button>
        </form>
    </div>
</div>
<c:choose>
    <c:when test="${empty sessionScope.artisan}">
        <c:redirect url="login.us" />
    </c:when>
</c:choose>
