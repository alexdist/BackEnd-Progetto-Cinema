package admin_commands.revenues;

import admin_interfaces.ICommand;
import revenues_observer.observer.IReport;


 // Comando per generare un report dei ricavi.
 // Implementa l'interfaccia ICommand e interagisce con l'interfaccia IReport per la generazione del report.
public class GeneraReportRicaviCommand implements ICommand {

    // Interfaccia per la gestione della generazione di report.
    private IReport report;

    // Costruttore che inizializza il comando con l'oggetto che si occupa di generare il report.
    public GeneraReportRicaviCommand(IReport report){
        this.report = report;
    }


     //  Metodo che esegue l'azione del comando, attivando il metodo di generazione del report.
     // Questo metodo invoca generate() sul report, che è responsabile per la creazione del report dei ricavi.
     public void execute(){
        report.generate();
    }
}
