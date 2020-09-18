<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<body>
	<h3>Capturando Exceções com JQuery</h3>
	<input type="text" value="valor informado" id="txtvalor"/>
	<input type="button" onclick="testarExcecao();" value="Testar Exceção"> 
</body>
<script type="text/javascript">
	function testarExcecao() {
		valorInformado = $('#txtvalor').val();
		
		$.ajax({
			method: "POST",
			url: "capturarExcecao", //qual a servelt?
			data: {valorParam: valorInformado}
		})
			.done(function(response){ //nenhum erro
				alert("Sucesso" + response);
			//fazer algo
			
		})
			.fail(function(xhr, status, errorThrow){ //reposta com o erro
				alert("Error" + xhr.resnposeText); // mostra erro do servidor
				
				//fazer algo se der errado
			});
	}
</script>
</html>