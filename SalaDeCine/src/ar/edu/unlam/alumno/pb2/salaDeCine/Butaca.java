package ar.edu.unlam.alumno.pb2.salaDeCine;

public class Butaca {
	private Boolean disponible;
	private Espectador espectador;

	/***
	 * El contructor por defecto crea una butaca disponible, la que será ocupada
	 * oportunamente y liberada nuevamente si así correspondiera
	 * 
	 * @param fila
	 * @param columna
	 * @param nombreOcupante
	 */
	public Butaca() {
		this.disponible = true;

	}

	public void estaVendida() {
		if (this.espectador != null && this.disponible == true) {
			this.disponible = false;
		}
	}

	/***
	 * inhabilita la butaca para que no pueda usarse
	 */
	public void butacaAnulada() {
		this.disponible = false;
	}

	public void setEspectador(Espectador espectador) {
		this.espectador = espectador;
	}

	public Espectador getEspectador() {
		return this.espectador;
	}

	public void liberarButaca() {

		this.disponible = true;

	}

	public boolean getButacaDisponible() {
		return this.disponible;
	}

	public void getButacaOcupada() {
		this.disponible = false;

	}


	@Override
	public String toString() {
		if (espectador == null) {
			this.disponible = true;
			return "Butaca disponible= " + this.disponible;
		} else
			return "Butaca disponible= " + this.disponible + ", espectador= " + espectador.getNombreCliente();
	}

}
