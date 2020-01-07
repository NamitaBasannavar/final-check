<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Movies</title>
<link href="./style/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<header>
		<span id="title">Movies</span> <img class="img"
			src="./images/logo.png" alt="logo" id="logo" />
		<nav>
			<a id="movies" href="ShowMovieListCustomer" />Movies</a> <a
				id="favorites" href="ShowFavorite">Favorites</a>
		</nav>
	</header>
	<div>
		<h1 class="Favorites">Favorites</h1>
		<h5 class="option">
			No items in Favorites.Use 'Add to Favorite' option in <a
				href="ShowMovieListCustomer"> Movie List.</a>
		</h5>
	</div>
	<footer>
		<span id="cpw">Copyright@2019</span>
	</footer>
</body>
</html>