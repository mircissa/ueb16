import java.util.Arrays;

/**
 * Klasse Divide.
 *
 * @author Hussein Abbas & Samantha Maaß
 * @version 04.05.2019
 */
public class Divide implements Funktionen {
    /**
     * Leerer Konstruktor
     */
    public Divide()
    {
    }
    
    /**
     * Methode Dividieren
     * Teild dir n/2 größten Werte im Array durch die n/2 kleinsten und speichert 
     * den neuen Wert im Datenfeld des jeweils größerem Wertes.
     * -> größter Wert / kleinster Wert; zweitgrößter Wert / zweitkleinster Wert; usw.
     * 
     * @param float Array
     * @return Array nach division
     */
    @Override
    public float[] bearbeiten(float[] zahlen) {
        float[] sotiert = zahlen.clone();
        float zahl;
        Arrays.sort(sotiert);

        for (int i = 0; i <= sotiert.length / 2; i++) {
            for (int j = sotiert.length; j >= sotiert.length / 2; j--) {
                zahl = sotiert[j] / sotiert[i];

                zahlen[indexof(sotiert[j], zahlen)] = zahl;
            }
        }

        return zahlen;
    }
    /**
     * Methode IndexOf
     * sucht den Index im Array für einen übergebenen Wert
     * 
     * @param zahl, Array
     * @return index von der Zahl im Array
     */
    public int indexof(float zahl, float[] zahlen) {
        for (int i = 0; i < zahlen.length; i++) {
            if (zahlen[i] == zahl)
                return i;
        }

        return -1;
    }
}
