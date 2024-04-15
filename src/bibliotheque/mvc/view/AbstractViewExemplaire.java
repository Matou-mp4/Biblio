package bibliotheque.mvc.view;

import bibliotheque.metier.Auteur;
import bibliotheque.metier.Exemplaire;
import bibliotheque.mvc.controller.AuteurController;
import bibliotheque.mvc.controller.ExemplaireController;
import bibliotheque.mvc.observer.Observer;

import java.util.List;

public abstract class AbstractViewExemplaire implements Observer {
    protected ExemplaireController exemplaireController;
    protected List<Exemplaire> lex;

    public void setExemplaireController(ExemplaireController exemplaireController) {
        this.exemplaireController = exemplaireController;
    }

    public void setLex(List<Exemplaire> lex) {
        this.lex = lex;
    }
    public abstract void menu();

    public abstract void affList(List lex);

    @Override
    public void update(List lex) {
        this.lex=lex;
        affList(lex);
    }
}
