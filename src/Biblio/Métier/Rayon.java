package Biblio.Métier;

import java.util.List;

public class Rayon {
    private String codeRayon;
    private String genre;
    private List<Exemplaire> exemplaires;
    public Rayon(String codeRayon, String genre){
        this.codeRayon=codeRayon;
        this.genre=genre;
    }

    public List<Exemplaire> getExemplaires() {
        return exemplaires;
    }

    public void listerOuvrages() {
    }
    public void listerExemplaires() {
    }
}
