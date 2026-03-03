package academic.driver;

import java.util.Scanner;

import academic.model.Enrollment;

/**
 * @author 12S24028-Rotua Immanuela Tampubolon
 */
public class Driver3 {

    public static void main(String[] _args) {

        Scanner scanner = new Scanner(System.in);
        // Menggunakan array untuk menyimpan objek Enrollment.
        // Asumsikan ukuran array maksimal, misalnya 100.
        Enrollment[] enrollments = new Enrollment[100];
        int enrollmentCount = 0; // Untuk melacak jumlah enrollment yang sudah tersimpan

        String line;
        while (scanner.hasNextLine() && !(line = scanner.nextLine()).equals("---")) {
            // Memparsing input: "COURSE_CODE#STUDENT_ID#ACADEMIC_YEAR#SEMESTER"
            // Contoh: 12S2203#12S20999#2021/2022#even
            String[] parts = line.split("#");

            // Memastikan data memiliki 4 segmen
            if (parts.length == 4) {
                String courseCode = parts[0];
                String studentId = parts[1];
                String academicYear = parts[2];
                String semester = parts[3];

                // Membuat objek Enrollment baru
                Enrollment newEnrollment = new Enrollment(courseCode, studentId, academicYear, semester);

                // Menyimpan objek Enrollment ke dalam array, jika array belum penuh
                if (enrollmentCount < enrollments.length) {
                    enrollments[enrollmentCount] = newEnrollment;
                    enrollmentCount++;
                } else {
                    System.err.println("Peringatan: Array penyimpanan enrollment penuh. Enrollment tidak dapat ditambahkan.");
                }
            } else {
                System.err.println("Peringatan: Format input tidak valid untuk baris: " + line);
            }
        }

        // Setelah input "---", tampilkan semua enrollments yang tersimpan
        for (int i = 0; i < enrollmentCount; i++) {
            System.out.println(enrollments[i]); // Memanggil metode toString() dari objek Enrollment
        }

        scanner.close(); // Menutup scanner
    }
}

