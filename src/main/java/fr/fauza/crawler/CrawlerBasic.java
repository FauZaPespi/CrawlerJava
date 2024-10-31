package fr.fauza.crawler;


import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Classe responsable du crawling de pages web.
 * Utilise Jsoup pour extraire et suivre les liens sur les pages visitées.
 * @Author FauZaPespi 31.10.2024
 */
public class CrawlerBasic {
    // Init pour pouvor suivre les URLs visitées
    private static Set<String> visitedUrls = new HashSet<>();

    // Vous pouvez changer l'URL de base.
    // Ici, j'ai mis Google car il y a plein de <a> dedans, donc c'est plus rapide,
    // mais vous pouvez mettre n'importe quelle page avec beaucoup de liens, comme Wikipedia, et c'est pareil.
    public static String googleSampleUrl = "https://www.google.com/search?q=";

    /**
     * Démarre le processus de crawling à partir de l'URL fournie.
     * Si l'URL a déjà été visitée, une nouvelle URL sera générée à l'aide d'un générateur de phrases aléatoires.
     *
     * @param url L'URL à crawler.
     */
    public static void crawl(String url) {
        if (visitedUrls.contains(url)) {
            crawl(googleSampleUrl + fr.fauza.generator.RandomPhraseGenerator.generateRandomPhrase());
        }

        try {
            // Ajout de l'URL visitées
            visitedUrls.add(url);
            System.out.println("Visiting: " + url);

            // Connexion à l'URL et récupération du document HTML
            Document document = Jsoup.connect(url).get();
            Elements links = document.select("a[href]");

            for (Element link : links) {
                String foundUrl = link.absUrl("href");
                if (!visitedUrls.contains(foundUrl)) {
                    crawl(foundUrl);
                }
            }
        } catch (IOException e) {
            System.out.println("Erreur lors de la connexion à l'URL: " + url);
        }
    }
}
