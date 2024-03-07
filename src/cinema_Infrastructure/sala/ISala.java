package cinema_Infrastructure.sala;

public interface ISala {
    // Metodo per occupare un posto nella sala, ritorna true se il posto è stato occupato, false altrimenti (es. sala piena)
    boolean occupaPosto();

    // Metodo per liberare un posto nella sala
    void liberaPosto();

    // Setter per l'ID della sala
    void setId(long id);

    // Getter per l'ID della sala
    long getId();

    // Getter per la capacità totale della sala
    int getCapacita();

    // Getter per il numero della sala
    int getNumeroSala();

    // Metodo per ottenere il numero di posti disponibili nella sala
    int getPostiDisponibili();
}
