package bibliotheque.mvc.model;

import bibliotheque.metier.*;
import bibliotheque.mvc.observer.Subject;
import java.util.List;
import java.util.Set;

public abstract class DAOExemplaire extends Subject {
    public abstract Exemplaire add(Exemplaire elt) ;

    public abstract boolean remove( Exemplaire elt) ;

    public abstract Exemplaire update(Exemplaire elt) ;

    public abstract Exemplaire read(Exemplaire rech) ;

    public abstract List<Exemplaire> getAll() ;


    public List<Exemplaire> getNotification(){
        return getAll();
    }
}
