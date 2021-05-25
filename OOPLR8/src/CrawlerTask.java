import java.util.*;
import java.net.*;

public class CrawlerTask extends Thread
{
    private URLPool urlPool;
    private final String protocol = "https:";

    public CrawlerTask(URLPair urlPair){
        urlPool = new URLPool();
        urlPool.addLink(urlPair);
    }

    @Override
    public void run()
    {
        URLPair urlPair = urlPool.getLink();
        System.out.println(urlPair);
        Crawler.URLCount++;
        if (urlPair.getDepth() >= Crawler.getMaxDepth()) return;
        search(urlPair);
    }

    private void search(URLPair current_address){
        try {
            URL url = new URL(current_address.getURL());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            Scanner scanner = new Scanner(connection.getInputStream());
            while (scanner.findWithinHorizon("<a\\s+(?:[^>]*?\\s+)?href=([\"'])(.*?)\\1", 0) != null)
            {
                String new_url = scanner.match().group(2);
                URLPair new_address = newURLPair(new_url, current_address);
                if (new_address == null) continue;
                newThread(new_address);
            }
        } catch (Exception e) {
            System.err.println("Exception: " + e.getLocalizedMessage());
        }
    }

    private URLPair newURLPair(String new_url, URLPair current_address)
    {
        if (new_url.startsWith("//"))
            new_url = protocol + new_url;
        else if (!new_url.startsWith(protocol)) return null;
        URLPair new_pair = new URLPair(new_url, current_address.getDepth() + 1);
        return new_pair;
    }

    private void newThread(URLPair urlPair)
    {
        CrawlerTask task = new CrawlerTask(urlPair);
        task.start();
    }
}