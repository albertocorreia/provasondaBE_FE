<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!doctype html>
<html lang="pt-br">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Sonda - Prova Java</title>

<script src='https://kit.fontawesome.com/a076d05399.js'></script>

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Montserrat&display=swap" />


<link
	href="https://www.sonda.com/content/themes/SONDA/dist/img/favicon.png"
	rel="shortcut icon">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"
	integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
	crossorigin="anonymous"></script>

<style>
body {
	background-color: #F2F4F7;
	margin: 0;
	padding: 0;
	font-family: 'Montserrat', sans-serif;
}

nav {
	background-color: #FFFFFF;
	box-shadow: 0px 3px 6px #00000029;
	border-top: #000000 5px solid;
}

.navbar-light .navbar-toggler-icon {
	background-image: url("../images/search.png") !important;
}

.li {
	font-size: 10px;
}

.h3 {
	font-size: 10px;
}

.formlabels {
	vertical-align: middle;
	text-align: center;
	padding-top: 15px;
}

.formInput {
	width: 300px;
	font-size: 15px;
	margin-top: 5px;
}

.tablelabels {
	border-right: 1px solid #FFFFFF;
	padding-top: 15px;
	color: #FFFFFF;
	background-color: #000000;
}

.tablelabelsTools {
	border-right: 1px solid #FFFFFF;
	padding-top: 15px;
	color: #FFFFFF;
	background-color: #6A5ACD;
}

.tableContent {
	border-right: 1px solid #6A5ACD;
	border-bottom: 1px solid #6A5ACD;
	padding-top: 10px;
	color: #000000;
}

.tableContentTools {
	border-right: 1px solid #6A5ACD;
	border-bottom: 1px solid #6A5ACD;
	padding-top: 10px;
	color: #000000;
	background-color: #ADD8E6;
}

.tableContentVendido {
	border-right: 1px solid #6A5ACD;
	border-bottom: 1px solid #6A5ACD;
	padding-top: 10px;
	color: #000000;
	background-color: #FFA07A;
}

.tableContentNaoVendido {
	border-right: 1px solid #6A5ACD;
	border-bottom: 1px solid #6A5ACD;
	padding-top: 10px;
	color: #000000;
	background-color: #98FB98;
}
</style>

</head>
<body>
	<header>
		<nav class="navbar navbar-expand-lg navbar-light fixed-top">
			<a class="navbar-brand"><img
				src="https://www.sonda.com/content/themes/SONDA/dist/img/logo-sonda.svg"
				style="width: 100px; border: 0px;" alt="Logo BelHaus" /></a>
		</nav>
	</header>

	<div
		style="margin-top: 100px; display: block; vertical-align: middle; text-align: center; width: 100%; height: 100%;">

		<h1>Gestão de Aeronaves</h1>


		<div class="container" style="margin-top: 20px;">
			<div class="row">
				<div class="col-sm formlabels">
					<span>Marca</span>
				</div>
				<div class="col-sm">
					<select id="aerMarca" class="form-control formInput">
						<option>Embraer</option>
						<option>Boeing</option>
						<option>Airbus</option>
					</select>
				</div>
			</div>
			<div class="row">
				<div class="col-sm formlabels">
					<span>Modelo</span>
				</div>
				<div class="col-sm">
					<input type="text" class="form-control formInput" id="aerNome"
						placeholder="digite aqui o modelo da aeronave">
				</div>
			</div>
			<div class="row">
				<div class="col-sm formlabels">
					<span>Descrição</span>
				</div>
				<div class="col-sm">
					<input type="text" class="form-control formInput" id="aerDescricao"
						placeholder="digite aqui a descrição da aeronave">
				</div>
			</div>
			<div class="row">
				<div class="col-sm formlabels">
					<span>Ano</span>
				</div>
				<div class="col-sm">
					<input type="text" class="form-control formInput" id="aerAno"
						onkeyup="somenteNumeros(this);"
						placeholder="digite aqui o ano da aeronave">
				</div>
			</div>
			<div class="row">
				<div class="col-sm formlabels">
					<span>Vendido</span>
				</div>
				<div class="col-sm">
					<select id="aerVendido" class="form-control formInput">
						<option value="0">não</option>
						<option value="1">sim</option>

					</select>
				</div>
			</div>
		</div>


	</div>
	<center>
		<br /> <input type="hidden" id="aerId" />
		<button type="button" class="btn btn-success" style="margin-top: 5px;"
			id="btnGravar">gravar aeronave</button>
		<button type="button" class="btn btn-warning" style="margin-top: 5px;"
			id="btnAtualizar">alterar aeronave</button>
	</center>

	<div id="ds1"
		style="margin-top: 100px; display: block; vertical-align: middle; text-align: center; width: 100%; height: 100%;">

		<div id="showDataGit"
			style="width: 100%; text-align: center; vertical-align: top"></div>

		<br />
		<div style="display: inline-block; width: 100%; text-align: center;">
			encontrada(s) <span id="ShowCount"></span> aeronave(s)
		</div>

		<br />
		<br /> <i class="fas fa-tasks"></i><br />Prova Java - 11/12/2020

	</div>


	<script>
    getDataAeronaves();
    getDataAeronaves();
    
    $('#btnAtualizar').hide();
    
    $(function(){

        /* botão para gravar as aearonaves */
        $('#btnGravar').click(function () {
        	
        	var erro = false;
        	
        	//validando os campos
        	//se os campos texto estão preenchidos
        	if(($("#aerNome").val().length == 0) || ($("#aerAno").val().length == 0)
        			|| ($("#aerDescricao").val().length == 0)){
        		alert("[erro] todos os campos são obrigatórios, verifque por fvor")
        		erro = true;
        	}
        	
        	//se o ano digitado é inferior ao ano atual
        	var data = new Date(), ano = data.getFullYear();
        	if(ano < $("#aerAno").val()){
        		alert("[erro] o ano não pode ser maior que o ano atual")
        		erro = true;
        	}
        	
        	if(!erro){
        		addAeronave();
            	document.getElementById('aerId').value = null;
            	document.getElementById('aerAno').value = null;
            	document.getElementById('aerDescricao').value = null;
            	document.getElementById('aerVendido').value = 0;
            	document.getElementById('aerMarca').value = "Embraer";
            	document.getElementById('aerNome').value = null;
            	getDataAeronaves();
        	}
        	
        	
        	
        });
        
        /* botão para atualizar as aearonaves */
        $('#btnAtualizar').click(function () {
        	
			var erro = false;
        	
        	//validando os campos
        	//se os campos texto estão preenchidos
        	if(($("#aerNome").val().length == 0) || ($("#aerAno").val().length == 0)
        			|| ($("#aerDescricao").val().length == 0)){
        		alert("[erro] todos os campos são obrigatórios, verifque por fvor")
        		erro = true;
        	}
        	
        	//se o ano digitado é inferior ao ano atual
        	var data = new Date(), ano = data.getFullYear();
        	if(ano < $("#aerAno").val()){
        		alert("[erro] o ano não pode ser maior que o ano atual")
        		erro = true;
        	}
        	
        	if(!erro){
        		updateAeronave();
            	document.getElementById('aerId').value = null;
            	document.getElementById('aerAno').value = null;
            	document.getElementById('aerDescricao').value = null;
            	document.getElementById('aerVendido').value = 0;
            	document.getElementById('aerMarca').value = "Embraer";
            	document.getElementById('aerNome').value = null;
            	getDataAeronaves();
            	getDataAeronaves();
            	$('#btnAtualizar').hide();
        		$('#btnGravar').show();
        	}
        	
        });
        
        
    });
    
    /* funçãao para popular os campos" */
	function getAeronave(id) {
    	
		$('#btnAtualizar').show();
		$('#btnGravar').hide();
		
        //obtem os registros
        $.getJSON('/ProvaJavaSondaBE/aeronaves/'+id, function (data) {


            var showDataGit = $('#showDataGit');

            showDataGit.empty();
            var content = '';
            	document.getElementById('aerId').value = data.aerId;
            	document.getElementById('aerAno').value = data.aerAno;
            	document.getElementById('aerDescricao').value = data.aerDescricao;
            	document.getElementById('aerVendido').value = data.aerVendido;
            	document.getElementById('aerMarca').value = data.aerMarca;
            	document.getElementById('aerNome').value = data.aerNome;
        });

        getDataAeronaves();

	}
            
    /* função que popula o grid pelo endpoint GET /aeronaves */
    function getDataAeronaves() {
    	
        //obtem os registros
        $.getJSON('/ProvaJavaSondaBE/aeronaves/', function (data) {

			var contador = 0;
            var showDataGit = $('#showDataGit');

            showDataGit.empty();
            var content = '';
            var vendido = '';
            console.log(data);
            
            content = content + '<div class="row"><div class="col-sm tablelabels">ID</div><div class="col-sm tablelabels">Marca</div><div class="col-sm  tablelabels">Modelo</div><div class="col-sm  tablelabels">Ano</div><div class="col-sm  tablelabels">Vendido</div><div class="col-sm tablelabelsTools">excluir</div><div class="col-sm tablelabelsTools">alterar</div></div></div>';
            $.each(data, function (i, item) {
            	contador++;
            	if(item.aerVendido == 0){
            		vendido = '<div class="col-sm tableContentNaoVendido">não</div>';
            	}
            	else{
            		vendido = '<div class="col-sm tableContentVendido">sim</div>';
            	}
            	
                content = content + '<div class="row"><div class="col-sm tableContent">'+item.aerId+'</div><div class="col-sm tableContent">'+item.aerMarca+'</div><div class="col-sm tableContent">'+item.aerNome+'</div><div class="col-sm tableContent">'+item.aerAno+'</div>'+vendido+'<div class="col-sm tableContentTools"><button onclick="deleteAeronave('+item.aerId+')" style="border:0px;background-color:#ADD8E6" ><i class="fa fa-trash" aria-hidden="true"></i></button></div><div class="col-sm tableContentTools"><button onclick="getAeronave('+item.aerId+')" style="border:0px;background-color:#ADD8E6" ><i class="fas fa-pencil-alt"></i></i></button></div></div></div>';
            });

            if(contador == 0){
            	content = "<h2>nenhuma aeronave cadastrada</h1>";
            }
            
            $("#ShowCount").html(contador);
            showDataGit.append(content);

           

        });


    }

    /* função para adicionar as aeronaves pelo endpoint POST /aeronaves */
    function addAeronave() {
        console.log('addWine');
        $.ajax({
            type: 'POST',
            contentType: 'application/json',
            url: '/ProvaJavaSondaBE/aeronaves/',
            dataType: "json",
            data: formToJSON(),
            success: function(data, textStatus, jqXHR){
                alert('aeronave cadastrada com sucesso');
            },
            error: function(jqXHR, textStatus, errorThrown){
                alert('error: ' + textStatus);
            }
        });
        
        getDataAeronaves();
    }
    
    /* função para atualizar as aeronaves pelo endpoint PUT /aeronaves/{id} */
    function updateAeronave() {
        $.ajax({
            type: 'PUT',
            contentType: 'application/json',
            url: '/ProvaJavaSondaBE/aeronaves/' + $('#aerId').val(),
            dataType: "json",
            data: formToJSON(),
            success: function(data, textStatus, jqXHR){
                alert('aeronave alterada com sucesso');
            },
            error: function(jqXHR, textStatus, errorThrown){
                alert('error:' + textStatus);
            }
        });
    }
    
    /* função para excluir as aeronaves pelo endpoint DELETE /aeronaves/{id} */
    function deleteAeronave(id) {
        console.log('delete');
        $.ajax({
            type: 'DELETE',
            url: '/ProvaJavaSondaBE/aeronaves/' + id,
            success: function(data, textStatus, jqXHR){
                alert('aeronave excluida com sucesso');
            },
            error: function(jqXHR, textStatus, errorThrown){
            	alert('error: ' + textStatus);
            }
        });
        getDataAeronaves();
        getDataAeronaves();
    }
    
    /* função para formatar o JSON */
    function formToJSON() {
        return JSON.stringify({
            "aerId": $('#aerId').val(),
            "aerAno": $('#aerAno').val(),
            "aerDescricao": $('#aerDescricao').val(),
            "aerVendido": $('#aerVendido').val(),
            "aerMarca": $('#aerMarca').val(),
            "aerNome": $('#aerNome').val()
            });
    }

    /* função axiliar para que o campo ano só tenha numeros */
    function somenteNumeros(num) {
        var er = /[^0-9]/;
        er.lastIndex = 0;
        var campo = num;
        if (er.test(campo.value)) {
          campo.value = "";
        }
    }
    
</script>

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>

</body>
</html>