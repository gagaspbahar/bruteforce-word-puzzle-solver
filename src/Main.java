import java.util.Scanner;

public class Main {
    public static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);

        System.out.println("Masukkan nama file berisi puzzle:");
        String filename = sc.nextLine();
        Puzzle puzzle = new Puzzle();
        puzzle.fileInput(filename);

        long start = System.nanoTime();
        Result[] resultList = new Result[puzzle.getWordsLength()];
        for (int i = 0; i < puzzle.getWordsLength(); i++) {
            resultList[i] = Solver.allWordCheck(puzzle, puzzle.getWords()[i]);
        }

        long end = System.nanoTime();

        System.out.println("Pilih output: ");
        System.out.println("1. Single, berwarna");
        System.out.println("2. Multiple matrix");
        String prompt = sc.nextLine();

        switch (prompt) {
            case "1":
                Result.printPuzzleWithColor(puzzle, resultList);
                break;
            case "2":
                for (int i = 0; i < puzzle.getWordsLength(); i++) {
                    System.out.printf("%d. %s\n", i + 1, puzzle.getWords()[i]);
                    resultList[i].printResult(puzzle);
                }
            default:
                break;
        }
        long time = (end - start);
        double timeElapsed = (double) time / 1_000_000_000;

        System.out.println("Time taken: " + timeElapsed + " seconds");
        System.out.printf("Comparison made: %d\n", puzzle.getComparison());
        sc.close();
    }
}