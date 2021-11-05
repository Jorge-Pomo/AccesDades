package Biblioteca;

public class Llibre {

	// Atributs
	private String titol;
	private String autor;
	private String anyNaiximent;
	private String anyPublicacio;
	private String editorial;
	private String nombrePagines;
	
	// Constructors
	public Llibre() {
		
	}
	
	// Constructor parametritzat
	public Llibre(String titol, String autor, String anynaiximent, String anyPublicacio, String editorial, String nombrePagines) {
		this.titol = titol;
		this.autor = autor;
		this.anyNaiximent = anyNaiximent;
		this.anyPublicacio = anyPublicacio;
		this.editorial = editorial;
		this.nombrePagines = nombrePagines;
	}

	// Getters && Setters
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

	public String getAnyNaiximent() {
		return anyNaiximent;
	}

	public void setAnyNaiximent(String anyNaiximent) {
		this.anyNaiximent = anyNaiximent;
	}

	public String getAnyPublicacio() {
		return anyPublicacio;
	}

	public void setAnyPublicacio(String anyPublicacio) {
		this.anyPublicacio = anyPublicacio;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getNombrePagines() {
		return nombrePagines;
	}

	public void setNombrePagines(String nombrePagines) {
		this.nombrePagines = nombrePagines;
	}
	
}
