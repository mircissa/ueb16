
/**
 * Klasse Swirl.
 *
 * @author Hussein Abbas & Samantha Maaß
 * @version 04.05.2019
 */
public class Swirl implements Funktionen {
     /**
     * Leerer Konstruktor
     */
    public Swirl() 
    {
    }
    
    /**
     * Methode Swirl
     * Führt n (n = laenge des Array) zufällige Verwechslungen der Dtenfelder durch
     *
     * @param float Array
     * @return Array nach Verwechslung
     */
    @Override
    public float[] bearbeiten(float[] zahlen) {
        int n = zahlen.length;

        for (int i = 1; i <= n; i++) {
            int zahl1 = (int) ((Math.random() * n));
            int zahl2 = (int) ((Math.random() * n));

            zahlen[zahl1] = zahlen[zahl2];
        }

        return zahlen;
    }

}
