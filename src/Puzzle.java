import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Puzzle {
    private char[][] puzzle;
    private String[] words;
    private int row;
    private int col;
    private int wordsLength;
    private String dir = "..\\test";
    private int CAPACITY = 500;
    private int comparison;

    public Puzzle() {
        this.puzzle = new char[CAPACITY][CAPACITY];
        this.words = new String[CAPACITY];
        this.row = 0;
        this.col = 0;
        this.wordsLength = 0;
        this.comparison = 0;
    }

    public char[][] getPuzzle() {
        return this.puzzle;
    }

    public String[] getWords() {
        return this.words;
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }

    public int getWordsLength() {
        return this.wordsLength;
    }

    public int getCapacity() {
        return this.CAPACITY;
    }

    public int getComparison() {
        return this.comparison;
    }

    public void setComparison(int x) {
        this.comparison = x;
    }

    public void fileInput(String filename) {
        try {
            String path = dir + "\\" + filename;
            File file = new File(path);
            Scanner scfile = new Scanner(file);
            int i = 0;
            while (scfile.hasNextLine()) {
                String line = scfile.nextLine();
                if (line.isEmpty()) {
                    break;
                }
                String[] lineArray = line.split(" ");
                this.col = lineArray.length;
                for (int j = 0; j < lineArray.length; j++) {
                    this.puzzle[i][j] = lineArray[j].charAt(0);
                }
                i++;
            }
            this.row = i;
            i = 0;
            while (scfile.hasNextLine()) {
                String line = scfile.nextLine();
                String noSpaceStr = line.replaceAll("\\s", "");
                this.words[i] = noSpaceStr.trim();
                i++;
            }
            this.wordsLength = i;
            scfile.close();
        } catch (FileNotFoundException e) {
            System.out.println("File tidak ditemukan.");
            System.exit(0);
        }
    }

    public void printPuzzle() {
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                if (j == col - 1) {
                    System.out.println(this.puzzle[i][j]);
                } else {
                    System.out.print(this.puzzle[i][j] + " ");
                }
            }
        }
    }

}
