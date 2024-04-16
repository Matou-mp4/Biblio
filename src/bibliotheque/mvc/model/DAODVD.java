package bibliotheque.mvc.model;

import bibliotheque.metier.DVD;
import bibliotheque.metier.Livre;
import bibliotheque.metier.Ouvrage;
import bibliotheque.metier.TypeLivre;
import bibliotheque.mvc.observer.Subject;
import java.util.List;
import java.util.Set;

public abstract class DAODVD extends Subject {


    public abstract DVD add( DVD elt) ;

    public abstract boolean remove( DVD elt) ;

    public abstract DVD update(DVD elt) ;

    public abstract DVD read(DVD rech) ;

    public abstract List<DVD> getAll() ;


    public abstract Set<Ouvrage> listerOuvrages(DVD a);

    public abstract List<Livre> listerLivre(DVD a, TypeLivre tl) ;

    public abstract List<Ouvrage> listerOuvrages(DVD a, String genre);

    public List<DVD> getNotification(){
        return getAll();
    }
}
