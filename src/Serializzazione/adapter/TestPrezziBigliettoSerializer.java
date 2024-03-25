//package Serializzazione.adapter;
//
//import Serializzazione.adapter.adapter.PrezziBigliettoSerializerAdapter;
//import Serializzazione.adapter.target.IDataSerializer;
//import ticket_pricing.PrezziBiglietto;
//
//public class TestPrezziBigliettoSerializer {
//    public static void main(String[] args) {
//        IDataSerializer prezziBigliettoSerializer = new PrezziBigliettoSerializerAdapter();
//
//        PrezziBiglietto prezziBiglietto = new PrezziBiglietto(10.0, 7.5);
//        prezziBigliettoSerializer.serialize(prezziBiglietto, "prezziBiglietto.ser");
//
//        PrezziBiglietto loadedPrezziBiglietto = (PrezziBiglietto) prezziBigliettoSerializer.deserialize("prezziBiglietto.ser");
//        System.out.println("Prezzo Intero: " + loadedPrezziBiglietto.getPrezzoIntero() + ", Prezzo Ridotto: " + loadedPrezziBiglietto.getPrezzoRidotto());
//    }
//}
