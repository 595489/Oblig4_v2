package no.hvl.dat108.oblig4.model;

import no.hvl.dat108.oblig4.utils.PassordUtil;
import no.hvl.dat108.oblig4.utils.Validator;
//import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;

public class Skjema {

    private String fornavn;
    private String etternavn;
    private String mobil;
    private String kjonn;
    private String passord;
    private String passordRep;
    private String fornavnFeil;
    private String etternavnFeil;
    private String mobilFeil;
    private String kjonnFeil;
    private String passordFeil;
    private String passordRepFeil;
    private String kvinne;
    private String mann;
    private String passordHash;
    private String passordSalt;

    public Skjema(HttpServletRequest request) {

        this.fornavn = request.getParameter("fornavn");
        this.etternavn = request.getParameter("etternavn");
        this.mobil = request.getParameter("mobil");
        this.kjonn = request.getParameter("kjonn");
        this.passord = request.getParameter("passord");
        this.passordRep = request.getParameter("passordRep");
        this.kvinne = request.getParameter("kvinne");
        this.mann = request.getParameter("mann");

    }

    public String getPassordHash() {
        return passordHash;
    }

    public void setPassordHash(String passordHash) {
        this.passordHash = passordHash;
    }

    public String getPassordSalt() {
        return passordSalt;
    }

    public void setPassordSalt(String passordSalt) {
        this.passordSalt = passordSalt;
    }

    public Skjema() {

    }

    public void checker() {
        if (kjonn != null) {
            if (kjonn.equals("kvinne")) {
                kvinne = "checked";
            } else {
                mann = "checked";
            }
        }
    }

    public boolean gyldigSkjema() {
        return Validator.validFornavn(fornavn) && Validator.validEtternavn(etternavn) && Validator.validMobil(mobil)
                && Validator.validKjonn(kjonn) && Validator.validPassord(passord);

    }

    private boolean passordlikt() {
        if (passord == null || passordRep == null) {
            return false;
        }

        return passord.equals(passordRep);
    }

    public void feilmeldinger() {
        if (!Validator.validFornavn(fornavn)) {
            fornavn = "";
            fornavnFeil = "Ugyldig fornavn";
        }
        if (!Validator.validEtternavn(etternavn)) {
            etternavn = "";
            etternavnFeil = "Ugyldig etternavn";
        }
        if (!Validator.validKjonn(kjonn)) {
            kjonn = "";
            kjonnFeil = "Ugyldig kj�nn";
        }
        if (!Validator.validMobil(mobil)) {
            mobil = "";
            mobilFeil = "Ugyldig mobil";
        }
        if (!Validator.validPassord(passord)) {
            passord = "";
            passordFeil = "Ugyldig passord";
        }
        if (!passordlikt()) {
            passordRepFeil = "Passordene m� v�re like!";
        }

    }

    public void deltagerMobilfinnes(Boolean deltager) {
        if(deltager == true) {
            mobil = "";
            mobilFeil = "Ugyldig mobil";
        }

    }

    public Deltager lagDeltager() {

        passordSalt = PassordUtil.genererTilfeldigSalt();
        passordHash = PassordUtil.hashMedSalt(passord, passordSalt);

        return new Deltager(fornavn, etternavn, mobil, kjonn, passordHash, passordSalt);
    }

    public String getKvinne() {
        return kvinne;
    }

    public void setKvinne(String kvinne) {
        this.kvinne = kvinne;
    }

    public String getMann() {
        return mann;
    }

    public void setMann(String mann) {
        this.mann = mann;
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

    public String getKjonn() {
        return kjonn;
    }

    public void setKjonn(String kjonn) {
        this.kjonn = kjonn;
    }

    public String getPassord() {
        return passord;
    }

    public void setPassord(String passord) {
        this.passord = passord;
    }

    public String getPassordRep() {
        return passordRep;
    }

    public void setPassordRep(String passordRep) {
        this.passordRep = passordRep;
    }

    public String getFornavnFeil() {
        return fornavnFeil;
    }

    public void setFornavnFeil(String fornavnFeil) {
        this.fornavnFeil = fornavnFeil;
    }

    public String getEtternavnFeil() {
        return etternavnFeil;
    }

    public void setEtternavnFeil(String etternavnFeil) {
        this.etternavnFeil = etternavnFeil;
    }

    public String getMobilFeil() {
        return mobilFeil;
    }

    public void setMobilFeil(String mobilFeil) {
        this.mobilFeil = mobilFeil;
    }

    public String getKjonnFeil() {
        return kjonnFeil;
    }

    public void setKjonnFeil(String kjonnFeil) {
        this.kjonnFeil = kjonnFeil;
    }

    public String getPassordFeil() {
        return passordFeil;
    }

    public void setPassordFeil(String passordFeil) {
        this.passordFeil = passordFeil;
    }

    public String getPassordRepFeil() {
        return passordRepFeil;
    }

    public void setPassordRepFeil(String passordRepFeil) {
        this.passordRepFeil = passordRepFeil;
    }

}