
/**
 * Klasse Substract
 *
 * @author Hussein Abbas & Samantha Maaß
 * @version 04.05.2019
 */
public class Substract implements Funktionen {
    /**
     * Leerer Konstruktor
     */
    public Substract() {
    }
    
    /**
     * Methode Subtrahieren
     * Subtrahiert die Elemte des Arrays paarweise von links nach recht auf und speichert 
     * den neuen Wert in dem jeweils rechten Datenfeld
     * -> a[1] = a[0] - a[1]; a[2] = a[1] - a[2] usw.
     * 
     * @param float Array
     * @return Array nach der subtraktion
     */
    @Override
    public float[] bearbeiten(float[] zahlen) {
        for (int i = 1; i < zahlen.length; i++) {
            zahlen[i] = zahlen[i] - zahlen[i - 1];
        }

        return zahlen;
    }
}
