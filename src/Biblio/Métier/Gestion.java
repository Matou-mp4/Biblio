package Biblio.Métier;
import java.time.LocalDate;
import static Biblio.Métier.typeLivre.*;
import static Biblio.Métier.typeOuvrage.*;
public class Gestion {
    public static void main(String[] args) {
        Auteur a = new Auteur("Verne","Jules","France");
        Livre l = new Livre("Vingt mille lieues sous les mers", (byte) 10,LocalDate.of(1880,1,1),LIVRE,1.50,"français","aventure","a125",350,ROMAN,"histoire de sous-marin");
        a.getOuvrages().add(l);
        l.getAuteurs().add(a);
        Rayon r = new Rayon("r12","aventure");
        Exemplaire e = new Exemplaire("m12","état neuf",l);
        e.setRayon(r);
        r.getExemplaires().add(e);
        Lecteur lec = new Lecteur("Dupont","Jean",LocalDate.of(2000,1,4),"Mons","jean.dupont@mail.com","0458774411");
        Location loc = new Location(LocalDate.of(2023,2,1),LocalDate.of(2023,3,1),lec,e);
        lec.getLocations().add(loc);
        e.getLocations().add(loc);
        System.out.println(a);
        System.out.println(l);
        System.out.println(r);
        System.out.println(e);
        System.out.println(lec);
        System.out.println(loc);
    }
}
