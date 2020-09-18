<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="resources/css/cadastro.css">
  <script src="resources/js/jquery.min.js" type="text/javascript"></script>
  <script src="resources/js/jquery.maskMoney.min.js" type="text/javascript"></script>
  
<title>Cadastro de Produtos</title>
</head>

<body>

	<center>
		<h2>Cadastro de Produto</h2>
		<h3 style="color: red;">${msg}</h3>
	</center>
	<div class="formulario" style="padding-left: 20%">
		<form action="salvarProduto" method="post" id="formProduto" onsubmit="return validarCampos()? true : false;" >
			<ul class="form-style-1">
					<table>
						<tr>
							<td>Código:</td>
							<td><input type="text" readonly="readonly" id="id" name="id" value="${produto.id}" width=""></td>
						</tr>
						<tr></tr>
						<tr></tr>
						<tr>
							<td>Descrição:</td>
							<td><input type="text" id="descricao" name="descricao"value="${produto.descricao}" placeholder="Descrição"></td>
						</tr>
						<tr></tr>
						<tr></tr>
						<tr>
							<td>Quantidade:</td>
							<td><input type="text" id="quantidade" name="quantidade" align="right" value="${produto.quantidade}" placeholder="Quantidade" maxlength="7"></td>
						</tr>
						<tr></tr>
						<tr></tr>
						<tr>
							<td>Valor R$:</td>
							<td><input type="text" id="valor" name="valor" data-thousands="." data-decimal="," align="right" value="${produto.valorEmTexto}" placeholder="Valor" maxlength="10"></td>
						</tr>
						<tr></tr>
						<tr></tr>
						<tr>
						<td>Categoria:</td>
						<td>
							<select id="categorias" name="categoria_id" style="width: 170px">
								<c:forEach items="${categorias}" var="cat">
									<option value="${cat.id}" id="${cat.id}"
										<c:if test="${cat.id == produto.categoria_id}">
											<c:out value="selected=selected"/>
										</c:if>
									>
										${cat.id} - ${cat.nome}
									</option>								
								</c:forEach>
							</select>
						</td>
						</tr>
						<tr>
							<tr></tr>
							<td></td>
							<td><input type="submit" value="Cadastrar"> <input type="submit" value="Cancelar" onclick="document.getElementById('formProduto').action = 'salvarProduto?acao=reset'"/></td>
						</tr>
				</table>
			</ul>
		</form>
	</div>
	
			<form action="servletCategoria" method="post" onsubmit="return validarCategoria()? true : false;">
			
				<ul class="form-style-1">
					<table>
						<tr>
							<td>Criar Categoria:</td>
							<td><input type="text" id="cadastrocategoria" name="cadastrocategoria" value="${cat.nome}"/></td>
							<td><a href="servletCategoria?acao=delete&categroia=${cat.id}">Excluir Categoria</a></td>
							<td><input type="submit" id="cadastrar" name="Cadastrar" value="Categoria"> </td>
						</tr>
					</table>
				</ul>
			</form>			
	
	<center>
		<a href="acessoliberado.jsp"><img src="resources/img/voltar.jpg" width="35px" height="35px" title="Voltar"></a>

		<a href="index.jsp"><img src="resources/img/inicio.jpg" title="Inicio" width="35px" height="35px"></a>
	</center>
	
	<br>
		<center><h2>Lista de Produtos</h2></center>
		
	
		<div class="formulario" style="padding-left: 10%">
			<ul class="form-style-1">
				<table class="flat-table">
				<thead>
					<tr>
						<th>Código</th>
						<th>Descrição</th>
						<th>Quanidade</th>
						<th>Valor R$</th>
						<th>Excluir</th>
						<th>Editar</th>
					</tr>
				</thead>
				<tbody class="corpo-td">
					<c:forEach items="${_produtos}" var="produto">
				<tr>
					<td style="width: 120px"><c:out value="${produto.id}"></c:out></td>
					<td style="width: 120px"><c:out value="${produto.descricao}"></c:out></td>
					<td><center> <c:out value="${produto.quantidade}"></c:out></center></td>
					<td><center> <fmt:formatNumber type="number" maxFractionDigits="2" value="${produto.valor}" /></center></td>

					<td><center> <a href="salvarProduto?acao=delete&produto=${produto.id}" onclick="return confirm('Deseja excluir cadastro?')"><img src="resources/img/excluir.jpg" alt="excluir" title="Excluir"
							width="30px" height="30px"> </a></center></td>
					<td><center><a href="salvarProduto?acao=editar&produto=${produto.id}"><img
							alt="Editar" title="Editar" src="resources/img/editar.jpg"
							width="30px" height="30px"></a></center></td>
				</tr>
			</c:forEach>
			</tbody>
			</table>
		</ul>
	  </div>		
	<br>

	<script type="text/javascript">
		function validarCampos() {
			if ((document.getElementById("descricao").value == '')) {
				alert('Informe a descrição do produto');
				return false;
			} else if ((document.getElementById("quantidade").value == '')) {
				alert('Informe a quantidade de produtos');
				return false;
			} else if ((document.getElementById("valor").value == '')) {
				alert('Informe o valor do produto');
				return false;
			}else if ((document.getElementById("valor").value == '')) {
					alert('Informe o valor do produto');
					return false;
			 }		
			return true;
		} 
	</script> 
	<script type="text/javascript">
		function validarCategoria(){
			if ((document.getElementById("cadastrocategoria").value == ' ')){
				alert('Informe a categoria');
				return false;
			}
			return true;
		}
	
	</script> 
</body>
<script>
  $(function() {
    $('#valor').maskMoney();
  })
</script>
</html>