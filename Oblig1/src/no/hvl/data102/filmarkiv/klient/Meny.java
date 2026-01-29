package no.hvl.data102.filmarkiv.klient;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;

import java.util.Scanner;

import static no.hvl.data102.filmarkiv.impl.Sjanger.ACTION;
import static no.hvl.data102.filmarkiv.impl.Sjanger.SCIFI;

public class Meny {
    private Tekstgrensesnitt tekstgr;
    private FilmarkivADT filmarkiv;
    public Meny(FilmarkivADT filmarkiv){
        tekstgr = new Tekstgrensesnitt();
        this.filmarkiv = filmarkiv;
    }
    public void start(){
// legg inn en del forhåndsdefinerte filmer for å teste metodene
// ..
        Film f1 = new Film(001, "Ridley Scott", "Gladiator", 2000, ACTION, "DreamWorks");
        Film f2 = new Film(002, "Tony Scott", "Top Gun", 1986, SCIFI, "Paramount");
        Film f3 = new Film(003, "En Prod", "En Tittel", 2026, ACTION,"ET FILMSELSKAP");
        filmarkiv.leggTilFilm(f1);
        filmarkiv.leggTilFilm(f2);
        filmarkiv.leggTilFilm(f3);

        Scanner in = new Scanner(System.in);

        for (int i = 0; i >= 0; i++){

            System.out.println();
            System.out.println("Hva vil du gjøre?" +"\nLegge til film: Skriv 1" +"\nSkrive ut film: Skriv 2"+
                    "\nSøke Tittel til film: Skriv 3"+"\nSøke produsent til film: Skriv 4"+
                    "\nStatistikk på sjanger: Skriv 5"+ "\nUt av loop: Skriv 6");
            System.out.println();

            int valg = in.nextInt();
            in.nextLine();

            switch (valg) {
                case 1:
                    Film film = tekstgr.lesFilm();
                    filmarkiv.leggTilFilm(film);
                    break;

                case 2:
                    System.out.println("Hvilken Film Tittel vil du ha?");
                    String temp = in.nextLine();

                    Film[] tempfilm = filmarkiv.soekTittel(temp);
                    if(tempfilm != null && tempfilm.length > 0) {
                        tekstgr.skrivUtFilm(tempfilm[0]);
                    }
                    break;

                case 3:
                    System.out.println("Titler du vil du ha?");
                    String temp2 = in.nextLine();

                    tekstgr.skrivUtFilmDelstrengITittel(filmarkiv, temp2);

                    break;

                case 4:
                    System.out.println("Produsenter du vil ha");
                    String temp3 = in.nextLine();
                    tekstgr.skrivUtFilmProdusent(filmarkiv, temp3);
                    break;

                case 5:
                    System.out.println("Statistikk på sjangere: \n");
                    tekstgr.skrivUtStatistikk(filmarkiv);
                    break;

                case 6:
                    return;
            }
        }

        /*Film film = tekstgr.lesFilm();
        tekstgr.skrivUtFilm(film);

        tekstgr.skrivUtFilmDelstrengITittel(filmarkiv, "i");

        tekstgr.skrivUtStatistikk(filmarkiv);*/

    }
}