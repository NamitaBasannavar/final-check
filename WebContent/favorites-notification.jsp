<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Movies</title>
<link href="./style/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<header>
		<span id="title">Movie Cruiser</span> <img src="./images/logo.png"
			alt="logo" id="logo">
		<nav>
			<a id="movies" href="ShowMovieListCustomer">Movies</a> <a
				id="favorites" href="ShowFavorite">Favorites</a>
		</nav>
	</header>
	<div>
		<h1>Favorites</h1>
		<h3>Movie removed from Favorites Successfully</h3>
		<table cellspacing="10px" cellpadding="5px">
			<tr>
				<th class="al-left">Title</th>
				<th class="al-right">Box Office</th>
				<th class="al-mid">Genre</th>
			</tr>
			<tr>
				<td class="al-left">${movie.title }</td>
				<td class="al-right">$.${movie.boxOffice }</td>
				<td class="al-mid">${movie.genre }</td>
				<td class="al-mid"><a href="RemoveFavorite?movieId=${movie.id }">Delete</td>
				</a>
			</tr>

			<tr>
				<th>No. of Favorites:2</th>
			</tr>
		</table>
	</div>
	<footer>
		<span id="cpw">Copyright@2019</span>
	</footer>
</body>
</html>