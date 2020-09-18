<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="resources/css/cadastro.css">


<title>Cadastro de telefones</title>
</head>
<body>
	
	
	<center>
		<h1>Cadastro de telefones</h1>
		<h3 style="color: red;">${msg}</h3>
	</center>
	<div class="formulario">
		
			<form action="salvarTelefones" method="post" id="formUser">
				<ul class="form-style-1">
					<li>
						<table >
							<tr>
								<td>User:</td>
								<td><input type="text" readonly="readonly"
									id="id" name="id" value="${userEscolhido.id}"></td>
									
								<td><input type="text" readonly="readonly"
									id="nome" name="nome" value="${userEscolhido.nome}"></td>
							</tr>
							
							<tr>
								<td>Número</td>
								<td><input type="text" id="numero" name="numero"> </td>
								<td><select id="tipo" name="tipo" style="width: 172px">
									<option>Residencial</option>
									<option>Contato</option>
									<option>Celular</option>
								</select>
								</td>
							</tr>		
							
							<tr>
								<td></td>
								<td>
									<input type="submit" value="Salvar" title="Salvar" style="width: 170px"></td>
									<td><input style="width: 170px" type="submit" value="Voltar" title="voltar" onclick="document.getElementById('formUser').action = 'salvarTelefones?acao=voltar'">
								</td>
							</tr>
						</table>
					</li>
				</ul>
			</form>
			<center>
			<a href="acessoliberado.jsp"><img src="resources/img/voltar.jpg"
				title="Voltar" width="30px" height="30px"></a> <a href="index.jsp"><img
				src="resources/img/inicio.jpg" title="Inicio" width="30px"
				height="30px"></a>
			</center>		
		
		<ul class="form-style-1">
			<li>
				<table class="flat-table">
					<caption>Lista de telefones cadastrados</caption>
					<thead>
						<tr>
							<th>ID</th>
							<th>Número</th>
							<th>Tipo</th>
							<th>Excluir</th>
						</tr>
					</thead>
					<tbody class="corpo-td">
						<c:forEach items="${telephone}" var="fone">
							<tr>
								<td style="width: 150px"><c:out value="${fone.id}"></c:out></td>
								<td style="width: 150px"><c:out value="${fone.numero}"></c:out></td>
								<td><c:out value="${fone.tipo}"></c:out></td>
								
								<td> <center> <a href="salvarTelefones?acao=deleteFone&foneId=${fone.id}" onclick="return confirm('Deseja excluir cadastro?')"><img alt="Excluir"
										src="resources/img/excluir.jpg" title="Excluir" width="25px"
										height="25px"></a> </center> </td>
								
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</li>
		</ul>

		<br>
		
</body>
</html>