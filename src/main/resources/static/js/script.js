$(document).ready(function(){
	obterListaLanche();
	obterIngredientes();
});

function obterListaLanche(){
	
	$.ajax({
		url: "http://localhost:8080/obter-todos", 
		type: "GET",
		dataType: "JSON",//response
		success: function(result){
			createListaLanches(result);
		},
		error: function(){
			alert('Falha ao obter a lista');
		}
	});	
}

function createListaLanches(listaLanches) {
	
	listaLanches.forEach(function(obj) {
		
		var number = numeral(obj.valor);
		numeral.defaultFormat('R$0,0.00');
		
		
		$('.divForm').append(
			$('<div>',{"class":"listLanches"}).append(
				$('<div>',{"style":"display: flex"}).append(	
					$('<div>',{"width":"300px"}).text(obj.descricao),
					$('<div>',{"width":"100px"}).text(number.format())
				),
				$('<div>').append(	
					$('<a>',{"onclick":"showIngredientes("+obj.id+")","style":"cursor: pointer"}).text("Adicionar")
				)
			)
		)
	});
}

function showIngredientes(id) {
	$('#divIgredientesItens').show(300);
	obterLancheIngredientes(id);
	$('.divIngrediente').data({"lancheId":id});
}

function obterIngredientes() {
	$.ajax({
		url: "http://localhost:8080/obter-ingredientes", 
		type: "GET",
		dataType: "JSON",//response
		success: function(result){
			createListaIngredientes(result);
		},
		error: function(){
			alert('Falha ao obter a lista');
		}
	});
}

function createListaIngredientes(listaIngrediente) {
	listaIngrediente.forEach(function(obj) {
		$('.divIngrediente').append(
			$('<div>',{"style":"padding: 10px"}).text(obj.nome).append(
				$('<input>',{"class":"inputIngrediente","id":obj.id,"type":"number","style":"float: right", "value" : 0})
				.data({"idIngrediente":obj.id})
			)
		)
	});
}


function obterLancheIngredientes(id) {
	$.ajax({
		url: "http://localhost:8080/obter-lanche-ingredientes", 
		type: "GET",
		data: {id:id},
		dataType: "JSON",//response
		success: function(result){
			populaValorIngrediente(result);
		},
		error: function(){
			alert('Falha ao obter a lista');
		}
	});
}

function populaValorIngrediente(result) {
	$("input").val(0);
	result.forEach(function(r){
		$('#'+r.ingrediente.id).val(r.qtde);
	});
}

function adicionar() {
	$inputs = $('.divIngrediente .inputIngrediente');
	
	var ingredientesArr = [];
	
	var lancheId = $('.divIngrediente').data('lancheId');
	console.log('lanche id ',lancheId);
	
	for(var k = 0 ; k < $inputs.length ; k ++) {
		var $input = $($inputs[k]);
		var ingredienteId = $input.data('idIngrediente');
		var qtde = $input.val();
		
		ingredientesArr.push({
			id: ingredienteId,
			qtde: qtde
		});
	}
	
	var lanche = {
		idLanche: lancheId,
		ingredienteQtdDTOList: ingredientesArr
	};
	
	saveEdit(lanche);
}


function saveEdit(lanche) {
	
	$.ajax({
		url: "http://localhost:8080/edit", 
		type: "POST",
		data: JSON.stringify(lanche),
		contentType: "application/json; charset=utf-8",
		dataType: "JSON",//response
		success: function(result){
			var number = numeral(result.valor);
			numeral.defaultFormat('R$0,0.00');
			$('#valorLanche').html(result.descricao + " <b>Valor Total </b> R$" + number.format());
		},
		error: function(){
			alert('Falha ao Salvar');
		}
	});
}


