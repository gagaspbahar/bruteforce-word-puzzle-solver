public class Solver {

    public static int lineMatcher(String text, String pattern) {
        int ans = -1;
        int tLen = text.length();
        int pLen = pattern.length();
        for (int i = 0; i < tLen - pLen; i++) {
            int j = 0;
            while ((j < pLen) && text.charAt(i + j) == pattern.charAt(j)) {
                j++;
            }
            if (j == pLen) {
                ans = j;
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

    // private static String diagonalizeCharArray(Puzzle p, int startCol, int startRow) {
    //     String ans = "";
    //     int max = (startCol > startRow) ? startCol : startRow;
    //     return ans;
    // }

    // TODO: Pikirin cara return
    // ! Note: 2 Possible Approaches: Loop words inside checker function, or one
    // word per checker, loop in main function.
    // To Return: Posisi Awal, Word Length
    public static int[] RightChecker(Puzzle p) {
        int first = -1;
        int wlen = p.getWordsLength();
        int[] ans = new int[wlen];
        for (int i = 0; i < wlen; i++) {
            for (int j = 0; j < p.getRow(); j++) {
                first = lineMatcher(String.valueOf(p.getPuzzle()[j]), p.getWords()[i]);
            }
        }
        return ans;
    }

    public static int[] LeftChecker(Puzzle p) {
        int first = -1;
        int wlen = p.getWordsLength();
        int[] ans = new int[wlen];
        for (int i = 0; i < wlen; i++) {
            for (int j = 0; j < p.getRow(); j++) {
                first = lineMatcher(reverseCharArray(p.getPuzzle()[j]), p.getWords()[i]);
            }
        }
        return ans;
    }

}
