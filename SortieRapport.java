import java.io.IOException;

// Responsabilite 2 : ecrire le contenu quelque part (fichier, memoire, reseau...)
public interface SortieRapport {
    void ecrire(String contenu) throws IOException;   // l'echec doit REMONTER
}