<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <title>Request - dodaj wniosek</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" type="text/css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/styles.css" type="text/css" rel="stylesheet">
  </head>

  <body>
    
    <nav class = "navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <a href="#" class="navbar-brand">Request</a>
        
        <button class="navbar-toggle" data-toggle="collapse" data-target=".navHeaderCollapse">
          <span class="glyphicon glyphicon-list"></span>
        </button>
        
        <div class="collapse navbar-collapse navHeaderCollapse">
          <ul class="nav navbar-nav navbar-right">
            <li class="active"><a href="#">Główna</a></li>
            <li><a href="${pageContext.request.contextPath}/myRequest">Moje wnioski</a></li>
            <li><a href="${pageContext.request.contextPath}/acceptRequest">Wnioski do zatwierdzenia</a></li>
            <li><a href="${pageContext.request.contextPath}/userInformation">Informacje o mnie</a></li>
            
            <li><a href="${pageContext.request.contextPath}/add">Dodaj</a></li>
            <c:choose>
            	<c:when test="${not empty sessionScope.user}">
            		<li><a href="${pageContext.request.contextPath}/logout">Wyloguj się</a></li>
            	</c:when>
            	<c:otherwise>
            		<li><a href="${pageContext.request.contextPath}/login">Zaloguj się</a></li>
            	</c:otherwise>
            </c:choose>
          </ul>
        </div>
        
      </div>
    </nav>
    
   <div class="container">
		<div class="col-sm-6 col-md-4 col-md-offset-4">
			<form class="form-signin" method="post" action="userInformation">
				<h2 class="form-signin-heading">Informacje o Tobie</h2>
				<label for="inputEmail">Twój Email:</label>
				<input name="inputEmail" type="email" class="form-control" placeholder="Email" required autofocus />
				<label for="inputUsername">Twója nazwa użytkownika:</label>
				<input name="inputUsername" type="text" name="inputUsername" class="form-control" placeholder="Nazwa użytkownika" required autofocus />
				<label for="inputUsername">Twóje imię:</label>
				<input name="inputFirstname" type="text" class="form-control" placeholder="Imię" required />
				<label for="inputUsername">Twóje nazwisko:</label>
				<input name="inputSecondname" type="text" class="form-control" placeholder="Nazwisko" required />
				<label for="inputSuperiorID">ID osoby do któej trafią wnioski:</label>
				<input name="inputSuperiorID" type="text" class="form-control" placeholder="ID osoby akceptującej" required />
				<button class="btn btn-lg btn-primary btn-block" type="submit" >Zaktualizuj dane</button>
			</form>
		</div>
    </div>
    
    <footer class="footer">
      <div class="container">
        <p class="navbar-text">Aplikacja Request by Artur Olszewski</p>
      </div>
    </footer>
    
    <script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
    <script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
    <script src="resources/js/bootstrap.js"></script>
  </body>
</html>