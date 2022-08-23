$(document).ready(function() {
	carga();
  $('#fibonacciTable').DataTable();
  $('#fibonacciTableAleatorio').DataTable();  
  
});


function carga(){
	
	let numero = getRandomIntInclusive(1,800000);	
	cargaTabla();	
	cargaTablaAleatorio(numero);
	countRow();
}


async function cargaTabla(){
	
	const request = await fetch('fibonacci/all',{
		method: 'GET',
		headers:{'Accept':'application/json','Content-Type':'application/json'}
	});
	
	const listFibo = await request.json();
	
	let rowFibo = "";
	
	for(let fib of listFibo ){
		 rowFibo += '<tr> <td>' + fib.id + '</td> <td> ' + fib.parametrosInicio + '</td> <td>' + fib.parametrosFinal + '</td><td>' + fib.fecha + '</td><td>' + fib.resultado + '</td> <td><a href="#" class="btn btn-danger btn-circle btn-sm" onc><i class="fas fa-trash" onclick="eliminarRegistro(' + fib.id + ')"></i></a></td> </tr>';	
	}
	
	document.querySelector('#fibonacciTable tbody').outerHTML = rowFibo ;
	
	
}


async function cargaTablaAleatorio(limite){
	
	const request = await fetch('/fibonacci/max?limite='+limite,{
		method: 'GET',
		headers:{'Accept':'application/json','Content-Type':'application/json'}
	});
	
	const fib = await request.json();
	
	let rowFibo = '<tr> <td>' + fib.id + '</td> <td> ' + fib.parametrosInicio + '</td> <td>' + fib.parametrosFinal + '</td><td>' + fib.fecha + '</td><td>' + fib.resultado + '</td> <td><a href="#" class="btn btn-danger btn-circle btn-sm" onc><i class="fas fa-trash" onclick="eliminarRegistro(' + fib.id + ')"></i></a></td> </tr>';	
		 
	
	document.querySelector('#fibonacciTableAleatorio tbody').outerHTML = rowFibo ;
	
	
}

async function eliminarRegistroId(id){
	
	const request = await fetch('/fibonacci/delete?id='+id,{
		method: 'GET',
		headers:{'Accept':'application/json','Content-Type':'application/json'}
	});
	
	location.reload();
}


async function countRow(){
	
	const request = await fetch('fibonacci/count',{
		method: 'GET',
		headers:{'Accept':'application/json','Content-Type':'application/json'}
	});
	
	const fib = await request.json();
	
	document.querySelector('#rowNumero ').outerHTML = "Fibonacci Example ALL numero de registro : " + fib ;
	
}

function eliminarRegistro(id){
	eliminarRegistroId(id);
}

function getRandomIntInclusive(min, max) {
	  min = Math.ceil(min);
	  max = Math.floor(max);
	  return Math.floor(Math.random() * (max - min + 1) + min);
}