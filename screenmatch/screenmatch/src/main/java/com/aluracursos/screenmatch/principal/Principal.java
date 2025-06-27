package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.model.*;
import com.aluracursos.screenmatch.repository.SerieRepository;
import com.aluracursos.screenmatch.service.ConsultaGemini;
import com.aluracursos.screenmatch.service.ConsumoAPI;
import com.aluracursos.screenmatch.service.ConvierteDatos;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class Principal {

        private Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        private ConsumoAPI consumoAPI = new ConsumoAPI();

        private final String URL_BASE = "https://www.omdbapi.com/?t=";
        private  final String API_KEY = "&apikey=2d783b4f";

        private ConvierteDatos conversor = new ConvierteDatos();
//        private final ConsultaGemini consultaGemini;
        private final SerieRepository repository;

        private List<Serie> series;
        private List<DatosSerie> datosSeries;
        private Optional<Serie> serieBuscada;

    public Principal(SerieRepository repository) {
//        this.consultaGemini = consultaGemini;
        this.repository = repository;
    }

    public void mostrarElMenu(){

        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    1 - Buscar series
                    2 - Buscar episodios
                    3 - Mostrar series buscadas
                    4 - Buscar series por titulo
                    5 - Top 5 mejores series
                    6 - Buscar serie por categoria
                    7 - Filtrar series
                    8 - Buscar episodios por titulo
                    9 - Top 5 episodios por serie
                    
                    0 - Salir
                    """;
            System.out.println(menu);
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    buscarSerieWeb();
                    break;
                case 2:
                    buscarEpisodioPorSerie();
                    break;
                case 3:
                    mostrarSeriesBuscadas();
                    break;
                case 4:
                    buscarSeriePorTitulo();
                    break;
                case 5:
                    buscarTop5Series();
                    break;
                case 6:
                    buscarSeriePorCategoria();
                    break;
                case 7:
                    filtrarSeriesPorTemporadaYEvalucion();
                    break;
                case 8:
                    buscarEpisodiosPorTitulo();
                    break;
                case 9:
                    busquedaTop5Episodios();
                    break;
                case 0:
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }

    }

    private void busquedaTop5Episodios() {
        buscarSeriePorTitulo();
        if (serieBuscada.isPresent()) {
            Serie serie = serieBuscada.get();
            List<Episodio> topEpisodios = repository.top5Eposodios(serie);

            topEpisodios = topEpisodios.stream()
                    .limit(5)
                    .collect(Collectors.toList());

            if (topEpisodios.isEmpty()) {
                System.out.println("No hay episodios registrados para esta serie.");
                return;
            }
            System.out.println("*** Top 5 episodios ***");
            topEpisodios.forEach(e ->
                    System.out.printf("Serie: %s | Título: %s | Temporada: %d | Episodio: %d | Evaluación: %.1f\n",
                            e.getSerie().getTitulo(), e.getTitulo(), e.getTemporada(), e.getNumeroEpisodio(), e.getEvaluacion()));
        }
    }

    private void buscarEpisodiosPorTitulo() {
        System.out.println("Escribe el nombre del episodio que deseas buscar: ");
        var nombreEpisodio = scanner.nextLine();
        List<Episodio> episodiosEncontrados = repository.episodiosPorNombre(nombreEpisodio);
        episodiosEncontrados.forEach(e ->
                System.out.printf("Serie: %s Temporada %s Episodio %s Evaluación %s\n",
                        e.getSerie(), e.getTemporada(), e.getNumeroEpisodio(), e.getEvaluacion()));
    }

    private void filtrarSeriesPorTemporadaYEvalucion() {
        System.out.println("¿Filtrar séries con cuántas temporadas? ");
        var totalTemporadas = scanner.nextInt();
        scanner.nextLine();
        System.out.println("¿Evaluación apartir de cuál valor? ");
        var evaluacion = scanner.nextDouble();
        scanner.nextLine();
        List<Serie> filtroSeries = repository.seriesPorTemporadaYEvaluacion(totalTemporadas, evaluacion);
        System.out.println("*** Series filtradas ***");
        filtroSeries.forEach(s ->
                System.out.println(s.getTitulo() + "  - evaluacion: " + s.getEvaluacion()));
    }

    private void buscarSeriePorCategoria() {
        System.out.println("Escriba el genero/categoria de la serie que deseas buscar: ");
        var genero = scanner.nextLine();
        var categoria = Categoria.fromEspanol(genero);
        List<Serie> seriesPorCategoria = repository.findByGenero(categoria);
        System.out.println("Las series de la categoria " + genero + " son: ");
        seriesPorCategoria.forEach(System.out::println);
    }

    private void buscarTop5Series() {
        List<Serie> topSeries = repository.findTop5ByOrderByEvaluacionDesc();

        topSeries.forEach(s -> System.out.println("Serie: " + s.getTitulo() + " Evaluacion: " + s.getEvaluacion()));
    }

    private void buscarSeriePorTitulo() {
        System.out.println("Escribe el nombre de la serie que deseas buscar: ");
        var nombreSerie = scanner.nextLine();

        serieBuscada = repository.findByTituloContainsIgnoreCase(nombreSerie);

        if (serieBuscada.isPresent()) {
            System.out.println("La serie buscada es: " + serieBuscada.get());
        }else {
            System.out.println("Serie no encontrada");
        }
    }

    private DatosSerie getDatosSerie() {
        System.out.println("Escribe el nombre de la serie que deseas buscar");
        var nombreSerie = scanner.nextLine();
        var json = consumoAPI.obtenerDatos(URL_BASE + nombreSerie.replace(" ", "+") + API_KEY);
        System.out.println(json);
        DatosSerie datos = conversor.obtenerDatos(json, DatosSerie.class);
        return datos;
    }
    private void buscarEpisodioPorSerie() {
        mostrarSeriesBuscadas();
        System.out.println("Escribe el nombre de la serie para ver sus episodios: ");
        var nombreSerie = scanner.nextLine();

        Optional<Serie> serie = series.stream()
                .filter(s -> s.getTitulo().toLowerCase().contains(nombreSerie.toLowerCase()))
                .findFirst();
        if (serie.isPresent()) {
            var serieEncontrada = serie.get();

            List<DatosTemporadas> temporadas = new ArrayList<>();

            for (int i = 1; i <= serieEncontrada.getTotalDeTemporadas(); i++) {
                var json = consumoAPI.obtenerDatos(URL_BASE + serieEncontrada.getTitulo().replace(" ", "+") + "&season=" + i + API_KEY);
                DatosTemporadas datosTemporada = conversor.obtenerDatos(json, DatosTemporadas.class);
                temporadas.add(datosTemporada);
            }
            temporadas.forEach(System.out::println);

            List<Episodio> episodios = temporadas.stream()
                    .flatMap(d -> d.episodios().stream()
                            .map(e -> new Episodio(d.numero(), e)))
                    .collect(Collectors.toList());
            serieEncontrada.setEpisodios(episodios);
            repository.save(serieEncontrada);
        }
    }

    private void buscarSerieWeb() {
        DatosSerie datos = getDatosSerie();
//        datosSeries.add(datos);
        Serie serie = new Serie(datos);
        repository.save(serie);
        System.out.println("Serie guardada en la base de datos: ");
        System.out.println(serie);
    }

    private void mostrarSeriesBuscadas() {
        series = repository.findAll();
        series.stream()
                .sorted(Comparator.comparing(Serie::getGenero))
                .forEach(System.out::println);
    }
}
