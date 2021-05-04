

public class Student <T>{
    private String name;
    private String surname;
    private int studentId;

    public Student(String name, String surname, int studentId) {
        this.name = name;
        this.surname = surname;
        this.studentId = studentId;
    }

    public Student() {

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {

        return surname;
    }

    public void setSurname(String surname) {

        this.surname = surname;
    }

    public int getStudentId() {

        return studentId;
    }

    public void setStudentId(int studentId) {

        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "[" + name.toUpperCase() + " " + surname.toUpperCase() + " " + studentId + "] ";
    }
}





