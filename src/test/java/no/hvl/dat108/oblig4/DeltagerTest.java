package no.hvl.dat108.oblig4;

import no.hvl.dat108.oblig4.model.Deltager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeltagerTest {
    Deltager deltager;
    String fnavn = "Per";
    String enavn = "Pettersen";
    String kjonn = "Mann";
    String mob = "80080800";
    String hash = "HASH";
    String salt = "SALT";

    @BeforeEach
    void setUp() {
        deltager = new Deltager(fnavn, enavn, kjonn, mob, hash, salt);
    }

//    @AfterEach
//    void tearDown() {
//    }

    @Test
    void testToString() {
        assertEquals(deltager.toString(), "Deltager Per Pettersen er nå registrert med mobilnummer 80080800.");
    }

    @Test
    void getPassordSalt() {
        assertEquals(deltager.getPassordSalt(), salt);
    }

    @Test
    void getPassordHash() {
        assertEquals(deltager.getPassordHash(), hash);
    }

    @Test
    void getKjonn() {
        assertEquals(deltager.getKjonn(), kjonn);
    }

    @Test
    void getFornavn() {
        assertEquals(deltager.getFornavn(), fnavn);
    }

    @Test
    void getEtternavn() {
        assertEquals(deltager.getEtternavn(), enavn);
    }

    @Test
    void getMobil() {
        assertEquals(deltager.getMobil(), mob);
    }
}