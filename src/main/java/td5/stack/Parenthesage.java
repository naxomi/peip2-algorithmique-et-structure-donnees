package td5.stack;

/**
 * exemple d'utilisation d'une pile pour le parenthésage
 */
public class Parenthesage {

    String phrase;

    public Parenthesage(String phrase) {
        this.phrase = phrase;
    }

    // renvoie le caractère qui ferme un ouvrant
    private static char ferme(char d) {
        switch (d) {
            case '(':
                return ')';
            case '[':
                return ']';
            default:
                return '}';
        }
    }

    // vrai si s est un délimiteur ouvrant
    private static boolean estOuvrant(char s) {
        return s == '(' | s == '{' | s == '[';
    }

    // vrai si s est un délimiteur fermant
    private static boolean estFermant(char s) {
        return s == ')' | s == '}' | s == ']';
    }

    // vérifie les parenthèses
    public boolean verificationParen() {
        return verifieLeDelimiteur('(');
    }

    // vérifie les []
    public boolean verificationCrochet() {
        return verifieLeDelimiteur('[');
    }

    // vérifie les {}
    public boolean verificationAcco() {
        return verifieLeDelimiteur('{');
    }

    // vérifie uniquement le delimiteur "delimiteur"
    private boolean verifieLeDelimiteur(char delimiteur) {
        // a compléter
        return false;
    }

    // verifie les 3 délimiteurs mais ne tient pas compte
    //  des intercroisements ([)] est considéré comme OK alors que c'est KO
    public boolean verificationKO() {
        // à compléter. Utillise 3 compteurs
        return false;
    }

    // verification OK : version avec la pile java
    public boolean verification() {
        // à compléter
        return false;
    }

    // verification OK : version avec la pile maison
    public boolean verificationMaison() {
        // à compléter
        // idem verification mais en utilisant votre propre pile
        return false;
    }

}
