package principal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

public class Partida {
	private LocalDate fecha;
	private String nombreJugador;
	private int intentos = 3;
	private Palabra palabras[];
	private int numeroPalabra;
	private int intentosLetras = 10;
	private boolean juegoTerminado;

	public Partida() {

	}

	public Partida(LocalDate fecha, String nombreJugador, int intentos, Palabra[] palabras) {
		this.fecha = fecha;
		this.nombreJugador = nombreJugador;
		this.intentos = intentos;
		this.palabras = palabras;
	}

	public void menu() throws NumberFormatException, IOException {
		int operacion = 0;
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		mostrarIntentos();
		System.out.println("Que operacion quieres realizar");
		System.out.println("1---Introducir una letra");
		System.out.println("2---Resolver Palabra");
		try {
			operacion = Integer.parseInt(br.readLine());
		} catch (NumberFormatException nfe) {
			System.out.println("Error, el numero introducido no es valido " + nfe);
		}

		switch (operacion) {
		case 1:
			try {
				pedirLetra();
			} catch (NumberFormatException nfe) {
				System.out.println("Error, el caracter introducido no es valido " + nfe);
			}

			break;
		case 2:
			try {
				resolver();
			} catch (NumberFormatException nfe) {
				System.out.println("Error, el caracter introducido no es valido " + nfe);
			}

			break;
			default: 
				System.out.println("La opcion elegida no es correcta");
		}
		MostrarPalabra();
	}

	public void mostrarIntentos() {
		if (intentosLetras < 0)
			System.out.println("Te quedan 0 intentos para pedir letra");
		else
			System.out.println("Te quedan: " + intentosLetras + " para pedir letra");
		if (intentos < 0)
			System.out.println("Te quedan 0 intentos para resolever");
		else
			System.out.println("Te quedan " + intentos + " para resolver");
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
			if (posiciones[i] == true)
				System.out.print(palabra.charAt(i));
			else
				System.out.print("-");
		}
		System.out.println();
	}

	public int numeroIntentos() {
		boolean limite[] = palabras[numeroPalabra].getPosicionesOcupadas();
		int contador = 0;
		String palabra = palabras[numeroPalabra].getValor();
		for (int i = 0; i < limite.length; i++) {
			if (limite[i] == false) {
				contador++;
			}
		}
		return contador;

	}

	public void pedirLetra() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String letra;
		char letraComparar;
		char letras[] = palabras[numeroPalabra].getLetrasDisponibles();
		int posicion;
		boolean posiciones[] = palabras[numeroPalabra].getPosicionesOcupadas();
		System.out.println("Introduce una letra");
		if (intentosLetras <= 0) {
			System.out.println("Sin intentos");
			intentosLetras = 0;
		} else {
			if (numeroIntentos() > 1) {
				letra = br.readLine();
				System.out.println("Introduce la posicion en la que introducir la letra");
				posicion = Integer.parseInt(br.readLine());
				if (posiciones[posicion] == false) {
					letraComparar = letra.charAt(0);
					if (letras[posicion] == letraComparar) {
						System.out.println("has acertado la letra");
						letras[posicion] = letraComparar;
						posiciones[posicion] = true;
					} else {
						System.out.println("La letra no coincide con la original");
					}
				} else {
					System.out.println("La posicion elegida ya esta ocupada");
				}
			} else {
				System.out.println("Ya no puedes pedir mas letras");
			}
		}
		intentosLetras--;

		palabras[numeroPalabra].setLetrasDisponibles(letras);
		palabras[numeroPalabra].setPosicionesOcupadas(posiciones);
	}

	public boolean resolver() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String palabra = palabras[numeroPalabra].getValor();
		System.out.println("Introduce la palabra");
		String palabraIntroducida = br.readLine();
		intentos--;
		if (intentos >= 0) {
			if (palabra.compareTo(palabraIntroducida) == 0) {
				System.out.println("Correcto");
				juegoTerminado = true;
				return true;
			}
		} else {
			System.out.println("No te quedan intentos");
		}

		return false;
	}

	public boolean fin() {
		if (juegoTerminado == true) {
			return true;
		}
		return false;
	}

	public int getIntentos() {
		return intentos;
	}

	public void setIntentos(int intentos) {
		this.intentos = intentos;
	}

}
