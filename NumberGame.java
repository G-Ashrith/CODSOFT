
import java.util.Scanner;
import java.util.Random;

public class NumberGame {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner =new Scanner(System.in);
		Random random=new Random();
		boolean restart=true;
		int highscore=0;
		while(restart) {
			int score =0;
			boolean guesscorrect=false;
			int maxattempt=10;
			int attempts=0;
			int rand=random.nextInt(100)+1;
			System.out.println("I have a number between 1 to 100. Try to guess the number!");
			System.out.println("Max attempts are :"+maxattempt);
			while(attempts<maxattempt && !guesscorrect) {
				System.out.println("Enter your guess:");
				int guess=scanner.nextInt();
				attempts++;
				if(guess==rand) {
					System.out.println("You have guessed the number correct");
					score=maxattempt - attempts + 1;
					guesscorrect=true;
				}
				else if(guess<rand) {
					System.out.println("Too low! Try again.");
				}
				else {
					System.out.println("Too high! Try again.");
				}
			}
			if(!guesscorrect) {
				System.out.println("You have used up all your attempts. The corect number is:"+ rand);
			}
			System.out.println("Your score was:" + score);
			System.out.println("Do you want to play again? (y/n):");
			String response=scanner.next();
			restart =  response.equalsIgnoreCase("y");

			
			highscore=Math.max(highscore,score);
		}
		System.out.println("Thanks for playing.Your Highscore was:" + highscore);
		scanner.close();

	}

}
