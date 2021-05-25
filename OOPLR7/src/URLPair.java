import java.util.LinkedList;
import java.net.MalformedURLException;
import java.net.URL;

public class URLPair {

    private String address;
    private int depth;

    public int getDepth(){
        return depth;
    }

    public String getUrl(){
        return address;
    }

    public URLPair(String address, int depth){
        this.address = address;
        this.depth = depth;
    }

    @Override
    public String toString(){
        return address + " | depth: " + depth;
    }
}