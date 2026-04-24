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
    
    this.nome = formattaNome(nome);
    this.data = data;
    this.tipo = tipo;
    this.codice = generaCodice(data);
  }
  
  private String generaCodice(LocalDate data) {
    String dataFormattata = data.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
    
    int nnn = new Random().nextInt(900) + 100;
    
    return "EVT-" + dataFormattata + "-" + nnn;
  }
  
  private String formattaNome(String nome) {
    StringBuilder nomeFormattato = new StringBuilder();
    
    // creo un array che contiene le parole trimmate del nome dell'evento dividendo ogni parola considerando lo spazio
    String[] parole = nome.trim().split("\\s+");
    
    for (String parola : parole) {
      if (!parola.isEmpty()) {
        // per ogni parola nell'array, se la parola non è vuota, prendo la prima lettera e la trasformo in uppercase
        nomeFormattato.append(Character.toUpperCase(parola.charAt(0)));
        
        // appendo il resto della parola in minuscolo
        nomeFormattato.append(parola.substring(1).toLowerCase());
        
        // appendo uno spazio dopo ogni parola
        nomeFormattato.append(" ");
      }
    }
    
    // trim del nome completo dell'evento per rimuovere l'ultimo spazio
    String nomeEvento = nomeFormattato.toString().trim();
    
    // appendo il resto della parola in minuscolo */ se il nome dell'evento supera i 50 caratteri, eseguo il truncate prendendo solo le prime 50 lettere aggiungedo alla fine "..."
    return nomeEvento.length() > 50 ? nomeEvento.substring(0, 50) + "..." : nomeEvento;
  }
}
