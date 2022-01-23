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
        char[][] puzzle = p.getPuzzle();
        switch (this.type) {
            case "right":
                boolean puzzleTable[][] = new boolean[row][col];
                for (int i = this.firstCol; i < this.firstCol + this.ansLength; i++) {
                    puzzleTable[this.firstRow][i] = true;
                }
                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < col; j++) {
                        if(puzzleTable[i][j]){
                            if (j == col - 1) {
                                System.out.println(puzzle[i][j]);
                            } else {
                                System.out.print(puzzle[i][j] + " ");
                            }
                        }
                        else{
                            if (j == col - 1) {
                                System.out.println("-");
                            } else {
                                System.out.print("-" + " ");
                            }
                        }
                    }
                }
                break;

            default:
                break;
        }
    }
}
