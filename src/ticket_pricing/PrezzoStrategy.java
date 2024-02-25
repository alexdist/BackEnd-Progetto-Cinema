package ticket_pricing;

import cinema_Infrastructure.Spettacolo;

public interface PrezzoStrategy {
  double calcolaPrezzo(Spettacolo spettacolo, String tipoBiglietto, PrezziBiglietto prezziCorrenti);
}

