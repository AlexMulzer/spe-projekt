package spe.mch;

/**
 *
 * @author Alex
 */
public class PersoenlicheDaten {
    
    private int kundennummer;
    private String nachname;
    private String vorname;
    private String telefon;
    private String strasse;
    private String hausnummer;
    private int ortsId;

    public PersoenlicheDaten(){}
    public PersoenlicheDaten(int kundennummer, String nachname, String vorname, String telefon, String strasse, String hausnummer, int ortsId){
        this.kundennummer = kundennummer;
        this.nachname = nachname;
        this.vorname = vorname;
        this.telefon = telefon;
        this.strasse = strasse;
        this.hausnummer = hausnummer;
        this.ortsId = ortsId;
    }

    //Getter und Setter einbauen
}
