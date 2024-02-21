package Biblio.Métier;

import java.util.List;

public class Auteur {
    private String nom;
    private String prenom;
    private String nationalite;
    private List<Ouvrage> ouvrages;
    public Auteur(String nom, String prenom, String nationalite) {
        this.nom=nom;
        this.nationalite=nationalite;
        this.prenom=prenom;
    }

    public List<Ouvrage> getOuvrages() {
        return ouvrages;
    }

    public void listerOuvrages() {
    }
    public void listerOuvrages(typeOuvrage type,typeLivre livre) {
    }
    public void listerOuvrages(String genre) {
    }
}
