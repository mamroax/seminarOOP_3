import java.util.List;

public class StreamService{
    public void sortStreams(List<Stream> streams) {
        StreamComparator comparator = new StreamComparator();
        streams.sort(comparator);
    }
}
