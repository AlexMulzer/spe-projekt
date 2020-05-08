package spe.mch;

/**
 *
 * @author Alex
 */
public class Bestellung {
    private int bestellnummer;
    private int kundennummer;
    private String extras;

    public Bestellung(){}
    public Bestellung(int bestellnummer, int kundennummer, String extras){
        this.bestellnummer = bestellnummer;
        this.kundennummer = kundennummer;
        this.extras = extras;
    }

    //Getter und Setter einbauen
}
