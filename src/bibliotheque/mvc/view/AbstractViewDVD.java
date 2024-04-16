package bibliotheque.mvc.view;

import bibliotheque.metier.DVD;
import bibliotheque.mvc.controller.DVDController;
import bibliotheque.mvc.observer.Observer;

import java.util.List;


public abstract  class AbstractViewDVD implements Observer {

    protected DVDController DVDController;
    protected List<DVD> la;

    public void setController(DVDController DVDController) {
        this.DVDController = DVDController;
    }

    public abstract void menu();

    public abstract void affList(List la);

    public List<DVD> getAll(){
        return la;
    }
    @Override
    public void update(List la) {
        this.la = la;
        affList(la);
    }
}
