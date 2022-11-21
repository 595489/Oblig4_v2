package no.hvl.dat108.oblig4.model;

import java.util.List;

public class DeltagerDB implements DeltakerDAO{
    @Override
    public Deltager get(String mobil) {
        return null; //TODO implement method
    }

    @Override
    public List<Deltager> getAll() {
        return null; //TODO implement method
    }

    @Override
    public void save(Deltager deltager) {
        //TODO implement method
    }

    @Override
    public void update(Deltager deltager, String[] params) {
        //TODO implement method (NOT REALLY NEEDED FOR NOW)
    }

    @Override
    public void delete(Deltager deltager) {
        //TODO implement method (NOT REALLY NEEDED FOR NOW)
    }
}
