package es.SYP.AE2;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class ProbabilidadNEO {
	/**
	 * Metodo para calcular la probabilidad de colisión del Neo.
	 * @param posicionNEO
	 * @param velocidadNEO
	 * @return
	 */
	public static String calcular(double posicionNEO, double velocidadNEO) {
		
		double posicionTierra = 1;
		double velocidadTierra = 100;
		for (int i = 0; i < (50 * 365 * 24 * 60 * 60); i++) {
		posicionNEO = posicionNEO + velocidadNEO * i;
		posicionTierra = posicionTierra + velocidadTierra * i;
		}
		
		double resultado = 100 * Math.random() * Math.pow( ((posicionNEO-posicionTierra)/(posicionNEO+posicionTierra)), 2);

		return String.format("%.02f", resultado);
	}
/**
 * Con los datos de cada Neo obtenemos el resultado y segun este resultado realizamos el tipo de mensaje que conviene.
 * @param args
 */
	public static void main(String[] args) {
			
		String nombreNEO = args[0];
		double posicionNEO = Double.valueOf(args[1]);
		double velocidadNEO = Double.valueOf(args[2]);
		
		String resultado="";
		try {
			resultado = calcular(posicionNEO, velocidadNEO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("La probabilidad de colisión del Neo " + nombreNEO + " es del " + resultado + " %");
		
		String x = resultado.replaceAll(",", ".");
		double probabilidad = Double.parseDouble(x);
		
		if(probabilidad > 10){
			System.err.println("!!!!!!!!!ALERTA MUNDIAL!!!!!!!! un Neo tiene la probabilidad de " + resultado + " % de estrellarse contra la tierra.");
		}else {
			System.out.println("MANTENGAN LA CALMA, la probabilidad de colisión es solo de " + resultado + " %.");
		}	
	}

}
