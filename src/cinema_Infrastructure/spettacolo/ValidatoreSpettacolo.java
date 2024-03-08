package cinema_Infrastructure.spettacolo;

import exception.FilmNonValidoException;
import exception.SalaNonValidaException;
import exception.spettacolo.SovrapposizioneSpettacoloException;

import java.time.LocalDateTime;
import java.util.List;

//public class ValidatoreSpettacolo {
//
//    public static void validaSpettacolo(ISpettacolo nuovoSpettacolo, List<ISpettacolo> programmazione) throws SovrapposizioneSpettacoloException {
//        LocalDateTime orarioFinePrevisto = nuovoSpettacolo.getOrarioProiezione().plusMinutes(nuovoSpettacolo.getFilm().getDurata());
//
//        for (ISpettacolo spettacoloEsistente : programmazione) {
//            if (spettacoloEsistente.getSala().getNumeroSala() == nuovoSpettacolo.getSala().getNumeroSala()) {
//                LocalDateTime inizioEsistente = spettacoloEsistente.getOrarioProiezione();
//                LocalDateTime fineEsistente = inizioEsistente.plusMinutes(spettacoloEsistente.getFilm().getDurata());
//
//                if (nuovoSpettacolo.getOrarioProiezione().isBefore(fineEsistente) && orarioFinePrevisto.isAfter(inizioEsistente)) {
//                    throw new SovrapposizioneSpettacoloException("Impossibile programmare: sovrapposizione con spettacolo esistente nella sala " + nuovoSpettacolo.getSala().getNumeroSala() + ".");
//                }
//            }
//        }
//    }
//}
public class ValidatoreSpettacolo {

    public static void validaSpettacolo(ISpettacolo nuovoSpettacolo, List<ISpettacolo> programmazione) throws SovrapposizioneSpettacoloException, FilmNonValidoException, SalaNonValidaException {
        // Verifica che il film dello spettacolo non sia null
        if (nuovoSpettacolo.getFilm() == null) {
            throw new FilmNonValidoException("Il film specificato per lo spettacolo è null.");
        }

        // Verifica che la sala dello spettacolo non sia null
        if (nuovoSpettacolo.getSala() == null) {
            throw new SalaNonValidaException("La sala specificata per lo spettacolo è null.");
        }

        LocalDateTime orarioFinePrevisto = nuovoSpettacolo.getOrarioProiezione().plusMinutes(nuovoSpettacolo.getFilm().getDurata());

        for (ISpettacolo spettacoloEsistente : programmazione) {
            if (spettacoloEsistente.getSala().getId() == nuovoSpettacolo.getSala().getId()) {
                LocalDateTime inizioEsistente = spettacoloEsistente.getOrarioProiezione();
                LocalDateTime fineEsistente = inizioEsistente.plusMinutes(spettacoloEsistente.getFilm().getDurata());

                if (nuovoSpettacolo.getOrarioProiezione().isBefore(fineEsistente) && orarioFinePrevisto.isAfter(inizioEsistente)) {
                    throw new SovrapposizioneSpettacoloException("Impossibile programmare: sovrapposizione con spettacolo esistente nella sala " + nuovoSpettacolo.getSala().getNumeroSala() + ".");
                }
            }
        }
    }
}



