
import java.net.*;
import java.util.LinkedList;

import java.util.*;

public class Crawler {

    private int maxDepth;
    private LinkedList<URLPair> toVisit;
    private HashMap<String, URLPair> visited;
    private static final String protocol = "http:";

    public static void main(String args[])
    {
        Crawler crawler = new Crawler("http://pravo.gov.ru/", 3);
        crawler.run();
    }

    public Crawler(String address, int maxDepth){
        visited = new HashMap<>();
        toVisit = new LinkedList<>();
        toVisit.add(new URLPair(address, 0));
        this.maxDepth = maxDepth;
    }

    public void run(){
        while (toVisit.size() > 0) {
            URLPair current_address = toVisit.pop();
            if (visited.containsKey(current_address.getUrl())) continue;
            visited.put(current_address.getUrl(), current_address);
            System.out.println(current_address);
            if (current_address.getDepth() < maxDepth)
                search(current_address);
        }
    }

    private void search(URLPair current_address){
        try {
            URL url = new URL(current_address.getUrl());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            Scanner scanner = new Scanner(connection.getInputStream());

            while (scanner.findWithinHorizon("<a\\s+(?:[^>]*?\\s+)?href=([\"'])(.*?)\\1", 0) != null){
                String new_url = scanner.match().group(2);
                newURLPair(new_url, current_address);
            }
        } catch (Exception e) {
            System.err.println("Exception: " + e.getLocalizedMessage());
        }
    }

    private void newURLPair(String new_url, URLPair current_address){
        if (new_url.startsWith("//"))
            new_url = protocol + new_url;
        else if (!new_url.startsWith(protocol)) return;
        URLPair new_pair = new URLPair(new_url, current_address.getDepth() + 1);
        toVisit.add(new_pair);
    }
}