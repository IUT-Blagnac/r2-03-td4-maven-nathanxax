
/**
 * Exemple de menu
 *
 * 
 */

import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.text.*;

public class Menu {

    // texte du menu
    public static String[][] promo = null;
    public static int nbItemMenu = 3;
    public static String texteMenu = "\n/**********************************************/\n"
            + "\t\t\tSelectionner\n\t\t1 - un etudiant sauf dernier selectionne\n"
            + "\t\t2 - un etudiant dans la promo\n" + "\t\t3 - affiche la promo\n\t\t0 - Quitter\n"
            + "/**********************************************/\n\n";

    /**
     * permet de retourner une valeur entiere saisie au clavier comprise entre
     * pfBorneInf et pfBorneSup
     * 
     * @param pfBorneSup In la borne sup
     * @param pfBorneInf In la borne inf
     * @param pfMessage  In message à afficher
     * @return valeur entiere comprise entre pfBorneInf et pfBorneSup
     **/
    public static int saisieIntC(int pfBorneInf, int pfBorneSup, String pfMessage) {
        int valeur;
        Scanner clavier = new Scanner(System.in);
        System.out.print(pfMessage);

        valeur = clavier.nextInt();
        while (valeur < pfBorneInf || valeur > pfBorneSup) {
            System.out.println(pfMessage);
            System.out.print("Erreur ! Donnez une valeur comprise " + pfBorneInf + " et " + pfBorneSup + "?");
            valeur = clavier.nextInt();
        }
        return valeur;
    }

    /**
     * traite le choix 1
     * 
     * @param vous pouvez en ajouter
     * @return un étudiant correspondant aux critères
     **/
    public static String[] traiterChoix1() {
        String etu[] = { "truc", "bidule" };
        System.out.println("selection d'un etudiant  sauf dernier selectionne...à faire");
        return etu;
    }

    /**
     * traite le choix 2
     * 
     * @param vous pouvez en ajouter
     * @return un étudiant correspondant aux critères
     **/
    public static String[] traiterChoix2() {
        String etu[] = { "truc", "bidule" };
        System.out.println("selection d'un etudiant dans la promo...à faire");
        return etu;
    }

    /**
     * affiche le menu et exécute les choix...
     * 
     * @param vous pouvez en ajouter
     * @return un étudiant correspondant aux critères
     **/
    public static void testMenu() {

        int choixUtilisateur;
        String etu[];
        do {
            System.out.println(texteMenu);
            choixUtilisateur = saisieIntC(0, nbItemMenu, "Choisir ");

            try {
                switch (choixUtilisateur) {
                    case 3:
                        // ecrire un sp
                        /* afficher promo */
                        for (int i = 0; i < ListeEtudiants.nbEtudiant(promo); i++) {

                            System.out.println("etu : " + (i + 1) + "\t" + promo[i][0] + "\t" + promo[i][1]);
                        }

                        break;
                    case 2:
                        // ecrire un sp
                        etu = traiterChoix2();
                        break;
                    case 1:
                        etu = traiterChoix1();
                        break;
                    case 0:
                        System.out.println("AU REVOIR ...   ...\n");

                        break;
                    default:
                        System.out.println("\n\n\nBIZARRE ... \n\n\n");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Erreur: " + e.getMessage());
            }
        } while (choixUtilisateur != 0);

    }

    public static void main(String arguments[]) {

        try {

            promo = ListeEtudiants.getListe("listenomssansaccent.csv", ","); // appel du sous programme précédé du nom
                                                                             // de la classe où elle est définie

            System.out.println("Il y a : " + ListeEtudiants.nbEtudiant(promo) + " etudiants");
            testMenu();

        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());

        }

    } // fin main
}
