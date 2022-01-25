package principal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

public class Partida {
	private LocalDate fecha;
	private String nombreJugador;
	private int intentos = 3;// intentos para resolver la palabra
	private Palabra palabras[];// array de la clase palabras
	private int numeroPalabra;// numero para seleccionar una palabra al inicio del programa
	// se guarda en metodo para poder acceder a ella desde todos los metodos
	private int intentosLetras = 10;// intentos para pedir resolver
	private boolean juegoTerminado;// variable para saber cuando se ha terminado el juego
	
	//constructor sin parametros
	public Partida() {

	}
	
	//constructor con parametros
	public Partida(LocalDate fecha, String nombreJugador, int intentos, Palabra[] palabras) {
		this.fecha = fecha;
		this.nombreJugador = nombreJugador;
		this.intentos = intentos;
		this.palabras = palabras;
	}
	//metodo que nos muestra el menu por pantalla
	public void menu() throws NumberFormatException, IOException {
		int operacion = 0; //Variabla que guarda la operacion a realizar
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		mostrarIntentos(); // metodo que muestra los intentos que quedan
		System.out.println("Que operacion quieres realizar");
		System.out.println("1---Introducir una letra");
		System.out.println("2---Resolver Palabra");
		try {
			operacion = Integer.parseInt(br.readLine());//Aqui se guarda la operacion a realizar
		} catch (NumberFormatException nfe) {
			System.out.println("Error, el numero introducido no es valido " + nfe);
		}

		switch (operacion) { //Menu de opciones
		case 1:
			try {
				pedirLetra(); //Metodo para pedir una letra
			} catch (NumberFormatException nfe) {
				System.out.println("Error, el caracter introducido no es valido " + nfe);
			} catch (ArrayIndexOutOfBoundsException aioe) {
				System.out.println("Se esta intentando acceder a una posicion incorrecta " + aioe);
			}

			break;
		case 2:
			try {
				resolver(); //Metodo para resolver la palabra.
			} catch (NumberFormatException nfe) {
				System.out.println("Error, el caracter introducido no es valido " + nfe);
			}

			break;
		default:
			System.out.println("La opcion elegida no es correcta");
		}
		MostrarPalabra(); //Se muestra el estado de la palabra.
	}

	public void mostrarIntentos() { //metodo para mostrar intentos, utilizado en el Menu
		if (intentosLetras < 0)
			System.out.println("Te quedan 0 intentos para pedir letra");
		else
			System.out.println("Te quedan: " + intentosLetras + " intentos para pedir letra");
		if (intentos < 0)
			System.out.println("Te quedan 0 intentos para resolever");
		else
			System.out.println("Te quedan: " + intentos + " intentos para resolver");
	}

	public void seleccionarPalabra() { //Metodo para elegir una palabra aleatoria del array de Palabras
		//La palabra, se guarda en el atributo para poder usarlo en todos los metodos
		numeroPalabra = (int) Math.floor(Math.random() * 3); 

		
	}


	public void MostrarPalabra() { //Metodo que muestra la palabra
		String palabra = palabras[numeroPalabra].getValor(); //se hace una copia del valor de la palabra mediante el metodo get
		boolean posiciones[] = palabras[numeroPalabra].getPosicionesOcupadas();//se hace una copia de el array de booleanos
		for (int i = 0; i < palabras[numeroPalabra].getValor().length(); i++) {
			if (posiciones[i] == true) //si la posicion del array es true se muestra la palabra
				System.out.print(palabra.charAt(i));
			else//si la posicion vale negativo se muestra un guion
				System.out.print("-");
		}
		System.out.println();//para introducir un salto de linea
	}

	public int limiteLetras() { //Para saber cuando no puedes meter mas letras
		boolean limite[] = palabras[numeroPalabra].getPosicionesOcupadas(); //se hace una copia del array del array de booleanos
		int contador = 0;//contador para saber cuando no se pueden pedir mas palabras
		String palabra = palabras[numeroPalabra].getValor();//se hace una copia del valor de la palabra
		for (int i = 0; i < limite.length; i++) {
			if (limite[i] == false) {//si la posicion es falso significa que el hueco esta vacio
				contador++;//y se incrementa el contador
			}
		}
		return contador; 

	}

	public void pedirLetra() throws IOException { //Metodo para poder pedir una letra e introducir una palabra
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String letra;
		char letraComparar;
		char letras[] = palabras[numeroPalabra].getLetrasDisponibles();//se hace una copia del valor de la letra
		int posicion;//variable para saber en que posicion escribir la letra
		boolean posiciones[] = palabras[numeroPalabra].getPosicionesOcupadas();//se hace una copia del array de booleanos
		System.out.println("Introduce una letra");
		if (intentosLetras <= 0) {//si no te quedan intentos no puedes introducir letra
			System.out.println("Sin intentos");
			intentosLetras = 0;//se ponen los intentos a 0 para que no muestre un numero negativo
		} else {
			if (limiteLetras() > 1) {//si que queda mas de un hueco se puede escribir letra
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

	//Metodo para poder resolver la palabra
	public boolean resolver() throws IOException { 
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String palabra = palabras[numeroPalabra].getValor();//se hace una copia del valor de la palabra
		System.out.println("Introduce la palabra");
		String palabraIntroducida = br.readLine();
		intentos--;//se resta un intento
		if (intentos >= 0) {//solo se puede resolver si te quedan intentos
			//si el metodo devuelve 0 siginfica que la palabra introducida es igual a la original
			if (palabra.compareToIgnoreCase(palabraIntroducida) == 0) {
				System.out.println("Correcto");
				juegoTerminado = true;//se indica que se ha terminado el juego porque se ha acertado la palabra
				return true;
			} else {
				System.out.println("La palabra no es correcta");
			}
		} else {
			System.out.println("No te quedan intentos");
		}

		return false;
	}
	//Metodo para saber cuando se termina el juego y poder enviarlo a la clase main
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
