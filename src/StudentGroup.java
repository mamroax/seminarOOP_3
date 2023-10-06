import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudentGroup implements Iterable<Student>{
    protected int groupNumber;
    protected List<Student> studentList = new ArrayList<>();

    public StudentGroup(){}

    public StudentGroup(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    public StudentGroup(int groupNumber, List<Student> studentList) {
        this.groupNumber = groupNumber;
        this.studentList = studentList;
    }

    public void addStudent(Student student) {
        studentList.add(student);
    }

    public void addListStudents(List<Student> studentList) {
        this.studentList = studentList;
    }

    public void addStudent(String firstName, String lastName) {
        studentList.add(new Student(firstName, lastName));
    }

    public void removeStudent(Student student) {
        studentList.remove(student);
    }

    public void removeStudent(String firstName, String lastName) {
        studentList.remove(new Student(firstName, lastName));
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("-".repeat(5)).append(" Students in group ").append(groupNumber).append(" ").append("-".repeat(5)).append("\n");
        int number = 1;
        for (Student student : studentList) {
            result.append("  ").append(number).append(". ").append(student.toString()).append("\n");
            number++;
        }
        result.append("-".repeat(5)).append(" Students in group ").append(groupNumber).append(" ").append("-".repeat(5)).append("\n");
        return result.toString();
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    public int getStudentsCount() {
        return this.studentList.size();
    }

    @Override
    public Iterator<Student> iterator() {
        return studentList.iterator();
    }
}
