package bibliotheque.mvc.model;

import bibliotheque.metier.Mail;
import bibliotheque.metier.Livre;
import bibliotheque.metier.Ouvrage;
import bibliotheque.metier.TypeLivre;
import bibliotheque.mvc.observer.Subject;
import java.util.List;
import java.util.Set;

public abstract class DAOMail extends Subject {


    public abstract Mail add( Mail elt) ;

    public abstract boolean remove( Mail elt) ;

    public abstract Mail update(Mail elt) ;

    public abstract Mail read(Mail rech) ;

    public abstract List<Mail> getAll() ;


    public abstract Set<Ouvrage> listerOuvrages(Mail a);

    public abstract List<Livre> listerLivre(Mail a, TypeLivre tl) ;

    public abstract List<Ouvrage> listerOuvrages(Mail a, String genre);

    public List<Mail> getNotification(){
        return getAll();
    }
}
