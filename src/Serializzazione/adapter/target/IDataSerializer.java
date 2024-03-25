package Serializzazione.adapter.target;

import java.io.IOException;

public interface IDataSerializer {
    void serialize(Object data, String filePath);
    Object deserialize(String filePath);
}
