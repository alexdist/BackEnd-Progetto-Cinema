package admin_commands.aggiungi_spettacolo;

//import admin_interfaces.Command;
//import cinema_Infrastructure.film.Film;
//import cinema_Infrastructure.sala.Sala;
//import exception.film.FilmNonInProgrammazioneException;
//import exception.IDSpettacoloEsistenteException;
//import exception.sala.SalaNonEsistenteException;
//import exception.SovrapposizioneSpettacoloException;
//import singleton.Cinema;
//
//import java.time.LocalDateTime;
//
//// Definisce un comando per creare o aggiornare uno spettacolo nel sistema di gestione del cinema.
//public class CreaSpettacoloCommand implements Command {
//
//    private String id; // ID dello spettacolo
//    private Film film; // Film dello spettacolo
//    private Sala sala; // Sala dello spettacolo
//    private LocalDateTime orarioProiezione; // Orario di proiezione dello spettacolo
//
//
//        // Costruttore con iniezione della dipendenza SpettacoloManager
//        public CreaSpettacoloCommand(String id, Film film, Sala sala, LocalDateTime orarioProiezione) {
//            ValidatoreSpettacolo.validaParametri(film, sala, orarioProiezione); // Utilizza una classe di validazione
//            this.id = id;
//            this.film = film;
//            this.sala = sala;
//            this.orarioProiezione = orarioProiezione;
//
//        }
//
//
//    @Override
//    public void execute() {
//        try {
//            // Prova a creare o aggiornare lo spettacolo con l'ID e i dettagli forniti.
//            boolean creato = Cinema.getInstance().getGestioneCinema().creaSpettacolo(id, film, sala, orarioProiezione);
//            if (creato) {
//                System.out.println("Spettacolo ID \"" + id + "\" del film \"" + film.getTitolo() +
//                        "\" programmato con successo nella sala " + sala.getNumeroSala() +
//                        " alle " + orarioProiezione);
//            }
//        } catch (SalaNonEsistenteException | FilmNonInProgrammazioneException | SovrapposizioneSpettacoloException e) {
//            System.err.println(e.getMessage());
//        } catch (IDSpettacoloEsistenteException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}