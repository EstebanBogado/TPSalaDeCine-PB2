package ar.edu.unlam.alumno.pb2.salaDeCine;

public class Accion {
	private String titulo;
	private Integer duracion;
	private Integer edadMinima;

	public Accion(String titulo, Integer duracion, Integer edadMinima) {
		this.titulo = titulo;
		this.duracion = duracion;
		this.edadMinima = edadMinima;
	}

	public String getTitulo() {
		return titulo;
	}

	public Integer getDuracion() {
		return duracion;
	}

	public Integer getEdadMinima() {
		return edadMinima;
	}
}
