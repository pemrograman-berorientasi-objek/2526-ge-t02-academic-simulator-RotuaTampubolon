package academic.driver;

import java.util.ArrayList;
import java.util.Scanner;

import academic.model.Course;

/**
 * @author 12S24028-Rotua Immanuela Tampubolon
 */
public class Driver1 {

    public static void main(String[] _args) {

        Scanner input = new Scanner(System.in);
        // Menggunakan ArrayList untuk menyimpan Course.
        // Meskipun Anda belajar Array, ArrayList lebih fleksibel karena ukurannya dinamis
        // dan lebih umum digunakan dalam praktikum nyata ketika jumlah elemen tidak diketahui.
        // Jika harus strict Array, nanti bisa dibahas di task selanjutnya atau dimodifikasi.
        ArrayList<Course> courses = new ArrayList<>();

        while (true) {
            String line = input.nextLine(); // Membaca satu baris input

            if (line.equals("---")) { // Kondisi berhenti
                break;
            }

            // Parsing input
            // Contoh: 12S2203#Object-oriented Programming#3#C
            String[] courseData = line.split("#"); // Memisahkan string berdasarkan '#'

            // Memastikan data memiliki 4 segmen
            if (courseData.length == 4) {
                String code = courseData[0];
                String name = courseData[1];
                int credits = Integer.parseInt(courseData[2]); // Mengonversi String ke int
                String grade = courseData[3];

                // Membuat objek Course baru dan menambahkannya ke ArrayList
                Course newCourse = new Course(code, name, credits, grade);
                courses.add(newCourse);
            } else {
                // Opsional: Penanganan jika format input tidak sesuai
                // Untuk praktikum ini, asumsikan input selalu benar atau kita abaikan yang salah.
                // System.err.println("Peringatan: Format input tidak valid untuk baris: " + line);
            }
        }

        // Setelah loop berhenti, tampilkan semua courses yang tersimpan
        for (Course course : courses) {
            System.out.println(course.toString()); // Memanggil metode toString() dari objek Course
        }

        input.close(); // Menutup scanner
    }
}
