package no.hvl.dat108.oblig4.model;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;

@Service
@Qualifier("json")
public class DeltagerJSON implements DeltakerDAO{
    JSONObject jsonObject = new JSONObject();
    String fileName = "./src/main/webapp/storage/test.json";

    @Override
    public Deltager get(String mobil) {
        JSONParser parser = new JSONParser();
        checkIfJSON();

        try{
            Reader reader = new FileReader(fileName);
            jsonObject = (JSONObject) parser.parse(reader);
            JSONArray array = (JSONArray) jsonObject.get("deltagere");
            if (array == null){
                return null;
            }
            reader.close();

            Deltager deltaker = null;

            Iterator<JSONObject> iterator = array.iterator();
            while (deltaker == null && iterator.hasNext()){
                Deltager c = getDeltagerJSON(iterator.next());
                if (Objects.equals(c.getMobil(), mobil)){
                    deltaker = c;
                }
            }
//            System.out.println(deltaker);

            return deltaker;
        }
        catch (IOException | ParseException e){
            e.printStackTrace();
        }
//        return Optional.empty();
        return null;
    }

    @Override
    public List<Deltager> getAll() {
        JSONParser parser = new JSONParser();
        checkIfJSON();

        try{
            Reader reader = new FileReader(fileName);
            jsonObject = (JSONObject) parser.parse(reader);
            JSONArray array = (JSONArray) jsonObject.get("deltagere");
            if (array == null){
                return null;
            }
            reader.close();
//            System.out.println(jsonObject);

            List<Deltager> deltagere = new ArrayList<Deltager>();

            Iterator<JSONObject> iterator = array.iterator();
            while (iterator.hasNext()){
                deltagere.add(getDeltagerJSON(iterator.next()));
            }

            return deltagere;
        }
        catch (IOException | ParseException e){
            e.printStackTrace();
        }
//        return Optional.empty();
        return null;
    }

    @Override
    public void save(Deltager deltager) {
        JSONParser parser = new JSONParser();
        checkIfJSON();
        if (get(deltager.getMobil()) != null){
            return;
        }

        try{
            Reader reader = new FileReader(fileName);
            jsonObject = (JSONObject) parser.parse(reader);
            JSONArray array = (JSONArray) jsonObject.get("deltagere");
            if (array == null){
                array = new JSONArray();
            }
            reader.close();

            array.add(setDeltakerJSON(deltager));
            jsonObject = new JSONObject();

            jsonObject.put("deltagere", array);
            FileWriter fileWriter = new FileWriter("./test.json");
            fileWriter.write(jsonObject.toJSONString());
            fileWriter.close();
        }
        catch (IOException | ParseException e){
            e.printStackTrace();
        }
//        jsonObject = new JSONObject();
    }

    private JSONObject setDeltakerJSON(Deltager deltager){
        JSONObject delt = new JSONObject();

//        System.out.println("Set");

        delt.put("fornavn", deltager.getFornavn());
        delt.put("etternavn", deltager.getEtternavn());
        delt.put("Kjonn", deltager.getKjonn());
        delt.put("Mobil", deltager.getMobil());
        delt.put("hash", deltager.getPassordHash());
        delt.put("salt", deltager.getPassordSalt());

        return delt;
    }

    private Deltager getDeltagerJSON(JSONObject jo) {
        Deltager deltager = new Deltager();

        deltager.setFornavn(jo.values().toArray()[4].toString());
        deltager.setEtternavn(jo.values().toArray()[2].toString());
        deltager.setKjonn(jo.values().toArray()[0].toString());
        deltager.setMobil(jo.values().toArray()[1].toString());
        deltager.setPassordSalt(jo.values().toArray()[3].toString());
        deltager.setPassordHash(jo.values().toArray()[5].toString());

//        System.out.println(deltager);

        return deltager;
    }

    private void checkIfJSON(){
        try{
            Reader reader = new FileReader(fileName);
            reader.close();
        } catch (FileNotFoundException e) {
            try {
                FileWriter writer = new FileWriter(fileName);
                JSONObject jo = new JSONObject();
                jo.put("test", "test");
                writer.write(jo.toJSONString());
                writer.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

//            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void update(Deltager deltager, String[] params) {
//        jsonObject = new JSONObject();
////        jsonObject.get(deltager.getMobil());
//        try{
//            FileReader fileReader = new FileReader("./test.json");
//            jsonObject.get(fileReader.read());
//
//
//            FileWriter fileWriter = new FileWriter("./test.json");
//        }
//        catch (IOException e){
//            e.printStackTrace();
//        }
    }

    @Override
    public void delete(Deltager deltager) {

    }
}
