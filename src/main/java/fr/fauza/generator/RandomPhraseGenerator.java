package fr.fauza.generator;

import java.util.Random;

/**
 * Générateur de phrases aléatoires à partir d'un ensemble de mots définis.
 * Utilisé pour générer des requêtes de recherche aléatoires pour le crawler.
 * @Author FauZaPespi 31.10.2024
 */
public class RandomPhraseGenerator {
    // Initialisation de la variable de génération aléatoire
    private static final Random RANDOM = new Random();

    // Ensemble de mots utilisés pour la génération de phrases
    private static final String[] WORDS = {"the", "sheep", "minecraft", "serveur"};

    /**
     * Génère une phrase aléatoire composée de 1 à 5 mots.
     *
     * @return Une chaîne de caractères contenant une phrase aléatoire.
     */
    public static String generateRandomPhrase() {
        StringBuilder phrase = new StringBuilder();
        int numberOfWords = RANDOM.nextInt(5) + 1;

        for (int i = 0; i < numberOfWords; i++) {
            String word = WORDS[RANDOM.nextInt(WORDS.length)];
            word = addRandomCharacters(word);
            phrase.append(word).append(" ");
        }

        return phrase.toString().trim();
    }

    /**
     * Ajoute des caractères aléatoires avant et après un mot donné.
     *
     * @param word Le mot auquel des caractères aléatoires seront ajoutés.
     * @return Le mot modifié avec des caractères aléatoires.
     */
    private static String addRandomCharacters(String word) {
        char randomCharBefore = (char) (RANDOM.nextInt(26) + 'a');
        char randomCharAfter = (char) (RANDOM.nextInt(26) + 'a');

        return randomCharBefore + word + randomCharAfter;
    }
}
