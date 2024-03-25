package prova_id_PERSISTENTE;

import java.io.IOException;

public interface IGeneratoreIDPersistente {
    long generaProssimoId() ;
    void salvaUltimoIdUsato() ;

     void caricaUltimoIdUsato() ;
}
