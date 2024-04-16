package bibliotheque.mvc.controller;

import bibliotheque.metier.Auteur;
import bibliotheque.metier.DVD;
import bibliotheque.mvc.model.DAODVD;
import bibliotheque.mvc.view.AbstractViewDVD;

import java.util.List;

public class DVDController {
    protected DAODVD model;
    protected AbstractViewDVD view;

    public DVDController(DAODVD model, AbstractViewDVD view) {
        this.model = model;
        this.view = view;
        this.view.setController(this);
    }
    public List<DVD> getAll(){
        List<DVD> l = model.getAll();
        return l;
    }

    public DVD add( DVD elt) {
        DVD nelt = model.add(elt);
        return nelt;
    }


    public boolean remove(DVD elt) {
        return model.remove(elt);
    }
    public DVD update(DVD elt) {
        return model.update(elt);
    }

    public DVD search(DVD rech) {
        return  model.read(rech);
    }
    public List<DVD> listerDVD(DVD dvd) {
        return model.listerDVD(dvd);
    }
}
