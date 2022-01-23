public class Solver {

    public static int lineMatcher(String text, String pattern, Puzzle p) {
        int ans = -1;
        text = text.trim();
        int tLen = text.trim().length();
        int pLen = pattern.length();
        int comp = 0;
        if (pLen <= tLen) {
            for (int i = 0; i <= tLen - pLen; i++) {
                int j = 0;
                while (j < pLen) {
                    comp++;
                    if (text.charAt(i + j) == pattern.charAt(j)) {
                        j++;
                    } else {
                        break;
                    }
                }
                if (j == pLen) {
                    ans = i;
                }
            }
        }
        p.setComparison(p.getComparison() + comp);
        return ans;
    }

    private static String reverseCharArray(char[] s) {
        String ans = "";
        for (int i = s.length - 1; i >= 0; i--) {
            ans += s[i];
        }
        return ans;
    }

    public static String reverseString(String s) {
        String ans = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            ans += s.charAt(i);
        }
        return ans;
    }


    public static Result wordCheckRight(Puzzle p, String word) {
        Result ans = new Result();
        int first;
        int ansFirst = -1;
        int ansRow = -1;
        for (int j = 0; j < p.getRow(); j++) {
            first = lineMatcher(String.valueOf(p.getPuzzle()[j]), word, p);
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
            first = lineMatcher(reverseCharArray(p.getPuzzle()[j]), word, p);
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
            first = lineMatcher(text, word, p);
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
            first = lineMatcher(reverseString(text), word, p);
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

    public static Result wordCheckRightUp(Puzzle p, String word) {
        Result ans = new Result();
        String[] check = diagonalize(p);
        int first;
        int ansCol = -1;
        int ansRow = -1;
        int i = 0;
        int j = 0;
        for (int k = 0; k < check.length; k++) {
            first = lineMatcher(String.valueOf(check[k]), word, p);
            if (first != -1) {
                ansRow = i - first;
                ansCol = j + first;
                break;
            }
            if (i != p.getRow() - 1) {
                i++;
            } else {
                j++;
            }
        }
        if (ansCol != -1) {
            ans = new Result(ansRow, ansCol, word.length(), "rightUp");
        }
        return ans;
    }

    public static Result wordCheckLeftDown(Puzzle p, String word) {
        Result ans = new Result();
        String[] check = diagonalize(p);
        int first;
        int ansCol = -1;
        int ansRow = -1;
        int i = 0;
        int j = 0;
        for (int k = 0; k < check.length; k++) {
            first = lineMatcher(String.valueOf(reverseString(check[k])), word, p);
            if (first != -1) {
                ansRow = i - (check[k].trim().length() - 1) + first;
                ansCol = j + (check[k].trim().length() - 1) - first;
                break;
            }
            if (i != p.getRow() - 1) {
                i++;
            } else {
                j++;
            }
        }
        if (ansCol != -1) {
            ans = new Result(ansRow, ansCol, word.length(), "leftDown");
        }
        return ans;
    }

    public static Result wordCheckRightDown(Puzzle p, String word) {
        Result ans = new Result();
        String[] check = diagonalizeRightDown(p);
        int first;
        int ansCol = -1;
        int ansRow = -1;
        int i = p.getRow() - 1;
        int j = 0;
        for (int k = 0; k < check.length; k++) {
            first = lineMatcher(String.valueOf(check[k]), word, p);
            if (first != -1) {
                ansRow = i + first;
                ansCol = j + first;
                break;
            }
            if (i != 0) {
                i--;
            } else {
                j++;
            }
        }
        if (ansCol != -1) {
            ans = new Result(ansRow, ansCol, word.length(), "rightDown");
        }
        return ans;
    }

    public static Result wordCheckLeftUp(Puzzle p, String word) {
        Result ans = new Result();
        String[] check = diagonalizeRightDown(p);
        int first;
        int ansCol = -1;
        int ansRow = -1;
        int i = p.getRow() - 1;
        int j = 0;
        for (int k = 0; k < check.length; k++) {
            first = lineMatcher(String.valueOf(reverseString(check[k])), word, p);
            if (first != -1) {
                ansRow = i + (check[k].trim().length() - 1 - first);
                ansCol = j + (check[k].trim().length() - 1 - first);
                break;
            }
            if (i != 0) {
                i--;
            } else {
                j++;
            }
        }
        if (ansCol != -1) {
            ans = new Result(ansRow, ansCol, word.length(), "leftUp");
        }
        return ans;
    }

    public static Result allWordCheck(Puzzle p, String word) {
        Result[] resultList = new Result[8];
        resultList[0] = wordCheckRight(p, word);
        resultList[1] = wordCheckLeft(p, word);
        resultList[2] = wordCheckUp(p, word);
        resultList[3] = wordCheckDown(p, word);
        resultList[4] = wordCheckRightUp(p, word);
        resultList[5] = wordCheckLeftDown(p, word);
        resultList[6] = wordCheckRightDown(p, word);
        resultList[7] = wordCheckLeftUp(p, word);

        int i = 0;
        Result res = new Result();
        while (res.getType() == "") {
            res = resultList[i];
            i++;
        }
        return res;
    }

    public static String[] diagonalize(Puzzle p) {
        char[][] puzzle = p.getPuzzle();
        int min = Math.min(p.getCol(), p.getRow()) * 2;
        if (p.getCol() == p.getRow()) {
            min--;
        }
        String[] ans = new String[min];
        String temp = "";
        int i = 0;
        int j = 0;
        int k = 0;
        int l = 1;
        while (k != p.getRow()) {
            temp = "";
            do {
                temp += puzzle[i][j];
                i--;
                j++;
            } while (i >= 0);
            ans[k] = temp;
            k++;
            i = k;
            j = 0;
        }
        i = p.getRow() - 1;
        j = l;
        while (l != p.getCol()) {
            temp = "";
            do {
                temp += puzzle[i][j];
                i--;
                j++;
            } while (i >= 0);
            ans[k] = temp;
            k++;
            l++;
            i = p.getRow() - 1;
            j = l;
        }
        return ans;
    }

    public static String[] diagonalizeRightDown(Puzzle p) {
        char[][] puzzle = p.getPuzzle();
        int min = Math.min(p.getCol(), p.getRow()) * 2;
        if (p.getCol() == p.getRow()) {
            min--;
        }
        String[] ans = new String[min];
        String temp = "";
        int i = p.getRow() - 1;
        int j = 0;
        int count = 0;
        int k = i;
        int l = 1;
        while (k != -1) {
            temp = "";
            do {
                temp += puzzle[i][j];
                i++;
                j++;
            } while (i < p.getRow());
            ans[count] = temp;
            count++;
            k--;
            i = k;
            j = 0;
        }
        i = 0;
        j = l;
        while (l != p.getCol()) {
            temp = "";
            do {
                temp += puzzle[i][j];
                i++;
                j++;
            } while (i < p.getRow());
            ans[count] = temp;
            count++;
            l++;
            i = 0;
            j = l;
        }
        return ans;
    }
}
