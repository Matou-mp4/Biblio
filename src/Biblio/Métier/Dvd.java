package Biblio.Métier;

import java.time.LocalTime;
import java.util.List;

public class Dvd extends Ouvrage{

    private long code;
    private LocalTime dureeTotale;
    private byte nbreBonus;
    private List<String> autresLangues;
    private List<String> sousTitres;
    public Dvd() {
    }
    @Override
    public double amandeRetard(int nbJours) {
        return 0;
    }
}
