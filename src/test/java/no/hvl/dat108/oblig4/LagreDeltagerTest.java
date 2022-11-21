package no.hvl.dat108.oblig4;

import no.hvl.dat108.oblig4.model.Deltager;
import no.hvl.dat108.oblig4.model.DeltagerDB;
import no.hvl.dat108.oblig4.model.DeltagerJSON;
import no.hvl.dat108.oblig4.model.DeltakerDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LagreDeltagerTest {
    Deltager deltager;
    String fnavn = "Per", enavn = "Pettersen", kjonn = "Mann", mob = "80080800", hash = "HASH", salt = "SALT";
    Deltager deltager2;
    Deltager deltager3;
    DeltakerDAO saveJson = new DeltagerJSON();
//    DeltakerDAO saveDB = new DeltagerDB(); //TODO implement database access class DeltagerDB

    @BeforeEach
    void setUp() {
        deltager = new Deltager(fnavn, enavn, kjonn, mob, hash, salt);
        deltager2 = new Deltager("Hans", "Hansen", "Mann", "00030333", "SECONDHASH", "SECONDSALT");
        deltager3 = new Deltager("Lisa", "Listhaug", "Kvinne", "50055005", "LISAHASH", "LISASALT");

        saveJson.save(deltager);
        saveJson.save(deltager2);
        saveJson.save(deltager3);
    }

    @Test
    void testGet(){
        System.out.println("Getter: " + saveJson.get(mob) + " Comparer: " + deltager);
        assertEquals(saveJson.get(mob).toString(), deltager.toString());
    }

    @Test
    void testGetAll(){
        List<Deltager> dl = new ArrayList<Deltager>();
        dl.add(deltager);
        dl.add(deltager2);
        dl.add(deltager3);

        assertEquals(saveJson.getAll().toString(), dl.toString());
    }

//    @Test
//    void testGetDb(){
//        //TODO implement test for database get
//    }

//    @Test
//    void testGetAllDb(){
//        //TODO implement test for database getAll
//    }
}
