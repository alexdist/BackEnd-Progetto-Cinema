package cinema_Infrastructure.spettacolo.gestione_spettacolo;

import cinema_Infrastructure.film.IFilm;
import cinema_Infrastructure.sala.ISala;
import exception.SpettacoloNonTrovatoException;

import java.time.LocalDateTime;

public interface IModificaSpettacolo {

    void modificaFilmPerIdSpettacolo(long idSpettacolo, IFilm nuovoFilm) throws SpettacoloNonTrovatoException;
    void modificaSalaPerIdSpettacolo(long idSpettacolo, ISala nuovaSala) throws SpettacoloNonTrovatoException;
    void modificaOrarioProiezionePerIdSpettacolo(long idSpettacolo, LocalDateTime nuovoOrario) throws SpettacoloNonTrovatoException;

}
