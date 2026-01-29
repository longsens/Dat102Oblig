package no.hvl.data102.filmarkiv.test;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Filmarkiv;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static no.hvl.data102.filmarkiv.impl.Sjanger.ACTION;
import static no.hvl.data102.filmarkiv.impl.Sjanger.SCIFI;
import static org.junit.jupiter.api.Assertions.*;

class FilmarkivTest {

    int kap = 5;
    Filmarkiv arkiv;
    Film film1;
    Film film2;

    @BeforeEach
    void opprettTest() {

        arkiv = new Filmarkiv(kap);
        film1 = new Film(001, "Ridley Scott", "Gladiator", 2000, ACTION, "DreamWorks");
        film2 = new Film(002, "Tony Scott", "Top Gun", 1986, SCIFI, "Paramount");
        arkiv.leggTilFilm(film1);
        arkiv.leggTilFilm(film2);
    }
    @Test
    void finnFilmTest(){
        assertEquals(film1, arkiv.finnFilm(001));
        assertEquals(film2, arkiv.finnFilm(002));
    }
    @Test
    void leggTilTest() {

        assertEquals(2, arkiv.antall());

        Film film3 = new Film(003, "Prod", "Tittel", 1800, ACTION, "SanderProd");
        arkiv.leggTilFilm(film3);

        assertEquals(3, arkiv.antall());
    }
    @Test
    void slettFilmTest() {

        assertEquals(2, arkiv.antall());

        arkiv.slettFilm(002);

        assertEquals(1, arkiv.antall());
    }
    @Test
    void soekTittelTest(){

        Film[] test1 = arkiv.soekTittel("Gla");
        Film[] test2 = arkiv.soekTittel("Top");

        assertEquals(film1, test1[0]);
        assertEquals(film2, test2[0]);

    }
    @Test
    void soekProdTest(){
        Film[] test = arkiv.soekProdusent("Ri");
        Film[] test1 = arkiv.soekProdusent("Ton");

        assertEquals(film1, test[0]);
        assertEquals(film2, test1[0]);
    }
    @Test
    void antallSjangerTest() {

        assertEquals(1, arkiv.antall(ACTION));

        Film film3 = new Film(003,"NOE","Tittel", 1003, ACTION, "Filmselskap");
        arkiv.leggTilFilm(film3);

        assertEquals(2, arkiv.antall(ACTION));
    }
    @Test
    void antallTest() {
        assertEquals(2, arkiv.antall());

        Film film3 = new Film(003,"NOE","Tittel", 1003, ACTION, "Filmselskap");
        arkiv.leggTilFilm(film3);

        assertEquals(3, arkiv.antall());
    }
    @Test
    void utvidTest() {
        int kapTest = 1;

        Film[] test = new Film[kapTest];
        assertEquals(kapTest, test.length);

        test = arkiv.utvid(test);
        assertEquals(kapTest*2, test.length);
    }
    @Test
    void trimTabTest() {
        Film[] test = new Film[5];
        assertEquals(5, test.length);

        test = arkiv.trimTab(test, arkiv.antall());
        assertEquals(2, test.length);
    }
}