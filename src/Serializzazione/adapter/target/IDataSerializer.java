package Serializzazione.adapter.target;

public interface IDataSerializer {
    void serialize(Object data, String filePath);
    Object deserialize(String filePath);
}
