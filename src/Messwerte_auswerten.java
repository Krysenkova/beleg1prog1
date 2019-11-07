import java.util.Scanner;
import java.lang.Math;

public class Messwerte_auswerten {

    public static void main(String[] args) {

        String weiterend;
        do {

            System.out.println("Messwerte auswerten Programm");

            Scanner in = new Scanner(System.in);
            double[] anz;
            double wert;

            anz = askMesswert(in);

            while (anz.length < 5 || anz.length > 40) {
                System.out.println("Geben Sie bitte eine Zahl aus dem Bereich 5 bis 40 ein");
                anz = askMesswert(in);
            }

            System.out.println("Wollen Sie mit Zufallszahlen arbeiten? (j/n)");
            String decision = in.next();
            if (decision.equals("j")) {
                for (int i = 0; i < anz.length; i++) {
                    double max = 27.0;
                    double min = -16.0;
                    double range = max - min + 1;
                    double zufall = (Math.random() * range) + min;
                    anz[i] = zufall;
                }

            } else

                for (int i = 0; i < anz.length; i++) {
                    wert = askWert(in);

                    while (wert < -16 || wert > 27) {
                        System.out.println("Geben Sie bitte ein Messwert aus dem Bereich -16.0 bis 27.0 ein");
                        wert = askWert(in);
                    }
                    anz[i] = wert;
                }
            double mittelwert = 0.0;
            double sum = 0.0;
            for (double v : anz) {
                sum = sum + v;
                mittelwert = sum / anz.length;
            }

            double quadAbw = 0.0;
            double streuung = 0.0;
            for (double v : anz) {
                quadAbw = (((v - mittelwert) * (v - mittelwert)) / (anz.length - 1.0) + quadAbw);
                streuung = Math.sqrt(quadAbw);
            }

            int neg = 0;
            for (double v : anz) {
                if (v < 0) neg++;
            }

            double kleinste = anz[0];
            double groesste = anz[0];
            for (int i = 1; i < anz.length; i++) {
                if (anz[i] > groesste)
                    groesste = anz[i];
                else if (anz[i] < kleinste)
                    kleinste = anz[i];
            }

            System.out.println(" ");
            System.out.println("Ihre Werte:");
            int n = 1;
            for (double i : anz) {
                System.out.print("Wert" + " " + (n++) + " " + "=" + " " + i + "| ");
                if (n % 9 == 0)
                    System.out.println();
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
            System.out.println("Die  Streuung ist:" + streuung);

            System.out.println(" ");
            System.out.println("Die Anzahl der negativen Messwete ist " + neg);

            System.out.println(" ");
            System.out.println("Wollen Sie mit anderen Messwerten fortfahren? (j/n)");
            weiterend = in.next();

        } while (weiterend.equals("j"));
    }

    private static double askWert(Scanner in) {
        System.out.println("Geben Sie bitte ein Messwert ein");
        return in.nextFloat();
    }


    private static double[] askMesswert(Scanner in) {
        System.out.println("Wieviele Messwerte wollen Sie eingeben?");
        return new double[(int) in.nextFloat()];
    }

    private static int position(double[] anz, double t) {
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





