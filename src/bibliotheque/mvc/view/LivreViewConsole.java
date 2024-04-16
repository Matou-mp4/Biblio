package bibliotheque.mvc.view;

import bibliotheque.metier.Livre;
import bibliotheque.metier.TypeLivre;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static bibliotheque.utilitaires.Utilitaire.*;


public class LivreViewConsole extends AbstractViewLivre {
    Scanner sc = new Scanner(System.in);


    @Override
    public void menu() {
        update(LivreController.getAll());
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
        Livre a = la.get(nl);
        boolean ok = LivreController.remove(a);
        if(ok) affMsg("Livre effacé");
        else affMsg("Livre non effacé");
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
            Livre rech = new Livre(nom, prenom, nat);
            Livre a = LivreController.search(rech);
            if(a==null) affMsg("Livre inconnu");
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
        Livre a = la.get(choix-1);
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
        LivreController.update(a);
    }


    public void ajouter() {
        Livre a;
        do {
            try {
                System.out.println("nom ");
                String nom = sc.nextLine();
                System.out.println("prénom ");
                String prenom = sc.nextLine();
                System.out.println("nationalité");
                String nat = sc.nextLine();
                a = new Livre(nom, prenom, nat);
                break;
            } catch (Exception e) {
                System.out.println("une erreur est survenue : "+e.getMessage());
            }
        }while(true);
        LivreController.add(a);
    }

//    public void special(Livre a) {
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
////    public void listerGenre(Livre a) {
////        System.out.println("genre :");
////        String genre = sc.nextLine();
////        affListe(new ArrayList(LivreController.listerOuvrages(a,genre)));
////    }
//
//
//    public void listerOuvrages(Livre a){
//        affList(new ArrayList(LivreController.listerOuvrages(a)));
//    }
//
//
//    public void listerLivres(Livre a){
//        TypeLivre[] tlv = TypeLivre.values();
//        int ch2 = choixListe(List.of(tlv));
//        TypeLivre tl = tlv[ch2-1];
//        affList(new ArrayList(LivreController.listerLivre(a,tl)));
//    }

    @Override
    public void affList(List la) {
        affListe(la);
    }
}

