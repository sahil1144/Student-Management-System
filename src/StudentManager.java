import java.util.ArrayList;

public class StudentManager {
    private ArrayList<Student> students = new ArrayList<>();

    public boolean addStudent(Student student) {
        if (findStudentByRollNumber(student.getRollNumber()) != null) return false;
        students.add(student);
        return true;
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public Student findStudentByRollNumber(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) return student;
        }
        return null;
    }

    public boolean updateMarks(int rollNumber, double newMarks) {
        Student student = findStudentByRollNumber(rollNumber);
        if (student == null) return false;
        student.setMarks(newMarks);
        return true;
    }

    public boolean deleteStudent(int rollNumber) {
        Student student = findStudentByRollNumber(rollNumber);
        if (student == null) return false;
        students.remove(student);
        return true;
    }

    public double calculateAverageMarks() {
        if (students.isEmpty()) return 0;

        double total = 0;
        for (Student student : students) {
            total += student.getMarks();
        }
        return total / students.size();
    }
}
