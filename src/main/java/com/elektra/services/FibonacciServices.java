package com.elektra.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elektra.helper.FibonacciHelper;
import com.elektra.models.FibonacciModel;
import com.elektra.repositories.FibonacciRepository;

/*
● Desarrollar un servicio REST que calcule la serie de fibonacci
● Recibir como parámetro el límite el cuál no podrá pasar el cálculo de dicha serie
● Se debe guardar en un archivo cada petición válida recibida por el servicio
● Se deben poder consultar los número enviados en peticiones anteriores
● Se debe poder eliminar un registro de número enviados
● Generar los contratos de interfaz en swagger
 * */

@Service
public class FibonacciServices {
	
@Autowired
FibonacciRepository fibonacciRepository;

FibonacciHelper fibonacciHelper = new FibonacciHelper();;

private static Logger LOG = LoggerFactory.getLogger(FibonacciRepository.class);


	/**  Desarrollar un servicio REST que calcule la serie de fibonacci
	 * @return
	 */	
	public FibonacciModel calculoFibonacci(int totalRegistros){
		
		 FibonacciModel fibonacci =  fibonacciHelper.calculoFibonacciParameter(totalRegistros);
		 fibonacci.setFecha(new Date());
		 fibonacci = fibonacciRepository.save(fibonacci);
		
		 fibonacciHelper.archivoFibonacciCreacion(fibonacci);
		 
		return fibonacci;
	}
	
	/*Recibir como parámetro el límite el cuál no podrá pasar el cálculo de dicha serie
	 * */
	public FibonacciModel calculoFibonacciMax(int limiteNumerico){
		
		 FibonacciModel fibonacci =  fibonacciHelper.calculoFibonacciParameterMax(limiteNumerico);
		 fibonacci.setFecha(new Date());
		 fibonacci = fibonacciRepository.save(fibonacci);
		 
		 fibonacciHelper.archivoFibonacciCreacion(fibonacci);
		 
	   return fibonacci;
	}
	
	/*Se deben poder consultar los número enviados en peticiones anteriores
	 * */
	public ArrayList<FibonacciModel> getListCalculoFibonacci(){
		return (ArrayList<FibonacciModel>)fibonacciRepository.findAll();
	}
	
	
	public Optional<FibonacciModel> getCalculoFibonacciId(Long id){
		return fibonacciRepository.findById(id);
	}
	
	
	public boolean eliminarCalculoFibonacci(Long id){
		try {
			fibonacciRepository.deleteById(id);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	public boolean eliminarCalculoFibonacciArhivo(Long id) {
		return fibonacciHelper.archivoFibonacciEliminar(id);
	}

	public Integer countListCalcularFibonacciArchivo() {
		return fibonacciHelper.archivoFibonacciContarArchivos();
	}

}
