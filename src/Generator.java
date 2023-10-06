import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Generator {


    public static String randomFrom(List<String> list) {
        return list.get(new Random().nextInt(list.size()));
    }


    public static List<String> fillEnumsList(Enum[] enums) {
        List<String> result = new ArrayList<>();
        for (Enum anEnum : enums) result.add(anEnum.name());
        return result;
    }

    public static Student getRandomStudent() {
        List<String> firstNames = fillEnumsList(FirstName.values());
        List<String> lastNames = fillEnumsList(LastName.values());
        return new Student(randomFrom(firstNames), randomFrom(lastNames));
    }


    public static List<Student> getRandomStudentList(int count) {
        List<Student> studentList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            studentList.add(getRandomStudent());
        }
        return studentList;
    }

    public static StudentGroup getRandomStudyGroup(int studentCount, int groupNumber) {
        return new StudentGroup(groupNumber, getRandomStudentList(studentCount));
    }

    public static List<StudentGroup> getRandomStudyGroupList(int count, int minStudentsInGroup, int maxStudentsInGroup) {
        List<StudentGroup> studyGroupList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            studyGroupList.add(getRandomStudyGroup(new Random().nextInt(minStudentsInGroup, maxStudentsInGroup), i + 100));
        }
        return studyGroupList;
    }


    public static Stream getRandomStream(int groupsCountInStream, int minStudentsInGroup, int maxStudentsInGroup) {
        return new Stream(getRandomStudyGroupList(groupsCountInStream, minStudentsInGroup, maxStudentsInGroup));
    }


    public static List<Stream> getRandomStreamList(int streamCount,
                                                   int minGroupsCountInStream,
                                                   int maxGroupsCountInStream,
                                                   int minStudentsInGroup,
                                                   int maxStudentsInGroup) {
        List<Stream> streams = new ArrayList<>();
        for (int i = 0; i < streamCount; i++) {
            streams.add(getRandomStream(new Random().nextInt(minGroupsCountInStream, maxGroupsCountInStream),
                    minStudentsInGroup,maxStudentsInGroup));
        }
        return streams;
    }
}
