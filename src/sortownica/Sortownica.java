package sortownica;

public class Sortownica<T> {
    private T[] obiekty;

    public Sortownica(T[] obiekty) {
        this.obiekty = obiekty;
    }

    public String toString() {
        StringBuilder wynik = new StringBuilder();
        for (T t : obiekty) {
            wynik.append(t.toString());
        }
        return wynik.toString();
    }

    public void sortuj(Porównywacz<T> p) {
        int i, j;

        for (j = 0; j < obiekty.length - 1; j++) {
            int iMin = j;
            for (i = j + 1; i < obiekty.length; i++) {
                if (p.porównaj(obiekty[i], obiekty[iMin]) < 0)
                    iMin = i;
            }
            if (j != iMin) zamień(j, iMin);
        }
    }

    private void zamień(int i, int j) {
        T pom = obiekty[i];
        obiekty[i] = obiekty[j];
        obiekty[j] = pom;
    }
}
