package ar.edu.unlam.alumno.pb2.salaDeCineTest;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.alumno.pb2.salaDeCine.Butaca;
import ar.edu.unlam.alumno.pb2.salaDeCine.Espectador;
import ar.edu.unlam.alumno.pb2.salaDeCine.Pelicula;
import ar.edu.unlam.alumno.pb2.salaDeCine.SalaDeCine;

public class TestSalaDeCine {

	int cantFilas = 3;
	int cantColumnas = 5;
	Pelicula peliculaEnCartelera = new Pelicula("Duro de Matar", "Acción", 91, 13);
	SalaDeCine nuevaSalaCine = new SalaDeCine(cantFilas, cantColumnas, peliculaEnCartelera);
	Espectador pepe = new Espectador("pepe", "gómez", 18);
	Espectador juan = new Espectador("juan", "pérez", 17);
	Espectador maria = new Espectador("maría", "gonzález", 15);
	Butaca[][] butaca = nuevaSalaCine.getButaca();
	int butacasDisponibles = 0;

	@Test
	public void queSePuedeCrearUnaSalaDeCineCorrectamente() {

		assertNotNull(nuevaSalaCine);
	}

	@Test
	public void creadaUnaSalaDeCineTieneButacasVaciasYVerifiqueQuinceButacas() {
		int cantidadDeButacas = 0;
		for (int i = 0; i < cantFilas; i++) {
			for (int j = 0; j < cantColumnas; j++) {
				cantidadDeButacas++;
				assertTrue(butaca[i][j].getButacaDisponible());
			}
		}
		assertEquals(cantidadDeButacas, nuevaSalaCine.getCapacidadSala());
	}

	@Test
	public void queLaSalaDeCineTengaTodosLosAsientosOcupados() {

		for (int i = 0; i < cantFilas; i++) {
			for (int j = 0; j < cantColumnas; j++) {
				butaca[i][j].setEspectador(juan);
				butaca[i][j].estaVendida();
				assertFalse(butaca[i][j].getButacaDisponible());
			}
		}

	}

	@Test
	public void contarLasButacasOcupadasYMostrarLasDisponibles() {
		int ocupadas = 0;
		int libres = 0;

		nuevaSalaCine.venderEntrada(juan);
		nuevaSalaCine.setFilaAsiento(2);
		nuevaSalaCine.setColumnaAsiento(3);
		nuevaSalaCine.venderEntrada(pepe);

		for (int i = 0; i < cantFilas; i++) {
			for (int j = 0; j < cantColumnas; j++) {
				if (butaca[i][j].getButacaDisponible()) {
					libres++;
				} else {
					butaca[i][j].getButacaOcupada();
					ocupadas++;
				}
			}
		}

				assertEquals(libres, nuevaSalaCine.getCantButacasDisponibles());
		assertEquals(ocupadas, nuevaSalaCine.getCantButacasOcupadas());
	}

	@Test
	public void queNoSePuedaCargarLosDatosDelEspectadorAUnaButacaAnulada() {
		nuevaSalaCine.getButaca()[1][3].butacaAnulada();
		nuevaSalaCine.setFilaAsiento(1);
		nuevaSalaCine.setColumnaAsiento(3);
		nuevaSalaCine.venderEntrada(juan);

		assertEquals(14, nuevaSalaCine.getCantButacasDisponibles());

	}

	@Test
	public void sePuedeAnularUnaButacaVacíaParaQueNoPuedaOcuparse() {
		butaca[1][3].butacaAnulada();

		assertTrue(!butaca[1][3].getButacaDisponible());
	}

	@Test
	public void saberQuePeliculaSeEstaProyectando() {
		assertEquals(peliculaEnCartelera.getTitulo(), nuevaSalaCine.getPeliculaEnCartelera().getTitulo());
	}

	@Test
	public void queAlVenderUnaEntradaElAsientoSeOcupe() {

		for (int i = 0; i < cantFilas; i++) {
			for (int j = 0; j < cantColumnas; j++) {
				if (butaca[i][j].getButacaDisponible()) {
					butaca[i][j].setEspectador(juan);
					butaca[i][j].estaVendida();
					assertFalse(butaca[i][j].getButacaDisponible());
					return;
				}
			}
		}
	}

	@Test
	public void venderUnaEntradaYOcuparUnAsiento() {
		// listado de asientos 00,01,02,03,04,10,11,12,13,14,20,21,22,23,24

		nuevaSalaCine.venderEntrada(pepe);
		nuevaSalaCine.venderEntrada(juan);
		nuevaSalaCine.venderEntrada(pepe);
		nuevaSalaCine.venderEntrada(juan);
		nuevaSalaCine.venderEntrada(pepe);
		nuevaSalaCine.venderEntrada(juan);

		assertTrue(peliculaEnCartelera.validarEdadMinima(pepe));
		assertTrue(peliculaEnCartelera.validarEdadMinima(juan));
		assertEquals(9, nuevaSalaCine.getCantButacasDisponibles());
	}

	@Test
	public void queAlVenderEntradasSeOcupenSoloLosAsientosQueValidenLaEdadMinima() {
		// listado de asientos 00,01,02,03,04,10,11,12,13,14,20,21,22,23,24

		nuevaSalaCine.venderEntrada(pepe);
		nuevaSalaCine.venderEntrada(juan);
		nuevaSalaCine.venderEntrada(maria);

		assertTrue(peliculaEnCartelera.validarEdadMinima(pepe));
		assertTrue(peliculaEnCartelera.validarEdadMinima(juan));
		assertEquals(12, nuevaSalaCine.getCantButacasDisponibles());
	}

	@Test
	public void queElEspectadorElijaElAsientoYSiNoCumpleConLaEdadMinimaQueNoLeVenda() {
		// listado de asientos 00,01,02,03,04,10,11,12,13,14,20,21,22,23,24
		nuevaSalaCine.setFilaAsiento(1);
		nuevaSalaCine.setColumnaAsiento(3);
		nuevaSalaCine.venderEntrada(pepe);
		nuevaSalaCine.setFilaAsiento(1);
		nuevaSalaCine.setColumnaAsiento(3);
		nuevaSalaCine.venderEntrada(juan);
		nuevaSalaCine.venderEntrada(maria);

		assertTrue(peliculaEnCartelera.validarEdadMinima(pepe));
		assertTrue(peliculaEnCartelera.validarEdadMinima(juan));
		assertEquals(12, nuevaSalaCine.getCantButacasDisponibles());
	}

	@Test
	public void cambiarLaCarteleraDeUnaSalaConGeneroValidoYConGeneroInvalido() {

		// película con género válido
		Pelicula otraPelicula = new Pelicula("Shreck", "infantil", 95, 0);
		assertTrue(nuevaSalaCine.validarGeneroPelicula(otraPelicula));

		// película con género inválido
		Pelicula segundaPelicula = new Pelicula("Cabo de miedo", "suspenso", 93, 16);
		assertFalse(nuevaSalaCine.validarGeneroPelicula(segundaPelicula));
	}

}
