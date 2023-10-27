<footer class="bg-gray-900 text-gray-400">
    <div class="container mx-auto py-8 px-4">
        <p class="text-center text-gray-500">© 2023 Artisanat. All rights reserved | made by @me</p>
    </div>
</footer>
   <c:choose>
        <c:when test="${empty sessionScope.artisan}">
            <c:redirect url="login.us" />
        </c:when>
    </c:choose>