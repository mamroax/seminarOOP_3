import java.util.ArrayList;
import java.util.List;

public class Stream extends StudentGroup implements Iterable<Student>{
    protected List<StudentGroup> studyGroupList = new ArrayList<StudentGroup>();
    protected static int lastId = -1;
    protected int groupsCount;
    protected int id;


    public Stream(List<StudentGroup> studyGroupList) {
        this.studyGroupList = studyGroupList;
        this.groupsCount = studyGroupList.size();
        id = generateUniqueId(); // Генерируем уникальный ID при создании объекта
    }

    private int generateUniqueId() {
        return ++lastId;
    }

    public void addGroup(StudentGroup studyGroup) {
        studyGroupList.add(studyGroup);
        groupsCount++;
    }

    public void addGroup(int groupNumber, List<Student> studentList) {
        studyGroupList.add(new StudentGroup(groupNumber, studentList));
        groupsCount++;
    }


    public void removeGroup(StudentGroup studyGroup) {
        studyGroupList.remove(studyGroup);
        groupsCount--;
    }

    public void removeGroup(int groupNumber, List<Student> studentList) {
        studyGroupList.remove(new StudentGroup(groupNumber, studentList));
        groupsCount--;
    }

    public List<StudentGroup> getStudyGroupList() {
        return studyGroupList;
    }


    public int getGroupsCount() {
        return groupsCount;
    }


    public int getId() {
        return id;
    }

    public String getInfo() {
        StringBuilder result = new StringBuilder();
        result.append("=".repeat(10)).append(" Stream Info ").append("=".repeat(10)).append('\n');
        int totalStudentsCount = 0;
        for (StudentGroup group : studyGroupList) {
            totalStudentsCount += group.getStudentsCount();
        }

        result.append(" - Groups count: ").append(groupsCount).append("\n");
        result.append(" - Total students count: ").append(totalStudentsCount).append('\n');
        return result.toString();
    }
}
