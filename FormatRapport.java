import java.util.List;

// Responsabilite 1 : transformer des documents en texte (CSV, TXT, JSON...)
public interface FormatRapport {
    String formater(List<Document> docs);
}