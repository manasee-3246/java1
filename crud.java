import java.util.*;

class Student {
    int id;
    String name;
    double marks;

    Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public String toString() {
        return "Id: " + id + " | Name: " + name + " | Marks: " + marks;
    }
}

public class crud {
    static ArrayList<Student> studentList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static void addStudent() {
        System.out.println("Enter Id:");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.println("Enter Name:");
        String name = sc.nextLine();
        System.out.println("Enter Marks:");
        double marks = sc.nextDouble();

        studentList.add(new Student(id, name, marks));
        System.out.println("Student added successfully.");
    }

    static void viewStudent() {
        if (studentList.isEmpty()) {
            System.out.println("No student records found.");
        } else {
            for (Student s : studentList) {
                System.out.println(s);
            }
        }
    }

    static void updateStudent() {
        System.out.println("Enter Id of student to update:");
        int id = sc.nextInt();
        boolean found = false;

        for (Student s : studentList) {
            if (s.id == id) {
                sc.nextLine(); // consume newline
                System.out.println("Enter New Name:");
                s.name = sc.nextLine();
                System.out.println("Enter New Marks:");
                s.marks = sc.nextDouble();
                System.out.println("Student updated successfully.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student with Id " + id + " not found.");
        }
    }

    static void deleteStudent() {
        System.out.println("Enter Id of student to delete:");
        int id = sc.nextInt();
        boolean removed = studentList.removeIf(s -> s.id == id);

        if (removed) {
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student with Id " + id + " not found.");
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Student Management System");
        boolean run = true;

        while (run) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudent();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    run = false;
                    System.out.println("You have exited the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
