package ar.edu.unlam.alumno.pb2.salaDeCineTest;

import static org.junit.Assert.*;

import java.time.LocalTime;

import org.junit.Test;

import ar.edu.unlam.alumno.pb2.salaDeCine.Pelicula;
import ar.edu.unlam.alumno.pb2.salaDeCine.ProgPpal;
import ar.edu.unlam.alumno.pb2.salaDeCine.SalaDeCine;

public class TestProgramaPrincipal {

	Pelicula peliculaSala1 = new Pelicula("Rambo", "Accion", 102, 14);
	Pelicula peliculaSala2 = new Pelicula("La Máscara", "comedia", 97, 13);
	SalaDeCine sala1 = new SalaDeCine(3, 5, peliculaSala1);
	SalaDeCine sala2 = new SalaDeCine(5, 6, peliculaSala2);
	int horaFuncion = 14;
	int minutosFuncion = 30;
	int horaPrimeraFuncion = 14;
	int minutoPrimeraFuncion = 30;
	int horaUltimaFuncion = 21;
	int minutoUltimaFuncion = 30;
	int cantFunciones = 4, cantSalas = 2;

	@Test
	public void crearUnCineConDosSalas() {
		ProgPpal[] salas = new ProgPpal[cantSalas];

		salas[0] = new ProgPpal(sala1, cantFunciones, LocalTime.of(horaFuncion, minutosFuncion),
				LocalTime.of(horaPrimeraFuncion, minutoPrimeraFuncion),
				LocalTime.of(horaUltimaFuncion, minutoUltimaFuncion));
		salas[1] = new ProgPpal(sala2, 5, LocalTime.of(15, 00), LocalTime.of(15, 00), LocalTime.of(22, 00));

		assertEquals("Rambo", salas[0].getPelicula().getTitulo());
		assertEquals("La Máscara", salas[1].getPelicula().getTitulo());

	}

	@Test
	public void crarUnProgramaPrincipalConSalaYCartelera() {

		ProgPpal programacion = new ProgPpal(sala1, cantFunciones, LocalTime.of(horaFuncion, minutosFuncion),
				LocalTime.of(horaPrimeraFuncion, minutoPrimeraFuncion),
				LocalTime.of(horaUltimaFuncion, minutoUltimaFuncion));

		assertNotNull(programacion);
		assertEquals("Rambo", peliculaSala1.getTitulo());
		assertEquals(peliculaSala1, sala1.getPeliculaEnCartelera());
	}

}
