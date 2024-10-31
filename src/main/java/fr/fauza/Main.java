package fr.fauza;

import static fr.fauza.crawler.CrawlerBasic.googleSampleUrl;

/**
 * La classe principale qui démarre le programme.
 * Elle initialise l'URL de départ pour le crawler et lance le processus de crawling.
 * @Author FauZaPespi 31.10.2024
 */
public class Main {

    /**
     * Point d'entrée de l'application.
     * @param args Arguments de la ligne de commande (non utilisés).
     */
    public static void main(String[] args) {
        String startUrl = googleSampleUrl + "wikipedia&rlz=1C1GCEA_enCH1114CH1114&oq=wikipedia&gs_lcrgfsadgZjaHJvbWUyBggAEEUYOTIHCAdgfgdsPAtIBCDM4ODdqMGo3qAIAsAIA&sourceid=chrome&ie=UTF-8"; // Point de départ du crawler
        fr.fauza.crawler.CrawlerBasic.crawl(startUrl);
    }
}

/**
 * Site utilisé:
 *                  - https://jsoup.org/ | Pour la doc de jsoup
 *                  - la doc java de ZEAL
 *                  - https://google.fr | https://fr.wikipedia.org/ [pour les tests]
 */