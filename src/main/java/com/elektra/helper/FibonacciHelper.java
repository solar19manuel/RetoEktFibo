package com.elektra.helper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.elektra.models.FibonacciModel;

public class FibonacciHelper {
	
	private static Logger LOG = LoggerFactory.getLogger(FibonacciHelper.class);

	
	public final static String ARREGLO_COMA = ", ";
	public final static String FILE_LOCAL_STATIC  = "src/main/resources/static/fibooArchivos/";
	
	public String clearArreglo(String resultado) {
		
		if(resultado.endsWith(ARREGLO_COMA))
			resultado = resultado.substring(0, resultado.length()-2);
		return resultado;
	}

	public boolean archivoFibonacciCreacion(FibonacciModel fibonacciModel) {
		
		String nameFile = FILE_LOCAL_STATIC + fibonacciModel.getId() + ".txt";
		
	    try {
	    	
	    File file = new File(nameFile);
		
	        if (!file.exists()) {
	            file.createNewFile();
	        }
        
        FileWriter     fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);      
        
		bw.write(fibonacciModel.getResultado());
        bw.close();
    	return true;
        
	    } catch (Exception e) {
	         e.printStackTrace();
	    return false;
	    }
	    
	}
	
	public boolean archivoFibonacciEliminar(Long id) {
		String nameFile = FILE_LOCAL_STATIC + id + ".txt";

	    try {
	    	
	    File file = new File(nameFile);
		
	        if (file.exists()) {
	            file.delete();
	        }        
       
    	return true;
        
	    } catch (Exception e) {
	         e.printStackTrace();
	    return false;
	    }
		
	}
	
	
	public Integer archivoFibonacciContarArchivos() {
		String nameFile = FILE_LOCAL_STATIC;

	    try {
	    	
	    File file = new File(nameFile);
	    	return file.list().length;  
	    }catch (Exception e) {
	    	return 0;
		}
		
	}

	public FibonacciModel  calculoFibonacciParameter(int fin){
		
		long num1 = 0, num2 = 1, suma = 1;
		
		LOG.info("Fin de : " + fin);
		
		FibonacciModel fibonacciModel = new FibonacciModel();
		
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(num1 +ARREGLO_COMA);
		
		for (int i = 1; i < fin; i++) {			
			
			stringBuffer.append(suma + ", ");
            
            suma = num1 + num2;
            num1 = num2;
            num2 = suma;
		}
		
		fibonacciModel.setParametrosInicio(1);
		fibonacciModel.setParametrosFinal(fin);
	    fibonacciModel.setResultado(clearArreglo(stringBuffer.toString()));
		
		LOG.info("FibonacciModel : " + fibonacciModel);
		
		return fibonacciModel;
		
	}
	
	public FibonacciModel  calculoFibonacciParameter(int fin,int limite){
		
		long num1 = 0, num2 = 1, suma = 1;
		
		LOG.info("Fin de : " + fin);
		
		FibonacciModel fibonacciModel = new FibonacciModel();
		
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(num1 +  FibonacciHelper.ARREGLO_COMA);
		
		for (int i = 1; i < fin; i++) {			
			
			if(suma >=limite)
				break;
			stringBuffer.append(suma +  FibonacciHelper.ARREGLO_COMA);
            
            suma = num1 + num2;
            num1 = num2;
            num2 = suma;
		}
		
		fibonacciModel.setParametrosInicio(1);
		fibonacciModel.setParametrosFinal(fin);
		fibonacciModel.setResultado(clearArreglo(stringBuffer.toString()));
		
		LOG.info("FibonacciModel : " + fibonacciModel);
		
		
		return fibonacciModel;
		
	}
	
	public FibonacciModel  calculoFibonacciParameterMax(int max){
		
		long num1 = 0, num2 = 1, suma = 1;
		Integer fin=0;
		
		
		FibonacciModel fibonacciModel = new FibonacciModel();
		
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(num1 +  FibonacciHelper.ARREGLO_COMA);
		
		do {
			
			stringBuffer.append(suma +  FibonacciHelper.ARREGLO_COMA);
            
            suma = num1 + num2;
            num1 = num2;
            num2 = suma;
            fin++;
            
		}while(max>=suma);
		
		fibonacciModel.setParametrosInicio(1);
		fibonacciModel.setParametrosFinal(fin);
		fibonacciModel.setResultado(clearArreglo(stringBuffer.toString()));
		
		LOG.info("FibonacciModel : " + fibonacciModel);
		
		
		return fibonacciModel;
		
	}

	

	public static void main(String[] args) {
		FibonacciHelper helper = new FibonacciHelper();
		helper.calculoFibonacciParameterMax(1000);
	}
	
}
