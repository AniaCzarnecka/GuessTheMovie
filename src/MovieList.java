import java.io.File;
import java.util.Scanner;

    public class MovieList {

        public static void main(String [] args) throws Exception {

            int numOfMovies = 0;
            int randomMovie = 0;
            String selectedMovie = "";
            String movies = "";

            File movieFile = new File( "movies.txt");
            Scanner scanner = new Scanner(movieFile);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                movies += (line + "\n");
                numOfMovies++;
            }

            randomMovie = (int) (Math.random() * numOfMovies);

            File movieFile2 = new File ("movies.txt");
            Scanner scanner2 = new Scanner(movieFile2);
            int i = 0;
            while (i <= randomMovie) {
                selectedMovie = scanner2.nextLine();
                i++;
            }

            Game game = new Game();
            game.Start(selectedMovie);


        }

        }

