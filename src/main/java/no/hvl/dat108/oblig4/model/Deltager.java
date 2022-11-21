package no.hvl.dat108.oblig4.model;

//import javax.persistence.*;
import javax.validation.*;
import javax.validation.constraints.Pattern;
//
//
//@Entity
//@Table(schema = "dat108oblig4", name = "deltager")
public class Deltager {

    @Pattern(regexp = "^[A-Z][a-z_-]{2,20}$", message = "Må inneholde 2 tegn, Stor forbokstav")
    private String fornavn;
    @Pattern(regexp = "^[A-Z][a-z_-]{2,20}$", message = "Må inneholde 2 tegn, Stor forbokstav")
    private String etternavn;
    @Pattern(regexp = "\\b(?=\\w{4,6}\\b)\\w(mann|kvinne)\\w*")
    private String kjonn;
//    @Id
//    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Pattern(regexp = "^[0-9]{8}$", message = "Må være 8 siffer")
    private String mobil;
    private String passordHash;
    private String passordSalt;


    @Override
    public String toString() {
        return "Deltager " + fornavn + " " + etternavn + " er nå registrert med mobilnummer " + mobil + ".";
    }

    public Deltager() {

    }

    /**
     * @param fornavn
     * @param etternavn
     * @param kjonn
     * @param mobil
     * @param passordHash
     * @param passordSalt
     */
    public Deltager(String fornavn, String etternavn, String kjonn, String mobil, String passordHash, String passordSalt) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.kjonn = kjonn;
        this.mobil = mobil;
        this.passordHash = passordHash;
        this.passordSalt = passordSalt;
    }

    public String getPassordSalt() {
        return passordSalt;
    }

    public void setPassordSalt(String passordSalt) {
        this.passordSalt = passordSalt;
    }

    public String getPassordHash() {
        return passordHash;
    }

    public void setPassordHash(String passordHash) {
        this.passordHash = passordHash;
    }

    public String getKjonn() {
        return kjonn;
    }

    public void setKjonn(String kjonn) {
        this.kjonn = kjonn;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public String getMobil() {
        return mobil;
    }

    public void setMobil(String mobil) {
        this.mobil = mobil;
    }

    public boolean erMann(){
        return kjonn.equals("mann") || kjonn.equalsIgnoreCase("Mann");
    }

    public boolean erKvinne(){
        return kjonn.equals("kvinne") || kjonn.equalsIgnoreCase("Kvinne");
    }

}