import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Klasse NumberCrunsherDialog
 * Schnittstelle zwischen benutzer und der NumberCrunsher Klasse
 *
 * @author Hussein Abbas & Samantha Maaß
 * @version 04.05.2019
 */
public class NumberCrunsherDialog {
    private Scanner input = new Scanner(System.in);
    
    /**
     * leerer Konstruktor
     */
    public NumberCrunsherDialog() {
    }
    
    // Klassenkonstanten
    private static final int ARRAY_ANLEGEN = 1;
    private static final int REIHENFOLGE = 2;
    private static final int PRINT = 3;
    private static final int ENDE = 0;
    NumberCrunsher numberCrunsher = null;
    
    /**
     * Hauptschleife des Programs
     * (+Ausnahme behandlung)
     */
    public void start() {
        int funktion = -1;

        while (funktion != ENDE) {
            try {
                funktion = einlesenFunktion();
                ausfuehrenFunktion(funktion);
            } catch (IllegalArgumentException e) {
                System.out.println(e);
                input.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("falsche eingabe!");
                input.nextLine();
            } catch (Exception e) {
                System.out.println(e);
                e.printStackTrace(System.out);
                input.nextLine();
            }
        }
    }
    
    /**
     * Menü, Möglichkeiten für den User (funktion als ganzzahliger Wert einlesen)
     * 
     * @return funktion als ganzzahliger Wert
     */
    private int einlesenFunktion() {
        System.out.print(ARRAY_ANLEGEN  + " : array anlegen \n" +
                         REIHENFOLGE    + " : Reihenfolge der funktionen angeben \n" +
                         PRINT          + " : array Ausgeben\n" +
                         ENDE           + " : Ende \n");
        return input.nextInt();
    }
    
    /**
     * Menü, Programm führt die passende Aktion aus
     * 
     * @param ganzzahliger wert von der eingabe 
     * @return führt jeweilige Funktion aus und gib ergebniss aus
     */
    private void ausfuehrenFunktion(int funktion) {
        switch (funktion) {
            case ARRAY_ANLEGEN:
                System.out.println("wie groß soll das array sein?");
                this.numberCrunsher = new NumberCrunsher(input.nextInt());
                break;
            case REIHENFOLGE:
                if (this.numberCrunsher == null) {
                    System.out.println("noch keine Liste erstellt!");
                } else {
                    this.numberCrunsher.crunsh(reihenfolge());
                }
                break;
            case ENDE:
                System.out.println("Programmende");
                break;
            case PRINT:
                if (this.numberCrunsher != null) {
                    this.numberCrunsher.printNumbers();
                } else {
                    System.out.println("noch keine Liste erstellt!");
                }
                break;
            default:
                System.out.println("Falsche Funktion!");
        }
    }
    
    /**
     * Methode rheinfolge
     * Legt ein Array an, welches die reihenfolge der Funktionen übergibt
     * 
     * @param jeweilige funktionen reihenfolge
     * @return gefülltes array
     */
    private String[] reihenfolge() {
        ArrayList<String> funktionen = new ArrayList<>();
        boolean loop = true;
        while (loop) {
            System.out.print("funktion wählen : \n" +
                    "0 -> funktionsliste fertig; \n" +
                    "1 -> summieren; \n" +
                    "2 -> Subtrahieren; \n" +
                    "3 -> Dividieren; \n" +
                    "4 -> Average; \n" +
                    "5 -> Swirl; \n");
            switch (input.nextInt()) {
                case 0:
                    loop = false;
                    break;
                case 1:
                    funktionen.add("SUM");
                    break;
                case 2:
                    funktionen.add("SUBSTRACT");
                    break;
                case 3:
                    funktionen.add("DIVIDE");
                    break;
                case 4:
                    funktionen.add("AVERAGE");
                    break;
                case 5:
                    funktionen.add("SWIRL");
                    break;
                default:
                    System.out.println("ungültige eingabe");
                    break;
            }
        }
        //0, because the reflection used to determine the correct size is fast enough since JDK 6
        //and the official JDK Documentation recommends it
        return funktionen.toArray(new String[0]);
    }
    
    /**
     * main start
     */
    public static void main(String[] args) {
        new NumberCrunsherDialog().start();
    }
}
