
import java.util.ArrayList;

public class Recursivite {

    // exceptionnellement, tout est en static (pas beau ...)
    
    public  static int factorielle(int n) {
        return 0;        
    }

    public static int sommeCarreRec(int n){
        return 0;
    }

    public static int compte(String s, char l) {
        return 0;
    }

    private static ArrayList<String> permute(String s) {
        ArrayList<String> res = new ArrayList<String>();
        return res;
    }

    public static void main(String[] s) {
        System.out.println(factorielle(8));
        System.out.println(compte("abracadabra",'a'));
        System.out.println(compte("abracadabra",'i'));
        String s1 = "dur";
        ArrayList ps1 = permute(s1);
        System.out.println(ps1 + " "  + factorielle(s1.length())+ " " + ps1.size());
        String s2 = "plage";
        ArrayList ps2 = permute(s2);
        System.out.println(ps2 + " "  + factorielle(s2.length()) + " " + ps2.size());
    }
}

