<!DOCTYPE html>
<html>
<head>
    <title>Order Details Form</title>
    <style>
        /* Add your custom styles here */
    </style>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.17/dist/tailwind.min.css" rel="stylesheet">
</head>
<body>
    <%@ include file="navbar.jsp" %>

    <div class="container mx-auto py-10">
        <h1 class="text-2xl font-bold mb-8">Pourriez vous nous donner quelque details !</h1>

        <form action="submitorder.as" method="POST">
            <div class="mb-4">
                <label for="address" class="block text-gray-700 text-sm font-bold mb-2">Address:</label>
                <input type="text" id="address" name="address" class="w-full px-3 py-2 border border-gray-300 rounded-md" required>
                <input type="hidden" id="address" name="user" value="${user}" class="w-full px-3 py-2 border border-gray-300 rounded-md" required>
              
                <c:forEach items="${products}" var="product">
			        <input type="hidden" name="qte" value="${product.quantity}">
			        <input type="hidden" name="article" value="${product.articleId}">
			        <input type="hidden" name="idCmd" value="${product.commandId}">
			    </c:forEach>
               
            </div>
            <div class="mb-4">
                <label for="phone" class="block text-gray-700 text-sm font-bold mb-2">Phone:</label>
                <input type="tel" id="phone" name="phone" class="w-full px-3 py-2 border border-gray-300 rounded-md" required>
            </div>
            <div class="mb-4">
                <label for="country" class="block text-gray-700 text-sm font-bold mb-2">Country:</label>
                <input type="text" id="country" name="country" class="w-full px-3 py-2 border border-gray-300 rounded-md" required>
            </div>
            <div class="mb-4">
                <label for="city" class="block text-gray-700 text-sm font-bold mb-2">City:</label>
                <input type="text" id="city" name="city" class="w-full px-3 py-2 border border-gray-300 rounded-md" required>
            </div>
            <div class="mb-4">
                <label for="zip" class="block text-gray-700 text-sm font-bold mb-2">Postal Code:</label>
                <input type="text" id="zip" name="zip" class="w-full px-3 py-2 border border-gray-300 rounded-md" required>
            </div>

            <button type="submit" class="bg-blue-500 hover:bg-blue-600 text-white py-2 px-4 rounded-md">Confirmer</button>
        </form>
    </div>

    <%@ include file="footer.jsp" %>
</body>
</html>
