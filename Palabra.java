package principal;

public class Palabra {
	private String valor;
	private char letrasDisponibles[];
	private boolean posicionesOcupadas[];
	public Palabra() {
		
	}

	public Palabra(String valor, char[] letrasDisponibles, boolean[] posicionesOcupadas) {
		this.valor = valor;
		this.letrasDisponibles = letrasDisponibles;
		this.posicionesOcupadas = posicionesOcupadas;
	}
	
	
	
	
}
