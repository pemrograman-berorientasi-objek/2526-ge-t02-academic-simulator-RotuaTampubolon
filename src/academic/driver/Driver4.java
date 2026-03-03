package academic.driver;

import java.util.Scanner;

import academic.model.Course;
import academic.model.Enrollment;
import academic.model.Student;

/**
 * @author 12S24028-Rotua Immanuela Tampubolon
 */
public class Driver4 {

    public static void main(String[] _args) {

         Scanner scanner = new Scanner(System.in);

        // Menggunakan array untuk menyimpan setiap jenis objek
        // Kita asumsikan ukuran array maksimal, misalnya 100 untuk setiap jenis
        Course[] courses = new Course[100];
        int courseCount = 0;

        Student[] students = new Student[100];
        int studentCount = 0;

        Enrollment[] enrollments = new Enrollment[100];
        int enrollmentCount = 0;

        String line;
        while (scanner.hasNextLine() && !(line = scanner.nextLine()).equals("---")) {
            // Memisahkan command dari data
            String[] parts = line.split("#", 2); // Split hanya 2 bagian: command dan sisanya

            if (parts.length < 2) {
                System.err.println("Peringatan: Format input tidak valid (tidak ada command atau data) untuk baris: " + line);
                continue;
            }

            String command = parts[0];
            String data = parts[1];

            switch (command) {
                case "course-add":
                    String[] courseData = data.split("#");
                    if (courseData.length == 4) {
                        String code = courseData[0];
                        String name = courseData[1];
                        int credits = Integer.parseInt(courseData[2]);
                        String grade = courseData[3];
                        Course newCourse = new Course(code, name, credits, grade);
                        if (courseCount < courses.length) {
                            courses[courseCount] = newCourse;
                            courseCount++;
                        } else {
                            System.err.println("Peringatan: Array courses penuh. Course tidak dapat ditambahkan.");
                        }
                    } else {
                        System.err.println("Peringatan: Format data course tidak valid untuk baris: " + line);
                    }
                    break;

                case "student-add":
                    String[] studentData = data.split("#");
                    if (studentData.length == 4) {
                        String id = studentData[0];
                        String name = studentData[1];
                        int year = Integer.parseInt(studentData[2]);
                        String major = studentData[3];
                        Student newStudent = new Student(id, name, year, major);
                        if (studentCount < students.length) {
                            students[studentCount] = newStudent;
                            studentCount++;
                        } else {
                            System.err.println("Peringatan: Array students penuh. Student tidak dapat ditambahkan.");
                        }
                    } else {
                        System.err.println("Peringatan: Format data student tidak valid untuk baris: " + line);
                    }
                    break;

                case "enrollment-add":
                    String[] enrollmentData = data.split("#");
                    if (enrollmentData.length == 4) {
                        String courseCode = enrollmentData[0];
                        String studentId = enrollmentData[1];
                        String academicYear = enrollmentData[2];
                        String semester = enrollmentData[3];
                        Enrollment newEnrollment = new Enrollment(courseCode, studentId, academicYear, semester);
                        if (enrollmentCount < enrollments.length) {
                            enrollments[enrollmentCount] = newEnrollment;
                            enrollmentCount++;
                        } else {
                            System.err.println("Peringatan: Array enrollments penuh. Enrollment tidak dapat ditambahkan.");
                        }
                    } else {
                        System.err.println("Peringatan: Format data enrollment tidak valid untuk baris: " + line);
                    }
                    break;

                default:
                    System.err.println("Peringatan: Command tidak dikenal untuk baris: " + line);
                    break;
            }
        }

        // --- Setelah input "---", tampilkan semua data sesuai urutan ---

        // 1. Tampilkan semua Courses
        for (int i = 0; i < courseCount; i++) {
            System.out.println(courses[i]); // Memanggil toString() dari Course
        }

        // 2. Tampilkan semua Students
        for (int i = 0; i < studentCount; i++) {
            System.out.println(students[i]); // Memanggil toString() dari Student
        }

        // 3. Tampilkan semua Enrollments
        for (int i = 0; i < enrollmentCount; i++) {
            System.out.println(enrollments[i]); // Memanggil toString() dari Enrollment
        }

        scanner.close(); // Tutup scanner
    }
}

