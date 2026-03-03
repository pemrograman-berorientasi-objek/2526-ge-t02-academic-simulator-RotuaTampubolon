package academic.model;

/**
 * @author 12S24028-Rotua Immanuela Tampubolon
 */
public class Enrollment {

    private String courseCode;
    private String studentId;
    private String academicYear;
    private String semester;
    private String grade; // Untuk output "None"

    // Constructor
    public Enrollment(String courseCode, String studentId, String academicYear, String semester) {
        this.courseCode = courseCode;
        this.studentId = studentId;
        this.academicYear = academicYear;
        this.semester = semester;
        this.grade = "None"; // Default grade adalah "None" sesuai output yang diminta
    }

    // Getter methods
    public String getCourseCode() {
        return courseCode;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public String getSemester() {
        return semester;
    }

    public String getGrade() {
        return grade;
    }

    // Metode toString untuk mempermudah representasi objek Enrollment saat dicetak
    // Ini akan digunakan untuk format output yang diminta (dipisahkan oleh '|')
    @Override
    public String toString() {
        return courseCode + "|" + studentId + "|" + academicYear + "|" + semester + "|" + grade;
    }
}
