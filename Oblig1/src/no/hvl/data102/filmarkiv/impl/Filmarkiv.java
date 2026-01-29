package no.hvl.data102.filmarkiv.impl;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;

public class Filmarkiv implements FilmarkivADT {
    Film[] arkiv;

    public Filmarkiv(int antall) {

        arkiv = new Film[antall];
    }

    @Override
    public Film finnFilm(int nr) {
        for (int i = 0; i < arkiv.length; i++) {
            if (arkiv[i] != null && arkiv[i].getFilmnr() == nr) {
                return arkiv[i];
            }
        }
        return null;
    }

    @Override
    public void leggTilFilm(Film nyFilm) {
        for(int i = 0; i < arkiv.length; i++) {
            if(arkiv[i] == null) {
                arkiv[i] = nyFilm;
                return;

            }
        }
        arkiv = utvid(arkiv);
        arkiv[arkiv.length / 2] = nyFilm;
    }

    @Override
    public boolean slettFilm(int filmnr) {
        int sisteFilm;
        int plassSlettet = 0;

        if (antall() > 0 && finnFilm(filmnr) != null) {
            sisteFilm = antall() - 1;

            for(int i = 0; i < antall() ; i++) {

                if(arkiv[i].getFilmnr() == filmnr) {
                    plassSlettet = i;
                }
            }
            arkiv[plassSlettet] = arkiv[sisteFilm];
            arkiv[sisteFilm] = null;
            return true;
        }
        return false;
    }

    @Override
    public Film[] soekTittel(String delstreng) {

        Film[] temp = new Film[antall()];
        int j = 0;

       for(int i = 0; i < antall(); i++) {
           if(arkiv[i].getTittel().contains(delstreng)){
               temp[j] = arkiv[i];
               j++;
           }
       }
       temp = trimTab(temp, j);
       return temp;
    }

    @Override
    public Film[] soekProdusent(String delstreng) {

        Film[] temp = new Film[antall()];
        int j = 0;

        for(int i = 0; i < antall(); i++) {
            if(arkiv[i].getProdusent().contains(delstreng)){
                temp[j] = arkiv[i];
                j++;
            }
        }
        temp = trimTab(temp, j);
        return temp;
    }

    @Override
    public int antall(Sjanger sjanger) {
        int teller = 0;
        for (int i = 0; i < antall(); i++) {
            if (sjanger == arkiv[i].getSjanger()) {
                teller++;
            }
        }
        return teller;
    }

    @Override
    public int antall() {
        int teller = 0;
        for (int i = 0; i < arkiv.length; i++) {
            if (arkiv[i] != null) {
                teller++;
            }
        }
        return teller;
    }
    public Film[] utvid(Film[] arkivUtvidet) {
        Film[] temp = new Film[arkivUtvidet.length * 2];
        for (int i = 0; i < arkivUtvidet.length; i++) {
            temp[i] = arkivUtvidet[i];
        }
        return temp;
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
