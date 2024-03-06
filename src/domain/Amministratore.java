package domain;
import admin_interfaces.Command;
import exception.film.FilmGiaPresenteException;


import java.util.ArrayList;
import java.util.List;

public class Amministratore extends Persona {

   // private List<Command> comandi;

    private Command command;

    public Amministratore(String nome, String cognome, Ruolo ruolo) {
        super(nome, cognome, ruolo);
        //this.comandi = new ArrayList<>();
    }

    public void setCommand(Command command){
        this.command = command;
    }

    public void eseguiComando(Command comando)  {
        comando.execute();
    }

}
