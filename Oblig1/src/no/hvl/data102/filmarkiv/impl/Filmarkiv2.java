package no.hvl.data102.filmarkiv.impl;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import org.junit.platform.engine.support.hierarchical.Node;

public class Filmarkiv2 implements FilmarkivADT {

    private int antall;
    private LinearNode<Film> start;
    private LinearNode<Film> temp;

    public Filmarkiv2() {
        this.antall = 0;
    }

    @Override
    public Film finnFilm(int nr) {

        temp = start;
        while(temp != null) {
            if(temp.data.getFilmnr() == nr) {
                return temp.data;
            }
            temp = temp.neste;
        }
        return null;
    }

    @Override
    public void leggTilFilm(Film nyFilm) {

        temp = new LinearNode<>(nyFilm);
        temp.neste = start;
        start = temp;
        antall++;
    }

    @Override
    public boolean slettFilm(int filmnr) {

        temp.data = finnFilm(filmnr);

        if (temp.data != null) {

            temp.data = start.data;
            start = start.neste;
            antall--;
            return true;
        }
        return false;
    }

    @Override
    public Film[] soekTittel(String delstreng) {

        int j = 0;
        Film[] tittel = new Film[antall()];
        temp = start;

        for(int i = 0; i < antall(); i++) {
            if(temp.data.getTittel().contains(delstreng)){
                tittel[j] = temp.data;
                j++;
            }
            temp = temp.neste;
        }
        tittel = trimTab(tittel, j);
        return tittel;
    }

    @Override
    public Film[] soekProdusent(String delstreng) {

        int j = 0;
        Film[] tittel = new Film[antall()];
        temp = start;

        for(int i = 0; i < antall(); i++) {
            if(temp.data.getProdusent().contains(delstreng)){
                tittel[j] = temp.data;
                j++;
            }
            temp = temp.neste;
        }
        tittel = trimTab(tittel, j);
        return tittel;
    }

    @Override
    public int antall(Sjanger sjanger) {
        int teller = 0;
        for (int i = 0; i < antall(); i++) {
            if (temp.data.getSjanger() == sjanger) {
                teller++;
            }
            temp = temp.neste;
        }
        return teller;
    }

    @Override
    public int antall() {
        return antall;
    }
    public Film[] trimTab(Film[] tab, int n) {
        // n er antall elementer
        Film[] nytab = new Film[n];
        int i = 0;
        while (i < n) {
            nytab[i] = tab[i];
            i++;
        }
        return nytab;
    }
}
