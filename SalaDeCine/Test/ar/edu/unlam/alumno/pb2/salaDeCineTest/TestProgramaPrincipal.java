package ar.edu.unlam.alumno.pb2.salaDeCineTest;

import static org.junit.Assert.*;

import java.time.LocalTime;

import org.junit.Test;

import ar.edu.unlam.alumno.pb2.salaDeCine.Espectador;
import ar.edu.unlam.alumno.pb2.salaDeCine.Pelicula;
import ar.edu.unlam.alumno.pb2.salaDeCine.ProgPpal;
import ar.edu.unlam.alumno.pb2.salaDeCine.SalaDeCine;

public class TestProgramaPrincipal {

	Pelicula peliculaSala1 = new Pelicula("Rambo", "Accion", 102, 16);
	Pelicula peliculaSala2 = new Pelicula("La Máscara", "comedia", 97, 12);
	SalaDeCine sala1 = new SalaDeCine(3, 5, peliculaSala1, "Sala 1");
	SalaDeCine sala2 = new SalaDeCine(5, 6, peliculaSala2, "Sala 2");
	Espectador espectador1 = new Espectador("pepe", "gomez", 18);
	Espectador espectador2 = new Espectador("maria", "pérez", 21);
	int horaFuncion = 14;
	int minutosFuncion = 30;
	int horaPrimeraFuncion = 14;
	int minutoPrimeraFuncion = 30;
	int horaUltimaFuncion = 21;
	int minutoUltimaFuncion = 30;
	int cantFunciones = 4;
	int cantSalas = 2;

	@Test
	public void venderEntradasEnLasSalasDeCineYQueSeOcupenLasButacasAleatoriamente() {
		ProgPpal[] salas = new ProgPpal[cantSalas];

		salas[0] = new ProgPpal(sala1, cantFunciones, LocalTime.of(horaFuncion, minutosFuncion),
				LocalTime.of(horaPrimeraFuncion, minutoPrimeraFuncion),
				LocalTime.of(horaUltimaFuncion, minutoUltimaFuncion));
		salas[1] = new ProgPpal(sala2, 5, LocalTime.of(15, 00), LocalTime.of(15, 00), LocalTime.of(22, 00));

		salas[1].getSala().venderEntrada(espectador1);
		salas[1].getSala().venderEntrada(espectador2);

		salas[0].getSala().venderEntrada(espectador1);
		salas[0].getSala().venderEntrada(espectador2);

		assertEquals(2, salas[1].getSala().getCantButacasOcupadas());
		assertEquals(2, salas[0].getSala().getCantButacasOcupadas());

		assertEquals(28, salas[1].getSala().getCantButacasDisponibles());
		assertEquals(13, salas[0].getSala().getCantButacasDisponibles());

	}

	@Test
	public void venderEntradasEnLasSalasDeCineYQueSeOcupenLasButacasElegidasYListarElEstadoDeCadaButaca() {
		ProgPpal[] salas = new ProgPpal[cantSalas];

		salas[0] = new ProgPpal(sala1, cantFunciones, LocalTime.of(horaFuncion, minutosFuncion),
				LocalTime.of(horaPrimeraFuncion, minutoPrimeraFuncion),
				LocalTime.of(horaUltimaFuncion, minutoUltimaFuncion));
		salas[1] = new ProgPpal(sala2, 5, LocalTime.of(15, 00), LocalTime.parse("15:00"), LocalTime.parse("22:00"));

		salas[1].getSala().venderEntrada(espectador2);
		salas[1].getSala().setFilaAsiento(1);
		salas[1].getSala().setColumnaAsiento(3);
		salas[1].getSala().venderEntrada(espectador1);

		salas[0].getSala().venderEntrada(espectador1);
		salas[0].getSala().venderEntrada(espectador2);

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 6; j++) {
				System.out.println(
						"Sala: " + salas[1].getSala().getNombreSala() + " " + salas[1].getSala().getButaca()[i][j]);
			}
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.println(
						"Sala: " + salas[0].getSala().getNombreSala() + " " + salas[0].getSala().getButaca()[i][j]);
			}
		}

		assertEquals(2, salas[1].getSala().getCantButacasOcupadas());
		assertEquals(2, salas[0].getSala().getCantButacasOcupadas());

	}

	@Test
	public void venderEntradasEnLasSalasDeCineYQueSeOcupenLasButacasElegidas() {
		ProgPpal[] salas = new ProgPpal[cantSalas];

		salas[0] = new ProgPpal(sala1, cantFunciones, LocalTime.of(horaFuncion, minutosFuncion),
				LocalTime.of(horaPrimeraFuncion, minutoPrimeraFuncion),
				LocalTime.of(horaUltimaFuncion, minutoUltimaFuncion));
		salas[1] = new ProgPpal(sala2, 5, LocalTime.of(15, 00), LocalTime.parse("15:00"), LocalTime.parse("22:00"));

		salas[1].getSala().venderEntrada(espectador2);
		salas[1].getSala().setFilaAsiento(1);
		salas[1].getSala().setColumnaAsiento(3);
		salas[1].getSala().venderEntrada(espectador1);

		salas[0].getSala().venderEntrada(espectador1);
		salas[0].getSala().venderEntrada(espectador2);

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 6; j++) {
				System.out.println(
						"Sala: " + salas[1].getSala().getNombreSala() + " " + salas[1].getSala().getButaca()[i][j]);
			}
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.println(
						"Sala: " + salas[0].getSala().getNombreSala() + " " + salas[0].getSala().getButaca()[i][j]);
			}
		}

		assertEquals(2, salas[1].getSala().getCantButacasOcupadas());
		assertEquals(2, salas[0].getSala().getCantButacasOcupadas());

	}

	@Test
	public void crearUnCineConDosSalas() {
		ProgPpal[] salas = new ProgPpal[cantSalas];

		salas[0] = new ProgPpal(sala1, cantFunciones, LocalTime.of(horaFuncion, minutosFuncion),
				LocalTime.of(horaPrimeraFuncion, minutoPrimeraFuncion),
				LocalTime.of(horaUltimaFuncion, minutoUltimaFuncion));
		salas[1] = new ProgPpal(sala2, 5, LocalTime.of(15, 00), LocalTime.parse("15:00"), LocalTime.parse("22:00"));
		assertEquals("Rambo", salas[0].getPelicula().getTitulo());
		assertEquals("La Máscara", salas[1].getPelicula().getTitulo());

	}

	@Test
	public void crearUnProgramaPrincipalConSalaYCartelera() {

		ProgPpal programacion = new ProgPpal(sala1, cantFunciones, LocalTime.of(horaFuncion, minutosFuncion),
				LocalTime.of(horaPrimeraFuncion, minutoPrimeraFuncion),
				LocalTime.of(horaUltimaFuncion, minutoUltimaFuncion));

		assertNotNull(programacion);
		assertEquals("Rambo", peliculaSala1.getTitulo());
		assertEquals(peliculaSala1, sala1.getPeliculaEnCartelera());
	}

	@Test
	public void venderEntradasParaUnaFuncion() {

		ProgPpal programacion = new ProgPpal(sala1, cantFunciones, LocalTime.of(horaFuncion, minutosFuncion),
				LocalTime.of(horaPrimeraFuncion, minutoPrimeraFuncion),
				LocalTime.of(horaUltimaFuncion, minutoUltimaFuncion));

		assertNotNull(programacion);
		assertEquals("Rambo", peliculaSala1.getTitulo());
		assertEquals(peliculaSala1, sala1.getPeliculaEnCartelera());
	}
//
}
