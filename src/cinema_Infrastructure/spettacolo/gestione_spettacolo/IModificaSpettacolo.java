package cinema_Infrastructure.spettacolo.gestione_spettacolo;

import cinema_Infrastructure.film.IFilm;
import cinema_Infrastructure.sala.ISala;
import exception.spettacolo.SpettacoloNonTrovatoException;

import java.time.LocalDateTime;

// IModificaSpettacolo agisce come 'Receiver' nel pattern Command.
// Questa interfaccia dichiara i metodi che saranno implementati per modificare uno Spettacolo
public interface IModificaSpettacolo {

    // Metodo per modificare il film associato a uno spettacolo esistente.
    // Richiede l'ID dello spettacolo e il nuovo film da associare.
    // Può sollevare un'eccezione se lo spettacolo non viene trovato.
    void modificaFilmPerIdSpettacolo(long idSpettacolo, IFilm nuovoFilm) throws SpettacoloNonTrovatoException;

    // Metodo per cambiare la sala in cui viene proiettato uno spettacolo.
    // Richiede l'ID dello spettacolo e la nuova sala da associare.
    // Può sollevare un'eccezione se lo spettacolo non viene trovato.
    void modificaSalaPerIdSpettacolo(long idSpettacolo, ISala nuovaSala) throws SpettacoloNonTrovatoException;

    // Metodo per aggiornare l'orario di proiezione di uno spettacolo.
    // Richiede l'ID dello spettacolo e il nuovo orario di proiezione.
    // Può sollevare un'eccezione se lo spettacolo non viene trovato.
    void modificaOrarioProiezionePerIdSpettacolo(long idSpettacolo, LocalDateTime nuovoOrario) throws SpettacoloNonTrovatoException;
}
