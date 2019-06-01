<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Quartos</title>
<link href="/webjars/bootstrap/4.3.1/css/bootstrap.min.css"
        rel="stylesheet">
</head>
<body>

<table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Número</th>
      <th scope="col">Valor Diária</th>
      <th scope="col">Tipo</th>
      <th scope="col">Ação</th>
    </tr>
  </thead>
  <tbody>
  	<c:forEach var="room" items="${ roomsList }">
	    <tr>
	      <th scope="row">${ room.id }</th>
	      <td>${ room.number }</td>
	      <td>${ room.dailyValue }</td>
	      <td>${ room.type }</td>
	      <td>
	      	<a href="/room?id=${ room.id }">
	      		<button type="button" class="btn btn-warning">Editar</button>
	      	</a>
	      </td>
	    </tr>
    </c:forEach>
  </tbody>
</table>

<script src="/webjars/jquery/3.3.1-1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</body>
</html>