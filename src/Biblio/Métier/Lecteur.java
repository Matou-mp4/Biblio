package Biblio.Métier;

import java.time.LocalDate;
import java.util.List;

public class Lecteur {
    private static int idact = 1;
    private int numLecteur;
    private String nom;
    private String prenom;
    private LocalDate dateNaiss;
    private String mail;
    private String adresse;
    private String tel;
    private List<Location> locations;
    public Lecteur(String nom,String prenom,LocalDate dateNaiss,String adresse,String mail,String tel) {
        this.numLecteur = idact++;
        this.nom=nom;
        this.prenom=prenom;
        this.dateNaiss=dateNaiss;
        this.adresse=adresse;
        this.mail=mail;
        this.tel=tel;
    }
    public void listerExemplairesEnLocation() {
    }
    public void listerExemplairsLoues() {
    }

    public List<Location> getLocations() {
        return locations;
    }
}
