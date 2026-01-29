package Oppgave3;

import static java.lang.System.currentTimeMillis;

public class Oppgave3g {

    public static void tid(long n) {

        long x = currentTimeMillis();

        long k = 0;
        for (long i = 1; i <= n; i++) {
            k = k + 5;
        }
        long y = currentTimeMillis();
        long z = y-x;

        System.out.println("Tid brukt: " + z + "ms");
    }

    public static void main(String[] args) {
        tid(10_000_000L);
        System.out.println();
        tid(100_000_000L);
        System.out.println();
        tid(1_000_000_000L);
    }

}
