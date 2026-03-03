package academic.model;

/**
 * @author 12S24028-Rotua Immanuela Tampubolon
 */
public class Student {

    private String id;
    private String name;
    private int year; // Tahun masuk
    private String major; // Jurusan

    // Constructor
    public Student(String id, String name, int year, String major) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.major = major;
    }

    // Getter methods
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getMajor() {
        return major;
    }

    // Metode toString untuk mempermudah representasi objek Student saat dicetak
    // Ini akan digunakan untuk format output yang diminta (dipisahkan oleh '|')
    @Override
    public String toString() {
        return id + "|" + name + "|" + year + "|" + major;
    }
}

