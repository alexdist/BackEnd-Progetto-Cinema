package domain;
import admin_interfaces.Command;
import admin_interfaces.ICommand;
import exception.film.DurataFilmNonValidaException;
import exception.film.FilmGiaPresenteException;
import exception.film.FilmNonTrovatoException;
import exception.film.TitoloVuotoException;
import exception.sala.SalaGiaEsistenteException;
import exception.sala.SalaNonTrovataException;


import java.util.ArrayList;
import java.util.List;

public class Amministratore extends Persona {

    private ICommand command;

    public Amministratore(String nome, String cognome, Ruolo ruolo) {
        super(nome, cognome, ruolo);

    }

    public void setCommand(ICommand command){
        this.command = command;
    }

    public void eseguiComando() throws FilmGiaPresenteException, DurataFilmNonValidaException, TitoloVuotoException, FilmNonTrovatoException, SalaGiaEsistenteException, SalaNonTrovataException {
        command.execute();
    }

}
