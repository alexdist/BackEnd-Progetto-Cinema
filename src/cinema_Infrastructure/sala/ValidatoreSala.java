package cinema_Infrastructure.sala;

import cinema_Infrastructure.sala.Sala;
import exception.sala.NumeroPostiNegativoException;
import exception.sala.NumeroSalaNegativoException;
import exception.sala.SalaGiaEsistenteException;

import java.util.List;
import java.util.Optional;

public class ValidatoreSala {
    // Metodo per validare i parametri di una sala usando l'interfaccia ISala
    public static void validaParametri(ISala sala) throws NumeroSalaNegativoException, NumeroPostiNegativoException {
        if (sala == null) {
            throw new IllegalArgumentException("La sala non può essere null");
        }
        if (sala.getNumeroSala() < 0) {
            throw new NumeroSalaNegativoException("Il numero della sala non può essere negativo.");
        }
        if (sala.getCapacita() < 0) {
            throw new NumeroPostiNegativoException("Il numero dei posti non può essere negativo.");
        }
    }

    // Metodo per validare l'unicità del numero della sala
    public static void validaUnicitaSala(List<ISala> sale, int numeroSala) throws SalaGiaEsistenteException {
        boolean salaEsistente = sale.stream()
                .anyMatch(s -> s.getNumeroSala() == numeroSala);
        if (salaEsistente) {
            throw new SalaGiaEsistenteException("Sala numero " + numeroSala + " esiste già.");
        }
    }
}