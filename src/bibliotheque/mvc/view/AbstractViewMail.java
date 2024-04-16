package bibliotheque.mvc.view;

import bibliotheque.metier.Mail;
import bibliotheque.mvc.controller.MailController;
import bibliotheque.mvc.observer.Observer;

import java.util.List;


public abstract  class AbstractViewMail implements Observer {

    protected MailController MailController;
    protected List<Mail> la;

    public void setController(MailController MailController) {
        this.MailController = MailController;
    }

    public abstract void menu();

    public abstract void affList(List la);

    public List<Mail> getAll(){
        return la;
    }
    @Override
    public void update(List la) {
        this.la = la;
        affList(la);
    }
}

