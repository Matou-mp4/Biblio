package bibliotheque.mvc.view;

import bibliotheque.metier.CD;
import bibliotheque.mvc.controller.CDController;
import bibliotheque.mvc.observer.Observer;

import java.util.List;


public abstract  class AbstractViewCD implements Observer {

    protected CDController CDController;
    protected List<CD> la;

    public void setController(CDController CDController) {
        this.CDController = CDController;
    }

    public abstract void menu();

    public abstract void affList(List la);

    public List<CD> getAll(){
        return la;
    }
    @Override
    public void update(List la) {
        this.la = la;
        affList(la);
    }
}
