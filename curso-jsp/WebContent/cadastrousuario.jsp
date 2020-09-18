<%@page import="beans.BeanCursoJsp"%>
<jsp:useBean id="bean_BeanCursoJsp" class="beans.BeanCursoJsp" type="beans.BeanCursoJsp" scope="session"/>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="resources/css/cadastro.css">

<!-- Adicionando JQuery -->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"
	integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
	crossorigin="anonymous"></script>

<title>Cadastro de usuário</title>
</head>
<body>

	
	<center>
		<h1>Cadastro de usuário do sistema</h1>
		<h3 style="color: red;">${msg}</h3>
	</center>


	<div class="formulario">
		
		<form action="salvarUsuario" method="post" id="formUser"
			onsubmit="return validarCampos() ? true : false;"
			enctype="multipart/form-data">
			<ul class="form-style-1">
				<table  class="flat-table" style="padding-left: 40%">
					<tr>
						<td>Código:</td>
						<td><input type="text" readonly="readonly" id="id" name="id" value="${user.id}"></td>
					</tr>
						<tr><td></td></tr>
					<tr>
						<td>Login:</td>
						<td><input type="text" id="login" name="login" value="${user.login}" placeholder="login"></td>
								
						<td>Senha:</td>
						<td><input type="password" id="senha" name="senha" value="${user.senha}" placeholder="senha"></td>
					</tr>
						<tr><td></td></tr>
					<tr>
						<td>Nome:</td>
						<td><input type="text" id="nome" name="nome" value="${user.nome}" placeholder="nome"></td>
								
						<td>Cep:</td>
						<td><input type="text" id="cep" name="cep" placeholder="Cep" onblur="consultaCep()" value="${user.cep}"></td>
					</tr>
						<tr><td></td></tr>
					<tr>
						<td>Rua:</td>
						<td><input type="text" id="rua" name="rua" placeholder="Rua" value="${user.rua}"></td>
								
						<td>Bairro:</td>
						<td><input type="text" id="bairro" name="bairro" placeholder="Bairro" value="${user.bairro}"></td>
					</tr>
						<tr><td></td></tr>
					<tr>
						<td>Cidade:</td>
						<td><input type="text" id="cidade" name="cidade" placeholder="Cidade" value="${user.cidade}"></td>
								
						<td>Estado:</td>
						<td><input type="text" id="estado" name="estado" placeholder="Estado" value="${user.estado}"></td>
					</tr>
						<tr><td></td></tr>
					<tr>
						<td>IBGE:</td>
						<td>
							<input type="text" id="ibge" name="ibge" value="${user.ibge}"></td>
							
							<td>Ativo:</td>
							<td> <input type="checkbox" id="ativo" name="ativo" 
								<%
									if (request.getAttribute("user") != null){
										BeanCursoJsp user = (BeanCursoJsp) request.getAttribute("user");
										if(user.isAtivo()){
											out.print(" ");
											out.print("checked=\"checked\"");
											out.print(" ");
										}
									}
								%>
							>
							</td>
						</tr>
						<tr><td></td></tr>
						<tr><td></td></tr>
						<tr>
							<td>Perfil:</td>
							<td>
								<select  id="perfil" name="perfil">
									<option value="nao_informado" >[--SELECIONE--]</option>
									
									<option value="administrador" 
										<%
										if (request.getAttribute("user") != null){
											BeanCursoJsp user = (BeanCursoJsp) request.getAttribute("user");
											if(user.getPerfil().equalsIgnoreCase("administrador")){
												out.print(" ");
												out.print("selected=\"selected\"");
												out.print(" ");
											}
										}
										%>
										
									>Adminstrador</option>
									
									<option value="secretaria" 
										<%
										if (request.getAttribute("user") != null){
											BeanCursoJsp user = (BeanCursoJsp) request.getAttribute("user");
											if(user.getPerfil().equalsIgnoreCase("secretaria")){
												out.print(" ");
												out.print("selected=\"selected\"");
												out.print(" ");
												}
											}
										%>
									>Secretaria(o)</option>
									
									<option value="analista" 
										<%
										if (request.getAttribute("user") != null){
											BeanCursoJsp user = (BeanCursoJsp) request.getAttribute("user");
											if(user.getPerfil().equalsIgnoreCase("analista")){
												out.print(" ");
												out.print("selected=\"selected\"");
												out.print(" ");
												}
											}
										%>
									>Analista</option>
									
									<option value="gerente" 
										<%
										if (request.getAttribute("user") != null){
											BeanCursoJsp user = (BeanCursoJsp) request.getAttribute("user");
											if(user.getPerfil().equalsIgnoreCase("gerente")){
												out.print(" ");
												out.print("selected=\"selected\"");
												out.print(" ");
												}
											}
										%>
									>Gerente</option>
								</select>
							</td>
							<td>Foto:</td>
								<td><input type="file" name="foto"></td>
						</tr>
						<tr></tr><tr></tr>
						<tr>
							<td>Sexo:</td>
							<td>
								<input type="radio" name="sexo" 
								<%
									if(request.getAttribute("user") != null){
										
										BeanCursoJsp user = (BeanCursoJsp) request.getAttribute("user");
										if (user.getSexo().equalsIgnoreCase("masculino")){
											out.print(" ");
											out.print("checked=\"checked\"");
											out.print(" ");
										}
									}
								%>
								value="masculino">Masculino</input>
								
								<input type="radio" name="sexo" 
								<%
									if(request.getAttribute("user") != null){
										
										BeanCursoJsp user = (BeanCursoJsp) request.getAttribute("user");
										if (user.getSexo().equalsIgnoreCase("feminino")){
											out.print(" ");
											out.print("checked=\"checked\"");
											out.print(" ");
										}
									}
								%>
								value="feminino">Feminino</input>
							</td>
								<td>Curriculo:</td>
								<td><input type="file" name="curriculo" value="curriculo">
							</td>
						</tr>
						<tr></tr><tr></tr>
						<tr>
							<td></td>
							<td><input type="submit" value="Salvar" title="Salvar" style="width: 142px"></td>
							<td></td>
							<td><input style="width: 142px" type="submit" value="Cancelar" onclick="document.getElementById('formUser').action = 'salvarUsuario?acao=reset'"
								title="Cancelar"></td>
					</tr>
				</table>
			</ul>
		</form>
	</div>	
		
		<center>
			<a href="acessoliberado.jsp"><img src="resources/img/voltar.jpg"
		title="Voltar" width="40px" height="40px"></a>
			<a href="index.jsp"><img src="resources/img/inicio.jpg"
		title="Inicio" width="40px" height="40px"></a>
		</center>
		
		
		<form action="servletPesquisa" method="post">	
			<ul class="form-style-1">
				<table  class="flat-table">
					<tr>
						<td>Descrição:</td>
						<td><input type="text" id="descricaoconsulta" name="descricaoconsulta"></td>
						<td><input type="submit" id="pesquisar" value="pesquisar"></td>
					</tr>		
				</table>
			</ul>
		</form>		
				
			<center>
				<h2>Lista de usuário cadastrados</h2>
			</center>
		<div class="formulario">	
			<ul class="form-style-1">
				<table class="flat-table">
					<thead>
						<tr>
							<th>Código</th>
							<th>Usuario</th>
							<th>Foto</th>
							<th>Curriculo</th>
							<th>Nome</th>
							<th>Telefone</th>
							<th>Delete</th>
							<th>Editar</th>
							<th>Update</th>
						</tr>
					</thead>
						<tbody class="corpo-td">
						<c:forEach items="${usuarios}" var="user">
							<tr>
								<td style="width: 150px"><c:out value="${user.id}"></c:out></td>
								<td style="width: 150px"><c:out value="${user.login}"></c:out></td>
								
								<c:if test="${user.fotoBase64Miniatura.isEmpty() == false}">
									<td> <center> <a href="salvarUsuario?acao=download&tipo=imagem&user=${user.id}"><img alt="imagemUser" title="ImagemUser" src="<c:out value="${user.fotoBase64Miniatura}"/>" width="32px" height="32px"/></a></center></td>
								</c:if>
								
								<c:if test="${user.fotoBase64Miniatura == null}">
									 <td><center><img src="resources/img/user.jpg" alt="ImagemUser" width="32px" height="32px" title="Imagem User"  onclick="alert('Não possui imagem')"></center></td>
								</c:if>
								
								<c:if test="${user.curriculoBase64.isEmpty() == false}">
									<td><center><a href="salvarUsuario?acao=download&tipo=curriculo&user=${user.id}"><img alt="Curriculo" src="resources/img/pdf1.jpg" width="32px" height="32px" /></a></center> </td>
								</c:if>
								
								<c:if test="${user.curriculoBase64 == null}">
									<td> <center> <img src="resources/img/pdf.jpg" alt="CurriculoUser" title="Curriculo" width="32px" height="32px" onclick="alert('Não possui documento')"/> </center> </td>
								</c:if>
								
								<td><c:out value="${user.nome}"></c:out></td>
								<td><c:out value="${user.telefone}"></c:out></td>

								<td><a href="salvarUsuario?acao=delete&user=${user.id}" onclick="return confirm('Deseja excluir cadastro?')">
										<center>
											<img alt="Excluir" src="resources/img/excluir.jpg"
												title="Excluir" width="28px" height="28px">
										</center></a></td>
								<td><a href="salvarUsuario?acao=editar&user=${user.id}"><center>
											<img alt="Editar" src="resources/img/editar.jpg"
												title="Editar" width="28px" height="28px">
										</center></a></td>
								<td><a href="salvarTelefones?acao=addFone&user=${user.id}"><center>
											<img alt="Telefones" src="resources/img/phone.jpg"
												title="Telefones" width="28px" height="28px">
							</center></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</ul>
	</div>
		<br>
		<script type="text/javascript">
			function validarCampos() {
				if (document.getElementById("login").value == '') {
					alert('Informe login');
					return false;
				} else if (document.getElementById("senha").value == '') {
					alert('Informe senha');
					return false;
				} else if (document.getElementById("nome").value == '') {
					alert('Informe nome');
					return false;
				} else if (document.getElementById("telefone").value == '') {
					alert('Informe telefone');
					return false;
				}else if (document.getElementById("cep").value == '') {
					alert('Informe cep');
					return false;
				}	
				return true;
			}

			function consultaCep() {
				var cep = $("#cep").val();

				//Consulta o webservice viacep.com.br/
				$.getJSON("https://viacep.com.br/ws/" + cep
						+ "/json/?callback=?", function(dados) {

					if (!("erro" in dados)) {
						//Atualiza os campos com os valores da consulta.
						$("#rua").val(dados.logradouro);
						$("#bairro").val(dados.bairro);
						$("#cidade").val(dados.localidade);
						$("#estado").val(dados.uf);
						$("#ibge").val(dados.ibge);

					} //end if.
					else {
						//CEP pesquisado não foi encontrado.$("#rua").val(dados.logradouro);

						$("#cep").val(' ');
						$("#rua").val(' ');
						$("#bairro").val(' ');
						$("#cidade").val(' ');
						$("#estado").val(' ');
						$("#ibge").val(' ');

						alert("CEP não encontrado.");
					}
				});

			}
		</script>
</body>
</html>