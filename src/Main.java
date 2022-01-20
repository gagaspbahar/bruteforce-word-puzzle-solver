import java.util.Scanner;

public class Main{
    public static Scanner sc;
    public static void main(String[] args){
        System.out.println("Hello world");
        sc = new Scanner(System.in);
        System.out.println("Masukkan nama file berisi puzzle:");
        String filename = sc.nextLine();
        FileIO io = new FileIO();
        io.fileInput(filename);
        io.printPuzzle();
    }
}