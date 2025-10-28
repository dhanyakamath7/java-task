package studentlogger;

public class MainApp {
    public static void main(String[] args) {
        String file = "student_scores.csv";

        // creating few student objects
        StudentInfo s1 = new StudentInfo("Asha", 101, 89);
        StudentInfo s2 = new StudentInfo("Manoj", 102, 76);
        StudentInfo s3 = new StudentInfo("Priya", 103, 92);

        Thread t1 = new Thread(new ScoreSaver(s1, file), "Thread-1");
        Thread t2 = new Thread(new ScoreSaver(s2, file), "Thread-2");
        Thread t3 = new Thread(new ScoreSaver(s3, file), "Thread-3");

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            System.out.println("Something went wrong with threads.");
        }

        System.out.println("\nAll student scores saved successfully!");
    }
} 

