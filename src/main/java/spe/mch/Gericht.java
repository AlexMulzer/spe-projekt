package spe.mch;

/**
 *
 * @author z0043bck
 */
public class Gericht {
    private int nummer;
    private String name;
    private double preis;
    private String beschreibung;
    private String kategorie;

    public Gericht() {
    }

    public Gericht(int nummer, String name, double preis, String beschreibung, String allergene, String kategorie) {
        this.nummer = nummer;
        this.name = name;
        this.preis = preis;
        this.beschreibung = beschreibung;
        this.kategorie = kategorie;
    }

    public int getNummer() {
        return nummer;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }
    
    public String getKategorie(){
        return kategorie;
    }
    
    public void setKategorie(){
        this.kategorie = kategorie;
    }
}
