package Biblio.Métier;

import java.time.LocalDate;

public class Livre extends Ouvrage {
    private String ISBN;
    private int nbPages;
    private typeLivre typeLivre;
    private String resume;
    public Livre(String titre, byte ageMin, LocalDate dateParution, typeOuvrage typeOuvrage, double prixLocation, String langue, String genre, String ISBN, int nbPages, typeLivre typeLivre, String resume){
        this.ISBN=ISBN;
        this.ageMin=ageMin;
        this.nbPages=nbPages;
        this.typeLivre=typeLivre;
        this.titre=titre;
        this.dateParution=dateParution;
        this.genre=genre;
        this.langue=langue;
        this.prixLocation=prixLocation;
        this.typeOuvrage=typeOuvrage;
        this.resume=resume;

    }
    @Override
    public double amandeRetard(int nbJours) {
        return 0;
    }



}
