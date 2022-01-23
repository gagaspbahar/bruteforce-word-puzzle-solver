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
        System.out.println("======");
        String[] test = Solver.diagonalize(puzzle);
        for(int i = 0; i < test.length; i++){
            System.out.println(Solver.reverseString(test[i]));
        }
        Result r = Solver.wordCheckLeftDown(puzzle, "TSRAR");
        r.printResult(puzzle);
        
    }
}