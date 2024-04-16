package bibliotheque.mvc.model;

import bibliotheque.metier.Mail;
import bibliotheque.metier.Livre;
import bibliotheque.metier.Ouvrage;
import bibliotheque.metier.TypeLivre;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MailModel extends DAOMail {

    private List<Mail> ldatas = new ArrayList<>();


    @Override
    public Mail add( Mail elt) {
        boolean present =ldatas.contains(elt);
        if (!present) {
            ldatas.add(elt);
            notifyObservers();
            return elt;
        } else return null;
    }

    @Override
    public boolean remove( Mail elt) {
        boolean ok = ldatas.remove(elt);
        notifyObservers();
        return ok;
    }

    @Override
    public Mail update(Mail elt) {
        int p = ldatas.indexOf(elt);
        if (p < 0) return null;
        ldatas.set(p, elt);
        notifyObservers();
        return elt;
    }

    @Override
    public Mail read(Mail rech) {
        int p = ldatas.indexOf(rech);
        if(p<0) return null;
        return ldatas.get(p);
    }

    @Override
    public List<Mail> getAll() {
        return ldatas;
    }

    @Override
    public Set<Ouvrage> listerOuvrages(Mail a) {
        return a.listerOuvrages();
    }

    @Override
    public List<Livre> listerLivre(Mail a, TypeLivre tl) {
        return a.listerLivres(tl);
    }

    @Override
    public List<Ouvrage> listerOuvrages(Mail a, String genre) {
        return a.listerOuvrages(genre);
    }
}
