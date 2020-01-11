import  java.util.regex.Pattern;

public class CheckAlphabet {
    void CheckAlphabet(String guess){
        if(!Pattern.matches("[a-zA-Z]+", guess ))
        {
            System.out.println("Please enter an alphabetical character.");
        }
    }
}
