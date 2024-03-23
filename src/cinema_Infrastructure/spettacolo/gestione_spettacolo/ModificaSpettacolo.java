package cinema_Infrastructure.spettacolo.gestione_spettacolo;

import cinema_Infrastructure.film.IFilm;
import cinema_Infrastructure.sala.ISala;
import cinema_Infrastructure.spettacolo.ISpettacolo;
import exception.spettacolo.SpettacoloNonTrovatoException;

import java.time.LocalDateTime;
import java.util.List;

public class ModificaSpettacolo implements IModificaSpettacolo {

    private List<ISpettacolo> spettacoli;

    public ModificaSpettacolo(List<ISpettacolo> spettacoli) {
        this.spettacoli = spettacoli;
    }

    public void modificaFilmPerIdSpettacolo(long idSpettacolo, IFilm nuovoFilm) throws SpettacoloNonTrovatoException {
        ISpettacolo spettacolo = esisteSpettacoloPerId(idSpettacolo);
        spettacolo.setFilm(nuovoFilm);
    }

    public void modificaSalaPerIdSpettacolo(long idSpettacolo, ISala nuovaSala) throws SpettacoloNonTrovatoException {
        ISpettacolo spettacolo = esisteSpettacoloPerId(idSpettacolo);
        spettacolo.setSala(nuovaSala);
    }

    public void modificaOrarioProiezionePerIdSpettacolo(long idSpettacolo, LocalDateTime nuovoOrario) throws SpettacoloNonTrovatoException {
        ISpettacolo spettacolo = esisteSpettacoloPerId(idSpettacolo);
        spettacolo.setOrarioProiezione(nuovoOrario);
    }

    private ISpettacolo esisteSpettacoloPerId(long idSpettacolo) throws SpettacoloNonTrovatoException {
        return spettacoli.stream()
                .filter(spettacolo -> spettacolo.getId() == idSpettacolo)
                .findFirst()
                .orElseThrow(() -> new SpettacoloNonTrovatoException("Spettacolo con ID " + idSpettacolo + " non presente nella lista."));
    }
}
