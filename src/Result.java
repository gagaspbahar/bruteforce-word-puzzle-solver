public class Result {
    private final int firstCol;
    private final int firstRow;
    private final int ansLength;
    private final String type;

    public Result(int firstRow, int firstCol, int ansLength, String type) {
        this.firstCol = firstCol;
        this.firstRow = firstRow;
        this.ansLength = ansLength;
        this.type = type;
    }

    public Result() {
        this.firstCol = -1;
        this.firstRow = -1;
        this.ansLength = -1;
        this.type = "";
    }

    public int getFirstCol() {
        return this.firstCol;
    }

    public int getFirstRow() {
        return this.firstRow;
    }

    public int getAnsLength() {
        return this.ansLength;
    }

    public String getType() {
        return this.type;
    }

    public void printResult(Puzzle p) {
        int row = p.getRow();
        int col = p.getCol();
        int start;
        int r;
        int c;
        char[][] puzzle = p.getPuzzle();
        boolean puzzleTable[][] = new boolean[row][col];
        switch (this.type) {
            case "right":
                for (int i = this.firstCol; i < this.firstCol + this.ansLength; i++) {
                    puzzleTable[this.firstRow][i] = true;
                }
                break;
            case "left":
                start = (p.getCol() - 1) - this.firstCol;
                for (int i = start; i >= start - (this.ansLength - 1); i--) {
                    puzzleTable[this.firstRow][i] = true;
                }
                break;
            case "down":
                for (int i = this.firstRow; i < this.firstRow + this.ansLength; i++) {
                    puzzleTable[i][this.firstCol] = true;
                }
                break;
            case "up":
                start = (p.getRow() - 1) - this.firstRow;
                for (int i = start; i >= start - (this.ansLength - 1); i--) {
                    puzzleTable[i][this.firstCol] = true;
                }
                break;
            case "rightUp":
                r = this.firstRow;
                c = this.firstCol;
                for (int i = 0; i < this.ansLength; i++) {
                    puzzleTable[r][c] = true;
                    r--;
                    c++;
                }
                break;
            case "leftDown":
                r = this.firstRow;
                c = this.firstCol;
                for (int i = 0; i < this.ansLength; i++) {
                    puzzleTable[r][c] = true;
                    r++;
                    c--;
                }
                break;
            case "rightDown":
                r = this.firstRow;
                c = this.firstCol;
                for (int i = 0; i < this.ansLength; i++) {
                    puzzleTable[r][c] = true;
                    r++;
                    c++;
                }
                break;
            case "leftUp":
                r = this.firstRow;
                c = this.firstCol;
                for (int i = 0; i < this.ansLength; i++) {
                    puzzleTable[r][c] = true;
                    r--;
                    c--;
                }
                break;

            default:
                break;
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (puzzleTable[i][j]) {
                    if (j == col - 1) {
                        System.out.println(puzzle[i][j]);
                    } else {
                        System.out.print(puzzle[i][j] + " ");
                    }
                } else {
                    if (j == col - 1) {
                        System.out.println("-");
                    } else {
                        System.out.print("-" + " ");
                    }
                }
            }
        }
    }

    public static void printPuzzleWithColor(Puzzle p, Result[] resultList) {
        int row = p.getRow();
        int col = p.getCol();
        int start;
        int r;
        int c;
        int currentColor = 1;
        char[][] puzzle = p.getPuzzle();
        String[] colors = {"RED", "GREEN", "YELLOW", "BLUE", "PURPLE", "CYAN", "WHITE", "RED_BRIGHT", "GREEN_BRIGHT", "YELLOW_BRIGHT", "BLUE_BRIGHT", "PURPLE_BRIGHT", "CYAN_BRIGHT"};
        int puzzleTable[][] = new int[row][col];
        for(int j = 0; j < resultList.length; j++){
            switch (resultList[j].type) {
                case "right":
                    for (int i = resultList[j].firstCol; i < resultList[j].firstCol + resultList[j].ansLength; i++) {
                        puzzleTable[resultList[j].firstRow][i] = currentColor;
                    }
                    break;
                case "left":
                    start = (p.getCol() - 1) - resultList[j].firstCol;
                    for (int i = start; i >= start - (resultList[j].ansLength - 1); i--) {
                        puzzleTable[resultList[j].firstRow][i] = currentColor;
                    }
                    break;
                case "down":
                    for (int i = resultList[j].firstRow; i < resultList[j].firstRow + resultList[j].ansLength; i++) {
                        puzzleTable[i][resultList[j].firstCol] = currentColor;
                    }
                    break;
                case "up":
                    start = (p.getRow() - 1) - resultList[j].firstRow;
                    for (int i = start; i >= start - (resultList[j].ansLength - 1); i--) {
                        puzzleTable[i][resultList[j].firstCol] = currentColor;
                    }
                    break;
                case "rightUp":
                    r = resultList[j].firstRow;
                    c = resultList[j].firstCol;
                    for (int i = 0; i < resultList[j].ansLength; i++) {
                        puzzleTable[r][c] = currentColor;
                        r--;
                        c++;
                    }
                    break;
                case "leftDown":
                    r = resultList[j].firstRow;
                    c = resultList[j].firstCol;
                    for (int i = 0; i < resultList[j].ansLength; i++) {
                        puzzleTable[r][c] = currentColor;
                        r++;
                        c--;
                    }
                    break;
                case "rightDown":
                    r = resultList[j].firstRow;
                    c = resultList[j].firstCol;
                    for (int i = 0; i < resultList[j].ansLength; i++) {
                        puzzleTable[r][c] = currentColor;
                        r++;
                        c++;
                    }
                    break;
                case "leftUp":
                    r = resultList[j].firstRow;
                    c = resultList[j].firstCol;
                    for (int i = 0; i < resultList[j].ansLength; i++) {
                        puzzleTable[r][c] = currentColor;
                        r--;
                        c--;
                    }
                    break;
    
                default:
                    break;
            }
            currentColor++;
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (puzzleTable[i][j] > 0) {
                    if (j == col - 1) {
                        PrintColor.printColor(puzzle[i][j], colors[puzzleTable[i][j] % 13]);
                        System.out.println("");
                    } else {
                        PrintColor.printColor(puzzle[i][j], colors[puzzleTable[i][j] % 13]);
                        System.out.print(" ");
                    }
                } else {
                    if (j == col - 1) {
                        PrintColor.printColor(puzzle[i][j], "BLACK");
                        System.out.println("");
                    } else {
                        PrintColor.printColor(puzzle[i][j], "BLACK");
                        System.out.print(" ");
                    }
                }
            }
        }
    }
}
