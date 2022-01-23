package principal;

import java.time.LocalDate;

public class Partida {
	private LocalDate fecha;
	private String nombreJugador;
	private int intentos=3;
	private Palabra palabras[];
	
	public Partida() {
		
	}

	public Partida(LocalDate fecha, String nombreJugador, int intentos, Palabra[] palabras) {
		this.fecha = fecha;
		this.nombreJugador = nombreJugador;
		this.intentos = intentos;
		this.palabras = palabras;
	}
	
	
	
	
}
