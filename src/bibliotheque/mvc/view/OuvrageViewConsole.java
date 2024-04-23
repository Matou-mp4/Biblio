package bibliotheque.mvc.view;

import bibliotheque.metier.*;
import bibliotheque.mvc.GestionMVC;
import bibliotheque.mvc.controller.ControllerSpecialOuvrage;
import bibliotheque.mvc.model.ModelAuteur;
import bibliotheque.utilitaires.*;

import java.util.*;

import static bibliotheque.utilitaires.Utilitaire.*;


public class OuvrageViewConsole extends AbstractView<Ouvrage> {
    Scanner sc = new Scanner(System.in);


    @Override
    public void menu() {
        update(controller.getAll());
        List options = Arrays.asList("ajouter", "retirer", "rechercher","modifier","fin");
        do {
            int ch = choixListe(options);

            switch (ch) {
                case 1:
                    ajouter();
                    break;
                case 2:
                    retirer();
                    break;
                case 3:
                    rechercher();
                    break;
                case 4:
                    modifier();
                    break;
                case 5:
                    return;
            }
        } while (true);
    }

    private void retirer() {
        int nl = choixElt(la)-1;
        Ouvrage a = la.get(nl);
        boolean ok = controller.remove(a);
        if(ok) affMsg("ouvrage effacé");
        else affMsg("ouvrage non effacé");
    }

    private void affMsg(String msg) {
        System.out.println(msg);
    }


    public void rechercher() {
        int cpt = 1;
        System.out.println("Choisissez le type d'ouvrage souhaité : ");
        for (TypeOuvrage T : TypeOuvrage.values()) {
            System.out.println(cpt+".  "+T);
            cpt++;
        }
        System.out.println("Votre choix : ");
        int choix = sc.nextInt();
        List<Ouvrage> lo = new ArrayList<>();
        switch (choix){
            case 1 : lo = listParType(TypeOuvrage.LIVRE); break;
            case 2 : lo = listParType(TypeOuvrage.CD); break;
            case 3 : lo = listParType(TypeOuvrage.DVD); break;
            default: System.out.println("erreur"); break;
        }
        choix=choixListe(lo);
        System.out.println(lo.get(choix-1));

        //_TODO rechercher ouvrage en demandant type d'ouvrage, puis l'info unique relative à au type recherché
    }


    public void modifier() {
        int choix = choixElt(la);
        Ouvrage a = la.get(choix-1);
         do {
            try {
                double ploc =Double.parseDouble(modifyIfNotBlank("prix location",""+a.getPrixLocation()));
                a.setPrixLocation(ploc);
                break;
            } catch (Exception e) {
                System.out.println("erreur :" + e);
            }
        }while(true);
        controller.update(a);
   }


    public void ajouter() {
        TypeOuvrage[] tto = TypeOuvrage.values();
        List<TypeOuvrage> lto = new ArrayList<>(Arrays.asList(tto));
        int choix = Utilitaire.choixListe(lto);
        Ouvrage a = null;
        List<OuvrageFactory> lof = new ArrayList<>(Arrays.asList(new LivreFactory(),new CDFactory(),new DVDFactory()));
        a = lof.get(choix-1).create();
        List<Auteur> laut = GestionMVC.am.getAll();
        laut.sort(new Comparator<Auteur>() {
            @Override
            public int compare(Auteur o1, Auteur o2) {
                int c = o1.getNom().compareTo(o2.getNom());
                if (!(c == 0)) {
                    return c;
                } else {
                    return o1.getPrenom().compareTo(o2.getPrenom());
                }
            }
        });
        do{

            System.out.println("Votre choix : ");
            choix = choixListe(laut);
            a.addAuteur(laut.get(choix-1));
            laut.remove(choix-1);
            System.out.println("Ajouter un autre auteur : ");
            System.out.println("oui : 1");
            System.out.println("non : 2");
        }
        while(choix==1);
        //_TODO affecter un ou plusieurs auteurs
        //_TODO trier les auteurs présentés par ordre de nom et prénom  ==>  classe anonyme
        //_TODO ne pas présenter les auteurs déjà enregistrés pour cet ouvrage
        controller.add(a);
    }

    protected void special() {
        int choix =  choixElt(la);
        Ouvrage o = la.get(choix-1);

        List options = new ArrayList<>(Arrays.asList("lister exemplaires", "lister exemplaires en location", "lister exemplaires libres","fin"));
        do {
            int ch = choixListe(options);

            switch (ch) {

                case 1:
                    exemplaires(o);
                    break;
                case 2:
                    enLocation(o, true);
                    break;
                case 3:
                    enLocation(o, false);
                    break;

                case 4 :return;
            }
        } while (true);

    }

    public void enLocation(Ouvrage o, boolean enLocation) {
        List<Exemplaire> l= ((ControllerSpecialOuvrage) controller).listerExemplaire(o, enLocation);
        affList(l);
    }

    public void exemplaires(Ouvrage o) {
        List<Exemplaire> l= ((ControllerSpecialOuvrage)controller).listerExemplaire(o);
        affList(l);
    }
    public List<Ouvrage> listParType(TypeOuvrage t){
        List<Ouvrage> newListO = new ArrayList<>();
        for (Ouvrage l: la) {
            if(l.getTo()==t){
                newListO.add(l);
            }
        }
        return newListO;
    }
    @Override
    public void affList(List la) {
        affListe(la);
    }
}
