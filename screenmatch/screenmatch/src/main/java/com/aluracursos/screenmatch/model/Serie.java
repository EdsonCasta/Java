package com.aluracursos.screenmatch.model;

import com.aluracursos.screenmatch.service.ConsultaGemini;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

@Entity
@Table(name = "series")
public class Serie {
        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String titulo;
    private Integer totalDeTemporadas;
    private Double evaluacion;
    private String poster;
    @Enumerated(EnumType.STRING)
    private Categoria genero;
    private String actores;
    private String sinopsis;

    @OneToMany(mappedBy = "serie", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Episodio> episodios;

    public Serie (){}

    public Serie(DatosSerie datosSerie){
        this.titulo = datosSerie.titulo();
        this.totalDeTemporadas = datosSerie.totalDeTemporadas();
        this.evaluacion = OptionalDouble.of(Double.valueOf(datosSerie.evaluacion())).orElse(0);
        this.poster = datosSerie.poster();
        this.genero = Categoria.fromString(datosSerie.genero().split(",")[0].trim());
        this.actores = datosSerie.actores();
//        this.sinopsis = consultaGemini.obtenerTraduccion(datosSerie.sinopsis());
        this.sinopsis = datosSerie.sinopsis();
    }

    @Override
    public String toString() {
        return "genero = '" + genero + '\'' +
                ", titulo = '" + titulo + '\'' +
                ", totalDeTemporadas = " + totalDeTemporadas +
                ", evaluacion = " + evaluacion +
                ", poster = '" + poster + '\'' +
                ", actores = '" + actores + '\'' +
                ", sinopsis = '" + sinopsis + '\'';
//                ", episodios = '" + episodios + '\'';
    }

    public List<Episodio> getEpisodios() {
        return episodios;
    }

    public void setEpisodios(List<Episodio> episodios) {
        episodios.forEach(e -> e.setSerie(this));
        this.episodios = episodios;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getTotalDeTemporadas() {
        return totalDeTemporadas;
    }

    public void setTotalDeTemporadas(Integer totalDeTemporadas) {
        this.totalDeTemporadas = totalDeTemporadas;
    }

    public Double getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(Double evaluacion) {
        this.evaluacion = evaluacion;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public Categoria getGenero() {
        return genero;
    }

    public void setGenero(Categoria genero) {
        this.genero = genero;
    }

    public String getActores() {
        return actores;
    }

    public void setActores(String actores) {
        this.actores = actores;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }
}
