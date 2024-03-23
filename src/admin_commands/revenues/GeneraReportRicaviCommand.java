package admin_commands.revenues;

import admin_interfaces.ICommand;
import revenues_observer.observer.IReport;


public class GeneraReportRicaviCommand implements ICommand {

    private IReport report;
    public GeneraReportRicaviCommand(IReport report){
        this.report = report;
    }


    public void execute(){
        report.generate();
    }
}
