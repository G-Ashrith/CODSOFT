
import java.util.*;
import java.util.concurrent.*;

public class QuizApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> questions = Arrays.asList(
            "What is the keyword used to define a class in Java?\n1. class\n2. define\n3. struct\n4. type",
            "Which method is used to start a thread in Java?\n1. start()\n2. run()\n3. init()\n4. begin()",
            "What is the default value of a boolean variable in Java?\n1. true\n2. false\n3. 0\n4. null",
            "Which of the following is not a primitive data type in Java?\n1. int\n2. float\n3. String\n4. char",
            "What is the base class for all exceptions in Java?\n1. Exception\n2. Throwable\n3. Error\n4. Runtime Exception"
        );
        List<Integer> correctAnswers = Arrays.asList(1, 1, 2, 3, 2); // 1-based index

        int score = 0;
        ExecutorService executor = Executors.newSingleThreadExecutor();

        for (int i = 0; i < questions.size(); i++) {
            System.out.println(questions.get(i));
            System.out.print("Select an option: ");

            Future<Integer> future = executor.submit(() -> scanner.nextInt());

            try {
                Integer userAnswer = future.get(10, TimeUnit.SECONDS); // 10 seconds to answer
                if (userAnswer != null && userAnswer == correctAnswers.get(i)) {
                    System.out.println("Correct!");
                    score++;
                } else {
                    System.out.println("Incorrect!");
                }
            } catch (TimeoutException e) {
                System.out.println("Time's up!");
            } catch (Exception e) {
                System.out.println("Invalid input.");
            }
        }

        executor.shutdown();
        System.out.println("\nQuiz Over!");
        System.out.println("Your score: " + score + "/" + questions.size());
    }
}

