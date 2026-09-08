import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        while (true) {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Marks");
            System.out.println("5. Delete Student");
            System.out.println("6. Calculate Average Marks");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter roll number: ");
                    int rollNumber = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter marks (0-100): ");
                    double marks = scanner.nextDouble();

                    if (marks < 0 || marks > 100) {
                        System.out.println("Marks must be between 0 and 100.");
                    } else {
                        Student student = new Student(rollNumber, name, marks);
                        if (manager.addStudent(student))
                            System.out.println("Student added successfully.");
                        else
                            System.out.println("Roll number already exists.");
                    }
                    break;

                case 2:
                    manager.displayAllStudents();
                    break;

                case 3:
                    System.out.print("Enter roll number: ");
                    rollNumber = scanner.nextInt();
                    Student student = manager.findStudentByRollNumber(rollNumber);
                    System.out.println(student != null ? student : "Student not found.");
                    break;

                case 4:
                    System.out.print("Enter roll number: ");
                    rollNumber = scanner.nextInt();
                    System.out.print("Enter new marks (0-100): ");
                    marks = scanner.nextDouble();

                    if (marks < 0 || marks > 100)
                        System.out.println("Marks must be between 0 and 100.");
                    else if (manager.updateMarks(rollNumber, marks))
                        System.out.println("Marks updated successfully.");
                    else
                        System.out.println("Student not found.");
                    break;

                case 5:
                    System.out.print("Enter roll number: ");
                    rollNumber = scanner.nextInt();

                    if (manager.deleteStudent(rollNumber))
                        System.out.println("Student deleted successfully.");
                    else
                        System.out.println("Student not found.");
                    break;

                case 6:
                    System.out.println("Average marks: "
                            + manager.calculateAverageMarks());
                    break;

                case 7:
                    scanner.close();
                    System.out.println("Exiting application...");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
