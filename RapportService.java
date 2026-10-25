import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

// CODE FOURNI (version "avant") : il fonctionne... et il est indefendable.
// Il sera refactore aux etapes 3, 4 et 5.
public class RapportService {

    public void genererRapport(List<Document> docs, String format) {
        String contenu = "";
        if (format.equals("CSV")) {
            for (Document d : docs)
                contenu += d.getTitre() + ";" + d.getId() + "\n";
        } else if (format.equals("TXT")) {
            for (Document d : docs)
                contenu += "- " + d.descriptionCourte() + "\n";
        } else {
            throw new RuntimeException("Format inconnu");
        }

        try (var w = new FileWriter("C:\\rapports\\rapport.txt")) {   // chemin en dur !
            w.write(contenu);
        } catch (IOException e) { }                                   // exception avalee !

        new ServeurSmtp("smtp.itbs.tn")
            .envoyer("direction@itbs.tn", "Rapport genere");
    }
}