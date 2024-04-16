package bibliotheque.mvc.view;

import bibliotheque.metier.Exemplaire;
import bibliotheque.metier.TypeLivre;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static bibliotheque.utilitaires.Utilitaire.*;


public class ExemplaireViewConsole extends AbstractViewExemplaire {
    Scanner sc = new Scanner(System.in);


    @Override
    public void menu() {
        update(ExemplaireController.getAll());
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
        Exemplaire a = la.get(nl);
        boolean ok = ExemplaireController.remove(a);
        if(ok) affMsg("Exemplaire effacé");
        else affMsg("Exemplaire non effacé");
    }

    private void affMsg(String msg) {
        System.out.println(msg);
    }


    public void rechercher() {
        try {
            System.out.println(" ");
            String nom = sc.nextLine();
            System.out.println("prénom ");
            String prenom = sc.nextLine();
            System.out.println("nationalité");
            String nat = sc.nextLine();
            Exemplaire rech = new Exemplaire(nom, prenom, nat);
            Exemplaire a = ExemplaireController.search(rech);
            if(a==null) affMsg("Exemplaire inconnu");
            else {
                affMsg(a.toString());
                //special(a);
            }
        }catch(Exception e){
            System.out.println("erreur : "+e);
        }

    }


    public void modifier() {
        int choix = choixElt(la);
        Exemplaire a = la.get(choix-1);
        do {
            try {
                long code = sc.nextLong();
                byte nbrePlages = sc.nextByte();
                //LocalTime dureeTotale =sc.nextLine();
                a.setCode(code);
                a.setNbrePlages(nbrePlages);
                //a.setDureeTotale(dureeTotale);
                break;
            } catch (Exception e) {
                System.out.println("erreur :" + e);
            }
        }while(true);
        ExemplaireController.update(a);
    }


    public void ajouter() {
        Exemplaire a;
        do {
            try {
                System.out.println("nom ");
                String nom = sc.nextLine();
                System.out.println("prénom ");
                String prenom = sc.nextLine();
                System.out.println("nationalité");
                String nat = sc.nextLine();
                a = new Exemplaire(nom, prenom, nat);
                break;
            } catch (Exception e) {
                System.out.println("une erreur est survenue : "+e.getMessage());
            }
        }while(true);
        ExemplaireController.add(a);
    }

//    public void special(Exemplaire a) {
//
//        List options = Arrays.asList("lister ouvrages", "lister livres", "lister par genre","fin");
//        do {
//            int ch = choixListe(options);
//
//            switch (ch) {
//
//                case 1:
//                    listerOuvrages(a);
//                    break;
//                case 2:
//                    listerLivres(a);
//                    break;
//                case 3:
//                    listerGenre(a);
//                    break;
//                case 4 :return;
//            }
//        } while (true);
//
//    }
//
//
////    public void listerGenre(Exemplaire a) {
////        System.out.println("genre :");
////        String genre = sc.nextLine();
////        affListe(new ArrayList(ExemplaireController.listerOuvrages(a,genre)));
////    }
//
//
//    public void listerOuvrages(Exemplaire a){
//        affList(new ArrayList(ExemplaireController.listerOuvrages(a)));
//    }
//
//
//    public void listerLivres(Exemplaire a){
//        TypeLivre[] tlv = TypeLivre.values();
//        int ch2 = choixListe(List.of(tlv));
//        TypeLivre tl = tlv[ch2-1];
//        affList(new ArrayList(ExemplaireController.listerLivre(a,tl)));
//    }

    @Override
    public void affList(List la) {
        affListe(la);
    }
}

