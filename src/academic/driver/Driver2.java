package academic.driver;

import java.util.Scanner;

import academic.model.Student;

/**
 * @author 12S24028 Rotua Tampubolon
 */
public class Driver2 {

    public static void main(String[] _args) {

          Scanner scanner = new Scanner(System.in);
        // Menggunakan array untuk menyimpan objek Student.
        // Sama seperti Task 01, kita asumsikan ukuran array maksimal, misalnya 100.
        Student[] students = new Student[100];
        int studentCount = 0; // Untuk melacak jumlah student yang sudah tersimpan

        String line;
        while (scanner.hasNextLine() && !(line = scanner.nextLine()).equals("---")) {
            // Memparsing input: "ID#NAME#YEAR#MAJOR"
            // Contoh: 12S20999#Wiro Sableng#2020#Information Systems
            String[] parts = line.split("#");

            // Memastikan data memiliki 4 segmen
            if (parts.length == 4) {
                String id = parts[0];
                String name = parts[1];
                int year = Integer.parseInt(parts[2]); // Mengonversi String ke int untuk tahun
                String major = parts[3];

                // Membuat objek Student baru
                Student newStudent = new Student(id, name, year, major);

                // Menyimpan objek Student ke dalam array, jika array belum penuh
                if (studentCount < students.length) {
                    students[studentCount] = newStudent;
                    studentCount++;
                } else {
                    System.err.println("Peringatan: Array penyimpanan student penuh. Student tidak dapat ditambahkan.");
                }
            } else {
                System.err.println("Peringatan: Format input tidak valid untuk baris: " + line);
            }
        }

        // Setelah input "---", tampilkan semua students yang tersimpan
        for (int i = 0; i < studentCount; i++) {
            System.out.println(students[i]); // Memanggil metode toString() dari objek Student
        }

        scanner.close(); // Menutup scanner
    }
}

    