<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload Files</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<body>
	<h1>Upload</h1>
	<form>
		<input type="file" id="file" name="file" onchange="uploadfile();"/>
		<img alt="Imagem" src="" id="target" width="200px" height="200px"/>
	</form>
	<br>
	<br>
	<br>
	<a href="fileUpload?acao=carregar">Carregar Imagem</a>
	<br>
	<br>
	<br>
	<br>
	
	<form action="fileUpload" method="get">
		<table>
			<c:forEach items="${listaUserImagem}" var="user">
				<tr>
					<td>${user.id}</td>
					<td>${user.login}</td>
					<td><a href="fileUpload?acao=download&iduser=${user.id}">Download Imagem</a></td>
				</tr>
			
			</c:forEach>
		</table>
	</form>	
	
</body>
<script type="text/javascript">
function uploadfile(){	
	var target = document.querySelector("img");
	var file = document.querySelector("input[type=file]").files[0];
	
	var reader = new FileReader();
	
	reader.onloadend = function(){
		target.src = reader.result;
		
		//---------Upload Ajax---------------
		
		$.ajax({
		method: "POST",
		url: "fileUpload", //qual a servelt?
		data: { fileUpload: reader.result }
	})
		.done(function(response){ //nenhum erro
			alert("Sucesso! " + response);
		//fazer algo
		
	})
		.fail(function(xhr, status, errorThrow){ //reposta com o erro
			alert("Error " + xhr.resnposeText); // mostra erro do servidor
			
			//fazer algo se der errado
		});
		
		//------------------------
	};
		if (file){
			reader.readAsDataURL(file);
		} else {
			target.src = "";
		}
	}

</script>
</html>