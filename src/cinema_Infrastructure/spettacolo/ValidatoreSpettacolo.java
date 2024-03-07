package cinema_Infrastructure.spettacolo;

import cinema_Infrastructure.film.Film;
import cinema_Infrastructure.sala.Sala;
import exception.SovrapposizioneSpettacoloException;
import exception.film.FilmNonInProgrammazioneException;
import exception.sala.SalaNonEsistenteException;

import java.time.LocalDateTime;
import java.util.List;

public class ValidatoreSpettacolo {

    public static void validaSpettacolo(ISpettacolo nuovoSpettacolo, List<ISpettacolo> programmazione) throws SovrapposizioneSpettacoloException {
        LocalDateTime orarioFinePrevisto = nuovoSpettacolo.getOrarioProiezione().plusMinutes(nuovoSpettacolo.getFilm().getDurata());

        for (ISpettacolo spettacoloEsistente : programmazione) {
            if (spettacoloEsistente.getSala().getNumeroSala() == nuovoSpettacolo.getSala().getNumeroSala()) {
                LocalDateTime inizioEsistente = spettacoloEsistente.getOrarioProiezione();
                LocalDateTime fineEsistente = inizioEsistente.plusMinutes(spettacoloEsistente.getFilm().getDurata());

                if (nuovoSpettacolo.getOrarioProiezione().isBefore(fineEsistente) && orarioFinePrevisto.isAfter(inizioEsistente)) {
                    throw new SovrapposizioneSpettacoloException("Impossibile programmare: sovrapposizione con spettacolo esistente nella sala " + nuovoSpettacolo.getSala().getNumeroSala() + ".");
                }
            }
        }
    }
}



