<link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.15/dist/tailwind.min.css" rel="stylesheet">


<style>
    .navbar {
        background-color: #051A29;
    }

    .navbar ul {
        display: flex;
        justify-content: space-between;
        padding: 1rem;
        margin: 0;
        list-style-type: none;
    }

    .navbar li {
        margin-right: 1rem;
    }

    .navbar a {
        color: #fff;
        text-decoration: none;
        font-weight: bold;
        padding: 0.5rem 1rem;
        transition: background-color 0.3s;
    }

    .navbar a:hover {
        background-color: #555;
    }
</style>

<nav class="navbar">
    <div class="container mx-auto">
        <ul>
            <li>
                <a href="home.as">Home</a>
            </li>
            <li>
                <a href="articles.as">Articles</a>
            </li>
            <li class="relative">
                <a href="#">Categories</a>
                <div class="absolute hidden bg-gray-900 text-white pt-2 pb-2 pl-4 pr-2 mt-2 min-w-[200px]">
                    <c:forEach items="${categories}" var="cat">
                        <a href="articlespercat.us?idCat=${cat.id}">${cat.name}</a>
                    </c:forEach>
                </div>
            </li>
            <li>
                <a href="panier.as?idUser=${sessionScope.id}">Panier</a>
            </li>
            <li>
                <a href="orders.as?idUser=${sessionScope.id}">Ordres</a>
            </li>
            <li>
                <a href="logout.us">Déconnexion</a>
            </li>
        </ul>
    </div>
   
</nav>


<script>
    const dropdown = document.querySelector('.relative');
    const dropdownContent = dropdown.querySelector('.absolute');

    dropdown.addEventListener('click', function() {
        dropdownContent.classList.toggle('hidden');
    });

    // Close the dropdown when the user clicks outside of it
    window.addEventListener('click', function(event) {
        if (!dropdown.contains(event.target)) {
            dropdownContent.classList.add('hidden');
        }
    });
</script>


