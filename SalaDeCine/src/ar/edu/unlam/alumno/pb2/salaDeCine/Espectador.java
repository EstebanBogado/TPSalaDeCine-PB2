package ar.edu.unlam.alumno.pb2.salaDeCine;

public class Espectador {
	private String nombreCliente;
	private String apellidoCliente;
	private int edadCliente;

	/***
	 * 
	 * @param nombreCliente
	 * @param apellidoCliente
	 * @param edadCliente
	 */
	public Espectador(String nombreCliente, String apellidoCliente, int edadCliente) {
		this.nombreCliente = nombreCliente;
		this.apellidoCliente = apellidoCliente;
		this.edadCliente = edadCliente;
	}

	public String getNombreCliente() {
		return this.nombreCliente;
	}

	public String getApellidoCliente() {
		return this.apellidoCliente;
	}

	public int getEdadCliente() {
		return this.edadCliente;
	}

}
