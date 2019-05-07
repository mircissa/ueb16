
/**
 * Klasse Average.
 *
 * @author Hussein Abbas & Samantha Maaß
 * @version 04.05.2019
 */
public class Average implements Funktionen {
    /**
     * Leerer Konstruktor
     */
    public Average() {
    }
    
    /**
     * Methode Average
     * Betimmt den Durshcnitt aller Werte im Array und speichert den Durschnittswert
     * im Datenfeld mit dem größten Wert
     * 
     * @param float array
     * @return array nach Average
     * 
     */
    @Override
    public float[] bearbeiten(float[] zahlen) {
        float durschnitt = 0;
        int pos = 0;

        for (int i = 0; i < zahlen.length; i++) {
            durschnitt = durschnitt + zahlen[i];

            if (zahlen[i] > zahlen[pos])
                pos = i;
        }

        zahlen[pos] = durschnitt / zahlen.length;

        return zahlen;
    }
}
