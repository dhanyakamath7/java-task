package studentlogger;

public class StudentInfo {
    private String name;
    private int rollNo;
    private int marks;

    public StudentInfo(String name, int rollNo, int marks) {
        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
    }

    public String toCSV() {
        return name + "," + rollNo + "," + marks;
    }
}

