package Biblio.Métier;

import java.time.LocalTime;

public class Cd extends Ouvrage {
    private long code;
    private byte nbrePlages;
    private LocalTime dureeTotale;
    public Cd() {
    }

    @Override
    public double amandeRetard(int nbJours) {
        return 0;
    }
}
