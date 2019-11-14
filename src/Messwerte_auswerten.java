import java.util.Scanner;
import java.lang.Math;

public class Messwerte_auswerten {

    public static void main(String[] args) {

        System.out.println("Messwerte auswerten Programm");

        String weiterend;

        do {   //do-while starts the program from the beginning when the user asks do to so

            Scanner in = new Scanner(System.in);
            double[] anz;
            double wert;

            anz = askMesswert(in); //calls the method to scan user's numbers to fill an array

            while (anz.length < 5 || anz.length > 40) { //checks if the number of values is correct
                System.out.println("Geben Sie bitte eine Zahl aus dem Bereich 5 bis 40 ein");
                anz = askMesswert(in);
            }

            System.out.println("Wollen Sie mit Zufallszahlen arbeiten? (j/n)");
            String decision = in.next();
            if (decision.equals("j")) {
                for (int i = 0; i < anz.length; i++) {
                    double max = 27.0;
                    double min = -16.0;
                    double range = max - min;
                    double zufall = (Math.random() * range) + min;
                    anz[i] = zufall; //fills an array with random numbers from -16 till 27 when the answer is j
                }

            } else // executes when the user wants to give values him/herself

                for (int i = 0; i < anz.length; i++) {
                    wert = askWert(in); // calls the method to scan values that the user prints in

                    while (wert < -16 || wert > 27) { //checks if the values are in correct range
                        System.out.println("Geben Sie bitte ein Messwert aus dem Bereich -16.0 bis 27.0 ein");
                        wert = askWert(in);
                    }
                    anz[i] = wert; //creates an array with values
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
                quadAbw = ((((v - mittelwert) * (v - mittelwert)) / (anz.length - 1.0)) + quadAbw);
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
                System.out.printf("Wert %2d ist %5.1f | ", n++, i);
                if (n % 8 == 1)
                    System.out.println();
            }
            System.out.println(" ");

            System.out.println(" ");
            System.out.printf("Der größte Messwert ist %.1f%n", groesste);
            System.out.printf("Der kleinste Messwert ist %.1f%n", kleinste);

            int minposition = position(anz, kleinste) + 1;
            int maxposition = position(anz, groesste) + 1;
            System.out.println(" ");
            System.out.printf("Der Position von %.1f",groesste);
            System.out.println(" ist " + maxposition);
            System.out.printf("Der Position von %.1f", kleinste);
            System.out.println(" ist " + minposition);

            System.out.println(" ");
            System.out.printf("Die Mittelwert ist %.1f%n", mittelwert);
            System.out.printf("Die Streuung ist %.6f%n", streuung);

            System.out.println(" ");
            System.out.println("Die Anzahl der negativen Messwete ist " + neg);

            System.out.println(" ");
            System.out.println("Wollen Sie mit anderen Messwerten fortfahren? (j/n)");
            weiterend = in.next();

        } while (weiterend.equals("j")); //when the answer is j, refers to the do section and starts the program again
    }

    private static double askWert(Scanner in) {
        System.out.println("Geben Sie bitte ein Messwert ein");
        return in.nextFloat();
    }


    /**
     * @param in Scanner for getting values from the user
     * @return array which...
     */
    private static double[] askMesswert(Scanner in) {
        System.out.println("Wie viele Messwerte wollen Sie eingeben?");
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





