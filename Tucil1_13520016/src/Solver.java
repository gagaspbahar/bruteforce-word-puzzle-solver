public class Solver {

    public static int lineMatcher(String text, String pattern) {
        int ans = -1;
        text = text.trim();
        int tLen = text.trim().length();
        int pLen = pattern.length();
        for (int i = 0; i <= tLen - pLen; i++) {
            int j = 0;
            while ((j < pLen) && text.charAt(i + j) == pattern.charAt(j)) {
                j++;
            }
            if (j == pLen) {
                ans = i;
            }
        }
        return ans;
    }

    private static String reverseCharArray(char[] s) {
        String ans = "";
        for (int i = s.length - 1; i >= 0; i--) {
            ans += s[i];
        }
        return ans;
    }

    private static String reverseString(String s) {
        String ans = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            ans += s.charAt(i);
        }
        return ans;
    }

    // private static String diagonalizeCharArray(Puzzle p, int startCol, int
    // startRow) {
    // String ans = "";
    // int max = (startCol > startRow) ? startCol : startRow;
    // return ans;
    // }

    // TODO: Pikirin cara return
    // ! Note: 2 Possible Approaches: Loop words inside checker function, or one
    // word per checker, loop in main function.
    // To Return: Posisi Awal, Word Length

    public static Result wordCheckRight(Puzzle p, String word) {
        Result ans = new Result();
        int first;
        int ansFirst = -1;
        int ansRow = -1;
        for (int j = 0; j < p.getRow(); j++) {
            first = lineMatcher(String.valueOf(p.getPuzzle()[j]), word);
            if (first != -1) {
                ansRow = j;
                ansFirst = first;
                break;
            }
        }
        if (ansFirst != -1) {
            ans = new Result(ansRow, ansFirst, word.length(), "right");
        }
        return ans;
    }

    public static Result wordCheckLeft(Puzzle p, String word) {
        Result ans = new Result();
        int first;
        int ansFirst = -1;
        int ansRow = -1;
        for (int j = 0; j < p.getRow(); j++) {
            first = lineMatcher(reverseCharArray(p.getPuzzle()[j]), word);
            if (first != -1) {
                ansRow = j;
                ansFirst = first;
                break;
            }
        }
        if (ansFirst != -1) {
            ans = new Result(ansRow, ansFirst, word.length(), "left");
        }
        return ans;
    }

    // ! Issue: First returns 94 (100-6) not 2 (8-6)
    public static Result wordCheckDown(Puzzle p, String word) {
        Result ans = new Result();
        int first;
        int ansFirst = -1;
        int ansCol = -1;
        for (int j = 0; j < p.getCol(); j++) {
            String text = "";
            for (int i = 0; i < p.getRow(); i++) {
                text += p.getPuzzle()[i][j];
            }
            first = lineMatcher(text, word);
            if (first != -1) {
                ansCol = j;
                ansFirst = first;
                break;
            }
        }
        if (ansFirst != -1) {
            ans = new Result(ansFirst, ansCol, word.length(), "down");
        }
        return ans;
    }

    public static Result wordCheckUp(Puzzle p, String word) {
        Result ans = new Result();
        int first;
        int ansFirst = -1;
        int ansCol = -1;
        for (int j = 0; j < p.getCol(); j++) {
            String text = "";
            for (int i = 0; i < p.getRow(); i++) {
                text += p.getPuzzle()[i][j];
            }
            first = lineMatcher(reverseString(text), word);
            if (first != -1) {
                ansCol = j;
                ansFirst = first;
                break;
            }
        }
        if (ansFirst != -1) {
            ans = new Result(ansFirst, ansCol, word.length(), "up");
        }
        return ans;
    }
}
