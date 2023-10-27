<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home - Moroccan Artisanat</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.15/dist/tailwind.min.css" rel="stylesheet">
</head>
<body class="bg-gray-100 ">
    <%@include file="navbar.jsp" %>
    <div class="container mx-auto py-10 flex items-center justify-center">
        <div class="max-w-4xl mx-auto px-4 text-center">
            <h1 class="text-4xl font-bold mb-6">Bienvenue sur Moroccan Artisanat !</h1>
            <div class="mb-8">
                <img class="w-full rounded-lg shadow-lg" src="https://static.wixstatic.com/media/19c60a_e966338ff45c415a90c87e834eaee414~mv2.jpg/v1/fill/w_1349,h_647,al_c,q_85,usm_0.66_1.00_0.01,enc_auto/19c60a_e966338ff45c415a90c87e834eaee414~mv2.jpg" alt="Artisan Product">
            </div>
            <p class="text-lg text-gray-800 leading-relaxed">
                D�couvrez les produits artisanaux marocains populaires. Ces produits sont fabriqu�s par des artisans talentueux au Maroc, qui perp�tuent des traditions ancestrales.
                Chaque pi�ce est unique et repr�sente le savoir-faire artisanal marocain.
                Profitez de la qualit� et de la beaut� de cet artisanat exceptionnel pour ajouter une touche d'authenticit� � votre int�rieur ou pour offrir un cadeau sp�cial � vos proches.
            </p>
        </div>
    </div>

    <%@include file="footer.jsp"%>
</body>
</html>
