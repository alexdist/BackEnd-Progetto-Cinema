package admin_commands;
//
//import admin_interfaces.Command;
//import ticket_pricing.GestoreRicavi;
//import singleton.*;
//
//// Definisce un comando per generare e stampare un report dei ricavi per il cinema.
//public class GeneraReportRicaviCommand implements Command {
//
//    // Costruttore di default non necessario da specificare esplicitamente
//    // poiché non ci sono campi dati da inizializzare.
//
//    // Implementazione del metodo execute definito dall'interfaccia Command.
//    // Questo metodo viene chiamato per eseguire l'azione di generazione e stampa del report dei ricavi.
//    @Override
//    public void execute() {
//        // Accede a GestoreRicavi tramite il singleton Cinema e invoca il metodo stampaReportRicavi
//        // per generare e stampare il report dei ricavi.
//        Cinema.getInstance().getGestoreRicavi().stampaReportRicavi();
//    }
//}

import admin_interfaces.Command;
import cinema_Infrastructure.Spettacolo;
import singleton.Cinema;

public class GeneraReportRicaviCommand implements Command {

    @Override
    public void execute() {
        // Chiama direttamente il metodo stampaReportRicavi sul singleton di Cinema
        // che a sua volta invoca il metodo stampaReportRicavi su GestoreRicavi
        Cinema.getInstance().getGestoreRicavi().stampaReportRicavi();
    }
}