<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Register Page</title>
  <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.16/dist/tailwind.min.css" rel="stylesheet">
  <style>
    .container {
      width: 90%;
      max-width: 600px;
      height: 120vh;
      display: flex;
      justify-content: center;
      align-items: center;
    }
  </style>
</head>
<body class="bg-gray-100">
  <div class="container mx-auto">
    <div class="bg-white rounded-lg shadow-md p-8 w-full">
      <h1 class="text-2xl text-center text-blue-900 font-bold mb-6">Register</h1>
      <c:if test="${!empty success }">
        <span class="text-green-600 font-bold mb-4 block">${success}</span>
      </c:if>
      <c:if test="${!empty error }">
        <span class="text-red-600 font-bold mb-4 block">${error}</span>
      </c:if>
      <form action="/ProjectJPA/postregister.us" method="POST">
        <label for="nom" class="block text-sm mb-2">Nom:</label>
        <input type="text" id="nom" name="nom" required class="border border-gray-300 rounded-lg px-4 py-2 w-full mb-4">

        <label for="prenom" class="block text-sm mb-2">Prenom:</label>
        <input type="text" id="prenom" name="prenom" required class="border border-gray-300 rounded-lg px-4 py-2 w-full mb-4">
		
		 <label for="username" class="block text-sm mb-2">Username:</label>
        <input type="text" id="username" name="username" required class="border border-gray-300 rounded-lg px-4 py-2 w-full mb-4">
		
		<label for="age" class="block text-sm mb-2">Age:</label>
		<input type="number" id="age" name="age" required class="border border-gray-300 rounded-lg px-4 py-2 w-full mb-4">

        <label for="password" class="block text-sm mb-2">Password:</label>
        <input type="password" id="password" name="password" required class="border border-gray-300 rounded-lg px-4 py-2 w-full mb-4">

        <div class="flex items-center mb-4">
          <input type="checkbox" id="isArtisan" name="isArtisan" value="true" class="mr-2">
          <label for="isArtisan" class="text-sm">Êtes-vous un(e) artisan(e)?</label>
        </div>

        <input type="submit" class="bg-blue-900 text-white rounded-lg px-4 py-2 w-full cursor-pointer" value="S'inscrire">
      </form>
      <a href="/ProjectJPA/login.us" class="block text-center text-blue-900 font-bold mt-4">Se connecter</a>
    </div>
  </div>
</body>
</html>
