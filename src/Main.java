import Evento.Evento;
import Evento.TipoEvento;
import Evento.GestoreEventi;

import java.time.LocalDate;

public class Main {
  
  public static void main(String[] args) {
    GestoreEventi gestore = new GestoreEventi();
    
    Evento e1 = new Evento("Concerto di Natale", LocalDate.of(2027, 12, 25), TipoEvento.CONCERTO);
    Evento e2 = new Evento("Java Conference Milano", LocalDate.of(2027, 3, 10), TipoEvento.CONFERENZA);
    Evento e3 = new Evento("Workshop Design Patterns", LocalDate.of(2027, 5, 18), TipoEvento.WORKSHOP);
    Evento e4 = new Evento("Champions League Finale", LocalDate.of(2027, 6, 1), TipoEvento.SPORT);
    Evento e5 = new Evento("Festival Jazz Roma", LocalDate.of(2027, 7, 20), TipoEvento.CONCERTO);
    
    gestore.aggiungiEvento(e1);
    gestore.aggiungiEvento(e2);
    gestore.aggiungiEvento(e3);
    gestore.aggiungiEvento(e4);
    gestore.aggiungiEvento(e5);
    
    System.out.println("Sono presenti i seguenti eventi: ");
    System.out.println("");
    
    gestore.getEventi();
    
    System.out.println("");
    System.out.println("Sono presenti i seguenti eventi filtrati per data: ");
    System.out.println("");
    System.out.println(gestore.cercaPerData(LocalDate.of(2027, 12, 25)));
    
    System.out.println("");
    System.out.println("Sono presenti i seguenti eventi filtrati per tipo: ");
    System.out.println("");
    System.out.println(gestore.cercaPerTipo(TipoEvento.SPORT));
  }
}
