package sortownica;

public class PorównywaczPoX implements Porównywacz<Punkt> {

    public int porównaj(Punkt a, Punkt b) {
        if (a.getX() < b.getX()) return -1;
        else if (a.getX() > b.getX()) return 1;
        else {
            if (a.getY() < b.getY()) return -1;
            else if (a.getY() > b.getY()) return 1;
            else return 0;
        }
    }
}
