package bibliotheque.mvc.model;

import bibliotheque.metier.Lecteur;
import bibliotheque.metier.Livre;
import bibliotheque.metier.Ouvrage;
import bibliotheque.metier.TypeLivre;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LecteurModel extends DAOLecteur {

    private List<Lecteur> ldatas = new ArrayList<>();


    @Override
    public Lecteur add( Lecteur elt) {
        boolean present =ldatas.contains(elt);
        if (!present) {
            ldatas.add(elt);
            notifyObservers();
            return elt;
        } else return null;
    }

    @Override
    public boolean remove( Lecteur elt) {
        boolean ok = ldatas.remove(elt);
        notifyObservers();
        return ok;
    }

    @Override
    public Lecteur update(Lecteur elt) {
        int p = ldatas.indexOf(elt);
        if (p < 0) return null;
        ldatas.set(p, elt);
        notifyObservers();
        return elt;
    }

    @Override
    public Lecteur read(Lecteur rech) {
        int p = ldatas.indexOf(rech);
        if(p<0) return null;
        return ldatas.get(p);
    }

    @Override
    public List<Lecteur> getAll() {
        return ldatas;
    }

    @Override
    public Set<Ouvrage> listerOuvrages(Lecteur a) {
        return a.listerOuvrages();
    }

    @Override
    public List<Livre> listerLivre(Lecteur a, TypeLivre tl) {
        return a.listerLivres(tl);
    }

    @Override
    public List<Ouvrage> listerOuvrages(Lecteur a, String genre) {
        return a.listerOuvrages(genre);
    }
}
