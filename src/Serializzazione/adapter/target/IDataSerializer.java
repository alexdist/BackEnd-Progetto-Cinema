package Serializzazione.adapter.target;

import java.io.IOException;

// IDataSerializer è l'interfaccia Target che definisce le operazioni che il client può invocare.
public interface IDataSerializer {
    void serialize(Object data, String filePath);
    Object deserialize(String filePath);
}
