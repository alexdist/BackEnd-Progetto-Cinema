package cinema_Infrastructure.spettacolo;

import java.util.ArrayList;
import java.util.List;

public class OttieniProgrammazione implements IOttieniProgrammazione{
    private List<Spettacolo> spettacoli = new ArrayList<>();

    @Override
    public List<Spettacolo> ottieniSpettacoli() {
        return new ArrayList<>(spettacoli); // Restituisce una copia della lista per evitare modifiche esterne
    }
}
