<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  
<title>Calculando datas</title>
</head>
<body>
	<form action="calculandoDataFinal" method="post">
		<label>Data Inicial: <input id="data" name="data"></label>
		<label>Tempo em Horas: <input type="text" id="tempo" name="tempo"></label>
		<input type="submit" value="Calcular">
	</form>
	<br>
	<br>
	
	<label>Data Final: <input type="text" id="dataFinal" name="dataFinal" readonly="readonly" value="${dataFinal}"></label>

</body>
<script type="text/javascript">
	$(function(){
		$('#data').datepicker({dateFormat: 'dd/mm/yy'});
	});
</script>

</html>