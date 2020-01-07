<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Edit movie Item</title>
<link href="./style/style.css" rel="stylesheet" type="text/css" />
<script src="./js/script.js" type="text/javascript"></script>
</head>
<body>
	<header> <span id="title">Movie Cruiser</span> <img
		class="img" src="./images/logo.png" alt="logo" id="logo" /> <nav>
	<a id="menu" href="ShowMovieListAdmin" />Movies</a> </nav> </header>
	<div>
		<h1>Edit movie Item</h1>
		<form class="cont" name="form" onsubmit="return validation()"
			method="post" action="EditMovieItem?movieId=${movie.id}">
			<table>
				<tr>
					<td colspan="4"><label for="texttitle"> Title</label></td>
				</tr>
				<tr>
					<td colspan="4"><input type="text" id="texttitle"
						name="texttitle" size="80" value="${movie.title }"></td>
				</tr>
				<tr>
					<td><label for="textboxOffice">$.boxOffice </label></td>
					<td>active</td>
					<td><label for="textdateofLaunch">dateofLaunch </label></td>
					<td><label for="genre">Genre </label></td>
				</tr>
				<tr>
					<td><input type="textbox" id="textboxOffice"
						name="textboxOffice" class="txt-right" value="${movie.boxOffice}"></td>
						
					<td><label for="rdYes"><input type="radio" id="rdYes"
							name="rdYes"  value= "Yes" <c:if test="${movie.active eq 'true'}"> checked="checked"</c:if>>Yes</label>
							 <label for="rdno"><input type="radio" id="rdYes" name="rdYes" value= "No" <c:if test="${movie.active eq 'false'}"> checked="checked"</c:if>>No</label>
							
					<td><input type="text" id="textdateofLaunch"
						name="textdateofLaunch"
						value="<fmt:formatDate pattern="dd/MM/yyyy"
							value="${movie.dateofLaunch }"></fmt:formatDate>"></td>
							
					<td><select name="genre" id="genre" value="${movie.genre}">
							<option value=Science Fiction>Science Fiction</option>
							<option value=Superhero>Superhero</option>
							<option value=Romance>Romance</option>
							<option value=Comedy>Comedy</option>
							<option value=Adventure>Adventure</option>
							<option value=Thriller>Thriller</option></td>
				</tr>
				<tr>
					<td colspan="2"><input type="checkbox" id="hasTeaser"
						name="hasTeaser" value= "Yes" <c:if test="${movie.hasTeaser eq 'true'}">checked="checked"</c:if>
						<c:if test="${!movie.hasTeaser  eq 'false'}"></c:if>/>HasTeaser</td>
				</tr>
				<tr>
					<td colspan="2"><input class="color" type="submit"
						value="Save"></td>
				</tr>
			</table>
		</form>
	</div>
	<footer> <span>Copyright@2019</span> </footer>
</body>
</html>