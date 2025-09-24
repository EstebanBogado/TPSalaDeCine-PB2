package ar.edu.unlam.alumno.pb2.salaDeCineTest;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.alumno.pb2.salaDeCine.Espectador;
import ar.edu.unlam.alumno.pb2.salaDeCine.Pelicula;

public class TestPelículas {

	Pelicula nuevaPelicula = new Pelicula("La Máscara", "comedia", 93, 13);

	@Test
	public void cargarUnaPeliculaYvalidarSuGeneroYLaEdadDelEspectador() {
		Espectador nuevoEspectador = new Espectador("Pepe", "Gómez", 16);

		assertEquals("La Máscara", nuevaPelicula.getTitulo());
		assertTrue(nuevaPelicula.validarEdadMinima(nuevoEspectador));

	}

	@Test
	public void cargarUnaPeliculaYvalidarSuGeneroYQueLaEdadMinimaSeaLaCorrecta() {

		Espectador nuevoEspectador = new Espectador("Pepe", "Gómez", 16);

		assertTrue(nuevaPelicula.validarEdadMinima(nuevoEspectador));
	}

	@Test
	public void cargarSinopsisYPoderLeerla() {
		String sinopsis = "Una película de comedia llena de avneturas y diversión, para mantenerte riendo de principio a fin";
		nuevaPelicula.setSinopsis(sinopsis);
		System.out.println(nuevaPelicula.getSinopsis());
		assertNotNull(nuevaPelicula.getSinopsis());
	}
}