<!DOCTYPE html>
<html>
<head>
    <title>Panier</title>
    <script>
        function updateTotal() {
            let total = 0;
            const rows = document.querySelectorAll('tbody tr');
            rows.forEach(row => {
                const quantity = parseInt(row.querySelector('.quantity-input').value);
                const price = parseFloat(row.querySelector('.price').innerText);
                total += quantity * price;
            });
            document.getElementById('total').innerText = total.toFixed(2);
        }
    </script>
     <c:if test="${not empty param.msg}">
        <script type="text/javascript">
        var alertContainer = document.createElement('div');
        alertContainer.classList.add('custom-alert');
        alertContainer.textContent = "${param.msg}";
        document.body.appendChild(alertContainer);
            history.replaceState(null, null, window.location.pathname);
        </script>
    </c:if>
    <style>
        html,
        body {
            height: 100%;
            display: flex;
            flex-direction: column;
        }

        .container {
            flex: 1;
        }

        .footer {
            flex-shrink: 0;
        }

        .bg-cover {
            background-size: contain;
            background-repeat: no-repeat;
            background-position: center center;
        }
    </style>
    <c:if test="${not empty param.msg}">
  
</c:if>
    
</head>
<body>
    <%@ include file="navbar.jsp" %>
    <div class="container mx-auto py-10">
        <h1 class="text-2xl font-bold mb-8">Mon panier</h1>
        <table class="min-w-full bg-white border border-gray-300">
            <thead>
                <tr>
                    <th class="py-4 px-6 bg-gray-200 font-bold uppercase text-sm text-gray-700 text-left">Image</th>
                    <th class="py-4 px-6 bg-gray-200 font-bold uppercase text-sm text-gray-700 text-left">Product</th>
                    <th class="py-4 px-6 bg-gray-200 font-bold uppercase text-sm text-gray-700 text-left">Price</th>
                    <th class="py-4 px-6 bg-gray-200 font-bold uppercase text-sm text-gray-700 text-left">Quantite</th>
                    <th class="py-4 px-6 bg-gray-200 font-bold uppercase text-sm text-gray-700 text-left">Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${cs}" var="c">
                	 <tr>
                        <td class="py-4 px-6 border-b border-gray-300">  
                         <div class="flex items-center space-x-4">
		          			<img src="images/${c.article.image}" alt="Article Image" class="w-16 h-16 rounded">
		          		<div>
		          </td>
                        <td class="py-4 px-6 border-b border-gray-300">${c.article.name}</td>
                        <td class="py-4 px-6 border-b border-gray-300 price">${c.article.price}DH</td>
                        <td class="py-4 px-6 border-b border-gray-300">
                        	<form action="placdordre.as" method="POST">
                          		<input name="qte" class="w-16 py-1 px-2 border border-gray-300 rounded-md quantity-input" max="${c.article.quantite}" min="0" type="number" value="${c.article.quantite}" onchange="updateTotal()">                        	
                          		<input name="article" class="w-16 py-1 px-2 border border-gray-300 rounded-md quantity-input" type="hidden" value="${c.article.id}" onchange="updateTotal()">                        	
                          		<input name="idCmd" class="w-16 py-1 px-2 border border-gray-300 rounded-md quantity-input" type="hidden" value="${c.id}" onchange="updateTotal()">                        	
                        </td>
                        <td class="py-2">
                            <a class="bg-red-500 text-white py-1 px-2 rounded-md" href="deletecommande.as?idcmd=${c.id}&idUser=${sessionScope.id}">Delete</a>
                    		<button type="submit" class="bg-green-500 text-white py-1 px-2 rounded-md">Acheter</button>
                        	</form>
                        </td>
                    </tr>	
                </c:forEach>
            </tbody>
        </table>
        <br>
        <tfoot>
            <tr>
                <td class="py-4 px-6 border-b border-gray-300" colspan="3"></td>
                <td class="py-4 px-6 border-b border-gray-300">Total : <span id="total">0.00</span> DH</td>
                <td class="py-4 px-6 border-b border-gray-300">
                    <a href="articles.as"><button class="bg-blue-500 hover:bg-green-600 text-white py-2 px-4 rounded-md mr-2">Ajouter autres articles</button></a>
                </td>
            </tr>
        </tfoot>
    </div>
    <%@include file="footer.jsp"%>
</body>
</html>
