<!DOCTYPE html>
<html>
<head>
    <title>Moroccan artisanat</title>
    <script>
        // JavaScript code here...
    </script>
    <style>
        html,
        body {
            height: 100%;
            display: flex;
            flex-direction: column;
            margin: 0;
            padding: 0;
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
            display: flex;
            align-items: center;
            justify-content: center;
            padding: 20px;
        }

        .card-container {
            max-width: 100%;
            width: 800px; /* Adjust the width as needed */
            padding: 20px;
            background-color: #fff;
            border-radius: 4px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
        }

        .card-image {
            background-size: cover;
            background-position: center center;
            height: 300px;
            margin-bottom: 20px;
        }

        .card-title {
            font-size: 24px;
            font-weight: bold;
            margin-bottom: 10px;
        }

        .card-category {
            font-size: 12px;
            font-weight: bold;
            text-transform: uppercase;
            margin-bottom: 10px;
        }

        .card-price {
            font-size: 28px;
            font-weight: bold;
            margin-bottom: 10px;
        }

        .card-details {
            margin-bottom: 20px;
        }

        .card-stock {
            font-size: 14px;
            color: #888;
            display: flex;
            align-items: center;
            margin-bottom: 10px;
        }

        .comment-form {
            margin-top: 20px;
        }

        .comment-textarea {
            width: 100%;
            height: 100px;
            resize: vertical;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
            font-size: 14px;
        }

        .comment-button {
            display: inline-flex;
            align-items: center;
            color: #333;
            background-color: #f0f0f0;
            border: none;
            padding: 10px 15px;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .comment-button:hover {
            background-color: #e0e0e0;
        }

        .comment-section {
            max-height: 200px; /* Adjust the height as needed */
            overflow-y: auto;
            margin-top: 20px;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }

        .comment {
            margin-bottom: 10px;
            padding-bottom: 10px;
            border-bottom: 1px solid #ddd;
        }

        .comment-user {
            font-weight: bold;
            margin-bottom: 5px;
        }

        .comment-text {
            font-size: 14px;
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
<body class="bg-gray-100">
    <%@include file="navbar.jsp" %>
    <div class="container">
        <div class="card-container">
            <h1 class="card-title">Commenter l'article "${article.name}"</h1>
            <div class="card">
                <div class="card-image bg-cover" style="background-image: url(images/${article.image})"></div>
                <div class="card-body">
                    <p class="card-category">${article.category.name}</p>
                    <p class="card-price">${article.price}DH</p>
                    <p class="card-details">${article.details}</p>
                </div>
                <div class="card-stock">
                    <img alt="" class="h-6 w-6 text-gray-600 fill-current mr-3" src="attests/stock.svg">
                    <p><span class="font-bold">${article.quantite}</span> En Stock</p>
                </div>
            </div>
            <form action="addcommentaire.as" class="comment-form">
                <input type="hidden" value="${article.id}" name="idArticle">
                <input type="hidden" value="${sessionScope.id}" name="idUser">
                <label for="articleContent">Commenter l'article :</label>
                <textarea id="articleContent" name="commentaire" required class="comment-textarea"></textarea>
                <br>
                <button type="submit" class="comment-button">Ajouter Commentaire</button>
            </form>
            <div class="comment-section">
                <c:forEach items="${comments}" var="comment">
                    <div class="comment">
                        <p class="comment-user">par : ${comment.user.nom} | en  <fmt:formatDate value="${comment.datetime}" pattern="yyyy-MM-dd hh:mm:ss" /></p>
                        <p class="comment-text">${comment.contenu}</p>
                    </div>
                </c:forEach>
            </div>
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
</html>
