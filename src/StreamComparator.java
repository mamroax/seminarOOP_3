import java.util.Comparator;

public class StreamComparator implements Comparator<Stream> {
    @Override
    public int compare(Stream stream1, Stream stream2) {
        return Integer.compare(stream1.getGroupsCount(), stream2.getGroupsCount());
    }
}
