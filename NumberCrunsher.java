import java.util.Arrays;
import java.util.Random;

/**
 * Klasse NumberCrunsher zum anwende der Funtionen
 *
 * @author Hussein Abbas & Samantha Maaß
 * @version 04.05.2019
 */
public class NumberCrunsher {
    private float[] zahlen;
    
    /**
     * Konstruktor zum anlegen eines arrays vom Typ float mit zufälligen zahlen
     * 
     * @param laenge (Int)
     * @return erstellt das Object
     */
    public NumberCrunsher(int laenge) {
        zahlen = new float[laenge];

        for (int i = 0; i < laenge; i++) {
            zahlen[i] = new Random().nextFloat();
        }
    }
    
    /**
     * Methode zum ausgeben des Arrays
     * 
     * @return array Ausgabe
     */
    public void printNumbers() {
        for (float f : this.zahlen) {
            System.out.println(f);
        }
    }
    
    /**
     * Anonyme Klassen mit Methoden
     * erklärung Methoden -> jeweilige Klasse
     * 
     * @param String array mit reihenfolge der Funktionen
     * @return wendet funktionen in richtiger Reihenfolge an
     */
    public void crunsh(String[] funktionen) {
        for (String s : funktionen) {
            Funktionen funktion;
            switch (s) {
                case "SUM":
                    funktion = new Funktionen() {
                        @Override
                        public float[] bearbeiten(float[] zahlen) {
                            for (int i = 1; i < zahlen.length; i++) {
                                zahlen[i] = zahlen[i] + zahlen[i - 1];
                            }

                            return zahlen;
                        }
                    };
                    break;
                case "SUBSTRACT":
                    funktion = new Funktionen() {
                        @Override
                        public float[] bearbeiten(float[] zahlen) {
                            for (int i = 1; i < zahlen.length; i++) {
                                zahlen[i] = zahlen[i] - zahlen[i - 1];
                            }

                            return zahlen;
                        }
                    };
                    break;
                case "AVERAGE":
                    funktion = new Funktionen() {
                        @Override
                        public float[] bearbeiten(float[] zahlen) {
                            float durschnitt = 0;
                            int pos = 0;

                            for (int i = 0; i < zahlen.length; i++) {
                                durschnitt += zahlen[i];

                                if (zahlen[i] > zahlen[pos])
                                    pos = i;
                            }

                            zahlen[pos] = durschnitt / zahlen.length;

                            return zahlen;
                        }
                    };
                    break;
                case "DIVIDE":
                    funktion = new Funktionen() {
                        @Override
                        public float[] bearbeiten(float[] zahlen) {
                            float[] sotiert = zahlen.clone();
                            float zahl;
                            Arrays.sort(sotiert);

                            for (int i = 0; i <= sotiert.length / 2; i++) {
                                zahl = sotiert[sotiert.length - 1 - i] / sotiert[i];

                                zahlen[indexof(sotiert[sotiert.length - 1 - i], zahlen)] = zahl;

                            }

                            return zahlen;


                        }

                        public int indexof(float zahl, float[] zahlen) {
                            for (int i = 0; i < zahlen.length; i++) {
                                if (zahlen[i] == zahl)
                                    return i;
                            }

                            return -1;
                        }
                    };
                    break;
                case "SWIRL":
                    funktion = new Funktionen() {
                        @Override
                        public float[] bearbeiten(float[] zahlen) {
                            int n = zahlen.length;

                            for (int i = 1; i <= n; i++) {
                                int zahl1 = (int) (Math.random() * n);
                                int zahl2 = (int) (Math.random() * n);

                                zahlen[zahl1] = zahlen[zahl2];
                            }

                            return zahlen;
                        }
                    };
                    break;
                default:
                    throw new IllegalArgumentException();
            }
            this.zahlen = funktion.bearbeiten(this.zahlen);
        }
    }


}