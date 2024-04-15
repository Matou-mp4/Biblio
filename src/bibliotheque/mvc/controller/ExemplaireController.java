package bibliotheque.mvc.controller;

import bibliotheque.mvc.model.DAOExemplaire;
import bibliotheque.mvc.view.AbstractViewAuteur;
import bibliotheque.mvc.view.AbstractViewExemplaire;

public class ExemplaireController {
    protected DAOExemplaire model;
    protected AbstractViewExemplaire view;

    public ExemplaireController(DAOExemplaire model, AbstractViewExemplaire view) {
        this.model = model;
        this.view = view;
        this.view.setController(this);
    }

}
