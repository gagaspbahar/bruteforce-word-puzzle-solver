import java.util.Scanner;


public class Main {
    public static Scanner sc;

    public static void main(String[] args) {
        System.out.println("Hello world");
        sc = new Scanner(System.in);
        System.out.println("Masukkan nama file berisi puzzle:");
        String filename = sc.nextLine();
        Puzzle puzzle = new Puzzle();
        puzzle.fileInput(filename);
        puzzle.printPuzzle();
        Result r = Solver.wordCheckLeft(puzzle, puzzle.getWords()[6]);
        r.printResult(puzzle);
    }
}