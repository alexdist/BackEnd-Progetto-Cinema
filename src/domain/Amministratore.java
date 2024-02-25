package domain;
import admin_interfaces.Command;


import java.util.ArrayList;
import java.util.List;

public class Amministratore extends Persona {
    private List<Command> comandi;

    public Amministratore(String nome, String cognome, Ruolo ruolo) {
        super(nome, cognome, ruolo);
        this.comandi = new ArrayList<>();
    }

    public void aggiungiComando(Command comando) {
        this.comandi.add(comando);
    }

    public void eseguiComando(int indiceComando) {
        if (indiceComando >= 0 && indiceComando < comandi.size()) {
            comandi.get(indiceComando).execute();
        } else {
            System.out.println("Indice comando non valido.");
        }
    }

    public void eseguiComando(Command comando) {
        comando.execute();
    }

    // Se vuoi eseguire tutti i comandi in sequenza
    public void eseguiTuttiComandi() {
        for (Command comando : comandi) {
            comando.execute();
        }
    }
}
