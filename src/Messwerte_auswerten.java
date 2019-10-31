import java.util.Scanner;
public class Messwerte_auswerten {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        float[] anz;
        float wert;

        anz = askMesswert(in);

        while (anz.length < 5 || anz.length > 40) {
            System.out.println("Geben Sie bitte eine Zahl aus dem Bereich 5 bis 40 ein");
            anz = askMesswert(in);
        }
        for (int i = 0; i < anz.length; i++) {

            wert = askWert(in);

            while (wert < -16 || wert > 27){
                System.out.println("Geben Sie bitte ein Messwert aus dem Bereich -16.0 bis 27.0 ein");
                wert = askWert(in);
            }
            anz[i] = wert;
        }
        System.out.println("Ihre Werte:");
        int n = 1;
        for (float i : anz) {
            System.out.print("Wert" + " " + (n++) + " " + "=" + " " + i + "; ");
        }
    }

    private static float askWert(Scanner in) {
        System.out.println("Geben Sie bitte ein Messwert ein");
        return in.nextFloat();
    }

    private static float[] askMesswert(Scanner in) {
        System.out.println("Wieviele Messwerte wollen Sie eingeben?");
        return new float[(int) in.nextFloat()];
    }
}



