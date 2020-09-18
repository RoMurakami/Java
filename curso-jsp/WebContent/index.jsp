<jsp:useBean id="calcuLa" class="beans.BeanCursoJsp"
	type="beans.BeanCursoJsp" scope="page" />


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="myprefix" uri="WEB-INF/testetag.tld"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="resources/css/estilo.css">

<title>Curso JSP</title>
</head>
<body>

		
	<div class="login-page">
	  
		<p><h2><center><b> Projeto Java Web </b></center></h2></p><br>
		<p><h2><center><b> JSP + Servlet + JDBC </b></h2></center></p>
		<p><center><b> Página do curso Java Web - JDev </b></center></p>
		<p><center><b> Login:</b> admin <b>Senha:</b> admin </center></p>
			
		<div class="form">
			<form action="LoginServlet" method="post" class="login-form">
				<label>Login: </label>
				<input type="text" id="login" name="login"
					placeholder="login"> <br> 
					
					<label>Senha: </label> 
					<input type="password" id="senha" name="senha" placeholder="senha">
				<br>
				<button type="submit" value="Logar">Logar</button>
				<br>
				<br>
				<a href="cadastrousuario.jsp"><b>Criar usuário</b></a>
				
			</form>
						
		</div>
	</div>
</body>



</html>