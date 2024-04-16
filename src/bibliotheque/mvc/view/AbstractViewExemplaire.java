package bibliotheque.mvc.view;

import bibliotheque.metier.Exemplaire;
import bibliotheque.mvc.controller.ExemplaireController;
import bibliotheque.mvc.observer.Observer;

import java.util.List;


public abstract  class AbstractViewExemplaire implements Observer {

    protected ExemplaireController ExemplaireController;
    protected List<Exemplaire> la;

    public void setController(ExemplaireController ExemplaireController) {
        this.ExemplaireController = ExemplaireController;
    }

    public abstract void menu();

    public abstract void affList(List la);

    public List<Exemplaire> getAll(){
        return la;
    }
    @Override
    public void update(List la) {
        this.la = la;
        affList(la);
    }
}
