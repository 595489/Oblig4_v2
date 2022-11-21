package no.hvl.dat108.oblig4.model;

import java.util.List;
import java.util.Optional;

public interface DeltakerDAO {
    Deltager get(String mobil);

    List<Deltager> getAll();

    void save(Deltager deltager);

    void update(Deltager deltager, String[] params);

    void delete(Deltager deltager);
}
