package admin_commands.revenues;

import admin_interfaces.ICommand;
import revenues.RegistroBiglietti;

public class GeneraReportRicaviCommand implements ICommand {

    public GeneraReportRicaviCommand(){}


    public void execute(){
        RegistroBiglietti.reportAffluenzaPerSala();
        RegistroBiglietti.reportRicaviPerSala();
    }
}
