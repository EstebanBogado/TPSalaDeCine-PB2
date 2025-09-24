package ar.edu.unlam.alumno.pb2.salaDeCineTest;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.alumno.pb2.salaDeCine.Espectador;
import ar.edu.unlam.alumno.pb2.salaDeCine.Pelicula;

public class TestEspectador {

	@Test
	public void sePuedeCrearUnEspectadorYValidarSuEdad() {

		Espectador nuevoEspectador = new Espectador("Pepe", "Gomez", 16);
		Pelicula nuevaPelicula = new Pelicula("Dracula", "accion", 90, 16);

		assertNotNull(nuevoEspectador);
		assertTrue(nuevaPelicula.validarEdadMinima(nuevoEspectador));

	}

}
