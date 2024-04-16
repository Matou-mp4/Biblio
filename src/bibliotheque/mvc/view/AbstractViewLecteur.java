package bibliotheque.mvc.view;

import bibliotheque.metier.Lecteur;
import bibliotheque.mvc.controller.LecteurController;
import bibliotheque.mvc.observer.Observer;

import java.util.List;


public abstract  class AbstractViewLecteur implements Observer {

    protected LecteurController LecteurController;
    protected List<Lecteur> la;

    public void setController(LecteurController LecteurController) {
        this.LecteurController = LecteurController;
    }

    public abstract void menu();

    public abstract void affList(List la);

    public List<Lecteur> getAll(){
        return la;
    }
    @Override
    public void update(List la) {
        this.la = la;
        affList(la);
    }
}