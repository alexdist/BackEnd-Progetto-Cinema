package cinema_Infrastructure.sala;

// Interfaccia ISala che definisce il contratto per le operazioni base su una Sala.
public interface ISala {
    boolean occupaPosto();
    void liberaPosto();
    void setId(long id);
    long getId();
    int getCapacita();
    int getNumeroSala();
    int getPostiDisponibili();
    ISala clone();
}
