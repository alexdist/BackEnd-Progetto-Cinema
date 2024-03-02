
import Serializzazione.CaretakerSerializer;
import Serializzazione.CinemaSerializer;
import Serializzazione.GestorePrezziSerializer;
import Serializzazione.GestoreRicaviSerializer;
import admin_commands.*;
import cinema_Infrastructure.Film;
import cinema_Infrastructure.Sala;
import cinema_Infrastructure.Spettacolo;
import domain.Amministratore;
import domain.Ruolo;
import domain.Utente;
import memento.AcquistoMemento;
import memento.Caretaker;
import payment_strategy.*;
import singleton.Cinema;
import singleton.GestioneCinema;
import ticket.*;
import ticket_pricing.GestorePrezzi;
import ticket_pricing.GestoreRicavi;
import user_services.ServizioAcquistoBiglietto;

import java.time.LocalDateTime;

public class main {
 public static void main(String[] args) {

  String filePathCinema = "gestioneCinema.ser";
  String filePathPrezzi = "gestorePrezzi.ser";
  String filePathCaretaker = "caretaker.ser";
  String filePatchRicavi = "gestoreRicavi.ser";

  // Ottiene l'istanza singleton di Cinema
  Cinema cinema = Cinema.getInstance();

  // Carica lo stato di GestioneCinema se esiste
  GestioneCinema gestioneCinemaCaricata = CinemaSerializer.caricaStatoGestioneCinema(filePathCinema);
  if (gestioneCinemaCaricata != null) {
   cinema.setGestioneCinema(gestioneCinemaCaricata);
   System.out.println("Stato precedente di GestioneCinema caricato con successo.");
  } else {
   System.out.println("Nessuno stato precedente trovato o errore nel caricamento. Inizializzazione di una nuova GestioneCinema.");
  }

//  // carica lo stato di gestore prezzi se esiste.
  GestorePrezzi gestionePrezziCaricata = GestorePrezziSerializer.caricaStatoGestorePrezzi(filePathPrezzi);
  if (gestionePrezziCaricata != null) {
   cinema.setGestorePrezzi(gestionePrezziCaricata);
   System.out.println("Stato precedente di GestionePrezzi caricato con successo");
  }
  else{
    System.out.println("Nessuno stato precedente trovato o errore nel caricamento. Inizializzazione di una nuova GestionePrezzi");
   }
////
//  // Carica lo stato del Caretaker se esiste
  Caretaker caretakerCaricato = CaretakerSerializer.caricaStatoCaretaker(filePathCaretaker);
  if (caretakerCaricato != null) {
   cinema.setCaretaker(caretakerCaricato);
   System.out.println("Stato precedente del Caretaker caricato con successo.");
  } else {
   System.out.println("Nessuno stato precedente del Caretaker trovato o errore nel caricamento.");
  }
//
//  //carica lo stato di gestore ricavi se esiste
  GestoreRicavi gestoreRicaviCaricato = GestoreRicaviSerializer.caricaStatoGestoreRicavi(filePatchRicavi);
  if (gestoreRicaviCaricato != null) {
   cinema.setGestoreRicavi(gestoreRicaviCaricato);
   System.out.println("Stato precedente di GestoreRicavi caricato con successo.");
  } else {
   System.out.println("Nessuno stato precedente di GestoreRicavi trovato o errore nel caricamento.");
   // Inizializzazione di un nuovo GestoreRicavi se necessario
  }



//  // Creazione e configurazione di un amministratore
  Amministratore amministratore = new Amministratore("NomeAdmin", "CognomeAdmin", Ruolo.AMMINISTRATORE);
//

//  amministratore.eseguiComando(new EliminaSpettacoloCommand("02"));
 // amministratore.eseguiComando(new EliminaSalaCommand(3));
 //  amministratore.eseguiComando(new EliminaFilmCommand("Interstellar"));
 // amministratore.eseguiComando(new EliminaFilmCommand("FastAndFurious"));

//////////////  // Aggiunta di una sala
//  Sala sala = new Sala(1, 10);
//  amministratore.eseguiComando(new AggiungiSalaCommand(sala));
////////// CinemaSerializer.salvaStatoGestioneCinema(cinema.getGestioneCinema(), filePathCinema);
//////////////////
////////////////
////////////////  //Aggiunta di una seconda sala
//  Sala sala2 = new Sala(2, 10);
//  amministratore.eseguiComando(new AggiungiSalaCommand(sala2));
////////////// // CinemaSerializer.salvaStatoGestioneCinema(cinema.getGestioneCinema(), filePathCinema);
////////////////
////////////
////  Sala sala3 = new Sala(3,10);
////  amministratore.eseguiComando(new AggiungiSalaCommand(sala3));
//////////////  // Aggiunta di un film
//  Film filmInterstellar = new Film("Interstellar", 169);
//  amministratore.eseguiComando(new AggiungiFilmCommand(filmInterstellar));
//// //CinemaSerializer.salvaStatoGestioneCinema(cinema.getGestioneCinema(), filePathCinema);
//////////////
////////////
////////////  //Aggiunta di un secondo film
// Film fastandfurious = new Film("FastandFurious", 130);
//  amministratore.eseguiComando(new AggiungiFilmCommand(fastandfurious));
//// //CinemaSerializer.salvaStatoGestioneCinema(cinema.getGestioneCinema(), filePathCinema);
////////////
//////////////  // Programmazione di uno spettacolo per "Interstellar"
//  LocalDateTime orarioProiezioneInterstellar = LocalDateTime.of(2024, 2, 26, 21, 0);
// amministratore.eseguiComando(new CreaSpettacoloCommand("01", filmInterstellar, 1, orarioProiezioneInterstellar));
////////////  CinemaSerializer.salvaStatoGestioneCinema(cinema.getGestioneCinema(), filePathCinema);
////////////
////////////  //Programmazione di uno spettacolo per "FastandFurious"
////////////
//  LocalDateTime orarioProiezioneFastAndFurious = LocalDateTime.of(2024, 2, 26, 20, 45);
//  amministratore.eseguiComando(new CreaSpettacoloCommand("02", fastandfurious,2,orarioProiezioneFastAndFurious));
//  CinemaSerializer.salvaStatoGestioneCinema(cinema.getGestioneCinema(), filePathCinema);

//  // Dopo aver caricato GestioneCinema, stampa le informazioni caricate
  gestioneCinemaCaricata = cinema.getGestioneCinema();
  System.out.println("Sale caricate: " + gestioneCinemaCaricata.getSale().values());
  System.out.println("Film in programmazione: " + gestioneCinemaCaricata.getFilmInProgrammazione());
  System.out.println("Programmazione spettacoli: " + gestioneCinemaCaricata.getProgrammazione());
//
////  // Ricerca dello spettacolo programmato per "Interstellar" tramite ID
  Spettacolo spettacoloInterstellar = gestioneCinemaCaricata.trovaSpettacolo("01");
  if (spettacoloInterstellar == null) {
   System.out.println("Spettacolo di 'Interstellar' non trovato.");
  } else {
   System.out.println("Spettacolo trovato: " + spettacoloInterstellar);
  }
//////
//////  // Ricerca dello spettacolo programmato per "FastAndFurious" tramite ID
  Spettacolo spettacoloFastAndFurious = gestioneCinemaCaricata.trovaSpettacolo("02");
  if (spettacoloFastAndFurious == null) {
   System.out.println("Spettacolo di 'FastAndFurious' non trovato.");
  } else {
   System.out.println("Spettacolo trovato: " + spettacoloFastAndFurious);
  }

  // Salva lo stato finale di GestioneCinema
  //CinemaSerializer.salvaStatoGestioneCinema(cinema.getGestioneCinema(), filePathCinema);




////  // Impostazione dei prezzi dei biglietti
//   amministratore.eseguiComando(new ImpostaPrezziBigliettiCommand(10.0, 5.0));
//   GestorePrezziSerializer.salvaStatoGestorePrezzi(cinema.getGestorePrezzi(), filePathPrezzi);


////  // Aumento dei prezzi dei biglietti
//     amministratore.eseguiComando(new IncrementaPrezzoBigliettiCommand(5, 3));
//     GestorePrezziSerializer.salvaStatoGestorePrezzi(cinema.getGestorePrezzi(), filePathPrezzi);

////  // Diminuzione dei prezzi dei biglietti
//  amministratore.eseguiComando(new DecrementaPrezzoBigliettiCommand(20,15));
//     GestorePrezziSerializer.salvaStatoGestorePrezzi(cinema.getGestorePrezzi(), filePathPrezzi);

////  // Diminuzione dei prezzi dei biglietti
////  //amministratore.eseguiComando(new DecreaseTicketPriceCommand(0.5, 0.2));

//// Creazione di un utente
   Utente utente = new Utente("Mario", "Rossi", Ruolo.UTENTE);
////
//////
//////
//////
//////
//////
////////
////////
//////////  // Creazione dei factory per i biglietti
//   BigliettoFactory bigliettoInteroFactory = new BigliettoInteroFactory();
//   BigliettoFactory bigliettoRidottoFactory = new BigliettoRidottoFactory();
//////////////////
//////////////////  // Creazione biglietto Interstellar (intero)
//   Biglietto bigliettoInterstellar = bigliettoInteroFactory.creaBiglietto(spettacoloInterstellar, utente);
//////////////////
//////////////////
//////////////////  // Creazione biglietto Interstellar (ridotto)
//   Biglietto bigliettoInterstellarRidotto = bigliettoRidottoFactory.creaBiglietto(spettacoloInterstellar, utente);
//////////////////
//////////////////
//////////////////  //Creazione biglietto FastAndFurious (intero)
//  Biglietto bigliettoFastAndFurious = bigliettoInteroFactory.creaBiglietto(spettacoloFastAndFurious,utente);
////////////////
////////////////  //Creazione biglietto FastAndFurious (ridotto)
//////// Biglietto bigliettoFastAndFuriousRidotto = bigliettoRidottoFactory.creaBiglietto(spettacolofastandfurious,utente);
////////////////////
////////////////////
////////////////////
////////////////////
////////////////////  // Configurazione del metodo di pagamento Carta di Credito
//  IPagamentoStrategy metodoPagamento = new PagamentoCartaDiCreditoStrategy();
//   GestorePagamenti gestorePagamenti = new GestorePagamenti(metodoPagamento);
//////////////////
//////////////////// // Configurazione del metodo di pagamento Contanti
//  IPagamentoStrategy metodoPagamentoContanti = new PagamentoContantiStrategy();
//  GestorePagamenti gestorePagamentiContanti = new GestorePagamenti(metodoPagamentoContanti);
//////////////////
//////////////////  // Configurazione del metodo di pagamento Bancomat
//  IPagamentoStrategy metodoPagamentoBancomat = new PagamentoBancomatStrategy();
//   GestorePagamenti gestorePagamentiBancomat = new GestorePagamenti(metodoPagamentoBancomat);
//////////////////
////////////////////
////////////////////  // Creazione del servizio di acquisto biglietto con Carta di Credito
//   ServizioAcquistoBiglietto servizioAcquisto = new ServizioAcquistoBiglietto(gestorePagamenti);
//////////////////
////////////////////  //Creazione del servizio di acquisto biglietto con Contanti
//  ServizioAcquistoBiglietto servizioAcquistoContanti = new ServizioAcquistoBiglietto(gestorePagamentiContanti);
////////
////////////////////  //Creazione del servizio di acquisto biglietto con Bancomat
//////////////   ServizioAcquistoBiglietto servizioAcquistoBancomat = new ServizioAcquistoBiglietto(gestorePagamentiBancomat);
////////
////////
////////  // Acquisto del biglietto Interstellar Carta di Credito
////////
//   servizioAcquisto.acquistaBiglietto(bigliettoInterstellarRidotto, metodoPagamento);
////////
////////
////   GestoreStampa.stampaDettagliBiglietto(bigliettoInterstellarRidotto);
////////
////////
//////// //Acquisto del biglietto Interstellar Ridotto Contanti
////////
//  servizioAcquisto.acquistaBiglietto(bigliettoInterstellar, metodoPagamentoContanti);
//  servizioAcquisto.acquistaBiglietto(bigliettoInterstellar, metodoPagamentoContanti);
//////////
////////////
////  GestoreStampa.stampaDettagliBiglietto(bigliettoInterstellar);
////////////
////////////
//////////// //Acquisto del biglietto Fast and Furious Ridotto Carta di Credito
////////////
//  servizioAcquisto.acquistaBiglietto(bigliettoFastAndFurious, metodoPagamento);
////////////
////  GestoreStampa.stampaDettagliBiglietto(bigliettoFastAndFurious);
//////
//////////////  // Acquisto del biglietto Fast and Furious Bancomat
//////
//  servizioAcquisto.acquistaBiglietto(bigliettoFastAndFurious, metodoPagamentoBancomat);
//
////
 // GestoreStampa.stampaDettagliBiglietto(bigliettoFastAndFurious);

  //

//////
//////
//////  // Tentativo di annullare l'ultimo acquisto immediatamente
//  Caretaker caretaker = cinema.getCaretaker();
//  if (caretaker.canUndo()) {
//   AcquistoMemento ultimoAcquistoAnnullato = caretaker.undoLastAcquisto();
//   System.out.println("L'ultimo acquisto è stato annullato con successo.");
//  } else {
//   System.out.println("Non è possibile annullare l'ultimo acquisto.");
// }


//////
//////  GestoreStampa.stampaDettagliBiglietto(bigliettoFastAndFurious);
//////
//////  System.out.println("Acquisto biglietto completato per l'utente: " + utente.getNome() + " " + utente.getCognome());
//////

//////
//////  CinemaSerializer.salvaStatoGestioneCinema(cinema.getGestioneCinema(), filePath);
//////  System.out.println("Stato attuale di GestioneCinema salvato con successo.");
// // CinemaSerializer.salvaStatoGestioneCinema(cinema.getGestioneCinema(), filePathCinema);

//  GestoreRicavi gestore = cinema.getGestoreRicavi();
//  gestore.stampaReportRicavi();

  //////  // Generazione del report dei ricavi
  amministratore.eseguiComando(new GeneraReportRicaviCommand());

//  // Test dei metodi getRicaviDaSpettacolo e getBigliettiVendutiDaSpettacolo
//  double ricaviSpettacolo1 = Cinema.getInstance().getGestoreRicavi().getRicaviDaSpettacolo("01");
//  int bigliettiVendutiSpettacolo1 = Cinema.getInstance().getGestoreRicavi().getBigliettiVendutiDaSpettacolo("01");
//
//  double ricaviSpettacolo2 = Cinema.getInstance().getGestoreRicavi().getRicaviDaSpettacolo("02");
//  int bigliettiVendutiSpettacolo2 = Cinema.getInstance().getGestoreRicavi().getBigliettiVendutiDaSpettacolo("02");
//
//  // Stampa dei risultati dei test
//  System.out.println("Ricavi Spettacolo 1: " + ricaviSpettacolo1);
//  System.out.println("Biglietti Venduti Spettacolo 1: " + bigliettiVendutiSpettacolo1);
//
//  System.out.println("Ricavi Spettacolo 2: " + ricaviSpettacolo2);
//  System.out.println("Biglietti Venduti Spettacolo 2: " + bigliettiVendutiSpettacolo2);
////
  GestoreRicaviSerializer.salvaStatoGestoreRicavi(cinema.getGestoreRicavi(), filePatchRicavi);
  CaretakerSerializer.salvaStatoCaretaker(cinema.getCaretaker(), filePathCaretaker);



  }
 }

























