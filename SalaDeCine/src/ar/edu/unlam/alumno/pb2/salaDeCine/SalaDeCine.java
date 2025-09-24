package ar.edu.unlam.alumno.pb2.salaDeCine;

public class SalaDeCine {

	private int cantFilas;
	private int cantColumnas;
	private Pelicula peliculaEnCartelera;
	private Butaca[][] butaca;
	private int butacasDisponibles, butacasOcupadas;
	private int fila, columna;
	private String nombreSala;

	/***
	 * El constructor SalaDeCine genera las butacas según el número de filas y
	 * columnas y coloca ese valor en la cantidad de butacas disponibles, las que
	 * irán siendo descontadas según se vendan entradas y se vayan ocupando
	 * 
	 * @param int      cantFilas
	 * @param int      cantColumnas
	 * @param Pelicula peliculaEnCartelera
	 * @param double   horarioPelicula
	 */
	public SalaDeCine(int cantFilas, int cantColumnas, Pelicula peliculaEnCartelera, String nombreSala) {
		this.cantFilas = cantFilas;
		this.cantColumnas = cantColumnas;
		this.peliculaEnCartelera = peliculaEnCartelera;
		this.nombreSala = nombreSala;
		this.butaca = new Butaca[cantFilas][cantColumnas];
		this.butacasDisponibles = getCapacidadSala();
		for (int i = 0; i < this.cantFilas; i++) {
			for (int j = 0; j < this.cantColumnas; j++) {
				this.butaca[i][j] = new Butaca();
			}
		}
	}

	/***
	 * Valida que el género de la película sea válido
	 * 
	 * @param pelicula
	 * @return
	 */

	public boolean validarGeneroPelicula(Pelicula pelicula) {
		if (pelicula.getGenero().equals("género inválido")) {
			return false;
		} else {
			this.peliculaEnCartelera = pelicula;
			return true;
		}
	}

	/***
	 * genera la venta de una entrada, se puede seleccionar un asiento a voluntad,
	 * pero si está ocupado asigna el primero que esté vacío
	 * 
	 * @param cliente
	 */

	public void venderEntrada(Espectador cliente) {
		if (peliculaEnCartelera.validarEdadMinima(cliente)) {
			if (butaca[this.fila][this.columna].getButacaDisponible()) {
				butaca[this.fila][this.columna].setEspectador(cliente);
				butaca[this.fila][this.columna].estaVendida();
				butacasDisponibles--;
				butacasOcupadas++;
				return;
			} else {
				for (int i = 0; i < this.cantFilas; i++) {
					for (int j = 0; j < this.cantColumnas; j++) {
						if (this.butaca[i][j].getButacaDisponible()) {
							butaca[this.fila][this.columna].setEspectador(cliente);
							butaca[i][j].estaVendida();
							butacasDisponibles--;
							butacasOcupadas++;
							return;
						}
					}
				}
			}
		}
	}

	public String getNombreSala() {
		return this.nombreSala;
	}

	public void setFilaAsiento(int fila) {
		this.fila = fila;
	}

	public void setColumnaAsiento(int columna) {
		this.columna = columna;
	}

	public int getCapacidadSala() {
		return this.cantFilas * cantColumnas;
	}

	public int getCantFilas() {
		return cantFilas;
	}

	public int getCantColumnas() {
		return cantColumnas;
	}

	public Pelicula getPeliculaEnCartelera() {
		return peliculaEnCartelera;
	}

	public Butaca[][] getButaca() {
		return this.butaca;
	}

	public int getCantButacasDisponibles() {
		return butacasDisponibles;
	}

	public int getCantButacasOcupadas() {
		return butacasOcupadas;
	}

}
