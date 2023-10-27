<!DOCTYPE html>
<%@page import="com.entity.Article"%>
<%@page import="com.dao.CommentaireImp"%>
<%@page import="com.dao.imp.ICommentaire"%>
<html>
<head>
    <title>Moroccan artisanat</title>
        <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/sweetalert2@11.0.19/dist/sweetalert2.min.css">
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.0.19/dist/sweetalert2.min.js"></script>
    
    <script>
        function confirmCommande() {
            var confirmation = confirm("Are you sure you want to add this item to your cart?");
            if (confirmation) {
                // User clicked OK, proceed with the form submission
                return true;
            } else {
                // User clicked Cancel, cancel the form submission
                return false;
            }
        }
        
        function showCustomAlert(message) {
            var alertContainer = document.createElement('div');
            alertContainer.classList.add('custom-alert');
            alertContainer.textContent = message;

            document.body.appendChild(alertContainer);
        }
        
        
        
     // Retrieve the message from the request attribute
     
    </script>
    <style>
        html,
        body {
            height: 100%;
            display: flex;
            flex-direction: column;
        }
        
        
        .custom-alert {
            position: fixed;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            background-color: #fff;
            border: 1px solid #ddd;
            padding: 20px;
            border-radius: 4px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
            z-index: 9999;
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
    
    
   
</head>
<body class="antialiased bg-gray-200 font-sans">
    <%@include file="navbar.jsp" %>
	<c:if test="${not empty param.cmt}">
    <script>
        // Display SweetAlert when condition is met
        Swal.fire({
            title: "Success!",
            text: "${param.cmt}",
            icon: "success",
            showConfirmButton: false,
            timer: 3000 // Automatically close after 3 seconds
        });
    </script>
</c:if>

    <div class="container mx-auto py-10 justify-start">
        <form action="search.as" method="POST">
        <div class="flex justify-end items-center mb-6">
            <div class="flex items-center mb-4">
               <input name="search" class="w-full max-w-sm px-4 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500 pr-8" type="text" placeholder="chercher une article">
            </div>
            &ensp;
            <div class="flex items-center mb-4">
         	<input type="submit" class="bg-blue-500 hover:bg-green-600 text-white py-2 px-4 rounded-md mr-2" value="Checher">
            </div>
		      
        </div>
        </form>
        <div class="flex items-center">
            <c:forEach items="${articles}" var="article">
                <div class="max-w-sm w-full sm:w-1/2 lg:w-1/3 py-6 px-3">
                    <div class="bg-white shadow-xl rounded-lg overflow-hidden">
                        <a href="articleDetails.as?idArticle=${article.id}"><div class="bg-cover bg-center h-56 p-4" style="background-image: url(images/${article.image})"></div></a>
                        <div class="p-4">
                            <p class="uppercase tracking-wide text-sm font-bold text-gray-700">${article.name}</p>
                            <p class="text-xs uppercase font-bold text-gray-600 tracking-wide">${article.category.name}</p>
                            <p class="text-3xl text-gray-900">${article.price}DH</p>
                            <p class="text-gray-700">${article.details}</p>                        
                        </div>
                        <div class="flex p-4 border-t border-gray-300 text-gray-700">
                            <div class="flex-1 inline-flex items-center">
								<img alt="" class="h-6 w-6 text-gray-600 fill-current mr-3" src="attests/stock.svg">
                                <p><span class="text-gray-900 font-bold">${article.quantite}</span> En Stock</p>
                            </div>
                             <div class="flex-1 inline-flex items-center">
								<img alt="" class="h-6 w-6 text-gray-600 fill-current mr-3" src="attests/cmt.png">
                                <p><span class="text-gray-900 font-bold">${article.getComments()}</span> Commentaires</p>
                            </div>
                        </div>
                        <form action="commande.us" class="px-4 pt-3 pb-4 border-t border-gray-300 bg-gray-100" onsubmit="return confirmCommande()">
						    <div class="flex items-center pt-2">
						        <input type="hidden" value="${article.id}" name="idArticle">
						        <input type="hidden" value="${sessionScope.id}" name="idUser">
						
						        <button type="submit" class="flex items-center text-gray-700" ${article.quantite > 0 ? '' : 'disabled'}>
						            <svg class="h-6 w-6 text-gray-600 fill-current mr-3" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
						                <path d="M12 2a1 1 0 0 1 1 1v8h8a1 1 0 0 1 0 2h-8v8a1 1 0 0 1-2 0v-8H3a1 1 0 0 1 0-2h8V3a1 1 0 0 1 1-1z" />
						            </svg>
						            <span class="font-bold text-gray-900">${article.quantite > 0 ? 'Ajouter au panier' : 'Expired'}</span>
						        </button>
						    </div>
						</form>
						<form action="commenter.as" class="px-4 pt-3 pb-4 border-t border-gray-300 bg-gray-100">
						    <div class="flex items-center pt-2">
						    	     <input type="hidden" value="${article.id}" name="idArticle">
								 	 <button type="submit" class="flex items-center text-gray-700">
							           	 <svg class="h-6 w-6 text-gray-600 fill-current mr-3" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
							           	     <path d="M12 2a1 1 0 0 1 1 1v8h8a1 1 0 0 1 0 2h-8v8a1 1 0 0 1-2 0v-8H3a1 1 0 0 1 0-2h8V3a1 1 0 0 1 1-1z" />
							            </svg>
						       		     <span class="font-bold text-gray-900">Commenter</span>
						      		</button>	
						    </div>
						</form>
						   
						      		
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
       <c:choose>
        <c:when test="${empty sessionScope.id}">
            <c:redirect url="login.us" />
        </c:when>
    </c:choose>
    <footer class="bg-gray-800 text-white py-4 text-center">
        <p class="text-center text-gray-500">© 2023 Artisanat. All rights reserved | made by @me</p>
    </footer>
</body>
 <c:if test="${not empty param.msg}">
        <script type="text/javascript">
        var alertContainer = document.createElement('div');
        alertContainer.classList.add('custom-alert');
        alertContainer.textContent = "${param.msg}";
        document.body.appendChild(alertContainer);
            history.replaceState(null, null, window.location.pathname);
        </script>
    </c:if>
</html>
