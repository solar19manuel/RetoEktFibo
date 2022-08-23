package com.elektra.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.elektra.models.FibonacciModel;
import com.elektra.services.FibonacciServices;

@RestController
@RequestMapping("/fibonacci")
public class FibonacciController {
	
	
	@Autowired
	FibonacciServices fibonacciServices;
	
	private static Logger LOG = LoggerFactory.getLogger(FibonacciController.class);
	
	/*
	● Desarrollar un servicio REST que calcule la serie de fibonacci
	● Recibir como parámetro el límite el cuál no podrá pasar el cálculo de dicha serie
	● Se debe guardar en un archivo cada petición válida recibida por el servicio
	● Se deben poder consultar los número enviados en peticiones anteriores
	● Se debe poder eliminar un registro de número enviados
	● Generar los contratos de interfaz en swagger
	 * */

	/*http://localhost:1919/fibonacci*/
	@GetMapping()
	public FibonacciModel calcularFibonacciModel(){
		LOG.info("calcularFibonacciModel : ");
		return fibonacciServices.calculoFibonacci(20);
	}
	
	/*http://localhost:1919/fibonacci/row?numero=50
	 * */
	@GetMapping(path ="/row")
	public FibonacciModel  calculoFibonacciRow(@RequestParam("numero") Integer limite){
		LOG.info("calculoFibonacciRow : numero : "+ limite);
		return fibonacciServices.calculoFibonacci(limite);
		
	}
	
	
	/*http://localhost:1919/fibonacci/max?limite=1000
	 * */
	@GetMapping(path ="/max")
	public FibonacciModel  calcularFibonacciModelMax(@RequestParam("limite") Integer limite){
		LOG.info("calcularFibonacciModelMax : Max :" + limite);
		return fibonacciServices.calculoFibonacciMax(limite);
		
	}
	
	/*http://localhost:1919/fibonacci/query?id=1
	 * */
	@GetMapping(path ="/query")
	public Optional<FibonacciModel>  getCalcularFibonacciModelId(@RequestParam("id") Long id){
		LOG.info("getCalcularFibonacciModelId : " +id);
		return fibonacciServices.getCalculoFibonacciId(id);
		
	}
	
	/*http://localhost:1919/fibonacci/all
	 * */
	@GetMapping(path ="/all")
	public ArrayList<FibonacciModel>  getListCalcularFibonacci(){
		LOG.info("getListCalcularFibonacci : ");
		return fibonacciServices.getListCalculoFibonacci();
		
	}
	
	/*http://localhost:1919/fibonacci/count
	 * */
	@GetMapping(path ="/count")
	public Integer countListCalcularFibonacci(){
		LOG.info("countListCalcularFibonacci : ");
		return fibonacciServices.getListCalculoFibonacci().size();
		
	}
	
	/*http://localhost:1919/fibonacci/countArchivos
	 * */
	@GetMapping(path ="/countArchivos")
	public Integer countListCalcularFibonacciArchivo(){
		LOG.info("countListCalcularFibonacciArchivo : ");
		return fibonacciServices.countListCalcularFibonacciArchivo();
		
	}
	
	
	/*http://localhost:1919/fibonacci/delete?id=1
	 * */
	
	@GetMapping(path ="/delete")
	public boolean  deleteCalcularFibonacciModelId(@RequestParam("id") Long id){
		LOG.info("deleteCalcularFibonacciModelId id : " +id);
		return fibonacciServices.eliminarCalculoFibonacci(id);
		
	}
	
	
	/*http://localhost:1919/fibonacci/deleteArhivo?id=10
	 * */
	@GetMapping(path ="/deleteArhivo")
	public boolean  deleteCalcularFibonacciModelIdArchivo(@RequestParam("id") Long id){
		LOG.info("deleteCalcularFibonacciModelIdArchivo : id "+ id);
		return fibonacciServices.eliminarCalculoFibonacciArhivo(id);
		
	}
	
}
