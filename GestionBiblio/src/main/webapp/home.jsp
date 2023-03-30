<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List"%>
<%@ page import="fr.univtours.polytech.gestionbiblio.model.GenreBean"%>
<!DOCTYPE html>
<html>
<head>
<title>Catalogue de livres</title>
</head>
<body>
	<h1>Catalogue de livres</h1>
	<c:choose>
		<c:when test="${not isConnected}">
			<form action="login" method="get">
				<input
					type="submit" value="Se connecter">
			</form>
		</c:when>
		<c:otherwise>
			<p>Bienvenue ${user.nom} ${user.prenom} !</p>
			<p>Nombre de livres empruntés : ${user.nbreLivresEmpruntes}</p>
			<form action="logout" method="post">
				<input type="submit" value="Se déconnecter">
			</form>
		</c:otherwise>
	</c:choose>
	<form action="home" method="get">
		<label for="author">Auteur :</label> <input type="text" id="author"
			name="author" value=""> <br> <br> <label
			for="title">Titre:</label> <input type="text" id="title" name="title"
			value="${title != null ? title : ''}"> <br> <br> <label
			for="genre">Genre :</label> <select id="genre" name="genre">
			<option value="">Tous</option>
			<%-- Remplir dynamiquement la liste des genres avec JPA --%>
			<c:forEach items="${requestScope.LIST_GENRES}" var="genre">
				<option value="${genre.nom}">${genre.nom}</option>
			</c:forEach>
		</select><br> <br> <label for="available">Disponibilité :</label> <input
			type="checkbox" id="available" name="available" value="true"><br>
		<br> <input type="submit" value="Rechercher">
	</form>
	<%-- Afficher les résultats de la recherche avec JPA --%>
	<c:if test="${not empty LIST_LIVRES}">
		<h2>Résultats de la recherche :</h2>
		<table>
			<thead>
				<tr>
					<th>Titre</th>
					<th>Auteur</th>
					<th>Genre</th>
					<th>Disponibilité</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${requestScope.LIST_LIVRES}" var="book">
					<tr>

						<td>${book.titre}</td>
						<td>${book.auteur}</td>
						<td>${book.genre.nom}</td>
						<td>${book.libre}</td>
						<td><c:if test="${isConnected}">
								<form action="reservation" method="post">
									<input type="hidden" name="bookId" value="${book.id}" /> <input
										type="submit" value="Réserver" />
								</form>
							</c:if></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</c:if>
	<c:if test="${empty LIST_LIVRES}">
		<p>Aucun résultat trouvé.</p>
	</c:if>
</body>
</html>

