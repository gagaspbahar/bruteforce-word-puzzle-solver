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

    // TODO: Refactor this
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
                System.out.println("not implemented.");
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
}
