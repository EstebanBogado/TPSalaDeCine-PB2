package ar.edu.unlam.alumno.pb2.salaDeCine;

import java.time.LocalTime;

public class ProgPpal {

	private SalaDeCine sala;
	private Pelicula pelicula;
	private LocalTime horarioFuncion; // LocalTime.of(14, 30);
	private LocalTime horaPrimeraFuncion, horaUltimaFuncion;
	private int cantFunciones;

	public ProgPpal(SalaDeCine sala, int cantFunciones, LocalTime horarioFuncion, LocalTime horaPrimeraFuncion,
			LocalTime horaUltimaFuncion) {
		this.sala = sala;
		this.horarioFuncion = horarioFuncion;
		this.horaPrimeraFuncion = horaPrimeraFuncion;
		this.horaUltimaFuncion = horaUltimaFuncion;
		this.cantFunciones = cantFunciones;
	}

	public Pelicula getPelicula() {
		return sala.getPeliculaEnCartelera();
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	public LocalTime getHoraPrimeraFuncion() {
		return horaPrimeraFuncion;
	}

	public void setHoraPrimeraFuncion(LocalTime horaPrimeraFuncion) {
		this.horaPrimeraFuncion = horaPrimeraFuncion;
	}

	public LocalTime getHoraUltimaFuncion() {
		return horaUltimaFuncion;
	}

	public void setHoraUltimaFuncion(LocalTime horaUltimaFuncion) {
		this.horaUltimaFuncion = horaUltimaFuncion;
	}

	public LocalTime getHorarioFuncion() {
		return horarioFuncion;
	}

	public void setHorarioFuncion(LocalTime horario) {
		this.horarioFuncion = horario;
	}

	public SalaDeCine getSala() {
		return sala;
	}

	public void setSala(SalaDeCine sala) {
		this.sala = sala;
	}

	public int getCantFunciones() {
		return cantFunciones;
	}

	public void setCantFunciones(int cantFunciones) {
		this.cantFunciones = cantFunciones;
	}

}
