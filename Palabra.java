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
	
	public void letrasIniales(String palabra) {
		int numeroLetras= palabra.length();
		int letrasMostradas=numeroLetras/2;
		for (int i = 0; i < letrasMostradas;i++) {
			
		}
	}

	
	

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public char[] getLetrasDisponibles() {
		return letrasDisponibles;
	}

	public void setLetrasDisponibles(char[] letrasDisponibles) {
		this.letrasDisponibles = letrasDisponibles;
	}

	public boolean[] getPosicionesOcupadas() {
		return posicionesOcupadas;
	}

	public void setPosicionesOcupadas(boolean[] posicionesOcupadas) {
		this.posicionesOcupadas = posicionesOcupadas;
	}
	
	
	
	
}