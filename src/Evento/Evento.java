package Evento;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Evento {
  private String nome;
  private LocalDate data;
  private TipoEvento tipo;
  private String codice;
  
  public Evento(String nome, LocalDate data, TipoEvento tipo) {
    if (nome == null || nome.trim().isEmpty()) {
      throw new IllegalArgumentException("Il nome dell'evento non può essere vuoto.");
    }
    
    if (data.isBefore(LocalDate.now())) {
      throw new DateTimeException("La data dell'evento non può essere nel passato.");
    }
    
    this.nome = nome;
    this.data = data;
    this.tipo = tipo;
    this.codice = generaCodice(data);
  }
  
  private String generaCodice(LocalDate data) {
    String dataFormattata = data.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
    
    int nnn = new Random().nextInt(900) + 100;
    
    return "EVT-" + dataFormattata + "-" + nnn;
  }
}
