import java.util.LinkedList;

import java.util.*;

public class URLPool
{
    private HashMap<String, URLPair> visited;
    private LinkedList<URLPair> toVisit;

    public URLPool()
    {
        visited = new HashMap<>();
        toVisit = new LinkedList<>();
    }

    public synchronized URLPair getLink()
    {
        boolean isWaiting = false;
        if (toVisit.size() == 0)
        {
            try
            {
                Crawler.threadsWaiting++;
                isWaiting = true;
                this.wait();
            }
            catch (Exception e)
            {
                return null;
            }
        }
        if (isWaiting) Crawler.threadsWaiting--;
        URLPair urlPair = toVisit.pop();
        visited.put(urlPair.getURL(), urlPair);
        return urlPair;
    }

    public synchronized void addLink(URLPair urlPair)
    {
        if (!visited.containsKey(urlPair.getURL()))
        {
            toVisit.add(urlPair);
            this.notify();
        }
    }
}