import java.util.List;

public class Main {
    /**
     * — Создать класс Поток, содержащий в себе список УчебныхГрупп и реализующий интерфейс Iterable;
     * — Создать класс StreamComparator, реализующий сравнение количества групп, входящих в Поток;
     * — Создать класс ПотокСервис, добавив в него метод сортировки списка потоков,
     * используя созданный StreamComparator; */
    public static void main(String[] args) {
        Student student = Generator.getRandomStudent();
        System.out.println(student);

        StudentGroup studyGroup = Generator.getRandomStudyGroup(20, 103);
        System.out.println(studyGroup);

        Stream stream = Generator.getRandomStream(4, 15,30);
        System.out.println(stream);

        System.out.println("<".repeat(10) + " Исходный поток " + ">".repeat(10));
        List<Stream> streams = Generator.getRandomStreamList(6,4, 10,4,12);
        for (Stream instream : streams) {
            System.out.printf("ID потока: %s. Всего групп в потоке: %s%n",instream.getId(), instream.getGroupsCount());
        }
        StreamService streamService = new StreamService();
        System.out.println("<".repeat(10) + " Отсортированный поток " + ">".repeat(10));
        streamService.sortStreams(streams);
        for (Stream instream : streams) {
            System.out.printf("ID потока: %s. Всего групп в потоке: %s%n",instream.getId(), instream.getGroupsCount());
        }
    }
}