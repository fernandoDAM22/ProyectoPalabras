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
		boolean fin = false;//para saber cuando se termina el programa
		String valor1 = "traza"; //palabra 1
		String valor2 = "codigo"; //palabra 2
		String valor3 = "depurar";//palabra 3
		Palabra palabras[] = new Palabra[3]; //array de la clase palabras
		//aqui se crean los arrays de caracteres para cada una de las palabras
		char letrasDisponibles1[] = valor1.toCharArray(); //este metodo convierte String a array
		char letrasDisponibles2[] = valor2.toCharArray();
		char letrasDisponibles3[] = valor3.toCharArray();
		//aqui se crean los arrays de booleanos para saber que posiciones estan ocupadas
		boolean posicionesOcupadas1[] = new boolean[valor1.length()]; //con la longitud de la palabra
		boolean posicionesOcupadas2[] = new boolean[valor2.length()];
		boolean posicionesOcupadas3[] = new boolean[valor3.length()];
		//se declaran las letras que se van a mostrar inicalmente
		posicionesOcupadas1[0] = true;
		posicionesOcupadas1[3] = true;
		posicionesOcupadas2[1] = true;
		posicionesOcupadas2[4] = true;
		posicionesOcupadas2[5] = true;
		posicionesOcupadas3[2] = true;
		posicionesOcupadas3[4] = true;
		posicionesOcupadas3[6] = true;
		//se crean los objetos de la clase palabras
		Palabra p1 = new Palabra("Traza",letrasDisponibles1,posicionesOcupadas1);
		Palabra p2 = new Palabra("codigo",letrasDisponibles2,posicionesOcupadas2);
		Palabra p3 = new Palabra("Depurar",letrasDisponibles3,posicionesOcupadas3);
		//se introducen las palabras en el array de la clase palabras
		palabras[0] = p1;
		palabras[1] = p2;
		palabras[2] = p3;
		LocalDate fecha; //se declara una variable 
		fecha = LocalDate.now(); //se introduce la fecha actual con el metodo now
		String nombreJugador; //variable para guardar el nombre del jugador
		System.out.println("Introduce tu nombre de usuario");
		nombreJugador = br.readLine();
		//-------------------------------------------------------------//
		Partida partida = new Partida(fecha,nombreJugador,3,palabras);
			partida.seleccionarPalabra();//se selecciona la palabra
			partida.MostrarPalabra(); //se muestra el estado de la palabra con sus letras ya colocadas
			do {
				partida.menu();//se llama al menu
				if(partida.fin()==true) { // si fin de partida devuelve true has ganado
					System.out.println("Fin del programa, has ganado");
					fin=true;
				}
				if(partida.getIntentos()==0) { //si te quedas sin intentos para resolver has perdido
					fin=true;
					System.out.println("Fin del programa, has perdido porque no te quedan intentos");
				}
					
				
			}while(!fin);
	}
	
}
