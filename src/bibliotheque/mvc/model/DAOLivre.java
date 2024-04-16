package bibliotheque.mvc.model;

import bibliotheque.metier.Livre;
import bibliotheque.metier.Livre;
import bibliotheque.metier.Ouvrage;
import bibliotheque.metier.TypeLivre;
import bibliotheque.mvc.observer.Subject;
import java.util.List;
import java.util.Set;

public abstract class DAOLivre extends Subject {


    public abstract Livre add( Livre elt) ;

    public abstract boolean remove( Livre elt) ;

    public abstract Livre update(Livre elt) ;

    public abstract Livre read(Livre rech) ;

    public abstract List<Livre> getAll() ;


    public abstract Set<Ouvrage> listerOuvrages(Livre a);

    public abstract List<Livre> listerLivre(Livre a, TypeLivre tl) ;

    public abstract List<Ouvrage> listerOuvrages(Livre a, String genre);

    public List<Livre> getNotification(){
        return getAll();
    }
}