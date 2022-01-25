package principal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader (isr);
		boolean fin = false;
		char letrasDisponibles[];
		String valor1 = "traza";
		String valor2 = "codigo";
		String valor3 = "depurar";
		Palabra palabras[] = new Palabra[3];
		char letrasDisponibles1[] = valor1.toCharArray();
		char letrasDisponibles2[] = valor2.toCharArray();
		char letrasDisponibles3[] = valor3.toCharArray();
		boolean posicionesOcupadas1[] = new boolean[valor1.length()];
		boolean posicionesOcupadas2[] = new boolean[valor2.length()];
		boolean posicionesOcupadas3[] = new boolean[valor3.length()];
		posicionesOcupadas1[0] = true;
		posicionesOcupadas1[3] = true;
		posicionesOcupadas2[1] = true;
		posicionesOcupadas2[4] = true;
		posicionesOcupadas2[5] = true;
		posicionesOcupadas3[2] = true;
		posicionesOcupadas3[4] = true;
		posicionesOcupadas3[6] = true;
		Palabra p1 = new Palabra("Traza",letrasDisponibles1,posicionesOcupadas1);
		Palabra p2 = new Palabra("codigo",letrasDisponibles2,posicionesOcupadas2);
		Palabra p3 = new Palabra("Depurar",letrasDisponibles3,posicionesOcupadas3);
		palabras[0] = p1;
		palabras[1] = p2;
		palabras[2] = p3;
		LocalDate fecha;
		fecha = LocalDate.now();
		String nombreJugador;
		System.out.println("Introduce tu nombre");
		nombreJugador = br.readLine();
		//-------------------------------------------------------------//
		Partida partida = new Partida(fecha,nombreJugador,3,palabras);
			partida.seleccionarPalabra();
			partida.MostrarPalabra();
			do {
				partida.menu();
				if(partida.fin()==true) {
					System.out.println("Fin del programa, has ganado");
					fin=true;
				}
				if(partida.getIntentos()==0) {
					fin=true;
					System.out.println("Fin del programa, has perdido porque no te quedan intentos");
				}
					
				
			}while(!fin);
	}
	
}
