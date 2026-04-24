package Evento;

import java.time.LocalDate;
import java.util.ArrayList;

public class GestoreEventi {
  private Evento[] eventi = new Evento[100];
  private int contatore = 0;
  
  public void aggiungiEvento(Evento e) {
    // aggiungo l'evento e all'array eventi, utilizzando un contatore per tenere traccia del numero di eventi aggiunti
    if (contatore < 100) {
      eventi[contatore++] = e;
    } else {
      throw new IllegalStateException("Limite massimo di eventi raggiunto.");
    }
  }
  
  // uso arraylist per restituire una lista di eventi filtrati per data, iterando sull'array eventi e aggiungendo gli eventi che hanno la data corrispondente
  public ArrayList<Evento> cercaPerData(LocalDate data) {
    ArrayList<Evento> eventiFiltrati = new ArrayList<Evento>();
    
    for (int i = 0; i < contatore; i++) {
      if (eventi[i].getData().equals(data)) {
        eventiFiltrati.add(eventi[i]);
      }
    }
    
    return eventiFiltrati;
  }
  
  // uso arraylist per restituire una lista di eventi filtrati per tipo, iterando sull'array eventi e aggiungendo gli eventi che hanno il tipo corrispondente
  public ArrayList<Evento> cercaPerTipo(TipoEvento tipo) {
    ArrayList<Evento> eventiFiltrati = new ArrayList<Evento>();
    
    for (int i = 0; i < contatore; i++) {
      if (eventi[i].getTipo() == tipo) {
        eventiFiltrati.add(eventi[i]);
      }
    }
    
    return eventiFiltrati;
  }
}
