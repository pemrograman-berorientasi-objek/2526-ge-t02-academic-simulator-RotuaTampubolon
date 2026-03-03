package academic.model;

/**
 * @author 12S24028-Rotua Immanuela Tampubolon
 */
public class Course {

     private String code;
    private String name;
    private int credits;
    private String grade;

    // Constructor
    public Course(String code, String name, int credits, String grade) {
        this.code = code;
        this.name = name;
        this.credits = credits;
        this.grade = grade;
    }

    // Getter methods (sesuai kebutuhan untuk menampilkan data)
    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    public String getGrade() {
        return grade;
    }

    // Metode toString untuk mempermudah representasi objek Course saat dicetak
    // Ini akan digunakan untuk format output yang diminta (dipisahkan oleh '|')
    @Override
    public String toString() {
        return code + "|" + name + "|" + credits + "|" + grade;
    }
}
