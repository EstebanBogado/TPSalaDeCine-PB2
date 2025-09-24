package ar.edu.unlam.alumno.pb2.salaDeCine;

public class Pelicula {

	private String titulo;
	private String genero;
	private int duracion;
	private int edadMinima;
	private String sinopsis = null;

	/***
	 * El constructor valida que se cargue un género de película y que este sea
	 * válido
	 * 
	 * @param titulo
	 * @param genero
	 * @param duracion
	 * @param edadMinima
	 */
	public Pelicula(String titulo, String genero, int duracion, int edadMinima) {
		this.titulo = titulo;
		this.duracion = duracion;
		this.edadMinima = edadMinima;
		
		switch (genero.toLowerCase()) {
		case "terror":
			this.genero = "terror";
			break;
		case "comedia":
			this.genero = "comedia";
			break;
		case "acción":
			this.genero = "acción";
			break;
		case "romantica":
			this.genero = "romántica";
			break;
		case "infantil":
			this.genero = "infantil";
			break;
		case "":
			System.out.println("NO PUEDE CARGARSE UNA PELÍCULA SIN ACLARAR SU GÉNERO");
			break;
		default:
			this.genero = "género inválido";
		}
	}
	
	public void setSinopsis(String sinopsis) {
		
		this.sinopsis = sinopsis;
		
	}
	
	public String getSinopsis() {
		return this.sinopsis;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public String getGenero() {
		return this.genero;
	}

	public int getDuracion() {
		return this.duracion;
	}

	public int getEdadMinima() {
		return this.edadMinima;
	}

	/***
	 * Compara que la edad del espectador sea igual o mayor a la edad mínima
	 * 
	 * @param edad
	 * @return ture o false
	 */

	public boolean validarEdadMinima(Espectador espectador) {
		if (espectador.getEdadCliente() >= this.edadMinima) {
			return true;
		}
		System.out.println(espectador.getNombreCliente() + " " + espectador.getApellidoCliente() + " " + "NO ALCANZA LA EDAD MÍNIMA");
		return false;
	}

}
