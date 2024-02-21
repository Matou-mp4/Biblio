package Biblio.Métier;

import java.util.List;

public class Exemplaire {
    private String matricule;
    private String descriptionEtat;
    private Ouvrage ouvrage;
    private Rayon rayon;
    private List<Location> locations;
    public Exemplaire(String matricule,String descriptionEtat,Ouvrage ouvrage) {
        this.matricule=matricule;
        this.descriptionEtat=descriptionEtat;
        this.ouvrage=ouvrage;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setRayon(Rayon rayon) {
        this.rayon = rayon;
    }

    public void modifierEtat(String etat) {
    }
    public void lecteurActuel() {
    }
    public void lecteur() {
    }
    public void envoiMailLecteurActuel(Mail mail) {
    }
    public void envoiMailLecteur(Mail mail) {
    }
    public Boolean enRetard() {
        return null;
    }
    public int joursRetard() {
        return 0;
    }
    public Boolean enLocation() {
        return null;
    }
}
