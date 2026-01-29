package no.hvl.data102.filmarkiv.impl;


import java.util.Objects;

public class Film {

    private int filmnr;
    private String produsent;
    private String tittel;
    private int år;
    private Enum sjanger;
    private String filmselskap;

    public Film() {

    }
    public Film(int filmnr, String produsent, String tittel, int år, Enum sjanger, String filmselskap) {
        this.filmnr = filmnr;
        this.produsent = produsent;
        this.tittel = tittel;
        this.år = år;
        this.sjanger = sjanger;
        this.filmselskap = filmselskap;
    }

    public int getFilmnr() {
        return filmnr;
    }
    public void setFilmnr(int filmnr) {
        this.filmnr = filmnr;
    }
    public String getProdusent() {
        return produsent;
    }
    public void setProdusent(String produsent) {
        this.produsent = produsent;
    }
    public String getTittel() {
        return tittel;
    }
    public void setTittel(String tittel) {
        this.tittel = tittel;
    }
    public int getAar() {
        return år;
    }
    public void setÅr(int år) {
        this.år = år;
    }
    public Enum getSjanger() {
        return sjanger;
    }
    public void setSjanger(Enum sjanger) {
        this.sjanger = sjanger;
    }
    public String getFilmselskap() {
        return filmselskap;
    }
    public void setFilmselskap(String filmselskap) {
        this.filmselskap = filmselskap;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return filmnr == film.filmnr && år == film.år && Objects.equals(produsent, film.produsent) && Objects.equals(tittel, film.tittel) && Objects.equals(sjanger, film.sjanger) && Objects.equals(filmselskap, film.filmselskap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmnr, produsent, tittel, år, sjanger, filmselskap);
    }
}
