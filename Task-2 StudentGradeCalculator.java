
import java.util.Scanner;
public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of subjects: ");
        int n = sc.nextInt();
        int[] m = new int[n];
        int t = 0;
        for (int i = 0; i < n; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            m[i] = sc.nextInt();
            t += m[i];
        }
        double avg = (double) t / n;
        String g;
        if (avg >= 90) g = "A+";
        else if (avg >= 80) g = "A";
        else if (avg >= 70) g = "B";
        else if (avg >= 60) g = "C";
        else if (avg >= 50) g = "D";
        else g = "F";
        System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ ");
        System.out.println("Total Marks: " + t);
        System.out.println("Average Marks: " + avg);
        System.out.println("Overall Grade: " + g);
        System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ ");
        sc.close();
    }
}

