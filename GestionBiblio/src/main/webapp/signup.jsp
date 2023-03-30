<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Page de connexion</title>
</head>
<body>
    <h1>Connexion</h1>
    <form action="signup" method="post">
        <label for="username">Username</label>
        <input type="text" id="username" name="username" required><br><br>
        <label for="username">Nom</label>
        <input type="text" id="username" name="nom" required><br><br>
        <label for="username">Prenom :</label>
        <input type="text" id="username" name="prenom" required><br><br>
        <label for="password">Mot de passe :</label>
        <input type="password" id="password" name="password" required><br><br>
        <input type="submit" value="Se connecter">
    </form>
    
</body>
</html>
