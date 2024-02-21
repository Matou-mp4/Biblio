package Biblio.Métier;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

public abstract class Ouvrage {
    protected String titre;
    protected byte ageMin;
    protected LocalDate dateParution;
    protected typeOuvrage typeOuvrage;
    protected double prixLocation;
    protected String langue;
    protected String genre;
    protected List<Auteur> auteurs;
    protected List<Exemplaire> exemplaires;
    public void listerExemplaires() {
    }
    public void listerExemplaires(boolean enLocation) {
    }
    public abstract double amandeRetard(int nbJours);

    public List<Auteur> getAuteurs() {
        return auteurs;
    }
}
