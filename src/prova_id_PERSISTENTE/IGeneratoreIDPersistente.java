package prova_id_PERSISTENTE;

public interface IGeneratoreIDPersistente {
    long generaProssimoId();
    void salvaUltimoIdUsato();
    void caricaUltimoIdUsato();
}
