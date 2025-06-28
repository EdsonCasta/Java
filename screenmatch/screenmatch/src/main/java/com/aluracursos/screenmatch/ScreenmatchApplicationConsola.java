//package com.aluracursos.screenmatch;
//
//import com.aluracursos.screenmatch.principal.Principal;
//import com.aluracursos.screenmatch.repository.SerieRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
//public class ScreenmatchApplicationConsola implements CommandLineRunner {
//
//	@Autowired
//	private SerieRepository repository;
//	public static void main(String[] args) {
//		SpringApplication.run(ScreenmatchApplicationConsola.class, args);
//	}
//
//	@Override
//	public void run(String... args) throws Exception {
//		Principal principal = new Principal(repository);
//		principal.mostrarElMenu();
//
//		/*
//		var consumoAPI = new ConsumoAPI();
//		var json = consumoAPI.obtenerDatos( "https://www.omdbapi.com/?t=game+of+thrones&apikey=2d783b4f");
//		System.out.println(json);
//
//		ConvierteDatos conversor = new ConvierteDatos();
//		var datos = conversor.obtenerDatos(json, DatosSerie.class);
//		System.out.println(datos);
//
//		json = consumoAPI.obtenerDatos("https://www.omdbapi.com/?t=game+of+thrones&season=1&episode=1&apikey=2d783b4f");
//		DatosEpisodio episodio = conversor.obtenerDatos(json, DatosEpisodio.class);
//		System.out.println(episodio);
//		*/
//
////		EjemploStreams ejemploStreams = new EjemploStreams();
////		ejemploStreams.muestraEjamplo();
//	}
//}
