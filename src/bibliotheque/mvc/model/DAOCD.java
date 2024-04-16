package bibliotheque.mvc.model;

import bibliotheque.metier.CD;
import bibliotheque.metier.Livre;
import bibliotheque.metier.Ouvrage;
import bibliotheque.metier.TypeLivre;
import bibliotheque.mvc.observer.Subject;
import java.util.List;
import java.util.Set;

public abstract class DAOCD extends Subject {


    public abstract CD add( CD elt) ;

    public abstract boolean remove( CD elt) ;

    public abstract CD update(CD elt) ;

    public abstract CD read(CD rech) ;

    public abstract List<CD> getAll() ;


    public abstract Set<Ouvrage> listerOuvrages(CD a);

    public abstract List<Livre> listerLivre(CD a, TypeLivre tl) ;

    public abstract List<Ouvrage> listerOuvrages(CD a, String genre);

    public List<CD> getNotification(){
        return getAll();
    }
}