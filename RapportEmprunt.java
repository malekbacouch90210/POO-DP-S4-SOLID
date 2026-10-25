import java.util.ArrayList;
import java.util.List;

public class RapportEmprunt implements AutoCloseable {

    private final List<String> titres = new ArrayList<>();
    private boolean ferme = false;

    public void enregistrer(String titre) {
        if (ferme)
            throw new IllegalStateException("Rapport deja ferme");
        titres.add(titre);
    }

    public List<String> getTitres() {
        return List.copyOf(titres);          // copie defensive : pas d'exposition interne
    }

    public boolean estFerme() {
        return ferme;
    }

    @Override
    public void close() {                    // pas de "throws Exception" : plus simple pour l'appelant
        ferme = true;
        System.out.println("Rapport ferme : " + titres.size() + " emprunt(s) enregistre(s)");
    }
}