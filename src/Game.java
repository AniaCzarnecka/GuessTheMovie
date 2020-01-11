import java.util.Scanner;
import java.util.regex.Pattern;

public class Game {

    private int numGuess = 0;
    private int numLoops = 0;
    private boolean alreadyGuessedThatLetter = false;

    public void Start(String selectedMovie) {
        String hidden = new String(new char[selectedMovie.length()]).replace('\0', '_');
        String lettersGuessed = "";

        System.out.println("You are guessing: " + hidden);

        Scanner scanner = new Scanner(System.in);

        for (int i = 10; i > 0; i--){
            System.out.println("You have " + i + " guesses left.");
            System.out.println("You already are guessing: " + lettersGuessed);
            System.out.println("You have made a total of " + numGuess + " guesses.");
            System.out.println("You are guessing: " + hidden);
            System.out.println("Enter your letter: ");
            String guess = scanner.nextLine();
            char currentGuess = guess.charAt(0);

            if (Pattern.matches("[a-zA-Z]+", guess)) {
                for (int x = 1; x <= numLoops; x++) {
                    if (currentGuess == lettersGuessed.charAt(x - 1)){
                        i++;
                        numGuess++;
                        alreadyGuessedThatLetter = true;
                        break;}
                    else {
                        alreadyGuessedThatLetter = false;
                    }
                }
                if(!alreadyGuessedThatLetter){
                    for (int r = 0; r <= selectedMovie.length() - 1; r++){
                        char current = selectedMovie.charAt(r);

                        currentGuess = Character.toLowerCase(currentGuess);
                        if (current == currentGuess) {
                            System.out.println("You guessed a correct letter");
                            char[] charHidden = hidden.toCharArray();
                            charHidden[r] = current;
                            hidden = String.valueOf(charHidden);
                        }

                        currentGuess = Character.toUpperCase(currentGuess);
                        if (current == currentGuess){
                            System.out.println("You guess a correct letter");
                            char [] charHidden = hidden.toCharArray();
                            charHidden[r] = current;
                            hidden = String.valueOf(charHidden);
                        }
                    }
                    lettersGuessed = lettersGuessed + currentGuess + ", ";
                    numGuess++;
                    numLoops++;
                }
                if (selectedMovie.equals(hidden)){
                    System.out.println("YOU WIN!!!");
                    System.out.println("You have guessed " + selectedMovie + "correctly.");
                    break;
                }
            }
            else{
                System.out.println("Please enter an alphabetical character.");
            }
            if(!selectedMovie.equals(hidden) && i == 1){
                System.out.println("GAME OVER!!!");
                System.out.println("YOU LOSE!!!");
                System.out.println("The movie was: " + selectedMovie + ".");
                break;
            }
        }


    }
}
