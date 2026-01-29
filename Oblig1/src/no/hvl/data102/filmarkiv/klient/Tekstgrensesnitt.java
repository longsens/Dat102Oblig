package no.hvl.data102.filmarkiv.klient;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Sjanger;

import java.util.Scanner;

public class Tekstgrensesnitt {

    Scanner in = new Scanner(System.in);

    // Leser inn opplysninger om en film fra tastatur og returnere et Film-objekt
    public Film lesFilm() {

        int filmnr;
        String tittel;
        String produsent;
        int aar;
        Enum sjanger;
        String selskap;

        System.out.print("Film Nummer: ");
        filmnr = in.nextInt();
        in.nextLine();

        System.out.print("Produsent: ");
        produsent = in.nextLine();

        System.out.print("Tittel: ");
        tittel = in.nextLine();

        System.out.print("År: ");
        aar = in.nextInt();
        in.nextLine();

        System.out.print("Sjanger: ");
        sjanger = Sjanger.valueOf(in.nextLine().toUpperCase());

        System.out.print("Selskap: ");
        selskap = in.nextLine();

        Film film = new Film(filmnr, produsent, tittel, aar, sjanger, selskap);

        return film;
    }

    // Skriver ut en film med alle opplysninger på skjerm (husk tekst for sjanger)
    public void skrivUtFilm(Film film) {

        int filmnr = film.getFilmnr();
        String produsent = film.getProdusent();
        String tittel = film.getTittel();
        int aar = film.getAar();
        Enum sjanger = film.getSjanger();
        String selskap = film.getFilmselskap();

        System.out.println("Film Nummer: " + filmnr + " | Tittel: " + tittel + " | Produsent: " + produsent +
                " | År: " + aar + " | Sjanger: " + sjanger + " | Selskap: " + selskap);
    }

    // Skriver ut alle filmer med en spesiell delstreng i tittelen
    public void skrivUtFilmDelstrengITittel(FilmarkivADT arkiv, String delstreng) {
        Film[] film = arkiv.soekTittel(delstreng);

        for (int i = 0; i < film.length; i++) {

            skrivUtFilm(film[i]);
        }
    }

    // Skriver ut alle Filmer av en produsent (produsent er delstreng)
    public void skrivUtFilmProdusent(FilmarkivADT arkiv, String delstreng) {
        Film[] film = arkiv.soekProdusent(delstreng);

        for (int i = 0; i < film.length; i++) {

            skrivUtFilm(film[i]);
        }
    }
        // Skriver ut en enkel statistikk som inneholder antall filmer totalt
// og hvor mange det er i hver sjanger.
    public void skrivUtStatistikk(FilmarkivADT arkiv){
        System.out.println("Antall filmer tot: " + arkiv.antall());

        System.out.println("Antall Action: " + arkiv.antall(Sjanger.ACTION));
        System.out.println("Antall SCIFI: " + arkiv.antall(Sjanger.SCIFI));
        System.out.println("Antall Drama: " + arkiv.antall(Sjanger.DRAMA));
        System.out.println("Antall History: " + arkiv.antall(Sjanger.HISTORY));

    }
// osv ... andre metoder
}