package studentlogger;

import java.io.FileWriter;
import java.io.IOException;

public class ScoreSaver implements Runnable {
    private StudentInfo student;
    private String fileName;

    public ScoreSaver(StudentInfo student, String fileName) {
        this.student = student;
        this.fileName = fileName;
    }

    @Override
    public void run() {
        writeToFile(student);
    }

    private static synchronized void writeToFile(StudentInfo s) {
        try (FileWriter fw = new FileWriter("student_scores.csv", true)) {
            fw.write(s.toCSV() + "\n");
            System.out.println(Thread.currentThread().getName() + " wrote: " + s.toCSV());
        } catch (IOException e) {
            System.out.println("Error while writing file: " + e.getMessage());
        }
    }
} 

