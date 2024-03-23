package cinema_Infrastructure.sala;

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
