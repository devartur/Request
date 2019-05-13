<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
  <head>
    <title>Request</title>
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
    
    <c:if test="${not empty requestScope.allrequest}">
	    <c:forEach var="requests" items="${requestScope.allrequest}">
	    	<div class="container">
		      <div class="row bs-callout bs-callout-primary">
		      	<div class="col col-md-2 col-sm-3">
		<c:choose>
		    <c:when test="${requests.request==0}">
		        <div class="well well-sm centered"><c:out value="ZŁOŻONY" /></div>
		    </c:when>
		    <c:when test="${requests.request==1}">
		        <div class="well well-sm centered"><c:out value="ZATWIERDZONY" /></div>
		    </c:when>
		    <c:when test="${requests.request==2}">
		        <div class="well well-sm centered"><c:out value="ANULOWANY" /></div>
		    </c:when>
		    <c:otherwise>
		      <div class="well well-sm centered"><c:out value="INNY" /></div>
		    </c:otherwise>
		</c:choose>
		      	</div>
		      	
		        <div class="col col-md-10 col-sm-9">
		          <h6><small>Dodane przez: <c:out value="${requests.user.username}" />, 
		          Dnia: <fmt:formatDate value="${requests.timestamp}" pattern="YYYY/MM/dd"/></small></h6>
		          <p>Nazwa: <c:out value="${requests.name}" /></p>
		        </div>
		        
		        <div class="col col-md-10 col-sm-9">
		          <h6><small>Data początku: <c:out value="${requests.start}" />, 
		          Data końca: <c:out value="${requests.stop}" /> </small></h6>
		          <p>Opis: <c:out value="${requests.description}" /></p>
		        </div>
		        
		        
		      </div>
		    </div>
	    </c:forEach>
    </c:if>
    
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