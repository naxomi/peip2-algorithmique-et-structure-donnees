package tds.complexite;

/***
 * classe pour les exercices sur la complexité / validité
 * ce n'est pas de la belle programmation objet, juste un classe pour faire des tests ...
 */
public class ValiditeComplexite {


    // fonction mystere
    // POSTCONDITION: renvoie res[[n:0]]
    String mystere(String m) {
        String res = "";
        int i=0;
        while (i<m.length()) {
            // P1: propriété sur m, i, et res pour assurer la validité
            // res[0:i] contient m[0:i] à l'envers
            res=m.charAt(i)+res;
            // P2: propriété sur i pour assurer la terminaison
            // i part de 0 et croît de 1 à chaque étape
            i++;
        }
        return res;
    }

    // verson récursive de mystere
    String mystereRec(String m){
        if (m.length()==1) return m;
        return m.charAt(m.length()-1) + mystereRec(m.substring(0,m.length()-1));
    }

    // répétition de c en fonction de n
    // complexite : n^2
    String repete1(char c,int n) {
        String res="";
        for (int i=0;i<n;i++) {
            for (int j = 0; j < n; j++)
                res += c;
        }
        return res;
    }

    // répétition de c en fonction de n
    // complexite : n^2
    String repete2(char c,int n) {
        String res="";
        for (int i=0;i<n;i++) {
            for (int j = 0; j < i; j++) {
                res += c;
            }
        }
        return res;
    }

    // renvoie vrai si c est un palindrome
    // complexite : c.length()
    public boolean palindrome(String c) {
        int i = 0;
        int j = c.length()-1;
        while ((i<j) && c.charAt(i)==c.charAt(j)) {
// P : si C1 est la sous-chaine de c allant de l’indice 0 `a l’indice i-1
// : si C2 est la sous-chaine de c allant de l’indice j+1 `a l’indice c.length()-1
// : alors C1C2 est un palindrome
            System.out.println(c.substring(0,i)+c.substring(j+1));
            i++;
            j--;
        }
        return i>=j;
    }



    public static void main(String[] s) {
        ValiditeComplexite vc = new ValiditeComplexite();

        System.out.println(vc.mystere("Bonjour"));
        System.out.println(vc.mystereRec("Bonjour"));

        System.out.println(vc.repete1('a',4));
        System.out.println(vc.repete2('a',4));

        System.out.println(vc.palindrome("ressasser"));
        System.out.println(vc.palindrome("épater  retapé"));
    }

}
