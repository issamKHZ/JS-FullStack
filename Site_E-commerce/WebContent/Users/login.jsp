<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Login Page</title>
  <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.16/dist/tailwind.min.css" rel="stylesheet">
</head>
<body class="bg-gray-100">
  <div class="container mx-auto flex justify-center items-center h-screen">
    <div class="bg-white rounded-lg shadow-md p-8 max-w-md w-full">
      <h1 class="text-2xl text-center text-blue-900 font-bold mb-6">Login</h1>
      <c:if test="${!empty error }">
        <span class="text-red-600 font-bold mb-4 block">${error}</span>
      </c:if>
      <form method="POST" action="/ProjectJPA/postlogin.us">
		<label for="email" class="block text-sm mb-2">Username:</label>
        <input type="text" id="username" name="username" required class="border border-gray-300 rounded-lg px-4 py-2 w-full mb-4">
		
        <label for="password" class="block text-sm mb-2">Password:</label>
        <input type="password" id="password" name="password" required class="border border-gray-300 rounded-lg px-4 py-2 w-full mb-4">

        <div class="flex items-center mb-4">
          <input type="checkbox" id="isArtisan" name="isArtisan" value="true" class="mr-2">
          <label for="isArtisan" class="text-sm">Êtes-vous un(e) artisan(e)?</label>
        </div>

        <input type="submit" class="bg-blue-900 text-white rounded-lg px-4 py-2 w-full cursor-pointer" value="Se connecter">
      </form>
      <a href="/ProjectJPA/register.us" class="block text-center text-blue-900 font-bold mt-4">S'inscrire</a>
    </div>
  </div>
</body>
</html>
