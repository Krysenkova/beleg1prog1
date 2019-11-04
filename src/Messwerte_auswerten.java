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

            while (wert < -16 || wert > 27) {
                System.out.println("Geben Sie bitte ein Messwert aus dem Bereich -16.0 bis 27.0 ein");
                wert = askWert(in);
            }
            anz[i] = wert;
        }
        float mittelwert = (float) 0.0;
        float sum = (float) 0.0;
        float quadAbw = 0;
        for (int i = 0; i < anz.length; i++) {
            sum = sum + anz[i];
            mittelwert = sum / anz.length;
            }

        quadAbw = (float) 0.0;
        for (int i = 0; i < anz.length; i++) {
            quadAbw = (float) (((anz[i] - mittelwert) * (anz[i] - mittelwert)) / (anz.length - 1.0));
        }

        int neg = 0;
        for(int i = 0; i < anz.length; i++) {
            if (anz[i] < 0) neg++;
        }

        float kleinste = anz[0];
        float groesste = anz[0];
        for (int i = 1; i < anz.length; i++) {
            if (anz[i] > groesste)
                groesste = anz[i];
            else if (anz[i] < kleinste)
                kleinste = anz[i];
        }

        System.out.println(" ");
        System.out.println("Ihre Werte:");
        int n = 1;
        for (float i : anz) {
            System.out.print("Wert" + " " + (n++) + " " + "=" + " " + i + "; ");
        }
        System.out.println(" ");

        System.out.println(" ");
        System.out.println("Der größte Messwert ist " + groesste);
        System.out.println("Der kleinste Messwert ist " + kleinste);

        System.out.println(" ");
        System.out.println("Der Position von " + groesste + " ist " + position(anz, groesste));
        System.out.println("Der Position von " + kleinste + " ist " + position(anz, kleinste));

        System.out.println(" ");
        System.out.println("Die Mittelwert ist: " + mittelwert);
        System.out.println("Die  Streuung ist:" + quadAbw);

        System.out.println(" ");
        System.out.println("Die Anzahl der negativen Messwete ist " + neg);
    }

    private static float askWert(Scanner in) {
        System.out.println("Geben Sie bitte ein Messwert ein");
        return in.nextFloat();
    }


    private static float[] askMesswert(Scanner in) {
        System.out.println("Wieviele Messwerte wollen Sie eingeben?");
        return new float[(int) in.nextFloat()];
    }

    private static int position(float[] anz, float t) {
        if (anz == null) return -1;
        int length = anz.length;
        int i = 0;
        while (i < length) {
            if (anz[i] == t) return i;
            else i = i + 1;
        }
        return -1;
    }
}





