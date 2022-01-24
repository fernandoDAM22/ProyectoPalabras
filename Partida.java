package principal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

public class Partida {
	private LocalDate fecha;
	private String nombreJugador;
	private int intentos=3;
	private Palabra palabras[];
	private int numeroPalabra;
	private int intentosLetras;
	public Partida() {
		
	}

	public Partida(LocalDate fecha, String nombreJugador, int intentos, Palabra[] palabras) {
		this.fecha = fecha;
		this.nombreJugador = nombreJugador;
		this.intentos = intentos;
		this.palabras = palabras;
	}
	public void menu() throws NumberFormatException, IOException {
		int operacion;
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader (isr);
		System.out.println("Que operacion quieres realizar");
		System.out.println("Introducir una letra");
		System.out.println("Resolver Palabra");
		operacion = Integer.parseInt(br.readLine());
		switch (operacion){
		case 1:
			break;
		case 2:
			break;
		}
	}
	public void seleccionarPalabra() {
		numeroPalabra = (int) Math.floor(Math.random() * 3);
		
	}
	public void palabraElegida() {
		Palabra palabraElegida = palabras[numeroPalabra];
	}
	public void MostrarPalabra() {
		String palabra = palabras[numeroPalabra].getValor();
		boolean posiciones[] = palabras[numeroPalabra].getPosicionesOcupadas();
		for (int i = 0; i < palabras[numeroPalabra].getValor().length(); i++) {
			if(posiciones[i] == true)
				System.out.print(palabra.charAt(i));
			else
				System.out.print("-");
		}
	}
	public void NumeroIntentos() {
		boolean limite[] = palabras[numeroPalabra].getPosicionesOcupadas();
		String palabra = palabras[numeroPalabra].getValor();
		intentosLetras = palabra.length() - 1;
		for(int i = 0; i< limite.length;i++) {
			if(limite[i] == true) {
				intentosLetras--;
			}
		}
		
	}
	public void pedirLetra() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader (isr);
		String letra;
		char letraComparar;
		char letras[] = palabras[numeroPalabra].getLetrasDisponibles();
		int posicion;
		boolean posiciones[] = palabras[numeroPalabra].getPosicionesOcupadas();
		System.out.println("Introduce una letra");
		letra = br.readLine();
		System.out.println("Introduce la posicion en la que introducir la letra");
		posicion = Integer.parseInt(br.readLine());
		if(intentos > 0){
			if(posiciones[posicion] == false) {
				letraComparar = letra.charAt(1);
				if(letras[posicion] == letraComparar) {
					System.out.println("has acertado la letra");
					letras[posicion] = letraComparar;
				}
				else {
					System.out.println("La letra no coincide con la original");
				}
			}
			else {
				System.out.println("La posicion elegida ya esta ocupada");
			}
		}
		
		intentos--;
		palabras[numeroPalabra].setLetrasDisponibles(letras);
	}
	
	
	
}
