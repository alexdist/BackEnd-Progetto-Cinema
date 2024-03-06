package cinema_Infrastructure.sala;

import cinema_Infrastructure.sala.Sala;
import exception.sala.NumeroPostiNegativoException;
import exception.sala.NumeroSalaNegativoException;
import exception.sala.SalaGiaEsistenteException;

import java.util.List;
import java.util.Optional;



public class ValidatoreSala {
    public static void validaParametri(Sala sala) throws NumeroSalaNegativoException, NumeroPostiNegativoException {
        if (sala == null) {
            throw new IllegalArgumentException("La sala non può essere null");
        }
        if (sala.getNumeroSala() < 0) {
            throw new NumeroSalaNegativoException();
        }
        if (sala.getCapacita() < 0) {
            throw new NumeroPostiNegativoException();
        }
    }

    // Metodo per validare l'unicità del numero della sala
    public static void validaUnicitaSala(List<Sala> sale, int numeroSala) throws SalaGiaEsistenteException {
        Optional<Sala> salaEsistente = sale.stream()
                .filter(s -> s.getNumeroSala() == numeroSala)
                .findFirst();
        if (salaEsistente.isPresent()) {
            throw new SalaGiaEsistenteException("Sala numero " + numeroSala + " esiste già.");
        }
    }
}