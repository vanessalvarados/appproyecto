package edu.galileo.android.moviemanager.models;


import java.io.Serializable;
import java.util.Objects;

public class
Articulo implements Serializable{

    /*String id;
    String title;
    String overview;
    float voteAverage;
    float voteCount;
    String posterPath;
    String backdropPath;


    public Articulo(String id, String title, String overview, float voteAverage, float voteCount, String posterPath, String backdropPath) {
        this.id = id;
        this.title = title;
        this.overview = overview;
        this.voteAverage = voteAverage;
        this.voteCount = voteCount;
        this.posterPath = posterPath;
        this.backdropPath = backdropPath;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public float getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(float voteAverage) {
        this.voteAverage = voteAverage;
    }

    public float getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(float voteCount) {
        this.voteCount = voteCount;
    }

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342%s", posterPath);
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getBackdropPath() {
        return String.format("https://image.tmdb.org/t/p/w780%s", backdropPath);
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }*/

    int id;
    String nombArticulo;
    String marca;
    String artDescripcion;
    double precioArticulo;
    String oferta;
    int porcentajeDescuento;
    String valorDescuento;
    String url_imagen;
    String url_imagen_poster;
    double rating;

    public Articulo(int id, String nombArticulo, String marca, String artDescripcion, double precioArticulo, String oferta, int porcentajeDescuento, String valorDescuento, String url_imagen, String url_imagen_poster, double rating) {
        this.id = id;
        this.nombArticulo = nombArticulo;
        this.marca = marca;
        this.artDescripcion = artDescripcion;
        this.precioArticulo = precioArticulo;
        this.oferta = oferta;
        this.porcentajeDescuento = porcentajeDescuento;
        this.valorDescuento = valorDescuento;
        this.url_imagen = url_imagen;
        this.url_imagen_poster = url_imagen_poster;
        this.rating = rating;
    }

    //Getters


    public double getRating() {
        return rating;
    }

    public int getId() {
        return id;
    }

    public String getNombArticulo() {
        return nombArticulo;
    }

    public String getMarca() {
        return marca;
    }

    public String getArtDescripcion() {
        return artDescripcion;
    }

    public double getPrecioArticulo() {
        return precioArticulo;
    }

    public String getOferta() {
        return oferta;
    }

    public int getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public  String getValorDescuento() {
        return valorDescuento;
    }

    public String getUrl_imagen() {
        return url_imagen;
    }

    public String getUrl_imagen_poster() {
        return url_imagen_poster;
    }

    //setters

    public void setValorDescuento(String valorDescuento) {
        this.valorDescuento = valorDescuento;
    }

    //equals

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Articulo articulo = (Articulo) o;
        return id == articulo.id;
    }
    @Override
    public int hashCode() {

        return id;
    }
}