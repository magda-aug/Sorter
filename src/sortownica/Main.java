package sortownica;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final int DODATEK = 1;
    private static final int DZIELNIK = 2;
    private static final int MNOZNIK = 3;
    private static final int POCZATKOWY = 0;

    private static Punkt[] elementy;

    public static void zapisz(int i, Punkt x) {
        if (i >= elementy.length) {
            elementy = Arrays.copyOf(elementy, MNOZNIK * i / DZIELNIK + DODATEK);
        }
        elementy[i] = x;
    }

    public static void czytaj() throws Exception {
        int i = 0;
        Scanner wejście = new Scanner(System.in);
        String wiersz;
        int x, y;
        while (wejście.hasNextLine()) {
            wiersz = wejście.nextLine();
            Scanner s = new Scanner(wiersz);
            if (s.hasNextInt()) {
                x = s.nextInt();
                if (s.hasNextInt()) {
                    y = s.nextInt();
                    zapisz(i, new Punkt(x, y));
                    i++;
                } else if (s.hasNext()) throw new BłędneDane();
                else throw new BrakDanych();
            } else if (s.hasNext()) throw new BłędneDane();
            else throw new BrakDanych();
            s.close();
        }
        wejście.close();
    }

    public static void main(String[] args) {
        elementy = new Punkt[POCZATKOWY];
        try {
            czytaj();
        } catch (BłędneDane | BrakDanych e) {
            System.out.println(e.getMessage());
            System.exit(1);
        } catch (Exception e) {
            System.exit(1);
        }
        Sortownica<Punkt> s = new Sortownica<>(elementy);
        PorównywaczPoX x = new PorównywaczPoX();
        PorównywaczPoY y = new PorównywaczPoY();
        s.sortuj(x);
        System.out.println(s);
        s.sortuj(y);
        System.out.print(s);
    }
}
