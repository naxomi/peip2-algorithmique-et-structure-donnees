package tds.tableaux.correcteur;

import tds.tableaux.generique.TableauGenerique;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Un correcteur orthographique
 */
public class CorrecteurOrthographique {
    // lettres de l'alphabet (utile pour les corrections avec ajout de lettre)
    private static char[] ALPHABET = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    // le tableau générique créé à partir du dictionnaire
    TableauGenerique tableauDico;

    /* construit un correcteur orthographique à partir d'un fichier dictionnaire
    (via un LecteurDico)
     */
    public CorrecteurOrthographique(String fileName)  {
        LecteurDico ld = new LecteurDico(fileName);
        String[] dico = ld.getDico();
        this.tableauDico = new TableauGenerique(dico);
    }

    /** vrai si le mot existe dans le dictionnaire
     */
     boolean estCorrect(String mot) {
         int r = tableauDico.recherche(mot);
//         int rv = tableauDico.rechercheVite(mot);
//         System.out.println("*"+mot +"*"+ " " + r + " " + rv);
        return tableauDico.rechercheVite(mot)!=-1;
//        return tableauDico.recherche(mot)!=-1;

    }

    // renvoie le nombre de mots corrects dans le tableaux mots
    // affiche le temps nécessaire
     private int compteCorrect(String[] mots){
        int n=0;;
        long t1 = System.currentTimeMillis();
        for (String m :mots) {
            if (estCorrect(m)) n++;
        }
        long t2 = System.currentTimeMillis();
        System.out.println("temps pour compter les mots corrects :" + (t2-t1) + "ms");
        return n;
    }

    // pour découper les mots d'une phrase et les mettre dans un tableau
    private String[] phraseToTableau(String phrase) {
        // on découpe en fonction de la ponctuation et de " "
        StringTokenizer st = new StringTokenizer(phrase, " ,;:!.");
        String[] lesMots = new String[st.countTokens()];
        int i = 0;
        while (st.hasMoreTokens()) {
            lesMots[i++] = st.nextToken().toLowerCase();
        }
        System.out.println(Arrays.toString(lesMots));
        return lesMots;
    }

    // méthode publique pour compter le nombre de mots corrects dans une phrase
    public int compteCorrect(String phrase){
        return compteCorrect(phraseToTableau(phrase) );
    }

    // renvoie toutes les corrections possibles pour un mot
     public ArrayList<String> corrections(String m) {
        ArrayList res = new ArrayList();
        // addAll ajoute tous les éléments d'une ArrayList dans une autre
         res.addAll(corrigeEnleve(m));
        res.addAll(corrigeChange(m));
        res.addAll(corrigePermute(m));
        res.addAll(corrigeAjoute(m));
         return res;
    }

    // affiche que le mot est correct et sinon, affiche toutes les corrections possibles
    public void afficheCorrections(String phrase) {
        String[] lesMots =  phraseToTableau(phrase);
        for (String m : lesMots) {
            if (estCorrect(m))
                System.out.println(m + " ok");
            else {
                System.out.println("corrections possibles pour " + m + ":" + corrections(m));
            }
        }
    }

    // renvoie les corrections d'un mot en essayant de supprimer une de ses lettres
    ArrayList<String> corrigeEnleve(String mot) {
        ArrayList res = new ArrayList();
        for (int i= 0;i<mot.length();i++) {
            String essai = mot.substring(0,i) + mot.substring(i+1);
            if (!res.contains(essai)&&estCorrect(essai)) {
                res.add(essai);
            }
        }
        return res;
    }

    // renvoie les corrections d'un mot en essayant de remplacer une de ses lettres
    // par une des lettres de l'alphabet
     ArrayList<String> corrigeChange(String mot) {
        ArrayList res = new ArrayList();
        for (int i= 0;i<mot.length();i++) {
            for (char l : ALPHABET) {
                String essai = mot.substring(0, i) + l + mot.substring(i + 1);
                if (!res.contains(essai) && estCorrect(essai)) {
                    res.add(essai);
                }
            }
        }
        return res;
    }

    // renvoie les corrections d'un mot en essayant d'ajouter une des lettres de l'alphabet
    // à n'importe quelle position
     ArrayList<String> corrigeAjoute(String mot) {
        ArrayList res = new ArrayList();
        for (int i= 0;i<mot.length();i++) {
            for (char l : ALPHABET) {
                String essai = mot.substring(0, i) + l + mot.substring(i);
                if (!res.contains(essai) && estCorrect(essai)) {
                    res.add(essai);
                }
            }
        }
        return res;
    }

    // renvoie les corrections d'un mot en essayant de permuter 2 lettres voisines
     ArrayList<String> corrigePermute(String mot) {
        ArrayList res = new ArrayList();
        for (int i = 0; i < mot.length() - 1; i++) {
            String essai = mot.substring(0, i) + mot.charAt(i+1) + mot.charAt(i)  + mot.substring(i+2);
//            System.out.println(essai);
            if (!res.contains(essai) && estCorrect(essai)) {
                res.add(essai);
            }
        }
        return res;
    }
}
