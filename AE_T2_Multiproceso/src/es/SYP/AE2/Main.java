package es.SYP.AE2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main {
	
	static final int procesadores = Runtime.getRuntime().availableProcessors();

/**
 * En el main leemos el fichero y obtenemos los datos de cada Neo.
 * @param args
 */
	public static void main(String[] args) {
		
		long tiempoInicio = System.nanoTime();    
		System.out.println("Tienes " + procesadores + " procesadores a tu servicio.");
		
		File fLectura = new File("NEOs.txt");
		int contador = 1 ;
		try {
			FileReader fr = new FileReader(fLectura);
			BufferedReader br = new BufferedReader(fr);
			String linea;
			while ((linea = br.readLine()) != null) {
				
				for(int i=1 ; i <= 1; i++) {
					
					String[] Neo = linea.split(",");
					String nombreNEO = Neo[0];
					Double posicionNEO = Double.valueOf(Neo[1]);
					Double velocidadNEO = Double.valueOf(Neo[2]);
					System.out.println("El Neo " + Neo[0] + " tiene una posición relativa a la tierra de " + Neo[1] + " y una velocidad de " + Neo[2]);

					String clase = "es.SYP.AE2.ProbabilidadNEO";
					String javaHome = System.getProperty("java.home");
					String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
					String classpath = System.getProperty("java.class.path");
					String className = clase;
					
					List<String> command = new ArrayList<>();
					command.add(javaBin);
					command.add("-cp");
					command.add(classpath);
					command.add(className);
					command.add(nombreNEO);
					command.add(String.valueOf(posicionNEO));
					command.add(String.valueOf(velocidadNEO));
					
					ProcessBuilder builder = new ProcessBuilder(command);
					try {
						builder.inheritIO().start();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				contador++;
				Thread.sleep(10000);
			}
			br.close();
			fr.close();
			
		}catch (Exception e) {
			JOptionPane.showMessageDialog(new JFrame(),e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		long tiempoFin = System.nanoTime();
		long duracion = (tiempoFin - tiempoInicio)/1000000; //milisegundos
		System.out.println("El tiempo de ejecución es de " + duracion + " ms.");	
	}
	

}
