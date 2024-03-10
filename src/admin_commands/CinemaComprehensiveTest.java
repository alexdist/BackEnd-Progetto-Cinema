//package admin_commands;
//
//import admin_commands.film.aggiungi_film.AggiungiFilmCommand;
//import admin_commands.sala.aggiungi_sala.AggiungiSalaCommand;
//import admin_commands.spettacolo.aggiungi_spettacolo.AggiungiSpettacoloCommand;
//import admin_commands.spettacolo.rimuovi_spettacolo.RimuoviSpettacoloCommand;
//import admin_interfaces.ICommand;
//import cinema_Infrastructure.film.Film;
//import cinema_Infrastructure.film.GeneratoreIDFilm;
//import cinema_Infrastructure.film.IFilm;
//import cinema_Infrastructure.film.IGeneratoreIDFilm;
//import cinema_Infrastructure.film.gestione_film.AggiungiFilm;
//import cinema_Infrastructure.film.gestione_film.IAggiungiFilm;
//import cinema_Infrastructure.film.gestione_film.RicercaFilm;
//import cinema_Infrastructure.sala.GeneratoreIDSala;
//import cinema_Infrastructure.sala.IGeneratoreIDSala;
//import cinema_Infrastructure.sala.ISala;
//import cinema_Infrastructure.sala.Sala;
//import cinema_Infrastructure.sala.gestione_sala.AggiungiSala;
//import cinema_Infrastructure.sala.gestione_sala.IAggiungiSala;
//import cinema_Infrastructure.sala.gestione_sala.RicercaSala;
//import cinema_Infrastructure.spettacolo.GeneratoreIDSpettacolo;
//import cinema_Infrastructure.spettacolo.IGeneratoreIDSpettacolo;
//import cinema_Infrastructure.spettacolo.ISpettacolo;
//import cinema_Infrastructure.spettacolo.Spettacolo;
//import cinema_Infrastructure.spettacolo.gestione_spettacolo.AggiungiSpettacolo;
//import cinema_Infrastructure.spettacolo.gestione_spettacolo.IAggiungiSpettacolo;
//import cinema_Infrastructure.spettacolo.gestione_spettacolo.IRimuoviSpettacolo;
//import cinema_Infrastructure.spettacolo.gestione_spettacolo.RimuoviSpettacolo;
//import domain.Amministratore;
//import domain.Ruolo;
//import exception.film.FilmNonValidoException;
//import exception.sala.SalaNonValidaException;
//import exception.spettacolo.SovrapposizioneSpettacoloException;
//import exception.film.DurataFilmNonValidaException;
//import exception.film.FilmGiaPresenteException;
//import exception.film.FilmNonTrovatoException;
//import exception.film.TitoloVuotoException;
//import exception.sala.SalaGiaEsistenteException;
//import exception.sala.SalaNonTrovataException;
//import exception.spettacolo.SpettacoloNonTrovatoException;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//public class CinemaComprehensiveTest {
//
//    public static void main(String[] args) {
//        try {
//            // Setup iniziale
//            List<IFilm> filmInProgrammazione = new ArrayList<>();
//            List<ISala> sale = new ArrayList<>();
//            ArrayList<ISpettacolo> spettacoli = new ArrayList<>();
//
//            IGeneratoreIDFilm generatoreIDFilm = GeneratoreIDFilm.getInstance();
//            IAggiungiFilm servizioAggiungiFilm = new AggiungiFilm(filmInProgrammazione, generatoreIDFilm);
//
//            IGeneratoreIDSala generatoreIDSala = GeneratoreIDSala.getInstance();
//            IAggiungiSala servizioAggiungiSala = new AggiungiSala(sale, generatoreIDSala);
//
//            Amministratore amministratore = new Amministratore("Luca", "Rossi", Ruolo.AMMINISTRATORE);
//
//            // Comando per aggiungere un film
//            IFilm nuovoFilm = new Film("Interstellar", 169, "Sci-fi"); // ID sarà assegnato automaticamente
//            ICommand aggiungiFilmCommand = new AggiungiFilmCommand(servizioAggiungiFilm, nuovoFilm);
//            amministratore.setCommand(aggiungiFilmCommand);
//            amministratore.eseguiComando();
//
//            // Comando per aggiungere una sala
//            ISala nuovaSala = new Sala(1, 150); // ID sarà assegnato automaticamente
//            ICommand aggiungiSalaCommand = new AggiungiSalaCommand(servizioAggiungiSala, nuovaSala);
//            amministratore.setCommand(aggiungiSalaCommand);
//            amministratore.eseguiComando();
//
//            // Ricerca del film e della sala aggiunti per creare uno spettacolo
//            IFilm filmSelezionato = RicercaFilm.trovaFilmPerTitoloEId(filmInProgrammazione, "Interstellar", 0);
//            ISala salaSelezionata = RicercaSala.trovaSalaPerNumeroEId(sale, 1, 0);
//
//           // if (filmSelezionato != null && salaSelezionata != null) {
//                IGeneratoreIDSpettacolo generatoreIDSpettacolo = GeneratoreIDSpettacolo.getInstance();
//                IAggiungiSpettacolo servizioAggiungiSpettacolo = new AggiungiSpettacolo(spettacoli, generatoreIDSpettacolo);
//
//                LocalDateTime orario = LocalDateTime.of(2024,3,10,20,45);
//                ISpettacolo nuovoSpettacolo = new Spettacolo(filmSelezionato, salaSelezionata, orario);
//
//                ICommand aggiungiSpettacoloCommand = new AggiungiSpettacoloCommand(servizioAggiungiSpettacolo, nuovoSpettacolo);
//                amministratore.setCommand(aggiungiSpettacoloCommand);
//                amministratore.eseguiComando();
//           // } else {
//                System.out.println(nuovoSpettacolo.getSala()+" "+nuovoSpettacolo.getFilm());
//           // }
//                IAggiungiSpettacolo servizioAggiungiSpettacolo2 = new AggiungiSpettacolo(spettacoli,generatoreIDSpettacolo);
//                LocalDateTime orario2 = LocalDateTime.of(2024,3,8,20,45);
//
//                ISpettacolo nuovoSpettacolo2 = new Spettacolo(filmSelezionato, salaSelezionata, orario2);
//
//                ICommand aggiungiSpettacoloCommand2 = new AggiungiSpettacoloCommand(servizioAggiungiSpettacolo2, nuovoSpettacolo2);
//                amministratore.setCommand(aggiungiSpettacoloCommand2);
//                amministratore.eseguiComando();
//
//
//            IRimuoviSpettacolo servizioRimuoviSpettacolo = new RimuoviSpettacolo(spettacoli);
//            ICommand rimuoviSpettacoloCommand = new RimuoviSpettacoloCommand(servizioRimuoviSpettacolo,0);
//            amministratore.setCommand(rimuoviSpettacoloCommand);
//            amministratore.eseguiComando();
//
//            for(ISpettacolo spettacolo : spettacoli){
//                System.out.println("ID: "+spettacolo.getId());
//            }
//
//
//
//
//            // Output dei risultati...
//
//        } catch (FilmNonValidoException | SalaNonValidaException | SovrapposizioneSpettacoloException |
//                 FilmGiaPresenteException | DurataFilmNonValidaException |
//                 TitoloVuotoException | FilmNonTrovatoException | SalaGiaEsistenteException | SalaNonTrovataException e) {
//            System.err.println("Errore imprevisto: " + e.getMessage());
//            e.printStackTrace();
//        } catch (SpettacoloNonTrovatoException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
