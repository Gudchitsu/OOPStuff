public class URLPair
{
    private String address;
    private int depth;

    public int getDepth()
    {
        return depth;
    }

    public String getURL()
    {
        return address;
    }

    public URLPair(String address, int depth)
    {
        this.address = address;
        this.depth = depth;
    }

    @Override
    public String toString()
    {
        return address + " | depth: " + depth;
    }
}