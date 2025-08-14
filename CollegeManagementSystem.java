import java.util.*;
class College {
    private String collegeName;
    private List<Student> students;
    private List<Faculty> faculties;
    public College(String collegeName) {
        this.collegeName = collegeName;
        this.students = new ArrayList<>();
        this.faculties = new ArrayList<>();
    }
    public String getCollegeName() {
        return collegeName;
    }
    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }
    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added: " + student.getName());
    }
    public void displayStudentDetails() {
        System.out.println("\n--- Student Details ---");
        if (students.isEmpty()) {
            System.out.println("No students enrolled.");
            return;
        }
        for (Student s : students) {
            System.out.println("ID: " + s.getId() + ", Name: " + s.getName() + ", Department: " + s.getDepartment());
        }
    }
    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
        System.out.println("Faculty added: " + faculty.getName());
    }
    public void displayFacultyDetails() {
        System.out.println("\n--- Faculty Details ---");
        if (faculties.isEmpty()) {
            System.out.println("No faculty members available.");
            return;
        }
        for (Faculty f : faculties) {
            System.out.println("ID: " + f.getId() + ", Name: " + f.getName() + ", Subject: " + f.getSubject());
        }
    }
    public List<Student> getStudents() {
        return students;
    }
    static class Student {
        private String id;
        private String name;
        private String department;
        public Student(String id, String name, String department) {
            this.id = id;
            this.name = name;
            this.department = department;
        }
        public String getId() {
            return id;
        }
        public void setId(String id) {
            this.id = id;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getDepartment() {
            return department;
        }
        public void setDepartment(String department) {
            this.department = department;
        }
    }
    static class Faculty {
        private String id;
        private String name;
        private String subject;
        public Faculty(String id, String name, String subject) {
            this.id = id;
            this.name = name;
            this.subject = subject;
        }
        public String getId() {
            return id;
        }
        public void setId(String id) {
            this.id = id;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getSubject() {
            return subject;
        }
        public void setSubject(String subject) {
            this.subject = subject;
        }
    }
}
class School extends College {
    private Map<String, Map<String, Integer>> studentMarks;
    public School(String collegeName) {
        super(collegeName);
        studentMarks = new HashMap<>();
    }
    public void addStudentMarks(String studentId, String subject, int marks) {
        if (marks < 0 || marks > 100) {
            System.out.println("Invalid marks. Please enter between 0 and 100.");
            return;
        }
        if (!studentExists(studentId)) {
            System.out.println("Student with ID " + studentId + " not found.");
            return;
        }
        studentMarks.putIfAbsent(studentId, new HashMap<>());
        studentMarks.get(studentId).put(subject, marks);
        System.out.println("Marks added for student ID " + studentId + " in " + subject + ": " + marks);
    }
    private boolean studentExists(String studentId) {
        for (Student s : super.getStudents()) {
            if (s.getId().equals(studentId)) {
                return true;
            }
        }
        return false;
    }
    public void displayStudentMarks(String studentId) {
        if (!studentExists(studentId)) {
            System.out.println("Student with ID " + studentId + " not found.");
            return;
        }
        System.out.println("\nMarks for student ID " + studentId + ":");
        Map<String, Integer> marks = studentMarks.get(studentId);
        if (marks == null || marks.isEmpty()) {
            System.out.println("No marks found.");
            return;
        }
        for (Map.Entry<String, Integer> entry : marks.entrySet()) {
            System.out.println("Subject: " + entry.getKey() + ", Marks: " + entry.getValue());
        }
    }
}
public class CollegeManagementSystem {
    public static void main(String[] args) {
        School mySchool = new School("Greenwood College");
        College.Student s1 = new College.Student("S001", "Alice Johnson", "Computer Science");
        College.Student s2 = new College.Student("S002", "Bob Smith", "Mechanical Engineering");
        mySchool.addStudent(s1);
        mySchool.addStudent(s2);
        College.Faculty f1 = new College.Faculty("F001", "Dr. Emily Clark", "Mathematics");
        College.Faculty f2 = new College.Faculty("F002", "Prof. John Doe", "Physics");
        mySchool.addFaculty(f1);
        mySchool.addFaculty(f2);
        mySchool.displayStudentDetails();
        mySchool.displayFacultyDetails();

        mySchool.addStudentMarks("S001", "Mathematics", 85);
        mySchool.addStudentMarks("S001", "Physics", 90);
        mySchool.addStudentMarks("S002", "Mathematics", 78);
        mySchool.addStudentMarks("S002", "Physics", 88);
        mySchool.displayStudentMarks("S001");
        mySchool.displayStudentMarks("S002");
        mySchool.addStudentMarks("S003", "Mathematics", 75);  // Student doesn't exist test
    }
}