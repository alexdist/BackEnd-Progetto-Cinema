package revenues_observer.observer;


//OBSERVER
// Interfaccia Observer: definisce l'operazione di update che deve essere implementata da ogni observer concreto.
public interface IReport {

    void update();  // Metodo utilizzato per aggiornare i dati del report in risposta a un cambiamento.

    void generate(); // Metodo per generare il report basato sui dati aggiornati.
}
