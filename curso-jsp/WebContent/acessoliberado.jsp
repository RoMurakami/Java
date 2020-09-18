<jsp:useBean id="calcula" class="beans.BeanCursoJsp"
	type="beans.BeanCursoJsp" scope="page" />

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Acessar Sistema</title>
</head>
<body>
	<jsp:setProperty property="*" name="calcula" />
	<center>
	<div style="padding: 10%">
	<h2>Bem vindo ao sistema de cadastros</h2>
	<br>
	<a href="salvarUsuario?acao=listartodos"><img
		src="resources/img/login.jpg" alt="cadastrodeusuario" title="Cadastro de usuário"></a>

	<a href="salvarProduto?acao=listartodos"><img src="resources/img/produto.jpg" alt="cadastrodeprodutos"
		title="Cadastro de produtos"></a>
		<center>
		<br>
		<br>
		<a href="index.jsp"><img src="resources/img/inicio.jpg" alt="inicio"
			title="Inicio" width="35px" height="35px"></a>
		</center>
      </div>
	</center>
</body>
</html>