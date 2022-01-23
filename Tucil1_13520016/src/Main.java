import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

public class Main {
    public static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);

        Instant start = Instant.now();

        System.out.println("Masukkan nama file berisi puzzle:");
        String filename = sc.nextLine();
        Puzzle puzzle = new Puzzle();
        puzzle.fileInput(filename);

        Result[] resultList = new Result[puzzle.getWordsLength()];
        for (int i = 0; i < puzzle.getWordsLength(); i++) {
            resultList[i] = Solver.allWordCheck(puzzle, puzzle.getWords()[i]);
            System.out.printf("%d. %s\n", i + 1, puzzle.getWords()[i]);
            resultList[i].printResult(puzzle);
        }

        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);

        System.out.println("Time taken: " + timeElapsed.toMillis() + " milliseconds");
        System.out.printf("Comparison made: %d\n", puzzle.getComparison());
    }
}