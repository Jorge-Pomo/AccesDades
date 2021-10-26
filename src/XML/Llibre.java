package XML;

public class Llibre {

	// Atributs
	private int identificador;
	private String titol;
	private String autor;
	private int anyPubli;
	private String editorial;
	private int numPagines;
	
	// Constructors
	public Llibre() {
	}

	public Llibre(int identificador, String titol, String autor, int anyPubli, String editorial, int numPagines) {
		this.identificador = identificador;
		this.titol = titol;
		this.autor = autor;
		this.anyPubli = anyPubli;
		this.editorial = editorial;
		this.numPagines = numPagines;
	}

	// Getters && Setters
	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

	public String getTitol() {
		return titol;
	}

	public void setTitol(String titol) {
		this.titol = titol;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getAnyPubli() {
		return anyPubli;
	}

	public void setAnyPubli(int anyPubli) {
		this.anyPubli = anyPubli;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public int getNumPagines() {
		return numPagines;
	}

	public void setNumPagines(int numPagines) {
		this.numPagines = numPagines;
	}
	
	@Override
	// Metodos
	public String toString() {
		return "Llibre [identificador = " + identificador + ", titol = " + titol + ", autor = " + autor + ", anyPubli = "
				+ anyPubli + ", editorial = " + editorial + ", numPagines = " + numPagines + "]";
	}

}